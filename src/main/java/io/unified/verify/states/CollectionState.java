package io.unified.verify.states;

import java.util.Collection;

public interface CollectionState<E, C extends Collection<E>> extends IterableState<E, C> {

  default boolean sizeEquals(int expected) {
    return _get().size() == expected;
  }

  default boolean sizeIsGreaterThan(int expected) {
    return _get().size() > expected;
  }

  default boolean sizeIsLessThan(int expected) {
    return _get().size() < expected;
  }
}
