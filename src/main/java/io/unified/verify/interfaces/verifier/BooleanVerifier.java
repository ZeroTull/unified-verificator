package io.unified.verify.interfaces.verifier;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.extensions.BooleanExtension;
import io.unified.verify.states.BooleanState;

public interface BooleanVerifier extends BooleanExtension, ObjectVerifier<Boolean, BooleanState> {

  default void verifyIsFalse(final VerificationQueue verifier) {
    verifyIsFalse(verifier, getDefaultMessage("Is False"));
  }

  default void verifyIsFalse(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, false, (a, b) -> _toState(a).isFalse(), message, params);
  }

  default void verifyIsTrue(final VerificationQueue verifier) {
    verifyIsTrue(verifier, getDefaultMessage("Is True"));
  }

  default void verifyIsTrue(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, true, (a, b) -> _toState(a).isTrue(), message, params);
  }

  default void verifyNotEquals(final VerificationQueue verifier, final Boolean expected) {
    verifyNotEquals(verifier, expected, getDefaultMessage("Not Equals"));
  }

  default void verifyNotEquals(final VerificationQueue verifier, final Boolean expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, b) -> _toState(a).isNotEqual(b), message, params);
  }
}
