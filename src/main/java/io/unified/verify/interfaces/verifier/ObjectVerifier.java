package io.unified.verify.interfaces.verifier;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.interfaces.BaseVerify;
import io.unified.verify.states.ObjectState;
import io.unified.verify.wait.BaseWaiter;

import java.util.List;

public interface ObjectVerifier<O, S extends ObjectState<O>> extends BaseVerify<O, S>, BaseWaiter<O> {

  default void verifyEquals(final VerificationQueue verifier, final O expected) {
    verifyEquals(verifier, expected, getDefaultMessage("Equals"));
  }

  default void verifyEquals(final VerificationQueue verifier, final O expected, final String message, final Object... params) {
    _verify(verifier, expected, (o1, o2) -> _toState(o1).isEqual(o2), message, params);
  }

  default void verifyEqualsAny(final VerificationQueue verifier, List<O> expectedList) {
    verifyEqualsAny(verifier, expectedList, getDefaultMessage("Is Equal To One Of Expected Values"));
  }

  default void verifyEqualsAny(VerificationQueue verifier, List<O> expectedList, final String message, final Object... params) {
    _verify(verifier, expectedList,
        (a, b) -> a != null && b != null && b.stream().anyMatch(b2 -> _toState(a).isEqual(b2)),
        message, params);
  }

  default void verifyEqualsNone(final VerificationQueue verifier, List<O> expectedList) {
    verifyEqualsNone(verifier, expectedList, getDefaultMessage("Is Not Equal To Any Of Expected Values"));
  }

  default void verifyEqualsNone(VerificationQueue verifier, List<O> expectedList, final String message, final Object... params) {
    _verify(verifier, expectedList,
        (a, b) -> a != null && b != null && b.stream().noneMatch(b2 -> _toState(a).isEqual(b2)),
        message, params);
  }

  default void verifyIsNotNull(final VerificationQueue verifier) {
    verifyIsNotNull(verifier, getDefaultMessage("Is Not Null"));
  }

  default void verifyIsNotNull(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, null, (o1, o2) -> o1 != o2, message, params);
  }

  default void verifyIsNull(final VerificationQueue verifier) {
    verifyIsNull(verifier, getDefaultMessage("Is Null"));
  }

  default void verifyIsNull(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, true, (o1, o2) -> _toState(o1).isEqual(null), message, params);
  }

  default void verifyNotEquals(final VerificationQueue verifier, final O expected) {
    verifyNotEquals(verifier, expected, getDefaultMessage("Not Equals"));
  }

  default void verifyNotEquals(final VerificationQueue verifier, final O expected, final String message, final Object... params) {
    _verify(verifier, expected, (o1, o2) -> _toState(o1).isNotEqual(o2), message, params);
  }
}
