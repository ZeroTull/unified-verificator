package io.unified.verify.interfaces.verifier;

import io.unified.verify.core.VerificationQueue;
import io.unified.verify.interfaces.base.CollectionVerify;
import io.unified.verify.states.CollectionState;

import java.util.Collection;

public interface CollectionVerifier<E, C extends Collection<E>>
    extends IterableVerifier<E, C>, CollectionVerify<E, C> {

  default void verifySizeEquals(final VerificationQueue verifier, int expected) {
    verifySizeEquals(verifier, expected, getDefaultMessage("Size Equals"));
  }

  default void verifySizeEquals(final VerificationQueue verifier, int expected, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).sizeEquals(o2), message, params);
  }

  default void verifySizeIsGreaterThan(final VerificationQueue verifier, int expected) {
    verifySizeIsGreaterThan(verifier, expected, getDefaultMessage("Size Is Greater Than"));
  }

  default void verifySizeIsGreaterThan(final VerificationQueue verifier, int expected, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).sizeIsGreaterThan(o2), message, params);
  }

  default void verifySizeIsLessThan(final VerificationQueue verifier, int expected) {
    verifySizeIsLessThan(verifier, expected, getDefaultMessage("Size Is Less Than"));
  }

  default void verifySizeIsLessThan(final VerificationQueue verifier, int expected, final String message, final Object... params) {
    _verify(verifier, expected, (o, o2) -> _toState(o).sizeIsLessThan(o2), message, params);
  }
}
