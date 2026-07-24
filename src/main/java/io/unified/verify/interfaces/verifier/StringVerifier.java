package io.unified.verify.interfaces.verifier;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.interfaces.base.StringVerify;
import io.unified.verify.states.StringState;

public interface StringVerifier extends ObjectVerifier<String, StringState>, StringVerify {

  default void verifyContains(final VerificationQueue verifier, final String expected) {
    verifyContains(verifier, expected, getDefaultMessage("Value Contains The Expected Value"));
  }

  default void verifyContains(final VerificationQueue verifier, final String expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, b) -> _toState(a).contains(b), message, params);
  }

  default void verifyEquals(final VerificationQueue verifier, final String expected) {
    verifyEquals(verifier, expected, getDefaultMessage("Equals"));
  }

  default void verifyEquals(final VerificationQueue verifier, final String expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, b) -> _toState(a).isEqual(b), message, params);
  }

  default void verifyEqualsIgnoreCase(final VerificationQueue verifier, final String expected) {
    verifyEqualsIgnoreCase(verifier, expected, getDefaultMessage("Equals Ignoring Case"));
  }

  default void verifyEqualsIgnoreCase(final VerificationQueue verifier, final String expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, b) -> _toState(a).equalsIgnoreCase(b), message, params);
  }

  default void verifyIsBlank(final VerificationQueue verifier) {
    verifyIsBlank(verifier, getDefaultMessage("Is Blank"));
  }

  default void verifyIsBlank(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, true, (a, b) -> _toState(a).isBlank(), message, params);
  }

  default void verifyIsNotBlank(final VerificationQueue verifier) {
    verifyIsNotBlank(verifier, getDefaultMessage("Is Not Blank"));
  }

  default void verifyIsNotBlank(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, true, (a, b) -> _toState(a).isNotBlank(), message, params);
  }

  default void verifyNotContains(final VerificationQueue verifier, final String expected) {
    verifyNotContains(verifier, expected, getDefaultMessage("Value Does Not Contain The Expected Value"));
  }

  default void verifyNotContains(final VerificationQueue verifier, final String expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, b) -> _toState(a).notContains(b), message, params);
  }

  default void verifyNotEquals(final VerificationQueue verifier, final String expected) {
    verifyNotEquals(verifier, expected, getDefaultMessage("Not Equals"));
  }

  default void verifyNotEquals(final VerificationQueue verifier, final String expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, b) -> _toState(a).isNotEqual(b), message, params);
  }

  default void verifyStartsWith(final VerificationQueue verifier, final String expected) {
    verifyStartsWith(verifier, expected, getDefaultMessage("Value Starts With The Expected Value"));
  }

  default void verifyStartsWith(final VerificationQueue verifier, final String expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, b) -> _toState(a).startsWith(b), message, params);
  }

  default void verifyEndsWith(final VerificationQueue verifier, final String expected) {
    verifyEndsWith(verifier, expected, getDefaultMessage("Value Ends With The Expected Value"));
  }

  default void verifyEndsWith(final VerificationQueue verifier, final String expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, b) -> _toState(a).endsWith(b), message, params);
  }
}
