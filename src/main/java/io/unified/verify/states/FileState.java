package io.unified.verify.states;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public interface FileState extends ObjectState<File> {

  default boolean isEqual(final File expected) {
    return Objects.equals(_get(), expected);
  }

  default boolean equalsStringContent(final File expectedFile) {
    File f1 = _get();
    if (f1 == null || expectedFile == null || !f1.exists() || !expectedFile.exists()) return false;
    try {
      String s1 = Files.readString(f1.toPath());
      String s2 = Files.readString(expectedFile.toPath());
      return StringUtils.equals(s1, s2);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  default boolean notEqualsStringContent(final File expectedFile) {
    File f1 = _get();
    if (f1 == null || expectedFile == null || !f1.exists() || !expectedFile.exists()) return false;
    try {
      String s1 = Files.readString(f1.toPath());
      String s2 = Files.readString(expectedFile.toPath());
      return !StringUtils.equals(s1, s2);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
