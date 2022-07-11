package com.example.lambda;

public class LambdaWork {

  public static int getDigit(OneArgumentFunctionalInterface one) {
    return one.getDigit();
  }

  public static int functionOneArgument(TwoArgumentFunctionalInterface two) {
    return two.oneDigit(20);
  }

  public static boolean equalsTwoDigits(
    ThreeArgumentFunctionalInterface three
  ) {
    return three.booleanFunc(20, 25);
  }
}
