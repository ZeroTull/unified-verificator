package io.unified.verify.interfaces.base;

import io.unified.verify.states.MapState;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public interface MapVerify<K, V> extends ObjectVerify<Map<K, V>, MapState<K, V>> {

  @Override
  default MapState<K, V> _toState(Map<K, V> e) {
    return () -> e;
  }

  default void verifyContains(K expectedKey, V expectedValue) {
    verifyContains(Map.entry(expectedKey, expectedValue));
  }

  default void verifyContains(K expectedKey, V expectedValue, final String message, final Object... params) {
    verifyContains(Map.entry(expectedKey, expectedValue), message, params);
  }

  default void verifyContains(Map.Entry<K, V> expected) {
    verifyContains(expected, getDefaultMessage("Contains The Expected Value"));
  }

  default void verifyContains(Map.Entry<K, V> expected, final String message, final Object... params) {
    _verify(
        expected,
        (a, e) -> {
          if (_get() == null || e == null) return false;
          if (!_get().containsKey(e.getKey())) {
            logger.warn("Key does not exist in map. Expected: '{}' Actual: '{}'", e.getKey(), _get().keySet());
            return false;
          }
          V value = _get().get(e.getKey());
          if (!Objects.equals(value, e.getValue())) {
            logger.warn("Expected Value does not match the map entity. Expected: '{}' Actual: '{}'", e.getValue(), value);
            return false;
          }
          return true;
        },
        message,
        params);
  }

  default void verifyContainsAll(Map<K, V> expected, final String message, final Object... params) {
    _verify(
        expected,
        (a, e) -> {
          if (e == null) return false;
          Map<K, V> diff = new HashMap<>();
          boolean result = _toState(a).containsAll(e, entry -> diff.put(entry.getKey(), entry.getValue()));
          if (!diff.isEmpty()) logger.warn("Actual list does not contain following records:\n" + diff);
          return result;
        },
        message,
        params);
  }

  default void verifyContainsAll(Map<K, V> expected) {
    verifyContainsAll(expected, getDefaultMessage("Contains All The Expected Map"));
  }

  default void verifyContainsNone(Map<K, V> expected, final String message, final Object... params) {
    _verify(
        expected,
        (a, e) -> {
          if (e == null) return false;
          Map<K, V> diff = new HashMap<>();
          boolean result = _toState(a).containsNone(e, entry -> diff.put(entry.getKey(), entry.getValue()));
          if (!diff.isEmpty()) logger.warn("Actual list contains following records:\n" + diff);
          return result;
        },
        message,
        params);
  }

  default void verifyContainsNone(Map<K, V> expected) {
    verifyContainsNone(expected, getDefaultMessage("Not Contains Any Record From The Expected Map"));
  }

  default void verifyEmptyOrContains(K expectedKey, V expectedValue) {
    verifyEmptyOrContains(Map.entry(expectedKey, expectedValue));
  }

  default void verifyEmptyOrContains(K expectedKey, V expectedValue, final String message, final Object... params) {
    verifyEmptyOrContains(Map.entry(expectedKey, expectedValue), message, params);
  }

  default void verifyEmptyOrContains(Map.Entry<K, V> expected) {
    verifyEmptyOrContains(expected, getDefaultMessage("Is Empty Or Contains The Expected Value"));
  }

  default void verifyEmptyOrContains(Map.Entry<K, V> expected, final String message, final Object... params) {
    Objects.requireNonNull(expected);
    Objects.requireNonNull(expected.getKey());
    _verify(
        expected,
        (a, e) -> {
          if (_get() == null) return false;
          if (_get().isEmpty()) return true;
          if (!_get().containsKey(e.getKey())) {
            logger.warn("Key does not exist in map. Expected Key: '{}' Actual keys: '{}'", e.getKey(), _get().keySet());
            return false;
          }
          V value = _get().get(e.getKey());
          if (!Objects.equals(value, e.getValue())) {
            logger.warn("Expected Value does not match the map entity. Expected Key: '{}' Actual keys: '{}'", e.getValue(), value);
            return false;
          }
          return true;
        },
        message,
        params);
  }

  default void verifyEmptyOrNotContains(K expectedKey, V expectedValue) {
    verifyEmptyOrNotContains(Map.entry(expectedKey, expectedValue));
  }

  default void verifyEmptyOrNotContains(K expectedKey, V expectedValue, final String message, final Object... params) {
    verifyEmptyOrNotContains(Map.entry(expectedKey, expectedValue), message, params);
  }

  default void verifyEmptyOrNotContains(Map.Entry<K, V> expected) {
    verifyEmptyOrNotContains(expected, getDefaultMessage("Is Empty Or Not Contains The Expected Value"));
  }

  default void verifyEmptyOrNotContains(Map.Entry<K, V> expected, final String message, final Object... params) {
    Objects.requireNonNull(expected.getKey());
    _verify(expected, (a, e) -> _toState(a).emptyOrNotContains(e), message, params);
  }

  default void verifyEquals(Map<K, V> expected) {
    verifyEquals(expected, getDefaultMessage("Equals Expected Value"));
  }

  default void verifyEquals(Map<K, V> expected, final String message, final Object... params) {
    _verify(
        expected,
        (o, o2) -> {
          Map<K, V> diffActual = new HashMap<>();
          Map<K, V> diffExpected = new HashMap<>();
          boolean equals = _toState(o).isEqual(o2,
              entry -> diffActual.put(entry.getKey(), entry.getValue()),
              entry -> diffExpected.put(entry.getKey(), entry.getValue()));
          if (!diffExpected.isEmpty()) logger.warn("Actual list does not contain following records:\n" + diffExpected);
          if (!diffActual.isEmpty()) logger.warn("Expected list does not contain following records:\n" + diffActual);
          return equals;
        },
        message,
        params);
  }

  default void verifyIsEmpty() {
    verifyIsEmpty(getDefaultMessage("Is Empty"));
  }

  default void verifyIsEmpty(final String message, final Object... params) {
    _verify(true, (o, o2) -> _get() == null || _get().isEmpty(), message, params);
  }

  default void verifyIsNotEmpty() {
    verifyIsNotEmpty(getDefaultMessage("Is Not Empty"));
  }

  default void verifyIsNotEmpty(final String message, final Object... params) {
    _verify(true, (o, o2) -> _toState(o).isNotEmpty(), message, params);
  }

  default void verifyNotContains(K expectedKey, V expectedValue) {
    verifyNotContains(Map.entry(expectedKey, expectedValue));
  }

  default void verifyNotContains(K expectedKey, V expectedValue, final String message, final Object... params) {
    verifyNotContains(Map.entry(expectedKey, expectedValue), message, params);
  }

  default void verifyNotContains(Map.Entry<K, V> expected) {
    verifyNotContains(expected, getDefaultMessage("Not Contains Expected Value"));
  }

  default void verifyNotContains(Map.Entry<K, V> expected, final String message, final Object... params) {
    _verify(expected, (a, e) -> _toState(a).notContains(e), message, params);
  }

  default void verifyNotContainsAll(Map<K, V> expected) {
    verifyNotContainsAll(expected, getDefaultMessage("Not Contains All Expected Values"));
  }

  default void verifyNotContainsAll(Map<K, V> expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).notContainsAll(o2), message, params);
  }

  default void verifySizeEquals(int expected) {
    verifySizeEquals(expected, getDefaultMessage("Size Is Equal To Expected Value"));
  }

  default void verifySizeEquals(int expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).sizeEquals(o2), message, params);
  }

  default void verifySizeIsGreaterThan(int expected) {
    verifySizeIsGreaterThan(expected, getDefaultMessage("Size Is Greater Than Expected Value"));
  }

  default void verifySizeIsGreaterThan(int expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).sizeIsGreaterThan(o2), message, params);
  }

  default void verifySizeIsGreaterThanOrEqual(int expected) {
    verifySizeIsGreaterThanOrEqual(expected, getDefaultMessage("Size Is Greater Than Expected Value"));
  }

  default void verifySizeIsGreaterThanOrEqual(int expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).sizeIsGreaterThanOrEqual(o2), message, params);
  }

  default void verifySizeIsLessThan(int expected) {
    verifySizeIsLessThan(expected, getDefaultMessage("Size Is Less Than Expected Value"));
  }

  default void verifySizeIsLessThan(int expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).sizeIsLessThan(o2), message, params);
  }

  default void verifySizeIsLessThanOrEqual(int expected) {
    verifySizeIsLessThanOrEqual(expected, getDefaultMessage("Size Is Less Than Or Equal Expected Value"));
  }

  default void verifySizeIsLessThanOrEqual(int expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).sizeIsLessThanOrEqual(o2), message, params);
  }
}
