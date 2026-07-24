package io.unified.verify.interfaces.verifier;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.interfaces.base.FileVerify;
import io.unified.verify.states.FileState;

import java.io.File;

public interface FileVerifier extends ObjectVerifier<File, FileState>, FileVerify {

  default void verifyEqualsStringContent(final VerificationQueue verifier, final File expectedFile) {
    verifyEqualsStringContent(verifier, expectedFile, getDefaultMessage("String Content Equals"));
  }

  default void verifyEqualsStringContent(final VerificationQueue verifier, final File expectedFile, final String message, final Object... params) {
    _verify(verifier, expectedFile, (f1, f2) -> _toState(f1).equalsStringContent(f2), message, params);
  }

  default void verifyExists(final VerificationQueue verifier) {
    verifyExists(verifier, getDefaultMessage("Exists"));
  }

  default void verifyExists(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, true, (file, aBoolean) -> _get().exists(), message, params);
  }

  default void verifyIsNotExists(final VerificationQueue verifier) {
    verifyIsNotExists(verifier, getDefaultMessage("Does Not Exist"));
  }

  default void verifyIsNotExists(final VerificationQueue verifier, final String message, final Object... params) {
    _verify(verifier, true, (file, aBoolean) -> !_get().exists(), message, params);
  }

  default void verifyNotEqualsStringContent(final VerificationQueue verifier, final File expectedFile) {
    verifyNotEqualsStringContent(verifier, expectedFile, getDefaultMessage("String Content Not Equals"));
  }

  default void verifyNotEqualsStringContent(final VerificationQueue verifier, final File expectedFile, final String message, final Object... params) {
    _verify(verifier, expectedFile, (f1, f2) -> _toState(f1).notEqualsStringContent(f2), message, params);
  }
}
