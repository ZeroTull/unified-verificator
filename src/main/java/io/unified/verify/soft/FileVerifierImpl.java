package io.unified.verify.soft;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.hard.FileVerification;
import io.unified.verify.interfaces.base.FileVerify;

import java.io.File;

public class FileVerifierImpl<T extends VerificationQueue> extends FileVerification {

  private final T verifier;

  public FileVerifierImpl(T verifier) {
    this.verifier = verifier;
  }

  @Override
  protected FileVerify toVerifier(File actual) {
    return new FileVerify() {
      @Override
      public VerificationQueue getVerificationQueue() {
        return verifier;
      }

      @Override
      public File _get() {
        return actual;
      }
    };
  }
}
