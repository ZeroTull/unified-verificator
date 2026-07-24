package io.unified.verify.states;

import io.unified.verify.interfaces.BaseVerify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface BaseState<O> {
  Logger logger = LoggerFactory.getLogger(BaseVerify.class);

  O _get();
}
