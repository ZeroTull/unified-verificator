package io.unified.verify.states;

import java.util.Objects;
import java.util.function.Predicate;

public interface ObjectState<O> extends BaseState<O> {

  default boolean test(Predicate<O> predicate) {
    return predicate.test(_get());
  }

  default boolean isEqual(O expected) {
    return Objects.equals(_get(), expected);
  }

  default boolean isNotEqual(final O expected) {
    return !isEqual(expected);
  }

  default boolean equalsAny(final O... expected) {
    if (expected == null) return false;
    for (O o : expected) {
      if (isEqual(o)) return true;
    }
    return false;
  }

  default boolean equalsAny(final Iterable<O> expected) {
    if (expected == null) return false;
    for (O o : expected) {
      if (isEqual(o)) return true;
    }
    return false;
  }

  default boolean equalsNone(final O... expected) {
    if (expected == null) return false;
    for (O o : expected) {
      if (isEqual(o)) return false;
    }
    boolean hasElements = false;
    for (O ignored : expected) { hasElements = true; break; }
    return hasElements;
  }

  default boolean equalsNone(final Iterable<O> expected) {
    if (expected == null) return false;
    boolean hasElements = false;
    for (O o : expected) {
      hasElements = true;
      if (isEqual(o)) return false;
    }
    return hasElements;
  }

  default boolean isNull() {
    return _get() == null;
  }

  default boolean isNotNull() {
    return _get() != null;
  }
}
