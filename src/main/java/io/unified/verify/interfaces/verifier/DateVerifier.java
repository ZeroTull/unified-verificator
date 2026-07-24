package io.unified.verify.interfaces.verifier;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.interfaces.base.DateVerify;
import io.unified.verify.states.DateState;

import java.util.Date;

public interface DateVerifier extends ObjectVerifier<Date, DateState>, DateVerify {

  default void verifyEqualsByFormat(final VerificationQueue verifier, final Date expected, final String format) {
    verifyEqualsByFormat(verifier, expected, format, getDefaultMessage("Equals By Format " + format));
  }

  default void verifyEqualsByFormat(final VerificationQueue verifier, final Date expected, final String format, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).equalsByFormat(o2, format), message, params);
  }

  default void verifyEqualsDatePortion(final VerificationQueue verifier, final Date expected) {
    verifyEqualsDatePortion(verifier, expected, getDefaultMessage("Date Portion Equals"));
  }

  default void verifyEqualsDatePortion(final VerificationQueue verifier, final Date expected, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).equalsDatePortion(o2), message, params);
  }

  default void verifyEqualsTimePortion(final VerificationQueue verifier, final Date expected) {
    verifyEqualsTimePortion(verifier, expected, getDefaultMessage("Time Portion Equals"));
  }

  default void verifyEqualsTimePortion(final VerificationQueue verifier, final Date expected, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).equalsTimePortion(o2), message, params);
  }

  default void verifyNotEqualsByFormat(final VerificationQueue verifier, final Date expected, final String format) {
    verifyNotEqualsByFormat(verifier, expected, format, getDefaultMessage("Not Equals By Format " + format));
  }

  default void verifyNotEqualsByFormat(final VerificationQueue verifier, final Date expected, final String format, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).notEqualsByFormat(o2, format), message, params);
  }
}
