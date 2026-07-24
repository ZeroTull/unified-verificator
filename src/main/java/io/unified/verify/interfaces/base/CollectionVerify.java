package io.unified.verify.interfaces.base;

import io.unified.verify.states.CollectionState;

import java.util.Collection;

public interface CollectionVerify<E, C extends Collection<E>> extends IterableVerify<E, C> {

  @Override
  default CollectionState<E, C> _toState(C e) {
    return () -> e;
  }

  default void verifySizeEquals(int expected) {
    verifySizeEquals(expected, getDefaultMessage("Size Equals"));
  }

  default void verifySizeEquals(int expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).sizeEquals(o2), message, params);
  }

  default void verifySizeIsGreaterThan(int expected) {
    verifySizeIsGreaterThan(expected, getDefaultMessage("Size Is Greater Than"));
  }

  default void verifySizeIsGreaterThan(int expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).sizeIsGreaterThan(o2), message, params);
  }

  default void verifySizeIsLessThan(int expected) {
    verifySizeIsLessThan(expected, getDefaultMessage("Size Is Less Than"));
  }

  default void verifySizeIsLessThan(int expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).sizeIsLessThan(o2), message, params);
  }
}
