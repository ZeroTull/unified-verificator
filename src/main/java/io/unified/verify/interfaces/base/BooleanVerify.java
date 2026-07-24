package io.unified.verify.interfaces.base;

import io.unified.verify.extensions.BooleanExtension;
import io.unified.verify.states.BooleanState;

public interface BooleanVerify extends BooleanExtension, ObjectVerify<Boolean, BooleanState> {

  default void verifyIsFalse() {
    verifyIsFalse(getDefaultMessage("Is False"));
  }

  default void verifyIsFalse(final String message, final Object... params) {
    _verify(false, (a, b) -> _toState(a).isFalse(), message, params);
  }

  default void verifyIsTrue() {
    verifyIsTrue(getDefaultMessage("Is True"));
  }

  default void verifyIsTrue(final String message, final Object... params) {
    _verify(true, (a, b) -> _toState(a).isTrue(), message, params);
  }

  default void verifyNotEquals(final Boolean expected) {
    verifyNotEquals(expected, getDefaultMessage("Not Equals"));
  }

  default void verifyNotEquals(final Boolean expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).isNotEqual(b), message, params);
  }
}
