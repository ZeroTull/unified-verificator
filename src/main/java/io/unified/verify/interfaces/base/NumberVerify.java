package io.unified.verify.interfaces.base;

import io.unified.verify.states.NumberState;

import java.util.HashMap;
import java.util.Map;

public interface NumberVerify<N extends Number & Comparable<N>>
    extends ObjectVerify<N, NumberState<N>> {

  @Override
  default NumberState<N> _toState(N e) {
    return () -> e;
  }

  default void verifyBetweenExclusive(final N lowerBound, final N higherBound) {
    verifyBetweenExclusive(lowerBound, higherBound,
        getDefaultMessage("Is Between %s And %s (Exclusive)", lowerBound, higherBound));
  }

  default void verifyBetweenExclusive(final N lowerBound, final N higherBound, final String message, final Object... params) {
    Map<String, N> map = new HashMap<>();
    map.put("Lower Bound", lowerBound);
    map.put("Higher Bound", higherBound);
    _verify(map, (o, o2) -> _toState(o).betweenExclusive(lowerBound, higherBound), message, params);
  }

  default void verifyBetweenInclusive(final N lowerBound, final N higherBound) {
    verifyBetweenInclusive(lowerBound, higherBound,
        getDefaultMessage("Is Between %s And %s (Inclusive)", lowerBound, higherBound));
  }

  default void verifyBetweenInclusive(final N lowerBound, final N higherBound, final String message, final Object... params) {
    Map<String, N> map = new HashMap<>();
    map.put("Lower Bound", lowerBound);
    map.put("Higher Bound", higherBound);
    _verify(map, (o, o2) -> _toState(o).betweenInclusive(lowerBound, higherBound), message, params);
  }

  default void verifyEqualsP(final N expected, final N precision) {
    verifyEqualsP(expected, precision, getDefaultMessage("Is Equal To The Expected Value"));
  }

  default void verifyEqualsP(final N expected, final N precision, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).isEqual(expected, precision), "[precision: " + precision + "]" + message, params);
  }

  default void verifyGreater(final N expected) {
    verifyGreater(expected, getDefaultMessage("Is Greater Than The Expected Value"));
  }

  default void verifyGreater(final N expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).greater(o2), message, params);
  }

  default void verifyGreaterOrEqual(final N expected) {
    verifyGreaterOrEqual(expected, getDefaultMessage("Is Greater Than Or Equal To The Expected Value"));
  }

  default void verifyGreaterOrEqual(final N expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).greaterOrEqual(o2), message, params);
  }

  default void verifyLess(final N expected) {
    verifyLess(expected, getDefaultMessage("Is Less Than The Expected Value"));
  }

  default void verifyLess(final N expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).less(o2), message, params);
  }

  default void verifyLessOrEqual(final N expected) {
    verifyLessOrEqual(expected, getDefaultMessage("Is Less Than Or Equal To The Expected Value"));
  }

  default void verifyLessOrEqual(final N expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).lessOrEqual(o2), message, params);
  }

  default void verifyNotBetweenExclusive(final N lowerBound, final N higherBound) {
    verifyNotBetweenExclusive(lowerBound, higherBound,
        String.format("Not Is Between %s And %s (Exclusive)", lowerBound, higherBound));
  }

  default void verifyNotBetweenExclusive(final N lowerBound, final N higherBound, final String message, final Object... params) {
    Map<String, N> map = new HashMap<>();
    map.put("Lower Bound", lowerBound);
    map.put("Higher Bound", higherBound);
    _verify(map, (o, o2) -> _toState(o).notBetweenExclusive(lowerBound, higherBound), message, params);
  }

  default void verifyNotBetweenInclusive(final N lowerBound, final N higherBound) {
    verifyNotBetweenInclusive(lowerBound, higherBound,
        String.format("Not Is Between %s And %s (Inclusive)", lowerBound, higherBound));
  }

  default void verifyNotBetweenInclusive(final N lowerBound, final N higherBound, final String message, final Object... params) {
    Map<String, N> map = new HashMap<>();
    map.put("Lower Bound", lowerBound);
    map.put("Higher Bound", higherBound);
    _verify(map, (o, o2) -> _toState(o).notBetweenInclusive(lowerBound, higherBound), message, params);
  }

  default void verifyNotEqualsP(final N expected, final N precision) {
    verifyNotEqualsP(expected, precision, "Is Not Equal To The Expected Value");
  }

  default void verifyNotEqualsP(final N expected, final N precision, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).notEquals(o2, precision), "[precision: " + precision + "]" + message, params);
  }
}
