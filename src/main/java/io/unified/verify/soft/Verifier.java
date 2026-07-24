package io.unified.verify.soft;

import io.unified.verify.core.AnsiUtil;
import io.unified.verify.core.VerificationInfo;
import io.unified.verify.core.VerificationQueue;
import io.unified.verify.core.VerifyConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Slf4j
public class Verifier implements VerificationQueue {

  private static final String LINE =
      "------------------------------------------------------------";

  public final ObjectVerifierImpl<Verifier> Object = new ObjectVerifierImpl<>(this);
  public final CollectionVerifierImpl<Verifier> Collection = new CollectionVerifierImpl<>(this);
  public final MapVerifierImpl<Verifier> Map = new MapVerifierImpl<>(this);
  public final BooleanVerifierImpl<Verifier> Bool = new BooleanVerifierImpl<>(this);
  public final DateVerifierImpl<Verifier> Date = new DateVerifierImpl<>(this);
  public final StringVerifierImpl<Verifier> String = new StringVerifierImpl<>(this);
  public final FileVerifierImpl<Verifier> File = new FileVerifierImpl<>(this);
  public final NumberVerifierImpl<Verifier, Long> Long = new NumberVerifierImpl<>(this);
  public final NumberVerifierImpl<Verifier, java.math.BigDecimal> BigDecimal = new NumberVerifierImpl<>(this);
  public final NumberVerifierImpl<Verifier, Double> Double = new NumberVerifierImpl<>(this);
  public final NumberVerifierImpl<Verifier, Float> Float = new NumberVerifierImpl<>(this);
  public final NumberVerifierImpl<Verifier, Integer> Int = new NumberVerifierImpl<>(this);

  protected final List<VerificationInfo<?, ?>> expectations = new ArrayList<>();

  @Override
  public void queue(VerificationInfo<?, ?> info) {
    expectations.add(info);
  }

  public void verify() {
    verify(StringUtils.EMPTY);
  }

  public void verify(String header) {
    perform(header, "Verify All",
        messages -> expectations.stream().filter(e -> !e.test(messages)).findAny().isEmpty());
  }

  public void verifyAny() {
    verifyAny(StringUtils.EMPTY);
  }

  public void verifyAny(String header) {
    perform(header, "Verify Any",
        messages -> expectations.stream().anyMatch(e -> e.test(messages)));
  }

  public void verifyNone() {
    verifyNone(StringUtils.EMPTY);
  }

  public void verifyNone(String header) {
    perform(header, "Verify None",
        messages -> expectations.stream().noneMatch(e -> e.test(messages)));
  }

  private void perform(String header, String type, Function<StringBuilder, Boolean> supplier) {
    StringBuilder messages = new StringBuilder();
    boolean hasHeader = StringUtils.isNotBlank(header);

    if (hasHeader) {
      messages.append(LINE).append(System.lineSeparator());
      messages.append(header).append(System.lineSeparator());
      messages.append(LINE).append(System.lineSeparator());
    }

    try {
      boolean passed = supplier.apply(messages);

      if (passed && !VerifyConfig.isPrintPassed()) {
        return;
      }

      if (hasHeader) {
        messages.append(LINE).append(System.lineSeparator());
      }

      String headline = System.lineSeparator()
          + "==============" + type + (passed ? " Passed" : " Failed")
          + "==============" + System.lineSeparator();

      boolean useAnsi = VerifyConfig.isAnsiColors();
      messages.insert(0, useAnsi
          ? (passed ? AnsiUtil.toGreen(headline) : AnsiUtil.toRed(headline))
          : headline);

      String text = messages.toString();
      if (!passed) {
        log.error(text);
        throw new AssertionError(text);
      }
      log.info(text);
    } finally {
      expectations.clear();
    }
  }
}
