package io.unified.verify.soft;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.hard.DateVerification;
import io.unified.verify.interfaces.base.DateVerify;

import java.util.Date;

public class DateVerifierImpl<T extends VerificationQueue> extends DateVerification {

  private final T verifier;

  public DateVerifierImpl(T verifier) {
    this.verifier = verifier;
  }

  @Override
  protected DateVerify toVerifier(Date actual) {
    return new DateVerify() {
      @Override
      public VerificationQueue getVerificationQueue() {
        return verifier;
      }

      @Override
      public Date _get() {
        return actual;
      }
    };
  }
}
