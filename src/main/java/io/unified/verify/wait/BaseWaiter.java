package io.unified.verify.wait;

import io.unified.verify.core.VerifyConfig;
import io.unified.verify.states.BaseState;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.util.function.Predicate;

public interface BaseWaiter<O> extends BaseState<O> {

  default int getDefaultWaitIntervalInMilliSeconds() {
    return VerifyConfig.getDefaultWaitIntervalMillis();
  }

  default int getDefaultWaitInSeconds() {
    return VerifyConfig.getDefaultWaitInSeconds();
  }

  default String getDefaultMessage(final String methodDescription, final Object... params) {
    return getDefaultMessage(String.format(methodDescription, params));
  }

  default String getDefaultMessage(final String methodDescription) {
    if (StringUtils.isBlank(getVerifyMessagePrefix())) {
      return "Verify " + methodDescription + ".";
    }
    return String.format("Verify %s %s.", getVerifyMessagePrefix(), methodDescription);
  }

  default String getVerifyMessagePrefix() {
    return "";
  }

  default boolean _waiter(Predicate<O> waitMethod, final int waitInSeconds, final int intervalInMilliSeconds) {
    boolean isTimeOuted = false;
    Throwable lastException = null;

    Instant deadLine = Instant.now().plusSeconds(waitInSeconds);
    while (true) {
      try {
        if (waitMethod.test(_get())) {
          break;
        }
      } catch (Exception e) {
        lastException = e;
      }

      if (Instant.now().isAfter(deadLine)) {
        isTimeOuted = true;
        break;
      }

      if ((waitInSeconds * 1000L) > intervalInMilliSeconds) {
        try {
          Thread.sleep(intervalInMilliSeconds);
        } catch (InterruptedException ie) {
          Thread.currentThread().interrupt();
        }
      }
    }

    if (isTimeOuted && lastException != null) {
      if (lastException instanceof RuntimeException exception) {
        throw exception;
      }
      throw new RuntimeException(lastException);
    }

    return !isTimeOuted;
  }
}
