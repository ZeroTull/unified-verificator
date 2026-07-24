package io.unified.verify.interfaces.verifier;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.interfaces.base.MapVerify;
import io.unified.verify.states.MapState;

import java.util.Map;

public interface MapVerifier<K, V> extends ObjectVerifier<Map<K, V>, MapState<K, V>>, MapVerify<K, V> {

  default void verifyContains(final VerificationQueue verifier, K expectedKey, V expectedValue) {
    verifyContains(verifier, Map.entry(expectedKey, expectedValue));
  }

  default void verifyContains(final VerificationQueue verifier, Map.Entry<K, V> expected) {
    verifyContains(verifier, expected, getDefaultMessage("Contains The Expected Value"));
  }

  default void verifyContains(final VerificationQueue verifier, Map.Entry<K, V> expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, e) -> _toState(a).contains(e), message, params);
  }

  default void verifyIsEmpty(final VerificationQueue verifier) {
    verifyIsEmpty(verifier, getDefaultMessage("Is Empty"));
  }

  default void verifyIsEmpty(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, true, (o, o2) -> _get() == null || _get().isEmpty(), message, params);
  }

  default void verifyIsNotEmpty(final VerificationQueue verifier) {
    verifyIsNotEmpty(verifier, getDefaultMessage("Is Not Empty"));
  }

  default void verifyIsNotEmpty(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, true, (o, o2) -> _toState(o).isNotEmpty(), message, params);
  }

  default void verifyNotContains(final VerificationQueue verifier, K expectedKey, V expectedValue) {
    verifyNotContains(verifier, Map.entry(expectedKey, expectedValue));
  }

  default void verifyNotContains(final VerificationQueue verifier, Map.Entry<K, V> expected) {
    verifyNotContains(verifier, expected, getDefaultMessage("Not Contains Expected Value"));
  }

  default void verifyNotContains(final VerificationQueue verifier, Map.Entry<K, V> expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, e) -> _toState(a).notContains(e), message, params);
  }
}
