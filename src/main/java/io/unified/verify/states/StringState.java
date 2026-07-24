package io.unified.verify.states;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.RegExUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.RegExUtils.removePattern;

public interface StringState extends ObjectState<String> {

  default boolean centerPadEquals(int size, String padStr, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.center(_get(), size, padStr), expected);
  }

  default boolean centerPadNotEquals(int size, String padStr, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.center(_get(), size, padStr), expected);
  }

  default boolean compare(String stringToCompare, int expected) {
    return StringUtils.compare(_get(), stringToCompare) == expected;
  }

  default boolean compareIgnoreCase(String stringToCompare, int expected) {
    return StringUtils.compareIgnoreCase(_get(), stringToCompare) == expected;
  }

  default boolean contains(String expected) {
    return _get() != null && expected != null && StringUtils.contains(_get(), expected);
  }

  default boolean containsIgnoreCase(String expected) {
    return _get() != null && expected != null && StringUtils.containsIgnoreCase(_get(), expected);
  }

  default boolean containsAny(Iterable<String> expected) {
    return _get() != null && expected != null
        && StringUtils.containsAny(_get(), toStringArray(expected));
  }

  default boolean containsAnyIgnoreCase(Iterable<String> expected) {
    return _get() != null && expected != null
        && StringUtils.containsAnyIgnoreCase(_get(), toStringArray(expected));
  }

  default boolean endsWith(String suffix) {
    return _get() != null && suffix != null && StringUtils.endsWith(_get(), suffix);
  }

  default boolean endsWithAny(Iterable<String> searchInputs) {
    return _get() != null && searchInputs != null
        && StringUtils.endsWithAny(_get(), toStringArray(searchInputs));
  }

  default boolean endsWithIgnoreCase(String suffix) {
    return _get() != null && suffix != null && StringUtils.endsWithIgnoreCase(_get(), suffix);
  }

  default boolean endsWithNone(Iterable<String> searchInputs) {
    return _get() != null && searchInputs != null
        && !StringUtils.endsWithAny(_get(), toStringArray(searchInputs));
  }

  default boolean isEqual(String expected) {
    return StringUtils.equals(_get(), expected);
  }

  default boolean equalsAny(Iterable<String> expectedList) {
    return _get() != null && expectedList != null
        && StringUtils.equalsAny(_get(), toStringArray(expectedList));
  }

  default boolean equalsAnyIgnoreCase(Iterable<String> expectedList) {
    return _get() != null && expectedList != null
        && StringUtils.equalsAnyIgnoreCase(_get(), toStringArray(expectedList));
  }

  default boolean equalsIgnoreCase(String expected) {
    return StringUtils.equalsIgnoreCase(_get(), expected);
  }

  default boolean equalsIgnoreWhiteSpaces(String expected) {
    return StringUtils.equals(removePattern(_get(), "\\s"), removePattern(expected, "\\s"));
  }

  default boolean equalsNone(Iterable<String> expectedList) {
    return _get() != null && expectedList != null
        && !StringUtils.equalsAny(_get(), toStringArray(expectedList));
  }

  default boolean equalsNoneIgnoreCase(Iterable<String> expectedList) {
    return _get() != null && expectedList != null
        && !StringUtils.equalsAnyIgnoreCase(_get(), toStringArray(expectedList));
  }

  default boolean isAlpha() {
    return _get() != null && StringUtils.isAlpha(_get());
  }

  default boolean isAlphaSpace() {
    return _get() != null && StringUtils.isAlphaSpace(_get());
  }

  default boolean isAlphanumeric() {
    return _get() != null && isAlphaNumericStr(_get());
  }

  default boolean isAlphanumericSpace() {
    return _get() != null && isAlphaNumericSpaceStr(_get());
  }

  default boolean isAsciiPrintable() {
    return _get() != null && StringUtils.isAsciiPrintable(_get());
  }

  default boolean isBlank() {
    return StringUtils.isBlank(_get());
  }

  default boolean isBlankOrAlpha() {
    String a = _get();
    return StringUtils.isBlank(a) || StringUtils.isAlpha(a);
  }

  default boolean isBlankOrAlphanumeric() {
    String a = _get();
    return StringUtils.isBlank(a) || StringUtils.isAlphanumeric(a);
  }

  default boolean isBlankOrAlphanumeric(int minLength, int maxLength) {
    String a = _get();
    return a != null && (StringUtils.isBlank(a)
        || (StringUtils.isAlphanumeric(a) && a.length() >= minLength && a.length() <= maxLength));
  }

  default boolean isBlankOrNotAlpha() {
    String a = _get();
    return StringUtils.isBlank(a) || !StringUtils.isAlpha(a);
  }

  default boolean isBlankOrNotAlphanumeric() {
    String a = _get();
    return StringUtils.isBlank(a) || !StringUtils.isAlphanumeric(a);
  }

  default boolean isBlankOrNotNumeric() {
    String a = _get();
    return a != null && (StringUtils.isBlank(a) || !StringUtils.isNumeric(a));
  }

  default boolean isBlankOrNumeric() {
    String a = _get();
    return a != null && StringUtils.isBlank(a) || StringUtils.isNumeric(a);
  }

  default boolean isBlankOrNumeric(int minLength, int maxLength) {
    String a = _get();
    return a != null && (StringUtils.isBlank(a)
        || (StringUtils.isNumeric(a) && a.length() >= minLength && a.length() <= maxLength));
  }

  default boolean isEmpty() {
    return StringUtils.isEmpty(_get());
  }

  default boolean isEmptyOrAlpha() {
    String a = _get();
    return StringUtils.isEmpty(a) || StringUtils.isAlpha(a);
  }

  default boolean isEmptyOrAlphanumeric() {
    String a = _get();
    return StringUtils.isEmpty(a) || StringUtils.isAlphanumeric(a);
  }

  default boolean isEmptyOrAlphanumeric(int minLength, int maxLength) {
    String a = _get();
    return a != null && (StringUtils.isEmpty(a)
        || (StringUtils.isAlphanumeric(a) && a.length() >= minLength && a.length() <= maxLength));
  }

  default boolean isEmptyOrNotAlpha() {
    String a = _get();
    return StringUtils.isEmpty(a) || !StringUtils.isAlpha(a);
  }

  default boolean isEmptyOrNotAlphanumeric() {
    String a = _get();
    return a != null && (StringUtils.isEmpty(a) || (a.contains(" ") || !isAlphaNumericSpaceStr(a)));
  }

  default boolean isEmptyOrNotNumeric() {
    String a = _get();
    return a != null && (StringUtils.isEmpty(a) || !StringUtils.isNumeric(a));
  }

  default boolean isEmptyOrNumeric() {
    String a = _get();
    return a != null && StringUtils.isEmpty(a) || StringUtils.isNumeric(a);
  }

  default boolean isEmptyOrNumeric(int minLength, int maxLength) {
    String a = _get();
    return a != null && (StringUtils.isEmpty(a)
        || (StringUtils.isNumeric(a) && a.length() >= minLength && a.length() <= maxLength));
  }

  default boolean isNotAlpha() {
    return _get() != null && !StringUtils.isAlpha(_get());
  }

  default boolean isNotAlphaSpace() {
    return _get() != null && !StringUtils.isAlphaSpace(_get());
  }

  default boolean isNotAlphanumeric() {
    return _get() != null && !isAlphaNumericStr(_get());
  }

  default boolean isNotAlphanumericSpace() {
    return _get() != null && !isAlphaNumericSpaceStr(_get());
  }

  default boolean isNotAsciiPrintable() {
    return _get() != null && !StringUtils.isAsciiPrintable(_get());
  }

  default boolean isNotBlank() {
    return StringUtils.isNotBlank(_get());
  }

  default boolean isNotEmpty() {
    return StringUtils.isNotEmpty(_get());
  }

  default boolean isNotNumeric() {
    return _get() != null && !StringUtils.isNumeric(_get());
  }

  default boolean isNotNumericSpace() {
    String a = _get();
    return a != null && !StringUtils.isNumericSpace(a);
  }

  default boolean isNumeric() {
    return _get() != null && StringUtils.isNumeric(_get());
  }

  default boolean isNumeric(int minLength, int maxLength) {
    String a = _get();
    return a != null && StringUtils.isNumeric(a) && a.length() >= minLength && a.length() <= maxLength;
  }

  default boolean isNumericSpace() {
    String a = _get();
    return a != null && StringUtils.isNumericSpace(a);
  }

  default boolean leftPadEquals(int size, String padStr, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.leftPad(_get(), size, padStr), expected);
  }

  default boolean leftPadNotEquals(int size, String padStr, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.leftPad(_get(), size, padStr), expected);
  }

  default boolean leftValueEquals(int len, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.left(_get(), len), expected);
  }

  default boolean leftValueNotEquals(int len, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.left(_get(), len), expected);
  }

  default boolean lengthEquals(int expected) {
    return StringUtils.length(_get()) == expected;
  }

  default boolean lengthNotEquals(int expected) {
    return StringUtils.length(_get()) != expected;
  }

  default boolean matches(final Pattern pattern) {
    return _get() != null && pattern != null && pattern.matcher(_get()).find();
  }

  default boolean matches(final String pattern) {
    return _get() != null && pattern != null && Pattern.compile(pattern).matcher(_get()).find();
  }

  default boolean matchAny(final List<Pattern> patterns) {
    if (_get() == null || patterns == null) return false;
    String val = _get();
    return patterns.stream().anyMatch(p -> p.matcher(val).find());
  }

  default boolean midValueEquals(int pos, int len, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.mid(_get(), pos, len), expected);
  }

  default boolean midValueNotEquals(int pos, int len, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.mid(_get(), pos, len), expected);
  }

  default boolean notContains(String expected) {
    return _get() != null && expected != null && !StringUtils.contains(_get(), expected);
  }

  default boolean notContainsIgnoreCase(String expected) {
    return _get() != null && expected != null && !StringUtils.containsIgnoreCase(_get(), expected);
  }

  default boolean notEndsWith(String suffix) {
    return _get() != null && suffix != null && !StringUtils.endsWith(_get(), suffix);
  }

  default boolean notEndsWithIgnoreCase(String suffix) {
    return _get() != null && suffix != null && !StringUtils.endsWithIgnoreCase(_get(), suffix);
  }

  default boolean isNotEqual(String expected) {
    return !StringUtils.equals(_get(), expected);
  }

  default boolean notEqualsIgnoreCase(String expected) {
    return !StringUtils.equalsIgnoreCase(_get(), expected);
  }

  default boolean notEqualsIgnoreWhiteSpaces(String expected) {
    return !StringUtils.equals(removePattern(_get(), "\\s"), removePattern(expected, "\\s"));
  }

  default boolean notMatches(final Pattern pattern) {
    return _get() != null && pattern != null && !pattern.matcher(_get()).find();
  }

  default boolean notMatches(final String pattern) {
    return _get() != null && pattern != null && !Pattern.compile(pattern).matcher(_get()).find();
  }

  default boolean matchNone(final List<Pattern> patterns) {
    if (_get() == null || patterns == null) return false;
    String val = _get();
    return patterns.stream().noneMatch(p -> p.matcher(val).find());
  }

  default boolean notStartsWith(String expected) {
    return _get() != null && expected != null && !StringUtils.startsWith(_get(), expected);
  }

  default boolean notStartsWithIgnoreCase(String expected) {
    return _get() != null && expected != null && !StringUtils.startsWithIgnoreCase(_get(), expected);
  }

  default boolean numberOfMatchesEquals(String subString, int expected) {
    return _get() != null && StringUtils.countMatches(_get(), subString) == expected;
  }

  default boolean numberOfMatchesNotEquals(String subString, int expected) {
    return _get() != null && StringUtils.countMatches(_get(), subString) != expected;
  }

  default boolean removeEndEquals(String remove, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.removeEnd(_get(), remove), expected);
  }

  default boolean removeEndIgnoreCaseEquals(String remove, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.removeEndIgnoreCase(_get(), remove), expected);
  }

  default boolean removeEndIgnoreCaseNotEquals(String remove, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.removeEndIgnoreCase(_get(), remove), expected);
  }

  default boolean removeEndNotEquals(String remove, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.removeEnd(_get(), remove), expected);
  }

  default boolean removeEquals(String remove, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.remove(_get(), remove), expected);
  }

  default boolean removeIgnoreCaseEquals(String remove, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.removeIgnoreCase(_get(), remove), expected);
  }

  default boolean removeIgnoreCaseNotEquals(String remove, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.removeIgnoreCase(_get(), remove), expected);
  }

  default boolean removeNotEquals(String remove, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.remove(_get(), remove), expected);
  }

  default boolean removeStartEquals(String remove, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.removeStart(_get(), remove), expected);
  }

  default boolean removeStartIgnoreCaseEquals(String remove, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.removeStartIgnoreCase(_get(), remove), expected);
  }

  default boolean removeStartIgnoreCaseNotEquals(String remove, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.removeStartIgnoreCase(_get(), remove), expected);
  }

  default boolean removeStartNotEquals(String remove, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.removeStart(_get(), remove), expected);
  }

  default boolean replaceEquals(String searchString, String replacement, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.replace(_get(), searchString, replacement), expected);
  }

  default boolean replaceIgnoreCaseEquals(String searchString, String replacement, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.replaceIgnoreCase(_get(), searchString, replacement), expected);
  }

  default boolean replaceIgnoreCaseNotEquals(String searchString, String replacement, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.replaceIgnoreCase(_get(), searchString, replacement), expected);
  }

  default boolean replaceNotEquals(String searchString, String replacement, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.replace(_get(), searchString, replacement), expected);
  }

  default boolean replaceOnceEquals(String searchString, String replacement, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.replaceOnce(_get(), searchString, replacement), expected);
  }

  default boolean replaceOnceIgnoreCaseEquals(String searchString, String replacement, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.replaceOnceIgnoreCase(_get(), searchString, replacement), expected);
  }

  default boolean replaceOnceIgnoreCaseNotEquals(String searchString, String replacement, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.replaceOnceIgnoreCase(_get(), searchString, replacement), expected);
  }

  default boolean replaceOnceNotEquals(String searchString, String replacement, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.replaceOnce(_get(), searchString, replacement), expected);
  }

  default boolean reverseEquals(String expected) {
    String a = _get();
    return a != null && expected != null && StringUtils.equals(StringUtils.reverse(a), expected);
  }

  default boolean reverseNotEquals(String expected) {
    String a = _get();
    return a != null && expected != null && !StringUtils.equals(StringUtils.reverse(a), expected);
  }

  default boolean rightPadEquals(int size, String padStr, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.rightPad(_get(), size, padStr), expected);
  }

  default boolean rightPadNotEquals(int size, String padStr, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.rightPad(_get(), size, padStr), expected);
  }

  default boolean rightValueEquals(int len, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.right(_get(), len), expected);
  }

  default boolean rightValueNotEquals(int len, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.right(_get(), len), expected);
  }

  default boolean startsWith(String expected) {
    return _get() != null && expected != null && StringUtils.startsWith(_get(), expected);
  }

  default boolean startsWithAny(Iterable<String> searchInputs) {
    return _get() != null && searchInputs != null
        && StringUtils.startsWithAny(_get(), toStringArray(searchInputs));
  }

  default boolean startsWithIgnoreCase(String expected) {
    return _get() != null && expected != null && StringUtils.startsWithIgnoreCase(_get(), expected);
  }

  default boolean startsWithNone(Iterable<String> searchInputs) {
    return _get() != null && searchInputs != null
        && !StringUtils.startsWithAny(_get(), toStringArray(searchInputs));
  }

  default boolean stripedEndValue(String stripChars, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.stripEnd(_get(), stripChars), expected);
  }

  default boolean stripedEndValueNot(String stripChars, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.stripEnd(_get(), stripChars), expected);
  }

  default boolean stripedStartValue(String stripChars, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.stripStart(_get(), stripChars), expected);
  }

  default boolean stripedStartValueNot(String stripChars, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.stripStart(_get(), stripChars), expected);
  }

  default boolean stripedValue(String stripChars, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.strip(_get(), stripChars), expected);
  }

  default boolean stripedValueNot(String stripChars, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.strip(_get(), stripChars), expected);
  }

  default boolean substringAfterEquals(String separator, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.substringAfter(_get(), separator), expected);
  }

  default boolean substringAfterLastEquals(String separator, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.substringAfterLast(_get(), separator), expected);
  }

  default boolean substringAfterLastNotEquals(String separator, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.substringAfterLast(_get(), separator), expected);
  }

  default boolean substringAfterNotEquals(String separator, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.substringAfter(_get(), separator), expected);
  }

  default boolean substringBeforeEquals(String separator, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.substringBefore(_get(), separator), expected);
  }

  default boolean substringBeforeLastEquals(String separator, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.substringBeforeLast(_get(), separator), expected);
  }

  default boolean substringBeforeLastNotEquals(String separator, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.substringBeforeLast(_get(), separator), expected);
  }

  default boolean substringBeforeNotEquals(String separator, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.substringBefore(_get(), separator), expected);
  }

  default boolean substringBetweenEquals(String open, String close, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.substringBetween(_get(), open, close), expected);
  }

  default boolean substringBetweenNotEquals(String open, String close, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.substringBetween(_get(), open, close), expected);
  }

  default boolean substringEquals(int start, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.substring(_get(), start), expected);
  }

  default boolean substringEquals(int start, int end, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.substring(_get(), start, end), expected);
  }

  default boolean substringNotEquals(int start, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.substring(_get(), start), expected);
  }

  default boolean substringNotEquals(int start, int end, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.substring(_get(), start, end), expected);
  }

  default boolean substringsBetweenContains(String open, String close, String expected) {
    if (_get() == null || expected == null) return false;
    String[] arr = StringUtils.substringsBetween(_get(), open, close);
    if (arr == null) return false;
    for (String s : arr) { if (s.equals(expected)) return true; }
    return false;
  }

  default boolean substringsBetweenEquals(String open, String close, Iterable<String> expected) {
    String[] substring = StringUtils.substringsBetween(_get(), open, close);
    if (_get() == null || expected == null || substring == null) return false;
    List<String> list = new ArrayList<>();
    expected.forEach(list::add);
    return substring.length == list.size() && Arrays.equals(substring, list.toArray());
  }

  default boolean substringsBetweenNotContains(String open, String close, String expected) {
    if (_get() == null || expected == null) return false;
    String[] arr = StringUtils.substringsBetween(_get(), open, close);
    if (arr == null) return false;
    for (String s : arr) { if (s.equals(expected)) return false; }
    return true;
  }

  default boolean substringsBetweenNotEquals(String open, String close, Iterable<String> expected) {
    String[] substring = StringUtils.substringsBetween(_get(), open, close);
    if (_get() == null || expected == null || substring == null) return false;
    List<String> list = new ArrayList<>();
    expected.forEach(list::add);
    return (substring.length != list.size() || !Arrays.equals(substring, list.toArray()));
  }

  default boolean trimmedValueEquals(String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.trim(_get()), expected);
  }

  default boolean trimmedValueNotEquals(String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.trim(_get()), expected);
  }

  default boolean truncatedValueEquals(int maxWidth, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.truncate(_get(), maxWidth), expected);
  }

  default boolean truncatedValueEquals(int offset, int maxWidth, String expected) {
    return _get() != null && expected != null
        && StringUtils.equals(StringUtils.truncate(_get(), offset, maxWidth), expected);
  }

  default boolean truncatedValueNotEquals(int maxWidth, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.truncate(_get(), maxWidth), expected);
  }

  default boolean truncatedValueNotEquals(int offset, int maxWidth, String expected) {
    return _get() != null && expected != null
        && !StringUtils.equals(StringUtils.truncate(_get(), offset, maxWidth), expected);
  }

  private String[] toStringArray(Iterable<String> input) {
    if (input == null) return null;
    List<String> list = new ArrayList<>();
    input.forEach(list::add);
    return list.toArray(new String[0]);
  }

  private static boolean isAlphaNumericStr(String input) {
    if (input == null) return false;
    return input.matches("^[0-9a-zA-Z]*$");
  }

  private static boolean isAlphaNumericSpaceStr(String input) {
    if (input == null) return false;
    String stripped = input.replaceAll("\\s+", "");
    return !stripped.isBlank() && stripped.matches("^[0-9a-zA-Z]*$");
  }
}
