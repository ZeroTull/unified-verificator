package io.unified.verify.interfaces.verifier;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.interfaces.base.IterableVerify;
import io.unified.verify.states.IterableState;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface IterableVerifier<E, C extends Iterable<E>>
    extends ObjectVerifier<C, IterableState<E, C>>, IterableVerify<E, C> {

  default void verifyContains(final VerificationQueue verifier, E expected) {
    verifyContains(verifier, expected, getDefaultMessage("Contains The Record"));
  }

  default void verifyContains(final VerificationQueue verifier, E expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, e) -> _toState(a).contains(e), message, params);
  }

  default void verifyContainsAll(final VerificationQueue verifier, C expected) {
    verifyContainsAll(verifier, expected, getDefaultMessage("Contains All"));
  }

  default void verifyContainsAll(final VerificationQueue verifier, C expected, final String message, final Object... params) {
    _verify(verifier, expected,
        (a, e) -> {
          if (e == null) return false;
          List<E> diff = new ArrayList<>();
          _toState(a).containsAll(e, diff::add);
          return diff.isEmpty();
        },
        message, params);
  }

  default void verifyContainsNone(final VerificationQueue verifier, C expected) {
    verifyContainsNone(verifier, expected, getDefaultMessage("Contains None"));
  }

  default void verifyContainsNone(final VerificationQueue verifier, C expected, final String message, final Object... params) {
    _verify(verifier, expected,
        (a, e) -> {
          List<E> diff = new ArrayList<>();
          _toState(a).containsNone(e, diff::add);
          boolean hasExpected = e != null && e.iterator().hasNext();
          return hasExpected && diff.isEmpty();
        },
        message, params);
  }

  default void verifyIsEmpty(final VerificationQueue verifier) {
    verifyIsEmpty(verifier, getDefaultMessage("Is Empty"));
  }

  default void verifyIsEmpty(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, true, (a, e) -> _toState(a).isEmpty(), message, params);
  }

  default void verifyIsNotEmpty(final VerificationQueue verifier) {
    verifyIsNotEmpty(verifier, getDefaultMessage("Is Not Empty"));
  }

  default void verifyIsNotEmpty(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, true, (a, e) -> _toState(a).isNotEmpty(), message, params);
  }

  default void verifyNotContains(final VerificationQueue verifier, E expected) {
    verifyNotContains(verifier, expected, getDefaultMessage("Does Not Contains The Record"));
  }

  default void verifyNotContains(final VerificationQueue verifier, E expected, final String message, final Object... params) {
    _verify(verifier, expected, (a, e) -> _toState(a).notContains(e), message, params);
  }

  default void verifyHas(final VerificationQueue verifier, Predicate<E> expected) {
    verifyHas(verifier, expected, getDefaultMessage("Has The Record With Defined Condition"));
  }

  default void verifyHas(final VerificationQueue verifier, Predicate<E> expected, final String message, final Object... params) {
    _verify(verifier, "true", (a, e) -> _toState(a).has(expected), message, params);
  }

  default void verifyHasNot(final VerificationQueue verifier, Predicate<E> expected) {
    verifyHasNot(verifier, expected, getDefaultMessage("Has Not The Record With Defined Condition"));
  }

  default void verifyHasNot(final VerificationQueue verifier, Predicate<E> expected, final String message, final Object... params) {
    _verify(verifier, "true", (a, e) -> _toState(a).hasNot(expected), message, params);
  }
}
