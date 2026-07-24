package io.unified.verify.core;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * Holds everything needed to run a single verification step:
 * the actual/expected suppliers, the comparison function,
 * an optional retry window, and an optional on-fail callback.
 */
@Slf4j
public class VerificationInfo<A, B> {

  private final Supplier<A> actualSupplier;
  private final Supplier<B> expectedSupplier;
  private final String message;
  private final boolean printDiff;
  private final int waitInSeconds;
  private final int intervalInMilliSeconds;
  private final BiFunction<A, B, Boolean> verifyMethod;
  private final BiConsumer<A, B> onFail;

  public VerificationInfo(
      Supplier<A> actualSupplier,
      Supplier<B> expectedSupplier,
      String message,
      boolean printDiff,
      BiFunction<A, B, Boolean> verifyMethod) {
    this(actualSupplier, expectedSupplier, message, printDiff, verifyMethod, null);
  }

  public VerificationInfo(
      Supplier<A> actualSupplier,
      Supplier<B> expectedSupplier,
      String message,
      boolean printDiff,
      BiFunction<A, B, Boolean> verifyMethod,
      BiConsumer<A, B> onFail) {
    this(actualSupplier, expectedSupplier, message, printDiff, -1, -1, verifyMethod, onFail);
  }

  public VerificationInfo(
      Supplier<A> actualSupplier,
      Supplier<B> expectedSupplier,
      String message,
      boolean printDiff,
      int waitInSeconds,
      int intervalInMilliSeconds,
      BiFunction<A, B, Boolean> verifyMethod) {
    this(actualSupplier, expectedSupplier, message, printDiff,
        waitInSeconds, intervalInMilliSeconds, verifyMethod, null);
  }

  public VerificationInfo(
      Supplier<A> actualSupplier,
      Supplier<B> expectedSupplier,
      String message,
      boolean printDiff,
      int waitInSeconds,
      int intervalInMilliSeconds,
      BiFunction<A, B, Boolean> verifyMethod,
      BiConsumer<A, B> onFail) {
    this.actualSupplier = actualSupplier;
    this.expectedSupplier = expectedSupplier;
    this.message = message;
    this.printDiff = printDiff;
    this.verifyMethod = verifyMethod;
    this.waitInSeconds = waitInSeconds;
    this.intervalInMilliSeconds = intervalInMilliSeconds;
    this.onFail = onFail;
  }

  /** Runs the verification. Appends a PASS/FAIL line to {@code verificationMessages}. */
  public boolean test(StringBuilder verificationMessages) {
    VerificationResult<?> result = computeResult();
    String line = buildMessage(result, result.passed());
    if (!result.passed() || VerifyConfig.isPrintPassed()) {
      verificationMessages.append(line).append(System.lineSeparator());
    }
    return result.passed();
  }

  private VerificationResult<?> computeResult() {
    if (waitInSeconds != -1) {
      return computeResultWithWait();
    }
    VerificationResult<?> result = null;
    try {
      A actual = actualSupplier.get();
      B expected = expectedSupplier.get();
      result = new VerificationResult<>(actual, expected, verifyMethod.apply(actual, expected));
    } finally {
      if (result == null || !result.passed()) {
        applyOnFail();
      }
    }
    return result;
  }

  private VerificationResult<?> computeResultWithWait() {
    Throwable lastException = null;
    A actual = null;
    B expected = null;
    Instant deadline = Instant.now().plusSeconds(waitInSeconds);

    while (true) {
      try {
        actual = actualSupplier.get();
        expected = expectedSupplier.get();
        VerificationResult<?> result =
            new VerificationResult<>(actual, expected, verifyMethod.apply(actual, expected));
        if (result.passed()) {
          return result;
        }
        Thread.sleep(intervalInMilliSeconds);
      } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
        break;
      } catch (Throwable t) {
        lastException = t;
      }
      if (Instant.now().isAfter(deadline)) {
        break;
      }
    }

    applyOnFail();

    if (lastException != null) {
      if (lastException instanceof RuntimeException ex) throw ex;
      throw new AssertionError("Verification Failed!", lastException);
    }
    return new VerificationResult<>(actual, expected, false);
  }

  private void applyOnFail() {
    if (onFail != null) {
      try {
        onFail.accept(actualSupplier.get(), expectedSupplier.get());
      } catch (Throwable t) {
        log.error("on-fail handler threw", t);
      }
    }
  }

  private String buildMessage(VerificationResult<?> result, boolean passed) {
    String expected = stringify(result.expected());
    String actual   = stringify(result.actual());
    boolean useAnsi = VerifyConfig.isAnsiColors();

    if (passed) {
      String out = "PASS ::> " + message.trim()
          + String.format(" Exp: '%s', Act: '%s'", expected, actual);
      return useAnsi ? AnsiUtil.toGreen(out) : out;
    } else {
      String prefix = useAnsi ? AnsiUtil.toRed("FAIL ::> ") : "FAIL ::> ";
      StringBuilder out = new StringBuilder(prefix).append(message.trim());
      if (printDiff) {
        out.append(String.format("%nDiff: '%s',%nExp: '%s',%nAct: '%s'",
            simpleDiff(expected, actual), expected, actual));
      } else {
        out.append(String.format(" Exp: '%s', Act: '%s'", expected, actual));
      }
      return out.toString();
    }
  }

  private String stringify(Object obj) {
    return obj == null ? "<NULL>" : obj.toString();
  }

  /** Placeholder diff — replace with diff-match-patch output if desired. */
  private String simpleDiff(String expected, String actual) {
    if (expected.equals(actual)) return "(no diff)";
    return String.format("[expected] %s  [actual] %s", expected, actual);
  }

  record VerificationResult<O>(O actual, O expected, boolean passed) {}
}
