package io.unified.verify.interfaces.base;

import io.unified.verify.states.IterableState;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface IterableVerify<E, C extends Iterable<E>>
    extends ObjectVerify<C, IterableState<E, C>> {

  @Override
  default IterableState<E, C> _toState(C e) {
    return () -> e;
  }

  default void verifyContains(E expected) {
    verifyContains(expected, getDefaultMessage("Contains The Record"));
  }

  default void verifyContains(E expected, final String message, final Object... params) {
    _verify(expected, (a, e) -> _toState(a).contains(e), message, params);
  }

  default void verifyContainsAll(C expected) {
    verifyContainsAll(expected, getDefaultMessage("Contains All"));
  }

  default void verifyContainsAll(C expected, final String message, final Object... params) {
    _verify(
        expected,
        (a, e) -> {
          if (e == null) return false;
          List<E> diff = new ArrayList<>();
          _toState(a).containsAll(e, diff::add);
          if (!diff.isEmpty()) {
            logger.trace("Actual list does not contain following records:\n" + diff);
          }
          return diff.isEmpty();
        },
        message,
        params);
  }

  default void verifyContainsNone(C expected) {
    verifyContainsNone(expected, getDefaultMessage("Contains None"));
  }

  default void verifyContainsNone(C expected, final String message, final Object... params) {
    _verify(
        expected,
        (a, e) -> {
          List<E> diff = new ArrayList<>();
          _toState(a).containsNone(e, diff::add);
          if (!diff.isEmpty()) {
            logger.trace("Actual list contains following records:\n" + diff);
          }
          boolean hasExpected = e != null && e.iterator().hasNext();
          return hasExpected && diff.isEmpty();
        },
        message,
        params);
  }

  default void verifyEmptyOrContains(E expected) {
    verifyEmptyOrContains(expected, getDefaultMessage("Is Empty Or Contains The Record"));
  }

  default void verifyEmptyOrContains(E expected, final String message, final Object... params) {
    _verify(expected, (a, e) -> _toState(a).emptyOrContains(e), message, params);
  }

  default void verifyEmptyOrNotContains(E expected) {
    verifyEmptyOrNotContains(expected, getDefaultMessage("Is Empty Or Not Contains The Record"));
  }

  default void verifyEmptyOrNotContains(E expected, final String message, final Object... params) {
    _verify(expected, (a, e) -> _toState(a).emptyOrNotContains(e), message, params);
  }

  default void verifyEquals(C expected) {
    verifyEquals(expected, getDefaultMessage("Records Are Equals"));
  }

  default void verifyEquals(C expected, final String message, final Object... params) {
    _verify(
        expected,
        (a, e) -> {
          List<E> diffActual = new ArrayList<>();
          List<E> diffExpected = new ArrayList<>();
          boolean result = _toState(a).isEqual(e, diffActual::add, diffExpected::add);
          if (!diffExpected.isEmpty()) logger.trace("Actual list does not contain following records:\n" + diffExpected);
          if (!diffActual.isEmpty()) logger.trace("Expected list does not contain following records:\n" + diffActual);
          return result;
        },
        message,
        params);
  }

  default void verifyHas(Predicate<E> expected) {
    verifyHas(expected, getDefaultMessage("Has The Record With Defined Condition"));
  }

  default void verifyHas(Predicate<E> expected, final String message, final Object... params) {
    _verify("true", (a, e) -> _toState(a).has(expected), message, params);
  }

  default void verifyHasNot(Predicate<E> expected) {
    verifyHasNot(expected, getDefaultMessage("Has Not The Record With Defined Condition"));
  }

  default void verifyHasNot(Predicate<E> expected, final String message, final Object... params) {
    _verify("true", (a, e) -> _toState(a).hasNot(expected), message, params);
  }

  default void verifyIsEmpty() {
    verifyIsEmpty(getDefaultMessage("Is Empty"));
  }

  default void verifyIsEmpty(final String message, final Object... params) {
    _verify(true, (a, e) -> _toState(a).isEmpty(), message, params);
  }

  default void verifyIsNotEmpty() {
    verifyIsNotEmpty(getDefaultMessage("Is Not Empty"));
  }

  default void verifyIsNotEmpty(final String message, final Object... params) {
    _verify(true, (a, e) -> _toState(a).isNotEmpty(), message, params);
  }

  default void verifyNotContains(E expected) {
    verifyNotContains(expected, getDefaultMessage("Does Not Contains The Record"));
  }

  default void verifyNotContains(E expected, final String message, final Object... params) {
    _verify(expected, (a, e) -> _toState(a).notContains(e), message, params);
  }

  default void verifyNotContainsAll(C expected) {
    verifyNotContainsAll(expected, getDefaultMessage("Does Not Contains All"));
  }

  default void verifyNotContainsAll(C expected, final String message, final Object... params) {
    _verify(expected, (a, e) -> _toState(a).notContainsAll(e), message, params);
  }
}
