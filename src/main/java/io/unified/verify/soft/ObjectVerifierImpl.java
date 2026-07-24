package io.unified.verify.soft;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.hard.ObjectVerification;
import io.unified.verify.interfaces.base.ObjectVerify;
import io.unified.verify.states.ObjectState;

import java.util.Objects;

public class ObjectVerifierImpl<T extends VerificationQueue> extends ObjectVerification {

  private final T verifier;

  public ObjectVerifierImpl(T verifier) {
    this.verifier = verifier;
  }

  @Override
  protected ObjectVerify<Object, ObjectState<Object>> toVerifier(Object actual) {
    return new ObjectVerify<>() {
      @Override
      public ObjectState<Object> _toState(Object o) {
        return new ObjectState<>() {
          @Override
          public boolean isEqual(Object expected) {
            return Objects.equals(_get(), expected);
          }

          @Override
          public Object _get() {
            return o;
          }
        };
      }

      @Override
      public VerificationQueue getVerificationQueue() {
        return verifier;
      }

      @Override
      public Object _get() {
        return actual;
      }
    };
  }
}
