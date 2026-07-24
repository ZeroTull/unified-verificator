package io.unified.verify.states;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public interface DateState extends ObjectState<Date> {

  default boolean isEqual(final Date expected) {
    return Objects.equals(_get(), expected);
  }

  default boolean equalsByFormat(final Date expected, final String format) {
    Date o = _get();
    if (o == null || expected == null) return o == expected;
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return sdf.format(o).equals(sdf.format(expected));
  }

  default boolean equalsDatePortion(final Date expected) {
    return equalsByFormat(expected, "yyyy-MM-dd");
  }

  default boolean equalsTimePortion(final Date expected) {
    return equalsByFormat(expected, "HH:mm:ss");
  }

  default boolean notEqualsByFormat(final Date expected, final String format) {
    Date o = _get();
    if (o == null || expected == null) return o != expected;
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    return !sdf.format(o).equals(sdf.format(expected));
  }

  default boolean notEqualsDatePortion(final Date expected) {
    return notEqualsByFormat(expected, "yyyy-MM-dd");
  }

  default boolean notEqualsTimePortion(final Date expected) {
    return notEqualsByFormat(expected, "HH:mm:ss");
  }
}
