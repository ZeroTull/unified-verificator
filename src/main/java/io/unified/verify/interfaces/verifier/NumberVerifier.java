package io.unified.verify.interfaces.verifier;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.interfaces.base.NumberVerify;
import io.unified.verify.states.NumberState;

import java.util.HashMap;
import java.util.Map;

public interface NumberVerifier<N extends Number & Comparable<N>>
    extends ObjectVerifier<N, NumberState<N>>, NumberVerify<N> {

  default void verifyBetweenExclusive(final VerificationQueue verifier, final N lowerBound, final N higherBound) {
    verifyBetweenExclusive(verifier, lowerBound, higherBound,
        getDefaultMessage("Is Between %s And %s (Exclusive)", lowerBound, higherBound));
  }

  default void verifyBetweenExclusive(final VerificationQueue verifier, final N lowerBound, final N higherBound, final String message, final Object... params) {
    Map<String, N> map = new HashMap<>();
    map.put("Lower Bound", lowerBound);
    map.put("Higher Bound", higherBound);
    _verify(verifier, map, (o, o2) -> _toState(o).betweenExclusive(lowerBound, higherBound), message, params);
  }

  default void verifyBetweenInclusive(final VerificationQueue verifier, final N lowerBound, final N higherBound) {
    verifyBetweenInclusive(verifier, lowerBound, higherBound,
        getDefaultMessage("Is Between %s And %s (Inclusive)", lowerBound, higherBound));
  }

  default void verifyBetweenInclusive(final VerificationQueue verifier, final N lowerBound, final N higherBound, final String message, final Object... params) {
    Map<String, N> map = new HashMap<>();
    map.put("Lower Bound", lowerBound);
    map.put("Higher Bound", higherBound);
    _verify(verifier, map, (o, o2) -> _toState(o).betweenInclusive(lowerBound, higherBound), message, params);
  }

  default void verifyGreater(final VerificationQueue verifier, final N expected) {
    verifyGreater(verifier, expected, getDefaultMessage("Is Greater Than The Expected Value"));
  }

  default void verifyGreater(final VerificationQueue verifier, final N expected, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).greater(o2), message, params);
  }

  default void verifyGreaterOrEqual(final VerificationQueue verifier, final N expected) {
    verifyGreaterOrEqual(verifier, expected, getDefaultMessage("Is Greater Than Or Equal To The Expected Value"));
  }

  default void verifyGreaterOrEqual(final VerificationQueue verifier, final N expected, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).greaterOrEqual(o2), message, params);
  }

  default void verifyLess(final VerificationQueue verifier, final N expected) {
    verifyLess(verifier, expected, getDefaultMessage("Is Less Than The Expected Value"));
  }

  default void verifyLess(final VerificationQueue verifier, final N expected, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).less(o2), message, params);
  }

  default void verifyLessOrEqual(final VerificationQueue verifier, final N expected) {
    verifyLessOrEqual(verifier, expected, getDefaultMessage("Is Less Than Or Equal To The Expected Value"));
  }

  default void verifyLessOrEqual(final VerificationQueue verifier, final N expected, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).lessOrEqual(o2), message, params);
  }
}
