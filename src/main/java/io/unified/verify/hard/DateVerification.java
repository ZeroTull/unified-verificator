package io.unified.verify.hard;

import io.unified.verify.interfaces.base.DateVerify;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class DateVerification extends BaseVerification {

  public void equals(final Date actual, final Date expected) {
    toVerifier(actual).verifyEquals(expected);
  }

  public void equals(final Date actual, final Date expected, final String message, final Object... params) {
    toVerifier(actual).verifyEquals(expected, message, params);
  }

  public void equalsByFormat(final Date actual, final Date expected, final String format) {
    toVerifier(actual).verifyEqualsByFormat(expected, format);
  }

  public void equalsByFormat(final Date actual, final Date expected, final String format, final String message, final Object... params) {
    toVerifier(actual).verifyEqualsByFormat(expected, format, message, params);
  }

  public void equalsDatePortion(final Date actual, final Date expected) {
    toVerifier(actual).verifyEqualsDatePortion(expected);
  }

  public void equalsDatePortion(final Date actual, final Date expected, final String message, final Object... params) {
    toVerifier(actual).verifyEqualsDatePortion(expected, message, params);
  }

  public void equalsTimePortion(final Date actual, final Date expected) {
    toVerifier(actual).verifyEqualsTimePortion(expected);
  }

  public void equalsTimePortion(final Date actual, final Date expected, final String message, final Object... params) {
    toVerifier(actual).verifyEqualsTimePortion(expected, message, params);
  }

  public void notEquals(final Date actual, final Date expected) {
    toVerifier(actual).verifyNotEquals(expected);
  }

  public void notEquals(final Date actual, final Date expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotEquals(expected, message, params);
  }

  public void notEqualsByFormat(final Date actual, final Date expected, final String format) {
    toVerifier(actual).verifyNotEqualsByFormat(expected, format);
  }

  public void notEqualsByFormat(final Date actual, final Date expected, final String format, final String message, final Object... params) {
    toVerifier(actual).verifyNotEqualsByFormat(expected, format, message, params);
  }

  public void notEqualsDatePortion(final Date actual, final Date expected) {
    toVerifier(actual).verifyNotEqualsDatePortion(expected);
  }

  public void notEqualsDatePortion(final Date actual, final Date expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotEqualsDatePortion(expected, message, params);
  }

  public void notEqualsTimePortion(final Date actual, final Date expected) {
    toVerifier(actual).verifyNotEqualsTimePortion(expected);
  }

  public void notEqualsTimePortion(final Date actual, final Date expected, final String message, final Object... params) {
    toVerifier(actual).verifyNotEqualsTimePortion(expected, message, params);
  }

  protected DateVerify toVerifier(Date actual) {
    return () -> actual;
  }
}
