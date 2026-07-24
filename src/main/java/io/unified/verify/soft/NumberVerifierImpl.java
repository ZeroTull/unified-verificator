package io.unified.verify.soft;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.hard.NumberVerification;
import io.unified.verify.interfaces.base.NumberVerify;

public class NumberVerifierImpl<T extends VerificationQueue, N extends Number & Comparable<N>>
    extends NumberVerification<N> {

  private final T verifier;

  public NumberVerifierImpl(T verifier) {
    this.verifier = verifier;
  }

  @Override
  protected NumberVerify<N> toVerifier(N actual) {
    return new NumberVerify<>() {
      @Override
      public VerificationQueue getVerificationQueue() {
        return verifier;
      }

      @Override
      public N _get() {
        return actual;
      }
    };
  }
}
