package com.example.lambda;

public class LambdaWork {
	
	final static int digit = 20;
	
	public static int getTen(OneArgumentFunctionalInterface one) {
		return one.getDigit();
	}
	
	public static int sumRandomDigit(TwoArgumentFunctionalInterface two) {
		return two.oneDigit(digit);
	}
	
	public static boolean equalsTwoDigits(ThreeArgumentFunctionalInterface three) {
		return three.booleanFunc(digit, 25);
	}
	
	public static void main(String ... s) {
		
		int ten = getTen(()-> 10);
		
		System.out.println(ten);
		
		int digits =  sumRandomDigit(new TwoArgumentFunctionalInterface() {
			@Override
			public int oneDigit(int digit) {
				int d = (int) (Math.random()*10);
				System.out.println("Random digit: " + d);
				return digit +  d;
			}
		});
		
		System.out.println(digits);
		
		System.out.println(equalsTwoDigits((a, b) -> a == b));
		
		
		
	}

}
