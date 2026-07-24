package io.unified.verify.states;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface IterableState<E, C extends Iterable<E>> extends ObjectState<C> {

  default boolean has(Predicate<E> expected) {
    for (E a : _get()) {
      if (expected.test(a)) return true;
    }
    return false;
  }

  default boolean hasNot(Predicate<E> expected) {
    for (E a : _get()) {
      if (expected.test(a)) return false;
    }
    return true;
  }

  default boolean isNotEmpty() {
    C c = _get();
    if (c == null) return false;
    return c.iterator().hasNext();
  }

  default boolean isEmpty() {
    return !isNotEmpty();
  }

  default boolean contains(Object o) {
    for (E a : _get()) {
      if (Objects.equals(a, o)) return true;
    }
    return false;
  }

  default boolean containsAny(C expected) {
    if (expected == null) return false;
    C actual = _get();
    for (E t : expected) {
      if (contains(t)) return true;
    }
    return false;
  }

  default boolean containsAll(C expected, Consumer<E> onNotMatch) {
    if (expected == null) return false;
    C actual = _get();
    boolean result = true;
    for (E t : expected) {
      if (!contains(t)) {
        if (onNotMatch == null) return false;
        result = false;
        onNotMatch.accept(t);
      }
    }
    return result;
  }

  default boolean containsNone(C expected) {
    return containsNone(expected, null);
  }

  default boolean containsNone(C expected, Consumer<E> onMatch) {
    if (expected == null) return false;
    boolean hasElements = false;
    for (E ignored : expected) { hasElements = true; break; }
    if (!hasElements) return false;
    C actual = _get();
    boolean result = true;
    for (E t : expected) {
      if (contains(t)) {
        if (onMatch == null) return false;
        result = false;
        onMatch.accept(t);
      }
    }
    return result;
  }

  default boolean emptyOrContains(E expected) {
    C a = _get();
    return a == null || isEmpty() || contains(expected);
  }

  default boolean emptyOrNotContains(E expected) {
    C a = _get();
    return a == null || isEmpty() || !contains(expected);
  }

  default boolean isEqual(C expected) {
    return isEqual(expected, null, null);
  }

  default boolean isEqual(C expected, Consumer<E> onActualNotContains, Consumer<E> onExpectedNotContains) {
    if (expected == null) return false;
    C actual = _get();
    boolean result = true;
    int actualSize = 0;
    int expectedSize = 0;
    for (E t : expected) {
      expectedSize++;
      if (!contains(t)) {
        if (onActualNotContains == null) return false;
        result = false;
        onActualNotContains.accept(t);
      }
    }
    for (E t : actual) {
      actualSize++;
      boolean found = false;
      for (E e : expected) {
        if (Objects.equals(t, e)) { found = true; break; }
      }
      if (!found) {
        if (onExpectedNotContains == null) return false;
        result = false;
        onExpectedNotContains.accept(t);
      }
    }
    return expectedSize == actualSize && result;
  }

  default boolean notContains(E expected) {
    if (expected == null) return false;
    return !contains(expected);
  }

  default boolean notContainsAll(C expected) {
    return notContainsAll(expected, null);
  }

  default boolean notContainsAll(C expected, Consumer<E> onActualContains) {
    if (expected == null) return false;
    boolean hasElements = false;
    for (E ignored : expected) { hasElements = true; break; }
    if (!hasElements) return false;
    C actual = _get();
    for (E t : expected) {
      if (!contains(t)) {
        if (onActualContains == null) return true;
      }
    }
    return false;
  }
}
