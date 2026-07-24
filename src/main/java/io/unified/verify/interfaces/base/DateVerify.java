package io.unified.verify.interfaces.base;

import io.unified.verify.states.DateState;

import java.util.Date;

public interface DateVerify extends ObjectVerify<Date, DateState> {

  @Override
  default DateState _toState(Date e) {
    return () -> e;
  }

  default void verifyEqualsByFormat(final Date expected, final String format) {
    verifyEqualsByFormat(expected, format, getDefaultMessage("Equals By Format " + format));
  }

  default void verifyEqualsByFormat(final Date expected, final String format, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).equalsByFormat(o2, format), message, params);
  }

  default void verifyEqualsDatePortion(final Date expected) {
    verifyEqualsDatePortion(expected, getDefaultMessage("Date Portion Equals"));
  }

  default void verifyEqualsDatePortion(final Date expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).equalsDatePortion(o2), message, params);
  }

  default void verifyEqualsTimePortion(final Date expected) {
    verifyEqualsTimePortion(expected, getDefaultMessage("Time Portion Equals"));
  }

  default void verifyEqualsTimePortion(final Date expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).equalsTimePortion(o2), message, params);
  }

  default void verifyNotEqualsByFormat(final Date expected, final String format) {
    verifyNotEqualsByFormat(expected, format, getDefaultMessage("Not Equals By Format " + format));
  }

  default void verifyNotEqualsByFormat(final Date expected, final String format, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).notEqualsByFormat(o2, format), message, params);
  }

  default void verifyNotEqualsDatePortion(final Date expected) {
    verifyNotEqualsDatePortion(expected, getDefaultMessage("Date Portion Not Equals"));
  }

  default void verifyNotEqualsDatePortion(final Date expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).notEqualsDatePortion(o2), message, params);
  }

  default void verifyNotEqualsTimePortion(final Date expected) {
    verifyNotEqualsTimePortion(expected, getDefaultMessage("Time Portion Not Equals"));
  }

  default void verifyNotEqualsTimePortion(final Date expected, final String message, final Object... params) {
    _verify(expected, (o, o2) -> _toState(o).notEqualsTimePortion(o2), message, params);
  }
}
