package io.unified.verify.soft;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.hard.BooleanVerification;
import io.unified.verify.interfaces.base.BooleanVerify;

public class BooleanVerifierImpl<T extends VerificationQueue> extends BooleanVerification {

  private final T verifier;

  public BooleanVerifierImpl(T verifier) {
    this.verifier = verifier;
  }

  @Override
  protected BooleanVerify toVerifier(Boolean actual) {
    return new BooleanVerify() {
      @Override
      public VerificationQueue getVerificationQueue() {
        return verifier;
      }

      @Override
      public Boolean _get() {
        return actual;
      }
    };
  }
}
