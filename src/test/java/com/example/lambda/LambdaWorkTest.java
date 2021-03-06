package com.example.lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LambdaWorkTest {

  @Test
  public void getDigitTest() {
    assertEquals(10, LambdaWork.getDigit(() -> 10));
    assertEquals(40, LambdaWork.getDigit(() -> 15 + 25));
    assertEquals(
      5,
      LambdaWork.getDigit(
        () -> {
          int a = 25;
          int b = 5;
          int c = a / b;
          return c;
        }
      )
    );
  }

  @Test
  public void FunctionOneArgumentTest() {
    assertEquals(200, LambdaWork.functionOneArgument(d -> d * 10));
    assertEquals(
      30,
      LambdaWork.functionOneArgument(
        new TwoArgumentFunctionalInterface() {
          @Override
          public int oneDigit(int digit) {
            int d = 10;
            return digit + d;
          }
        }
      )
    );
    assertEquals(0, LambdaWork.functionOneArgument(d -> d - 20));
  }

  @Test
  public void equalsTwoDigitsTest() {
    assertTrue(LambdaWork.equalsTwoDigits((a, b) -> a < b));
    assertFalse(LambdaWork.equalsTwoDigits((a, b) -> a > b));
    assertFalse(LambdaWork.equalsTwoDigits((a, b) -> a == b));
  }
}
