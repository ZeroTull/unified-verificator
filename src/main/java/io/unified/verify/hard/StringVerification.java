package io.unified.verify.hard;

import io.unified.verify.interfaces.base.StringVerify;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.regex.Pattern;

@Slf4j
public class StringVerification extends BaseVerification {

  public void centerPadEquals(final String actual, final int size, final String padStr, final String expected) {
    toVerifier(actual).verifyCenterPadEquals(size, padStr, expected);
  }

  public void centerPadEquals(final String actual, final int size, final String padStr, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyCenterPadEquals(size, padStr, expected, message, params);
  }

  public void centerPadNotEquals(final String actual, final int size, final String padStr, final String expected) {
    toVerifier(actual).verifyCenterPadNotEquals(size, padStr, expected);
  }

  public void centerPadNotEquals(final String actual, final int size, final String padStr, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyCenterPadNotEquals(size, padStr, expected, message, params);
  }

  public void compare(final String actual, final String stringToCompare, final int expected) {
    toVerifier(actual).verifyCompare(stringToCompare, expected);
  }

  public void compare(final String actual, final String stringToCompare, final int expected, final String message, final Object... params) {
    toVerifier(actual).verifyCompare(stringToCompare, expected, message, params);
  }

  public void compareIgnoreCase(final String actual, final String stringToCompare, final int expected) {
    toVerifier(actual).verifyCompareIgnoreCase(stringToCompare, expected);
  }

  public void compareIgnoreCase(final String actual, final String stringToCompare, final int expected, final String message, final Object... params) {
    toVerifier(actual).verifyCompareIgnoreCase(stringToCompare, expected, message, params);
  }

  public void contains(final String actual, final String expected) {
    toVerifier(actual).verifyContains(expected);
  }

  public void contains(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyContains(expected, message, params);
  }

  public void containsIgnoreCase(final String actual, final String expected) {
    toVerifier(actual).verifyContainsIgnoreCase(expected);
  }

  public void containsIgnoreCase(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyContainsIgnoreCase(expected, message, params);
  }

  public void containsAny(final String actual, final Iterable<String> expected) {
    toVerifier(actual).verifyContainsAny(expected);
  }

  public void containsAny(final String actual, final Iterable<String> expected, final String message, final Object... params) {
    toVerifier(actual).verifyContainsAny(expected, message, params);
  }

  public void containsAnyIgnoreCase(final String actual, final Iterable<String> expected) {
    toVerifier(actual).verifyContainsAnyIgnoreCase(expected);
  }

  public void containsAnyIgnoreCase(final String actual, final Iterable<String> expected, final String message, final Object... params) {
    toVerifier(actual).verifyContainsAnyIgnoreCase(expected, message, params);
  }

  public void endsWith(final String actual, final String suffix) {
    toVerifier(actual).verifyEndsWith(suffix);
  }

  public void endsWith(final String actual, final String suffix, final String message, final Object... params) {
    toVerifier(actual).verifyEndsWith(suffix, message, params);
  }

  public void endsWithAny(final String actual, final Iterable<String> searchInputs) {
    toVerifier(actual).verifyEndsWithAny(searchInputs);
  }

  public void endsWithAny(final String actual, final Iterable<String> searchInputs, final String message, final Object... params) {
    toVerifier(actual).verifyEndsWithAny(searchInputs, message, params);
  }

  public void endsWithIgnoreCase(final String actual, final String suffix) {
    toVerifier(actual).verifyEndsWithIgnoreCase(suffix);
  }

  public void endsWithIgnoreCase(final String actual, final String suffix, final String message, final Object... params) {
    toVerifier(actual).verifyEndsWithIgnoreCase(suffix, message, params);
  }

  public void endsWithNone(final String actual, final Iterable<String> searchInputs) {
    toVerifier(actual).verifyEndsWithNone(searchInputs);
  }

  public void endsWithNone(final String actual, final Iterable<String> searchInputs, final String message, final Object... params) {
    toVerifier(actual).verifyEndsWithNone(searchInputs, message, params);
  }

  public void equals(final String actual, final String expected) {
    toVerifier(actual).verifyEquals(expected);
  }

  public void equals(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyEquals(expected, message, params);
  }

  public void equalsAny(final String actual, final Iterable<String> expectedList) {
    toVerifier(actual).verifyEqualsAny(expectedList);
  }

  public void equalsAny(final String actual, final Iterable<String> expectedList, final String message, final Object... params) {
    toVerifier(actual).verifyEqualsAny(expectedList, message, params);
  }

  public void equalsAnyIgnoreCase(final String actual, final Iterable<String> expectedList) {
    toVerifier(actual).verifyEqualsAnyIgnoreCase(expectedList);
  }

  public void equalsAnyIgnoreCase(final String actual, final Iterable<String> expectedList, final String message, final Object... params) {
    toVerifier(actual).verifyEqualsAnyIgnoreCase(expectedList, message, params);
  }

  public void equalsIgnoreCase(final String actual, final String expected) {
    toVerifier(actual).verifyEqualsIgnoreCase(expected);
  }

  public void equalsIgnoreCase(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyEqualsIgnoreCase(expected, message, params);
  }

  public void equalsIgnoreWhiteSpaces(final String actual, final String expected) {
    toVerifier(actual).verifyEqualsIgnoreWhiteSpaces(expected);
  }

  public void equalsIgnoreWhiteSpaces(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyEqualsIgnoreWhiteSpaces(expected, message, params);
  }

  public void equalsNone(final String actual, final Iterable<String> expectedList) {
    toVerifier(actual).verifyEqualsNone(expectedList);
  }

  public void equalsNone(final String actual, final Iterable<String> expectedList, final String message, final Object... params) {
    toVerifier(actual).verifyEqualsNone(expectedList, message, params);
  }

  public void isAlpha(final String actual) {
    toVerifier(actual).verifyIsAlpha();
  }

  public void isAlpha(final String actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsAlpha(message, params);
  }

  public void isAlphanumeric(final String actual) {
    toVerifier(actual).verifyIsAlphanumeric();
  }

  public void isAlphanumeric(final String actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsAlphanumeric(message, params);
  }

  public void isBlank(final String actual) {
    toVerifier(actual).verifyIsBlank();
  }

  public void isBlank(final String actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsBlank(message, params);
  }

  public void isEmpty(final String actual) {
    toVerifier(actual).verifyIsEmpty();
  }

  public void isEmpty(final String actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsEmpty(message, params);
  }

  public void isNotBlank(final String actual) {
    toVerifier(actual).verifyIsNotBlank();
  }

  public void isNotBlank(final String actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsNotBlank(message, params);
  }

  public void isNotEmpty(final String actual) {
    toVerifier(actual).verifyIsNotEmpty();
  }

  public void isNotEmpty(final String actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsNotEmpty(message, params);
  }

  public void isNumeric(final String actual) {
    toVerifier(actual).verifyIsNumeric();
  }

  public void isNumeric(final String actual, final String message, final Object... params) {
    toVerifier(actual).verifyIsNumeric(message, params);
  }

  public void lengthEquals(final String actual, final int expected) {
    toVerifier(actual).verifyLengthEquals(expected);
  }

  public void lengthEquals(final String actual, final int expected, final String message, final Object... params) {
    toVerifier(actual).verifyLengthEquals(expected, message, params);
  }

  public void lengthNotEquals(final String actual, final int expected) {
    toVerifier(actual).verifyLengthNotEquals(expected);
  }

  public void lengthNotEquals(final String actual, final int expected, final String message, final Object... params) {
    toVerifier(actual).verifyLengthNotEquals(expected, message, params);
  }

  public void matches(final String actual, final Pattern pattern) {
    toVerifier(actual).verifyMatches(pattern);
  }

  public void matches(final String actual, final Pattern pattern, final String message, final Object... params) {
    toVerifier(actual).verifyMatches(pattern, message, params);
  }

  public void matches(final String actual, final String pattern) {
    toVerifier(actual).verifyMatches(pattern);
  }

  public void matches(final String actual, final String pattern, final String message, final Object... params) {
    toVerifier(actual).verifyMatches(pattern, message, params);
  }

  public void matchAny(final String actual, final List<Pattern> patterns) {
    toVerifier(actual).verifyMatchAny(patterns);
  }

  public void matchAny(final String actual, final List<Pattern> patterns, final String message, final Object... params) {
    toVerifier(actual).verifyMatchAny(patterns, message, params);
  }

  public void notContains(final String actual, final String expected) {
    toVerifier(actual).verifyNotContains(expected);
  }

  public void notContains(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotContains(expected, message, params);
  }

  public void notContainsIgnoreCase(final String actual, final String expected) {
    toVerifier(actual).verifyNotContainsIgnoreCase(expected);
  }

  public void notContainsIgnoreCase(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotContainsIgnoreCase(expected, message, params);
  }

  public void notEndsWith(final String actual, final String suffix) {
    toVerifier(actual).verifyNotEndsWith(suffix);
  }

  public void notEndsWith(final String actual, final String suffix, final String message, final Object... params) {
    toVerifier(actual).verifyNotEndsWith(suffix, message, params);
  }

  public void notEquals(final String actual, final String expected) {
    toVerifier(actual).verifyNotEquals(expected);
  }

  public void notEquals(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotEquals(expected, message, params);
  }

  public void notEqualsIgnoreCase(final String actual, final String expected) {
    toVerifier(actual).verifyNotEqualsIgnoreCase(expected);
  }

  public void notEqualsIgnoreCase(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotEqualsIgnoreCase(expected, message, params);
  }

  public void notMatches(final String actual, final Pattern pattern) {
    toVerifier(actual).verifyNotMatches(pattern);
  }

  public void notMatches(final String actual, final Pattern pattern, final String message, final Object... params) {
    toVerifier(actual).verifyNotMatches(pattern, message, params);
  }

  public void notMatches(final String actual, final String pattern) {
    toVerifier(actual).verifyNotMatches(pattern);
  }

  public void notMatches(final String actual, final String pattern, final String message, final Object... params) {
    toVerifier(actual).verifyNotMatches(pattern, message, params);
  }

  public void notStartsWith(final String actual, final String expected) {
    toVerifier(actual).verifyNotStartsWith(expected);
  }

  public void notStartsWith(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotStartsWith(expected, message, params);
  }

  public void startsWith(final String actual, final String expected) {
    toVerifier(actual).verifyStartsWith(expected);
  }

  public void startsWith(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyStartsWith(expected, message, params);
  }

  public void startsWithAny(final String actual, final Iterable<String> searchInputs) {
    toVerifier(actual).verifyStartsWithAny(searchInputs);
  }

  public void startsWithAny(final String actual, final Iterable<String> searchInputs, final String message, final Object... params) {
    toVerifier(actual).verifyStartsWithAny(searchInputs, message, params);
  }

  public void startsWithIgnoreCase(final String actual, final String expected) {
    toVerifier(actual).verifyStartsWithIgnoreCase(expected);
  }

  public void startsWithIgnoreCase(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyStartsWithIgnoreCase(expected, message, params);
  }

  public void trimmedValueEquals(final String actual, final String expected) {
    toVerifier(actual).verifyTrimmedValueEquals(expected);
  }

  public void trimmedValueEquals(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyTrimmedValueEquals(expected, message, params);
  }

  public void trimmedValueNotEquals(final String actual, final String expected) {
    toVerifier(actual).verifyTrimmedValueNotEquals(expected);
  }

  public void trimmedValueNotEquals(final String actual, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyTrimmedValueNotEquals(expected, message, params);
  }

  public void truncatedValueEquals(final String actual, final int maxWidth, final String expected) {
    toVerifier(actual).verifyTruncatedValueEquals(maxWidth, expected);
  }

  public void truncatedValueEquals(final String actual, final int maxWidth, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyTruncatedValueEquals(maxWidth, expected, message, params);
  }

  public void truncatedValueEquals(final String actual, final int offset, final int maxWidth, final String expected) {
    toVerifier(actual).verifyTruncatedValueEquals(offset, maxWidth, expected);
  }

  public void truncatedValueEquals(final String actual, final int offset, final int maxWidth, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyTruncatedValueEquals(offset, maxWidth, expected, message, params);
  }

  public void truncatedValueNotEquals(final String actual, final int maxWidth, final String expected) {
    toVerifier(actual).verifyTruncatedValueNotEquals(maxWidth, expected);
  }

  public void truncatedValueNotEquals(final String actual, final int maxWidth, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyTruncatedValueNotEquals(maxWidth, expected, message, params);
  }

  public void truncatedValueNotEquals(final String actual, final int offset, final int maxWidth, final String expected) {
    toVerifier(actual).verifyTruncatedValueNotEquals(offset, maxWidth, expected);
  }

  public void truncatedValueNotEquals(final String actual, final int offset, final int maxWidth, final String expected, final String message, final Object... params) {
    toVerifier(actual).verifyTruncatedValueNotEquals(offset, maxWidth, expected, message, params);
  }

  protected StringVerify toVerifier(String actual) {
    return () -> actual;
  }
}
