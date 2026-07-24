package io.unified.verify.hard;

import io.unified.verify.interfaces.base.ObjectVerify;
import io.unified.verify.states.ObjectState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectVerification extends BaseVerification {

  public void equals(final Object actual, final Object expected) {
    toVerifier(actual).verifyEquals(expected);
  }

  public void equals(final Object actual, final Object expected, final String message, final Object... params) {
    toVerifier(actual).verifyEquals(expected, message, params);
  }

  public void isNotNull(final Object actual) {
    toVerifier(actual).verifyIsNotNull();
  }

  public void isNotNull(final Object actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsNotNull(message, params);
  }

  public void isNull(final Object actual) {
    toVerifier(actual).verifyIsNull();
  }

  public void isNull(final Object actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsNull(message, params);
  }

  public void notEquals(final Object actual, final Object expected) {
    toVerifier(actual).verifyNotEquals(expected);
  }

  public void notEquals(final Object actual, final Object expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotEquals(expected, message, params);
  }

  protected ObjectVerify<Object, ObjectState<Object>> toVerifier(Object actual) {
    return new ObjectVerify<>() {
      @Override
      public ObjectState<Object> _toState(Object o) {
        return () -> actual;
      }

      @Override
      public Object _get() {
        return actual;
      }
    };
  }
}
