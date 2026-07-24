package io.unified.verify.hard;

import io.unified.verify.interfaces.base.BooleanVerify;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BooleanVerification extends BaseVerification {

  public void equals(final Boolean actual, final Boolean expected) {
    toVerifier(actual).verifyEquals(expected);
  }

  public void equals(final Boolean actual, final Boolean expected, final String message, final Object... params) {
    toVerifier(actual).verifyEquals(expected, message, params);
  }

  public void isFalse(Boolean actual) {
    toVerifier(actual).verifyIsFalse();
  }

  public void isFalse(Boolean actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsFalse(message, params);
  }

  public void isTrue(Boolean actual) {
    toVerifier(actual).verifyIsTrue();
  }

  public void isTrue(Boolean actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsTrue(message, params);
  }

  public void notEquals(final Boolean actual, final Boolean expected) {
    toVerifier(actual).verifyNotEquals(expected);
  }

  public void notEquals(final Boolean actual, final Boolean expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotEquals(expected, message, params);
  }

  protected BooleanVerify toVerifier(Boolean actual) {
    return () -> actual;
  }
}
