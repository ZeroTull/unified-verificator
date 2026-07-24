package io.unified.verify.interfaces.base;

import io.unified.verify.states.StringState;

import java.util.List;
import java.util.regex.Pattern;

public interface StringVerify extends ObjectVerify<String, StringState> {

  @Override
  default StringState _toState(String e) {
    return () -> e;
  }

  @Override
  default boolean printDiff() {
    return true;
  }

  default void verifyCenterPadEquals(int size, String padStr, final String expected) {
    verifyCenterPadEquals(size, padStr, expected,
        getDefaultMessage("Value Center Pad With '%s' And The Length Of '%d' Equals To Expected Value", padStr, size));
  }

  default void verifyCenterPadEquals(int size, String padStr, final String expected, String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).centerPadEquals(size, padStr, b), message, params);
  }

  default void verifyCenterPadNotEquals(int size, String padStr, final String expected) {
    verifyCenterPadNotEquals(size, padStr, expected,
        getDefaultMessage("Value Center Pad With '%s' And The Length Of '%d' Is Not Equal To Expected Value", padStr, size));
  }

  default void verifyCenterPadNotEquals(int size, String padStr, final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).centerPadNotEquals(size, padStr, b), message, params);
  }

  default void verifyCompare(String stringToCompare, int expected) {
    verifyCompare(stringToCompare, expected,
        getDefaultMessage("Result Of Comparison With The Expected Value Is '%d'", expected));
  }

  default void verifyCompare(String stringToCompare, int expected, final String message, final Object... params) {
    _verify(stringToCompare, (a, b) -> _toState(a).compare(b, expected), message, params);
  }

  default void verifyCompareIgnoreCase(String stringToCompare, int expected) {
    verifyCompareIgnoreCase(stringToCompare, expected,
        getDefaultMessage("Result Of Comparison (Ignoring Case) With The Expected Value Is '%d'", expected));
  }

  default void verifyCompareIgnoreCase(String stringToCompare, int expected, String message, final Object... params) {
    _verify(stringToCompare, (a, b) -> _toState(a).compareIgnoreCase(b, expected), message, params);
  }

  default void verifyContains(final String expected) {
    verifyContains(expected, getDefaultMessage("Value Contains The Expected Value"));
  }

  default void verifyContains(String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).contains(b), message, params);
  }

  default void verifyContainsIgnoreCase(final String expected) {
    verifyContainsIgnoreCase(expected, getDefaultMessage("Value Contains The Expected Value Ignoring Case Sensitivity"));
  }

  default void verifyContainsIgnoreCase(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).containsIgnoreCase(b), message, params);
  }

  default void verifyContainsAny(final Iterable<String> expected) {
    verifyContainsAny(expected, getDefaultMessage("Value Contains Any Of The Expected Values"));
  }

  default void verifyContainsAny(final Iterable<String> expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).containsAny(b), message, params);
  }

  default void verifyContainsAnyIgnoreCase(final Iterable<String> expected) {
    verifyContainsAnyIgnoreCase(expected, getDefaultMessage("Value Contains Any Of The Expected Values Ignoring Case"));
  }

  default void verifyContainsAnyIgnoreCase(final Iterable<String> expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).containsAnyIgnoreCase(b), message, params);
  }

  default void verifyEndsWith(final String suffix) {
    verifyEndsWith(suffix, getDefaultMessage("Value Ends With The Expected Value"));
  }

  default void verifyEndsWith(final String suffix, final String message, final Object... params) {
    _verify(suffix, (a, b) -> _toState(a).endsWith(b), message, params);
  }

  default void verifyEndsWithAny(final Iterable<String> searchInputs) {
    verifyEndsWithAny(searchInputs, getDefaultMessage("Value Ends With Any Of The Expected Values"));
  }

  default void verifyEndsWithAny(final Iterable<String> searchInputs, final String message, final Object... params) {
    _verify(searchInputs, (a, b) -> _toState(a).endsWithAny(b), message, params);
  }

  default void verifyEndsWithIgnoreCase(final String suffix) {
    verifyEndsWithIgnoreCase(suffix, getDefaultMessage("Value Ends With Expected Value Ignoring Case"));
  }

  default void verifyEndsWithIgnoreCase(final String suffix, final String message, final Object... params) {
    _verify(suffix, (a, b) -> _toState(a).endsWithIgnoreCase(b), message, params);
  }

  default void verifyEndsWithNone(final Iterable<String> searchInputs) {
    verifyEndsWithNone(searchInputs, getDefaultMessage("Value Does Not End With Any Of The Expected Values"));
  }

  default void verifyEndsWithNone(final Iterable<String> searchInputs, final String message, final Object... params) {
    _verify(searchInputs, (a, b) -> _toState(a).endsWithNone(b), message, params);
  }

  default void verifyEquals(final String expected) {
    verifyEquals(expected, getDefaultMessage("Equals"));
  }

  default void verifyEquals(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).isEqual(b), message, params);
  }

  default void verifyEqualsAny(final Iterable<String> expectedList) {
    verifyEqualsAny(expectedList, getDefaultMessage("Is Equal To One Of Expected Values"));
  }

  default void verifyEqualsAny(final Iterable<String> expectedList, final String message, final Object... params) {
    _verify(expectedList, (a, b) -> _toState(a).equalsAny(b), message, params);
  }

  default void verifyEqualsAnyIgnoreCase(final Iterable<String> expectedList) {
    verifyEqualsAnyIgnoreCase(expectedList, getDefaultMessage("Is Equal To One Of Expected Values Ignoring Case"));
  }

  default void verifyEqualsAnyIgnoreCase(final Iterable<String> expectedList, final String message, final Object... params) {
    _verify(expectedList, (a, b) -> _toState(a).equalsAnyIgnoreCase(b), message, params);
  }

  default void verifyEqualsIgnoreCase(final String expected) {
    verifyEqualsIgnoreCase(expected, getDefaultMessage("Equals Ignoring Case"));
  }

  default void verifyEqualsIgnoreCase(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).equalsIgnoreCase(b), message, params);
  }

  default void verifyEqualsIgnoreWhiteSpaces(final String expected) {
    verifyEqualsIgnoreWhiteSpaces(expected, getDefaultMessage("Equals Ignoring White Spaces"));
  }

  default void verifyEqualsIgnoreWhiteSpaces(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).equalsIgnoreWhiteSpaces(b), message, params);
  }

  default void verifyEqualsNone(final Iterable<String> expectedList) {
    verifyEqualsNone(expectedList, getDefaultMessage("Is Not Equal To Any Of Expected Values"));
  }

  default void verifyEqualsNone(final Iterable<String> expectedList, final String message, final Object... params) {
    _verify(expectedList, (a, b) -> _toState(a).equalsNone(b), message, params);
  }

  default void verifyIsAlpha() {
    verifyIsAlpha(getDefaultMessage("Is Alpha"));
  }

  default void verifyIsAlpha(final String message, final Object... params) {
    _verify(true, (a, b) -> _toState(a).isAlpha(), message, params);
  }

  default void verifyIsAlphanumeric() {
    verifyIsAlphanumeric(getDefaultMessage("Is Alphanumeric"));
  }

  default void verifyIsAlphanumeric(final String message, final Object... params) {
    _verify(true, (a, b) -> _toState(a).isAlphanumeric(), message, params);
  }

  default void verifyIsBlank() {
    verifyIsBlank(getDefaultMessage("Is Blank"));
  }

  default void verifyIsBlank(final String message, final Object... params) {
    _verify(true, (a, b) -> _toState(a).isBlank(), message, params);
  }

  default void verifyIsEmpty() {
    verifyIsEmpty(getDefaultMessage("Is Empty"));
  }

  default void verifyIsEmpty(final String message, final Object... params) {
    _verify(true, (a, b) -> _toState(a).isEmpty(), message, params);
  }

  default void verifyIsNotBlank() {
    verifyIsNotBlank(getDefaultMessage("Is Not Blank"));
  }

  default void verifyIsNotBlank(final String message, final Object... params) {
    _verify(true, (a, b) -> _toState(a).isNotBlank(), message, params);
  }

  default void verifyIsNotEmpty() {
    verifyIsNotEmpty(getDefaultMessage("Is Not Empty"));
  }

  default void verifyIsNotEmpty(final String message, final Object... params) {
    _verify(true, (a, b) -> _toState(a).isNotEmpty(), message, params);
  }

  default void verifyIsNumeric() {
    verifyIsNumeric(getDefaultMessage("Is Numeric"));
  }

  default void verifyIsNumeric(final String message, final Object... params) {
    _verify(true, (a, b) -> _toState(a).isNumeric(), message, params);
  }

  default void verifyLengthEquals(int expected) {
    verifyLengthEquals(expected, getDefaultMessage("Length Equals '%d'", expected));
  }

  default void verifyLengthEquals(int expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).lengthEquals(b), message, params);
  }

  default void verifyLengthNotEquals(int expected) {
    verifyLengthNotEquals(expected, getDefaultMessage("Length Not Equals '%d'", expected));
  }

  default void verifyLengthNotEquals(int expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).lengthNotEquals(b), message, params);
  }

  default void verifyMatches(final Pattern pattern) {
    verifyMatches(pattern, getDefaultMessage("Matches Pattern"));
  }

  default void verifyMatches(final Pattern pattern, final String message, final Object... params) {
    _verify(pattern, (a, b) -> _toState(a).matches(b), message, params);
  }

  default void verifyMatches(final String pattern) {
    verifyMatches(pattern, getDefaultMessage("Matches Pattern"));
  }

  default void verifyMatches(final String pattern, final String message, final Object... params) {
    _verify(pattern, (a, b) -> _toState(a).matches(b), message, params);
  }

  default void verifyMatchAny(final List<Pattern> patterns) {
    verifyMatchAny(patterns, getDefaultMessage("Matches Any Of Provided Patterns"));
  }

  default void verifyMatchAny(final List<Pattern> patterns, final String message, final Object... params) {
    _verify(patterns, (a, b) -> _toState(a).matchAny(b), message, params);
  }

  default void verifyNotContains(final String expected) {
    verifyNotContains(expected, getDefaultMessage("Value Does Not Contain The Expected Value"));
  }

  default void verifyNotContains(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).notContains(b), message, params);
  }

  default void verifyNotContainsIgnoreCase(final String expected) {
    verifyNotContainsIgnoreCase(expected, getDefaultMessage("Value Does Not Contain The Expected Value Ignoring Case"));
  }

  default void verifyNotContainsIgnoreCase(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).notContainsIgnoreCase(b), message, params);
  }

  default void verifyNotEndsWith(final String suffix) {
    verifyNotEndsWith(suffix, getDefaultMessage("Value Does Not End With Expected Value"));
  }

  default void verifyNotEndsWith(final String suffix, final String message, final Object... params) {
    _verify(suffix, (a, b) -> _toState(a).notEndsWith(b), message, params);
  }

  default void verifyNotEquals(final String expected) {
    verifyNotEquals(expected, getDefaultMessage("Not Equals"));
  }

  default void verifyNotEquals(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).isNotEqual(b), message, params);
  }

  default void verifyNotEqualsIgnoreCase(final String expected) {
    verifyNotEqualsIgnoreCase(expected, getDefaultMessage("Not Equals Ignoring Case"));
  }

  default void verifyNotEqualsIgnoreCase(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).notEqualsIgnoreCase(b), message, params);
  }

  default void verifyNotMatches(final Pattern pattern) {
    verifyNotMatches(pattern, getDefaultMessage("Does Not Match Pattern"));
  }

  default void verifyNotMatches(final Pattern pattern, final String message, final Object... params) {
    _verify(pattern, (a, b) -> _toState(a).notMatches(b), message, params);
  }

  default void verifyNotMatches(final String pattern) {
    verifyNotMatches(pattern, getDefaultMessage("Does Not Match Pattern"));
  }

  default void verifyNotMatches(final String pattern, final String message, final Object... params) {
    _verify(pattern, (a, b) -> _toState(a).notMatches(b), message, params);
  }

  default void verifyNotStartsWith(final String expected) {
    verifyNotStartsWith(expected, getDefaultMessage("Value Does Not Start With Expected Value"));
  }

  default void verifyNotStartsWith(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).notStartsWith(b), message, params);
  }

  default void verifyStartsWith(final String expected) {
    verifyStartsWith(expected, getDefaultMessage("Value Starts With The Expected Value"));
  }

  default void verifyStartsWith(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).startsWith(b), message, params);
  }

  default void verifyStartsWithAny(final Iterable<String> searchInputs) {
    verifyStartsWithAny(searchInputs, getDefaultMessage("Value Starts With Any Of The Expected Values"));
  }

  default void verifyStartsWithAny(final Iterable<String> searchInputs, final String message, final Object... params) {
    _verify(searchInputs, (a, b) -> _toState(a).startsWithAny(b), message, params);
  }

  default void verifyStartsWithIgnoreCase(final String expected) {
    verifyStartsWithIgnoreCase(expected, getDefaultMessage("Value Starts With Expected Value Ignoring Case"));
  }

  default void verifyStartsWithIgnoreCase(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).startsWithIgnoreCase(b), message, params);
  }

  default void verifyTrimmedValueEquals(final String expected) {
    verifyTrimmedValueEquals(expected, getDefaultMessage("Trimmed Value Equals"));
  }

  default void verifyTrimmedValueEquals(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).trimmedValueEquals(b), message, params);
  }

  default void verifyTrimmedValueNotEquals(final String expected) {
    verifyTrimmedValueNotEquals(expected, getDefaultMessage("Trimmed Value Not Equals"));
  }

  default void verifyTrimmedValueNotEquals(final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).trimmedValueNotEquals(b), message, params);
  }

  default void verifyTruncatedValueEquals(int maxWidth, final String expected) {
    verifyTruncatedValueEquals(maxWidth, expected, getDefaultMessage("Truncated Value Equals"));
  }

  default void verifyTruncatedValueEquals(int maxWidth, final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).truncatedValueEquals(maxWidth, b), message, params);
  }

  default void verifyTruncatedValueEquals(int offset, int maxWidth, final String expected) {
    verifyTruncatedValueEquals(offset, maxWidth, expected, getDefaultMessage("Truncated Value Equals"));
  }

  default void verifyTruncatedValueEquals(int offset, int maxWidth, final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).truncatedValueEquals(offset, maxWidth, b), message, params);
  }

  default void verifyTruncatedValueNotEquals(int maxWidth, final String expected) {
    verifyTruncatedValueNotEquals(maxWidth, expected, getDefaultMessage("Truncated Value Not Equals"));
  }

  default void verifyTruncatedValueNotEquals(int maxWidth, final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).truncatedValueNotEquals(maxWidth, b), message, params);
  }

  default void verifyTruncatedValueNotEquals(int offset, int maxWidth, final String expected) {
    verifyTruncatedValueNotEquals(offset, maxWidth, expected, getDefaultMessage("Truncated Value Not Equals"));
  }

  default void verifyTruncatedValueNotEquals(int offset, int maxWidth, final String expected, final String message, final Object... params) {
    _verify(expected, (a, b) -> _toState(a).truncatedValueNotEquals(offset, maxWidth, b), message, params);
  }
}
