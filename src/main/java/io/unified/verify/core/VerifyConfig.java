package io.unified.verify.core;

/**
 * Global configuration for the verificator library.
 * Set via system properties or programmatically before tests run.
 *
 * System properties:
 *   unified.verify.printPassed=true   — log PASS lines in addition to FAIL
 *   unified.verify.ansiColors=true    — colorize console output
 */
public final class VerifyConfig {

  private static boolean printPassed =
      Boolean.parseBoolean(System.getProperty("unified.verify.printPassed", "false"));

  private static boolean ansiColors =
      Boolean.parseBoolean(System.getProperty("unified.verify.ansiColors", "true"));

  private VerifyConfig() {}

  public static boolean isPrintPassed() {
    return printPassed;
  }

  public static void setPrintPassed(boolean value) {
    printPassed = value;
  }

  public static boolean isAnsiColors() {
    return ansiColors && System.console() != null;
  }

  public static void setAnsiColors(boolean value) {
    ansiColors = value;
  }

  public static int getDefaultWaitInSeconds() {
    return Integer.parseInt(System.getProperty("unified.verify.defaultWaitSeconds", "30"));
  }

  public static int getDefaultWaitIntervalMillis() {
    return Integer.parseInt(System.getProperty("unified.verify.defaultWaitIntervalMillis", "500"));
  }
}
