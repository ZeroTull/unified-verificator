package io.unified.verify.states;

import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public interface MapState<K, V> extends ObjectState<Map<K, V>> {

  default boolean contains(K expectedKey, V expectedValue) {
    return contains(Map.entry(expectedKey, expectedValue));
  }

  default boolean contains(Map.Entry<K, V> expected) {
    if (expected == null) return false;
    Map<K, V> a = _get();
    return a.containsKey(expected.getKey())
        && Objects.equals(a.get(expected.getKey()), expected.getValue());
  }

  default boolean containsAll(Map<K, V> expected) {
    return containsAll(expected, null);
  }

  default boolean containsAll(Map<K, V> expected, Consumer<Map.Entry<K, V>> onNotMatch) {
    if (expected == null) return false;
    boolean result = true;
    Map<K, V> a = _get();
    for (Map.Entry<K, V> t : expected.entrySet()) {
      if (!a.containsKey(t.getKey()) || !Objects.equals(a.get(t.getKey()), t.getValue())) {
        if (onNotMatch == null) return false;
        result = false;
        onNotMatch.accept(t);
      }
    }
    return result;
  }

  default boolean containsNone(Map<K, V> expected) {
    return containsNone(expected, null);
  }

  default boolean containsNone(Map<K, V> expected, Consumer<Map.Entry<K, V>> onMatch) {
    if (expected == null) return false;
    boolean result = !expected.isEmpty();
    Map<K, V> a = _get();
    for (Map.Entry<K, V> t : expected.entrySet()) {
      if (a.containsKey(t.getKey()) && Objects.equals(a.get(t.getKey()), t.getValue())) {
        if (onMatch == null) return false;
        result = false;
        onMatch.accept(t);
      }
    }
    return result;
  }

  default boolean emptyOrContains(K expectedKey, V expectedValue) {
    return emptyOrContains(Map.entry(expectedKey, expectedValue));
  }

  default boolean emptyOrContains(Map.Entry<K, V> expected) {
    if (expected == null) return false;
    Map<K, V> a = _get();
    if (a == null) return true;
    return a.isEmpty()
        || (a.containsKey(expected.getKey())
            && Objects.equals(a.get(expected.getKey()), expected.getValue()));
  }

  default boolean emptyOrNotContains(K expectedKey, V expectedValue) {
    return emptyOrNotContains(Map.entry(expectedKey, expectedValue));
  }

  default boolean emptyOrNotContains(Map.Entry<K, V> expected) {
    if (expected == null) return false;
    Map<K, V> a = _get();
    if (a == null) return true;
    return a.isEmpty()
        || !(a.containsKey(expected.getKey())
            && Objects.equals(a.get(expected.getKey()), expected.getValue()));
  }

  default boolean isEqual(final Map<K, V> expected) {
    return Objects.equals(_get(), expected);
  }

  default boolean isEqual(
      Map<K, V> expected,
      Consumer<Map.Entry<K, V>> onActualNotContains,
      Consumer<Map.Entry<K, V>> onExpectedNotContains) {
    if (expected == null) return false;
    Map<K, V> actual = _get();
    boolean result = true;
    for (Map.Entry<K, V> t : expected.entrySet()) {
      if (!actual.containsKey(t.getKey()) || !Objects.equals(actual.get(t.getKey()), t.getValue())) {
        if (onActualNotContains == null) return false;
        result = false;
        onActualNotContains.accept(t);
      }
    }
    for (Map.Entry<K, V> t : actual.entrySet()) {
      if (!expected.containsKey(t.getKey()) || !Objects.equals(expected.get(t.getKey()), t.getValue())) {
        if (onExpectedNotContains == null) return false;
        result = false;
        onExpectedNotContains.accept(t);
      }
    }
    return expected.size() == actual.size() && result;
  }

  default boolean isNotEmpty() {
    return _get() != null && !_get().isEmpty();
  }

  default boolean notContains(K expectedKey, V expectedValue) {
    return notContains(Map.entry(expectedKey, expectedValue));
  }

  default boolean notContains(Map.Entry<K, V> expected) {
    if (expected == null) return false;
    Map<K, V> a = _get();
    return !(a.containsKey(expected.getKey())
        && Objects.equals(a.get(expected.getKey()), expected.getValue()));
  }

  default boolean notContainsAll(Map<K, V> expected) {
    if (expected == null || expected.isEmpty()) return false;
    Map<K, V> a = _get();
    for (Map.Entry<K, V> t : expected.entrySet()) {
      if (!a.containsKey(t.getKey()) || !Objects.equals(a.get(t.getKey()), t.getValue())) {
        return true;
      }
    }
    return false;
  }

  default boolean sizeEquals(int expected) {
    return _get() == null ? 0 == expected : _get().size() == expected;
  }

  default boolean sizeIsGreaterThan(int expected) {
    return _get() == null ? 0 > expected : _get().size() > expected;
  }

  default boolean sizeIsGreaterThanOrEqual(int expected) {
    return _get() == null ? 0 >= expected : _get().size() >= expected;
  }

  default boolean sizeIsLessThan(int expected) {
    return _get() == null ? 0 < expected : _get().size() < expected;
  }

  default boolean sizeIsLessThanOrEqual(int expected) {
    return _get() == null ? 0 <= expected : _get().size() <= expected;
  }
}
