package io.unified.verify.soft;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.hard.CollectionVerification;
import io.unified.verify.interfaces.base.CollectionVerify;
import io.unified.verify.interfaces.base.IterableVerify;

import java.util.Collection;

public class CollectionVerifierImpl<T extends VerificationQueue> extends CollectionVerification {

  private final T verifier;

  public CollectionVerifierImpl(T verifier) {
    this.verifier = verifier;
  }

  @Override
  protected <E> CollectionVerify<E, Collection<E>> toVerifier(Collection<E> actual) {
    return new CollectionVerify<>() {
      @Override
      public VerificationQueue getVerificationQueue() {
        return verifier;
      }

      @Override
      public Collection<E> _get() {
        return actual;
      }
    };
  }

  @Override
  protected <E> IterableVerify<E, Iterable<E>> toVerifier(Iterable<E> actual) {
    return new IterableVerify<>() {
      @Override
      public VerificationQueue getVerificationQueue() {
        return verifier;
      }

      @Override
      public Iterable<E> _get() {
        return actual;
      }
    };
  }
}
