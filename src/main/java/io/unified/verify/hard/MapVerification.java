package io.unified.verify.hard;

import io.unified.verify.interfaces.base.MapVerify;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class MapVerification extends BaseVerification {

  public <K, V> void contains(Map<K, V> actual, Map.Entry<K, V> expected) {
    toVerifier(actual).verifyContains(expected);
  }

  public <K, V> void contains(Map<K, V> actual, Map.Entry<K, V> expected, final String message, final Object... params) {
    toVerifier(actual).verifyContains(expected, message, params);
  }

  public <K, V> void contains(Map<K, V> actual, K expectedKey, V expectedValue) {
    toVerifier(actual).verifyContains(expectedKey, expectedValue);
  }

  public <K, V> void contains(Map<K, V> actual, K expectedKey, V expectedValue, final String message, final Object... params) {
    toVerifier(actual).verifyContains(expectedKey, expectedValue, message, params);
  }

  public <K, V> void containsAll(Map<K, V> actual, Map<K, V> expected) {
    toVerifier(actual).verifyContainsAll(expected);
  }

  public <K, V> void containsAll(Map<K, V> actual, Map<K, V> expected, final String message, final Object... params) {
    toVerifier(actual).verifyContainsAll(expected, message, params);
  }

  public <K, V> void containsNone(Map<K, V> actual, Map<K, V> expected) {
    toVerifier(actual).verifyContainsNone(expected);
  }

  public <K, V> void containsNone(Map<K, V> actual, Map<K, V> expected, final String message, final Object... params) {
    toVerifier(actual).verifyContainsNone(expected, message, params);
  }

  public <K, V> void emptyOrContains(Map<K, V> actual, K expectedKey, V expectedValue) {
    toVerifier(actual).verifyEmptyOrContains(expectedKey, expectedValue);
  }

  public <K, V> void emptyOrContains(Map<K, V> actual, K expectedKey, V expectedValue, final String message, final Object... params) {
    toVerifier(actual).verifyEmptyOrContains(expectedKey, expectedValue, message, params);
  }

  public <K, V> void emptyOrContains(Map<K, V> actual, Map.Entry<K, V> expected) {
    toVerifier(actual).verifyEmptyOrContains(expected);
  }

  public <K, V> void emptyOrContains(Map<K, V> actual, Map.Entry<K, V> expected, final String message, final Object... params) {
    toVerifier(actual).verifyEmptyOrContains(expected, message, params);
  }

  public <K, V> void emptyOrNotContains(Map<K, V> actual, K expectedKey, V expectedValue) {
    toVerifier(actual).verifyEmptyOrNotContains(expectedKey, expectedValue);
  }

  public <K, V> void emptyOrNotContains(Map<K, V> actual, K expectedKey, V expectedValue, final String message, final Object... params) {
    toVerifier(actual).verifyEmptyOrNotContains(expectedKey, expectedValue, message, params);
  }

  public <K, V> void emptyOrNotContains(Map<K, V> actual, Map.Entry<K, V> expected) {
    toVerifier(actual).verifyEmptyOrNotContains(expected);
  }

  public <K, V> void emptyOrNotContains(Map<K, V> actual, Map.Entry<K, V> expected, final String message, final Object... params) {
    toVerifier(actual).verifyEmptyOrNotContains(expected, message, params);
  }

  public <K, V> void equals(Map<K, V> actual, Map<K, V> expected) {
    toVerifier(actual).verifyEquals(expected);
  }

  public <K, V> void equals(Map<K, V> actual, Map<K, V> expected, final String message, final Object... params) {
    toVerifier(actual).verifyEquals(expected, message, params);
  }

  public <K, V> void notEquals(Map<K, V> actual, Map<K, V> expected) {
    toVerifier(actual).verifyNotEquals(expected);
  }

  public <K, V> void notEquals(Map<K, V> actual, Map<K, V> expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotEquals(expected, message, params);
  }

  public <K, V> void isEmpty(Map<K, V> actual) {
    toVerifier(actual).verifyIsEmpty();
  }

  public <K, V> void isEmpty(Map<K, V> actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsEmpty(message, params);
  }

  public <K, V> void isNotEmpty(Map<K, V> actual) {
    toVerifier(actual).verifyIsNotEmpty();
  }

  public <K, V> void isNotEmpty(Map<K, V> actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsNotEmpty(message, params);
  }

  public <K, V> void notContains(Map<K, V> actual, Map.Entry<K, V> expected) {
    toVerifier(actual).verifyNotContains(expected);
  }

  public <K, V> void notContains(Map<K, V> actual, Map.Entry<K, V> expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotContains(expected, message, params);
  }

  public <K, V> void notContains(Map<K, V> actual, K expectedKey, V expectedValue) {
    toVerifier(actual).verifyNotContains(expectedKey, expectedValue);
  }

  public <K, V> void notContains(Map<K, V> actual, K expectedKey, V expectedValue, final String message, final Object... params) {
    toVerifier(actual).verifyNotContains(expectedKey, expectedValue, message, params);
  }

  public <K, V> void notContainsAll(Map<K, V> actual, Map<K, V> expected) {
    toVerifier(actual).verifyNotContainsAll(expected);
  }

  public <K, V> void notContainsAll(Map<K, V> actual, Map<K, V> expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotContainsAll(expected, message, params);
  }

  public <K, V> void sizeEquals(Map<K, V> actual, int expected) {
    toVerifier(actual).verifySizeEquals(expected);
  }

  public <K, V> void sizeEquals(Map<K, V> actual, int expected, final String message, final Object... params) {
    toVerifier(actual).verifySizeEquals(expected, message, params);
  }

  public <K, V> void sizeIsGreaterThan(Map<K, V> actual, int expected) {
    toVerifier(actual).verifySizeIsGreaterThan(expected);
  }

  public <K, V> void sizeIsGreaterThan(Map<K, V> actual, int expected, final String message, final Object... params) {
    toVerifier(actual).verifySizeIsGreaterThan(expected, message, params);
  }

  public <K, V> void sizeIsGreaterThanOrEqual(Map<K, V> actual, int expected) {
    toVerifier(actual).verifySizeIsGreaterThanOrEqual(expected);
  }

  public <K, V> void sizeIsGreaterThanOrEqual(Map<K, V> actual, int expected, final String message, final Object... params) {
    toVerifier(actual).verifySizeIsGreaterThanOrEqual(expected, message, params);
  }

  public <K, V> void sizeIsLessThan(Map<K, V> actual, int expected) {
    toVerifier(actual).verifySizeIsLessThan(expected);
  }

  public <K, V> void sizeIsLessThan(Map<K, V> actual, int expected, final String message, final Object... params) {
    toVerifier(actual).verifySizeIsLessThan(expected, message, params);
  }

  public <K, V> void sizeIsLessThanOrEqual(Map<K, V> actual, int expected) {
    toVerifier(actual).verifySizeIsLessThanOrEqual(expected);
  }

  public <K, V> void sizeIsLessThanOrEqual(Map<K, V> actual, int expected, final String message, final Object... params) {
    toVerifier(actual).verifySizeIsLessThanOrEqual(expected, message, params);
  }

  protected <K, V> MapVerify<K, V> toVerifier(Map<K, V> actual) {
    return () -> actual;
  }
}
