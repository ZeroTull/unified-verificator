package io.unified.verify.interfaces;

import io.unified.verify.core.VerificationInfo;
import io.unified.verify.core.VerificationQueue;
import io.unified.verify.states.BaseState;
import io.unified.verify.wait.BaseWaiter;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface BaseVerify<O, S extends BaseState<O>> extends BaseWaiter<O> {

  S _toState(O o);

  default <A, B> void _verify(
      Function<O, A> actualProvider,
      Supplier<B> expectedSupplier,
      BiFunction<A, B, Boolean> verifyMethod,
      final String message,
      final Object... params) {
    _verify(getVerificationQueue(), actualProvider, expectedSupplier, verifyMethod, message, params);
  }

  default <A, B, V extends VerificationQueue> void _verify(
      V verifier,
      Function<O, A> actualProvider,
      Supplier<B> expectedSupplier,
      BiFunction<A, B, Boolean> verifyMethod,
      final String message,
      final Object... params) {
    if (withWaiter()) {
      verifier.queue(new VerificationInfo<>(
          () -> actualProvider.apply(_get()),
          expectedSupplier,
          String.format(message, params),
          printDiff(),
          getDefaultWaitInSeconds(),
          getDefaultWaitIntervalInMilliSeconds(),
          verifyMethod));
    } else {
      verifier.queue(new VerificationInfo<>(
          () -> actualProvider.apply(_get()),
          expectedSupplier,
          String.format(message, params),
          printDiff(),
          verifyMethod));
    }
  }

  default <B> void _verify(
      O actual,
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      final String message,
      final Object... params) {
    _verify(getVerificationQueue(), actual, expected, verifyMethod, message, params);
  }

  default <B, V extends VerificationQueue> void _verify(
      V verifier,
      O actual,
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      final String message,
      final Object... params) {
    if (withWaiter()) {
      verifier.queue(new VerificationInfo<>(
          () -> actual,
          () -> expected,
          String.format(message, params),
          printDiff(),
          getDefaultWaitInSeconds(),
          getDefaultWaitIntervalInMilliSeconds(),
          verifyMethod));
    } else {
      verifier.queue(new VerificationInfo<>(
          () -> actual,
          () -> expected,
          String.format(message, params),
          printDiff(),
          verifyMethod));
    }
  }

  default <B> void _verify(
      O actual,
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      final int waitInSeconds,
      final int intervalInMilliSeconds,
      final String message,
      final Object... params) {
    _verify(getVerificationQueue(), actual, expected, verifyMethod, waitInSeconds, intervalInMilliSeconds, message, params);
  }

  default <B, V extends VerificationQueue> void _verify(
      V verifier,
      O actual,
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      final int waitInSeconds,
      final int intervalInMilliSeconds,
      final String message,
      final Object... params) {
    verifier.queue(new VerificationInfo<>(
        () -> actual,
        () -> expected,
        String.format(message, params),
        printDiff(),
        waitInSeconds,
        intervalInMilliSeconds,
        verifyMethod));
  }

  default <B> void _verify(
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      final String message,
      final Object... params) {
    _verify(getVerificationQueue(), expected, verifyMethod, message, params);
  }

  default <B, V extends VerificationQueue> void _verify(
      V verifier,
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      final String message,
      final Object... params) {
    if (withWaiter()) {
      verifier.queue(new VerificationInfo<>(
          this::_get,
          () -> expected,
          String.format(message, params),
          printDiff(),
          getDefaultWaitInSeconds(),
          getDefaultWaitIntervalInMilliSeconds(),
          verifyMethod));
    } else {
      verifier.queue(new VerificationInfo<>(
          this::_get,
          () -> expected,
          String.format(message, params),
          printDiff(),
          verifyMethod));
    }
  }

  default <B> void _verify_with_failure_handler(
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      BiConsumer<O, B> onFail,
      final String message,
      final Object... params) {
    _verify_with_failure_handler(getVerificationQueue(), expected, verifyMethod, onFail, message, params);
  }

  default <B, V extends VerificationQueue> void _verify_with_failure_handler(
      V verifier,
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      BiConsumer<O, B> onFail,
      final String message,
      final Object... params) {
    if (withWaiter()) {
      verifier.queue(new VerificationInfo<>(
          this::_get,
          () -> expected,
          String.format(message, params),
          printDiff(),
          getDefaultWaitInSeconds(),
          getDefaultWaitIntervalInMilliSeconds(),
          verifyMethod,
          onFail));
    } else {
      verifier.queue(new VerificationInfo<>(
          this::_get,
          () -> expected,
          String.format(message, params),
          printDiff(),
          verifyMethod,
          onFail));
    }
  }

  default <B> void _verify(
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      final int waitInSeconds,
      final String message,
      final Object... params) {
    _verify(getVerificationQueue(), expected, verifyMethod, waitInSeconds, message, params);
  }

  default <B, V extends VerificationQueue> void _verify(
      V verifier,
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      final int waitInSeconds,
      final String message,
      final Object... params) {
    _verify(verifier, expected, verifyMethod, waitInSeconds, getDefaultWaitIntervalInMilliSeconds(), message, params);
  }

  default <B> void _verify_with_failure_handler(
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      BiConsumer<O, B> onFail,
      final int waitInSeconds,
      final String message,
      final Object... params) {
    _verify_with_failure_handler(getVerificationQueue(), expected, verifyMethod, onFail, waitInSeconds, message, params);
  }

  default <B, V extends VerificationQueue> void _verify_with_failure_handler(
      V verifier,
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      BiConsumer<O, B> onFail,
      final int waitInSeconds,
      final String message,
      final Object... params) {
    _verify_with_failure_handler(verifier, expected, verifyMethod, onFail, waitInSeconds, getDefaultWaitIntervalInMilliSeconds(), message, params);
  }

  default <B> void _verify(
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      final int waitInSeconds,
      final int intervalInMilliSeconds,
      final String message,
      final Object... params) {
    _verify(getVerificationQueue(), expected, verifyMethod, waitInSeconds, intervalInMilliSeconds, message, params);
  }

  default <B, V extends VerificationQueue> void _verify(
      V verifier,
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      final int waitInSeconds,
      final int intervalInMilliSeconds,
      final String message,
      final Object... params) {
    verifier.queue(new VerificationInfo<>(
        this::_get,
        () -> expected,
        String.format(message, params),
        printDiff(),
        waitInSeconds,
        intervalInMilliSeconds,
        verifyMethod));
  }

  default <B> void _verify_with_failure_handler(
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      BiConsumer<O, B> onFail,
      final int waitInSeconds,
      final int intervalInMilliSeconds,
      final String message,
      final Object... params) {
    _verify_with_failure_handler(getVerificationQueue(), expected, verifyMethod, onFail, waitInSeconds, intervalInMilliSeconds, message, params);
  }

  default <B, V extends VerificationQueue> void _verify_with_failure_handler(
      V verifier,
      B expected,
      BiFunction<O, B, Boolean> verifyMethod,
      BiConsumer<O, B> onFail,
      final int waitInSeconds,
      final int intervalInMilliSeconds,
      final String message,
      final Object... params) {
    verifier.queue(new VerificationInfo<>(
        this::_get,
        () -> expected,
        String.format(message, params),
        printDiff(),
        waitInSeconds,
        intervalInMilliSeconds,
        verifyMethod,
        onFail));
  }

  default boolean withWaiter() {
    return false;
  }

  default boolean printDiff() {
    return false;
  }

  default VerificationQueue getVerificationQueue() {
    return new VerificationQueue() {};
  }
}
