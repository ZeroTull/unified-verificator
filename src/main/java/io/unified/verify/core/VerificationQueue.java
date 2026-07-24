package io.unified.verify.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Strategy interface for dispatching a single verification.
 *
 * <p>Hard implementations (see {@code Verify}) throw immediately on failure.
 * Soft implementations (see {@code Verifier}) enqueue the check and throw
 * only when {@code verifier.verify()} is called.
 */
public interface VerificationQueue {

  Logger logger = LoggerFactory.getLogger(VerificationQueue.class);

  default void queue(VerificationInfo<?, ?> info) {
    StringBuilder messages = new StringBuilder(
        VerifyConfig.isAnsiColors() ? AnsiUtil.RESET : "");
    boolean passed = info.test(messages);
    String text = messages.toString();
    if (!passed) {
      logger.error(text);
      throw new AssertionError(text);
    } else if (VerifyConfig.isPrintPassed()) {
      logger.info(text);
    }
  }
}
