package io.unified.verify.extensions;

import io.unified.verify.interfaces.BaseVerify;
import io.unified.verify.states.BooleanState;
import io.unified.verify.states.ObjectState;

public interface BooleanExtension extends BaseVerify<Boolean, BooleanState> {

  @Override
  default BooleanState _toState(Boolean e) {
    return () -> e;
  }
}
