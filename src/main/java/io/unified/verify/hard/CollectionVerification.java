package io.unified.verify.hard;

import io.unified.verify.interfaces.base.CollectionVerify;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@Slf4j
public class CollectionVerification extends IterableVerification {

  public <E, C extends Collection<E>> void verifySizeEquals(C actual, int expected) {
    toVerifier(actual).verifySizeEquals(expected);
  }

  public <E, C extends Collection<E>> void verifySizeEquals(C actual, int expected, final String message, final Object... params) {
    toVerifier(actual).verifySizeEquals(expected, message, params);
  }

  public <E, C extends Collection<E>> void verifySizeIsGreaterThan(C actual, int expected) {
    toVerifier(actual).verifySizeIsGreaterThan(expected);
  }

  public <E, C extends Collection<E>> void verifySizeIsGreaterThan(C actual, int expected, final String message, final Object... params) {
    toVerifier(actual).verifySizeIsGreaterThan(expected, message, params);
  }

  public <E, C extends Collection<E>> void verifySizeIsLessThan(C actual, int expected) {
    toVerifier(actual).verifySizeIsLessThan(expected);
  }

  public <E, C extends Collection<E>> void verifySizeIsLessThan(C actual, int expected, final String message, final Object... params) {
    toVerifier(actual).verifySizeIsLessThan(expected, message, params);
  }

  protected <E> CollectionVerify<E, Collection<E>> toVerifier(Collection<E> actual) {
    return () -> actual;
  }
}
