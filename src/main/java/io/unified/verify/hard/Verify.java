package io.unified.verify.hard;

public class Verify {

  private Verify() {}

  public static final ObjectVerification Object = new ObjectVerification();
  public static final CollectionVerification Collection = new CollectionVerification();
  public static final MapVerification Map = new MapVerification();
  public static final BooleanVerification Bool = new BooleanVerification();
  public static final DateVerification Date = new DateVerification();
  public static final StringVerification String = new StringVerification();
  public static final FileVerification File = new FileVerification();
  public static final NumberVerification<Long> Long = new NumberVerification<>();
  public static final NumberVerification<java.math.BigDecimal> BigDecimal = new NumberVerification<>();
  public static final NumberVerification<Double> Double = new NumberVerification<>();
  public static final NumberVerification<Float> Float = new NumberVerification<>();
  public static final NumberVerification<Integer> Int = new NumberVerification<>();
}
