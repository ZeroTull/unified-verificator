package io.unified.verify.hard;

import io.unified.verify.interfaces.base.FileVerify;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class FileVerification extends BaseVerification {

  public void equalsStringContent(final String actualFile, final String expectedFile) {
    toVerifier(new File(actualFile)).verifyEqualsStringContent(new File(expectedFile));
  }

  public void equalsStringContent(final String actualFile, final String expectedFile, final String message, final Object... params) {
    toVerifier(new File(actualFile)).verifyEqualsStringContent(new File(expectedFile), message, params);
  }

  public void equalsStringContent(final File actualFile, final File expectedFile) {
    toVerifier(actualFile).verifyEqualsStringContent(expectedFile);
  }

  public void equalsStringContent(final File actualFile, final File expectedFile, final String message, final Object... params) {
    toVerifier(actualFile).verifyEqualsStringContent(expectedFile, message, params);
  }

  public void exists(final String actualFile) {
    toVerifier(new File(actualFile)).verifyExists();
  }

  public void exists(final String actualFile, final String message, final Object... params) {
    toVerifier(new File(actualFile)).verifyExists(message, params);
  }

  public void exists(final File actualFile) {
    toVerifier(actualFile).verifyExists();
  }

  public void exists(final File actualFile, final String message, final Object... params) {
    toVerifier(actualFile).verifyExists(message, params);
  }

  public void notEqualsStringContent(final String actualFile, final String expectedFile) {
    toVerifier(new File(actualFile)).verifyNotEqualsStringContent(new File(expectedFile));
  }

  public void notEqualsStringContent(final String actualFile, final String expectedFile, final String message, final Object... params) {
    toVerifier(new File(actualFile)).verifyNotEqualsStringContent(new File(expectedFile), message, params);
  }

  public void notEqualsStringContent(final File actualFile, final File expectedFile) {
    toVerifier(actualFile).verifyNotEqualsStringContent(expectedFile);
  }

  public void notEqualsStringContent(final File actualFile, final File expectedFile, final String message, final Object... params) {
    toVerifier(actualFile).verifyNotEqualsStringContent(expectedFile, message, params);
  }

  public void notExists(final String actualFile) {
    toVerifier(new File(actualFile)).verifyIsNotExists();
  }

  public void notExists(final String actualFile, final String message, final Object... params) {
    toVerifier(new File(actualFile)).verifyIsNotExists(message, params);
  }

  public void notExists(final File actualFile) {
    toVerifier(actualFile).verifyIsNotExists();
  }

  public void notExists(final File actualFile, final String message, final Object... params) {
    toVerifier(actualFile).verifyIsNotExists(message, params);
  }

  protected FileVerify toVerifier(File actual) {
    return () -> actual;
  }
}
