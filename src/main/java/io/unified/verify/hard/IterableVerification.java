package io.unified.verify.hard;

import io.unified.verify.interfaces.base.IterableVerify;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@Slf4j
public class IterableVerification extends BaseVerification {

  public <C extends Iterable<E>, E> void has(C actual, Predicate<E> expected) {
    toVerifier(actual).verifyHas(expected);
  }

  public <C extends Iterable<E>, E> void has(C actual, Predicate<E> expected, final String message, final Object... params) {
    toVerifier(actual).verifyHas(expected, message, params);
  }

  public <C extends Iterable<E>, E> void contains(C actual, E expected) {
    toVerifier(actual).verifyContains(expected);
  }

  public <C extends Iterable<E>, E> void contains(C actual, E expected, final String message, final Object... params) {
    toVerifier(actual).verifyContains(expected, message, params);
  }

  public <C extends Iterable<E>, E> void containsAll(C actual, C expected) {
    toVerifier(actual).verifyContainsAll(expected);
  }

  public <C extends Iterable<E>, E> void containsAll(C actual, C expected, final String message, final Object... params) {
    toVerifier(actual).verifyContainsAll(expected, message, params);
  }

  public <C extends Iterable<E>, E> void containsNone(C actual, C expected) {
    toVerifier(actual).verifyContainsNone(expected);
  }

  public <C extends Iterable<E>, E> void containsNone(C actual, C expected, final String message, final Object... params) {
    toVerifier(actual).verifyContainsNone(expected, message, params);
  }

  public <C extends Iterable<E>, E> void emptyOrContains(C actual, E expected) {
    toVerifier(actual).verifyEmptyOrContains(expected);
  }

  public <C extends Iterable<E>, E> void emptyOrContains(C actual, E expected, final String message, final Object... params) {
    toVerifier(actual).verifyEmptyOrContains(expected, message, params);
  }

  public <C extends Iterable<E>, E> void emptyOrNotContains(C actual, E expected) {
    toVerifier(actual).verifyEmptyOrNotContains(expected);
  }

  public <C extends Iterable<E>, E> void emptyOrNotContains(C actual, E expected, final String message, final Object... params) {
    toVerifier(actual).verifyEmptyOrNotContains(expected, message, params);
  }

  public <C extends Iterable<E>, E> void equals(C actual, C expected) {
    toVerifier(actual).verifyEquals(expected);
  }

  public <C extends Iterable<E>, E> void equals(C actual, C expected, final String message, final Object... params) {
    toVerifier(actual).verifyEquals(expected, message, params);
  }

  public <C extends Iterable<E>, E> void isEmpty(C actual) {
    toVerifier(actual).verifyIsEmpty();
  }

  public <C extends Iterable<E>, E> void isEmpty(C actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsEmpty(message, params);
  }

  public <C extends Iterable<E>, E> void isNotEmpty(C actual) {
    toVerifier(actual).verifyIsNotEmpty();
  }

  public <C extends Iterable<E>, E> void isNotEmpty(C actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsNotEmpty(message, params);
  }

  public <C extends Iterable<E>, E> void notContains(C actual, E expected) {
    toVerifier(actual).verifyNotContains(expected);
  }

  public <C extends Iterable<E>, E> void notContains(C actual, E expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotContains(expected, message, params);
  }

  public <C extends Iterable<E>, E> void notContainsAll(C actual, C expected) {
    toVerifier(actual).verifyNotContainsAll(expected);
  }

  public <C extends Iterable<E>, E> void notContainsAll(C actual, C expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotContainsAll(expected, message, params);
  }

  protected <E> IterableVerify<E, Iterable<E>> toVerifier(Iterable<E> actual) {
    return () -> actual;
  }
}
