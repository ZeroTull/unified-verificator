package io.unified.verify.soft;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.hard.StringVerification;
import io.unified.verify.interfaces.base.StringVerify;

public class StringVerifierImpl<T extends VerificationQueue> extends StringVerification {

  private final T verifier;

  public StringVerifierImpl(T verifier) {
    this.verifier = verifier;
  }

  @Override
  protected StringVerify toVerifier(String actual) {
    return new StringVerify() {
      @Override
      public VerificationQueue getVerificationQueue() {
        return verifier;
      }

      @Override
      public String _get() {
        return actual;
      }
    };
  }
}
