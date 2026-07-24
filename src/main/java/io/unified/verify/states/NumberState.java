package io.unified.verify.states;

import java.util.Objects;

public interface NumberState<N extends Number & Comparable<N>> extends ObjectState<N> {

  default boolean betweenExclusive(final N lowerBound, final N higherBound) {
    Objects.requireNonNull(lowerBound);
    Objects.requireNonNull(higherBound);
    if (lowerBound.compareTo(higherBound) > 0) {
      throw new IllegalArgumentException("Lower Bound value should be less or equal to Higher Bound Value");
    }
    N o = _get();
    return o.compareTo(higherBound) < 0 && o.compareTo(lowerBound) > 0;
  }

  default boolean betweenInclusive(final N lowerBound, final N higherBound) {
    Objects.requireNonNull(lowerBound);
    Objects.requireNonNull(higherBound);
    if (lowerBound.compareTo(higherBound) > 0) {
      throw new IllegalArgumentException("Lower Bound value should be less or equal to Higher Bound Value");
    }
    N o = _get();
    return o.compareTo(higherBound) <= 0 && o.compareTo(lowerBound) >= 0;
  }

  default boolean isEqual(final N expected) {
    N o = _get();
    return o == null || expected == null ? o == expected : o.compareTo(expected) == 0;
  }

  default boolean isNotEqual(final N expected) {
    N o = _get();
    return o == null || expected == null ? o != expected : o.compareTo(expected) != 0;
  }

  default boolean isEqual(final N expected, final N precision) {
    N o = _get();
    if (o == null || expected == null) return o == expected;
    if (o instanceof Integer) return Math.abs(o.intValue() - expected.intValue()) <= precision.intValue();
    if (o instanceof Long) return Math.abs(o.longValue() - expected.longValue()) <= precision.longValue();
    if (o instanceof Float) return Math.abs(o.floatValue() - expected.floatValue()) <= precision.floatValue();
    if (o instanceof Byte) return Math.abs(o.byteValue() - expected.byteValue()) <= precision.byteValue();
    if (o instanceof Short) return Math.abs(o.shortValue() - expected.shortValue()) <= precision.shortValue();
    return Math.abs(o.doubleValue() - expected.doubleValue()) <= precision.doubleValue();
  }

  default boolean greater(final N expected) {
    Objects.requireNonNull(expected);
    return _get().compareTo(expected) > 0;
  }

  default boolean greaterOrEqual(final N expected) {
    Objects.requireNonNull(expected);
    return _get().compareTo(expected) >= 0;
  }

  default boolean less(final N expected) {
    Objects.requireNonNull(expected);
    return _get().compareTo(expected) < 0;
  }

  default boolean lessOrEqual(final N expected) {
    Objects.requireNonNull(expected);
    return _get().compareTo(expected) <= 0;
  }

  default boolean notBetweenExclusive(final N lowerBound, final N higherBound) {
    return !betweenExclusive(lowerBound, higherBound);
  }

  default boolean notBetweenInclusive(final N lowerBound, final N higherBound) {
    return !betweenInclusive(lowerBound, higherBound);
  }

  default boolean notEquals(final N expected, final N precision) {
    return !isEqual(expected, precision);
  }
}
