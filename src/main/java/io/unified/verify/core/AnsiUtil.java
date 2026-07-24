package io.unified.verify.core;

/** Minimal ANSI color helper for console output. */
public final class AnsiUtil {

  public static final String RESET = "[0m";
  private static final String RED   = "[31m";
  private static final String GREEN = "[32m";

  private AnsiUtil() {}

  public static String toRed(String text) {
    return RED + text + RESET;
  }

  public static String toGreen(String text) {
    return GREEN + text + RESET;
  }
}
