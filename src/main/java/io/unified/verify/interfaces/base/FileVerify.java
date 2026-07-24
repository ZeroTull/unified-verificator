package io.unified.verify.interfaces.base;

import io.unified.verify.states.FileState;

import java.io.File;

public interface FileVerify extends ObjectVerify<File, FileState> {

  @Override
  default FileState _toState(File e) {
    return () -> e;
  }

  default void verifyEqualsStringContent(final File expectedFile) {
    verifyEqualsStringContent(expectedFile, getDefaultMessage("String Content Equals"));
  }

  default void verifyEqualsStringContent(final File expectedFile, final String message, final Object... params) {
    _verify(expectedFile, (f1, f2) -> _toState(f1).equalsStringContent(f2), message, params);
  }

  default void verifyExists() {
    verifyExists(getDefaultMessage("Exists"));
  }

  default void verifyExists(final String message, final Object... params) {
    _verify(true, (file, aBoolean) -> _get().exists(), message, params);
  }

  default void verifyIsNotExists() {
    verifyIsNotExists(getDefaultMessage("Does Not Exist"));
  }

  default void verifyIsNotExists(final String message, final Object... params) {
    _verify(true, (file, aBoolean) -> !_get().exists(), message, params);
  }

  default void verifyNotEqualsStringContent(final File expectedFile) {
    verifyNotEqualsStringContent(expectedFile, getDefaultMessage("String Content Not Equals"));
  }

  default void verifyNotEqualsStringContent(final File expectedFile, final String message, final Object... params) {
    _verify(expectedFile, (f1, f2) -> _toState(f1).notEqualsStringContent(f2), message, params);
  }
}
