package io.unified.verify.hard;

import io.unified.verify.interfaces.base.NumberVerify;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberVerification<N extends Number & Comparable<N>> extends BaseVerification {

  public void betweenExclusive(final N actual, final N lowerBound, final N higherBound) {
    toVerifier(actual).verifyBetweenExclusive(lowerBound, higherBound);
  }

  public void betweenExclusive(final N actual, final N lowerBound, final N higherBound, final String message, final Object... params) {
    toVerifier(actual).verifyBetweenExclusive(lowerBound, higherBound, message, params);
  }

  public void betweenInclusive(final N actual, final N lowerBound, final N higherBound) {
    toVerifier(actual).verifyBetweenInclusive(lowerBound, higherBound);
  }

  public void betweenInclusive(final N actual, final N lowerBound, final N higherBound, final String message, final Object... params) {
    toVerifier(actual).verifyBetweenInclusive(lowerBound, higherBound, message, params);
  }

  public void equals(final N actual, final N expected) {
    toVerifier(actual).verifyEquals(expected);
  }

  public void equals(final N actual, final N expected, final String message, final Object... params) {
    toVerifier(actual).verifyEquals(expected, message, params);
  }

  public void equalsP(final N actual, final N expected, final N precision) {
    toVerifier(actual).verifyEqualsP(expected, precision);
  }

  public void equalsP(final N actual, final N expected, final N precision, final String message, final Object... params) {
    toVerifier(actual).verifyEqualsP(expected, precision, message, params);
  }

  public void greater(final N actual, final N expected) {
    toVerifier(actual).verifyGreater(expected);
  }

  public void greater(final N actual, final N expected, final String message, final Object... params) {
    toVerifier(actual).verifyGreater(expected, message, params);
  }

  public void greaterOrEqual(final N actual, final N expected) {
    toVerifier(actual).verifyGreaterOrEqual(expected);
  }

  public void greaterOrEqual(final N actual, final N expected, final String message, final Object... params) {
    toVerifier(actual).verifyGreaterOrEqual(expected, message, params);
  }

  public void less(final N actual, final N expected) {
    toVerifier(actual).verifyLess(expected);
  }

  public void less(final N actual, final N expected, final String message, final Object... params) {
    toVerifier(actual).verifyLess(expected, message, params);
  }

  public void lessOrEqual(final N actual, final N expected) {
    toVerifier(actual).verifyLessOrEqual(expected);
  }

  public void lessOrEqual(final N actual, final N expected, final String message, final Object... params) {
    toVerifier(actual).verifyLessOrEqual(expected, message, params);
  }

  public void notBetweenExclusive(final N actual, final N lowerBound, final N higherBound) {
    toVerifier(actual).verifyNotBetweenExclusive(lowerBound, higherBound);
  }

  public void notBetweenExclusive(final N actual, final N lowerBound, final N higherBound, final String message, final Object... params) {
    toVerifier(actual).verifyNotBetweenExclusive(lowerBound, higherBound, message, params);
  }

  public void notBetweenInclusive(final N actual, final N lowerBound, final N higherBound) {
    toVerifier(actual).verifyNotBetweenInclusive(lowerBound, higherBound);
  }

  public void notBetweenInclusive(final N actual, final N lowerBound, final N higherBound, final String message, final Object... params) {
    toVerifier(actual).verifyNotBetweenInclusive(lowerBound, higherBound, message, params);
  }

  public void notEquals(final N actual, final N expected) {
    toVerifier(actual).verifyNotEquals(expected);
  }

  public void notEquals(final N actual, final N expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotEquals(expected, message, params);
  }

  public void notEqualsP(final N actual, final N expected, final N precision) {
    toVerifier(actual).verifyNotEqualsP(expected, precision);
  }

  public void notEqualsP(final N actual, final N expected, final N precision, final String message, final Object... params) {
    toVerifier(actual).verifyNotEqualsP(expected, precision, message, params);
  }

  protected NumberVerify<N> toVerifier(N actual) {
    return () -> actual;
  }
}
