package io.unified.verify.soft;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.hard.MapVerification;
import io.unified.verify.interfaces.base.MapVerify;

import java.util.Map;

public class MapVerifierImpl<T extends VerificationQueue> extends MapVerification {

  private final T verifier;

  public MapVerifierImpl(T verifier) {
    this.verifier = verifier;
  }

  @Override
  protected <K, V> MapVerify<K, V> toVerifier(Map<K, V> actual) {
    return new MapVerify<>() {
      @Override
      public VerificationQueue getVerificationQueue() {
        return verifier;
      }

      @Override
      public Map<K, V> _get() {
        return actual;
      }
    };
  }
}
