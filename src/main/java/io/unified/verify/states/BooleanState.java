package io.unified.verify.states;

import java.util.Objects;

public interface BooleanState extends ObjectState<Boolean> {

  default boolean isEqual(final Boolean expected) {
    return Objects.equals(_get(), expected);
  }

  default Boolean isFalse() {
    return !_get();
  }

  default Boolean isTrue() {
    return _get();
  }
}
