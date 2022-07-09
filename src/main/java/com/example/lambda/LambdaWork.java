package com.example.lambda;

public class LambdaWork {

  public static int getDigit(OneArgumentFunctionalInterface one) {
    return one.getDigit();
  }

  public static int FunctionOneArgument(TwoArgumentFunctionalInterface two) {
    return two.oneDigit(20);
  }

  public static boolean equalsTwoDigits(
    ThreeArgumentFunctionalInterface three
  ) {
    return three.booleanFunc(20, 25);
  }

  public static void main(String... s) {
    int ten = getDigit(() -> 10);

    System.out.println(ten);

    int digits = FunctionOneArgument(
      new TwoArgumentFunctionalInterface() {
        @Override
        public int oneDigit(int digit) {
          int d = (int) (Math.random() * 10);
          System.out.println("Random digit: " + d);
          return digit + d;
        }
      }
    );

    System.out.println(digits);
    System.out.println(equalsTwoDigits((a, b) -> a == b));
  }
}
