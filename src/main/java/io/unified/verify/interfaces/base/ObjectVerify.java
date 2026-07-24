package io.unified.verify.interfaces.base;

import io.unified.verify.interfaces.BaseVerify;
import io.unified.verify.states.ObjectState;

import java.util.List;

public interface ObjectVerify<O, S extends ObjectState<O>> extends BaseVerify<O, S> {

  default void verifyEquals(final O expected) {
    verifyEquals(expected, getDefaultMessage("Equals"));
  }

  default void verifyEquals(final O expected, final String message, final Object... params) {
    _verify(expected, (o1, o2) -> _toState(o1).isEqual(o2), message, params);
  }

  default void verifyEqualsAny(List<O> expectedList) {
    verifyEqualsAny(expectedList, getDefaultMessage("Is Equal To One Of Expected Values"));
  }

  default void verifyEqualsAny(List<O> expectedList, final String message, final Object... params) {
    _verify(
        expectedList,
        (a, b) -> a != null && b != null && b.stream().anyMatch(b2 -> _toState(a).isEqual(b2)),
        message,
        params);
  }

  default void verifyEqualsNone(List<O> expectedList) {
    verifyEqualsNone(expectedList, getDefaultMessage("Is Not Equal To Any Of Expected Values"));
  }

  default void verifyEqualsNone(List<O> expectedList, final String message, final Object... params) {
    _verify(
        expectedList,
        (a, b) -> a != null && b != null && b.stream().noneMatch(b2 -> _toState(a).isEqual(b2)),
        message,
        params);
  }

  default void verifyIsNotNull() {
    verifyIsNotNull(getDefaultMessage("Is Not Null"));
  }

  default void verifyIsNotNull(final String message, final Object... params) {
    _verify(null, (o1, o2) -> o1 != o2, message, params);
  }

  default void verifyIsNull() {
    verifyIsNull(getDefaultMessage("Is Null"));
  }

  @SuppressWarnings("unchecked")
  default void verifyIsNull(final String message, final Object... params) {
    _verify(null, (o1, o2) -> _toState(o1).isEqual((O) o2), message, params);
  }

  default void verifyNotEquals(final O expected) {
    verifyNotEquals(expected, getDefaultMessage("Not Equals"));
  }

  default void verifyNotEquals(final O expected, final String message, final Object... params) {
    _verify(expected, (o1, o2) -> _toState(o1).isNotEqual(o2), message, params);
  }
}
