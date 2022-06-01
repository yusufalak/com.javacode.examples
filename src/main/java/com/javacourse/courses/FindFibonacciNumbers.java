package com.javacourse.courses;

import java.math.BigDecimal;

public class FindFibonacciNumbers {

	public static void main(String[] args) {

		int findFibonacci = 7500;

		BigDecimal[] cachedFibonacci = new BigDecimal[findFibonacci + 1];

		System.out.println("--------------FIND FIBONACCI--------------------");

		long start = System.currentTimeMillis();
		BigDecimal val = createFibonacciArray(findFibonacci);
		long end = System.currentTimeMillis();

		System.out.println("Find ForLoop Method Fibonacci: " + findFibonacci + ". = [ " + val + " ] -> " + (end - start) + " millis.");

		start = System.currentTimeMillis();
		val = findFibonacciNumber(cachedFibonacci, findFibonacci);
		end = System.currentTimeMillis();

		System.out.println("Find Recursive Fibonacci: " + findFibonacci + ". = [ " + val + " ] -> " + (end - start) + " millis.");
	}

	private static BigDecimal findFibonacciNumber(BigDecimal[] cachedFibonacci, int n) {
		if (n <= 1)
			return BigDecimal.valueOf(n);

		if (cachedFibonacci[n] != null)
			return cachedFibonacci[n];

		BigDecimal newFibonacciNumber = findFibonacciNumber(cachedFibonacci, n - 1).add(findFibonacciNumber(cachedFibonacci, n - 2));

		cachedFibonacci[n] = newFibonacciNumber;

		return newFibonacciNumber;
	}

	private static BigDecimal createFibonacciArray(int fibonacciCount) {

		BigDecimal[] fibonacciNumbers = new BigDecimal[fibonacciCount + 1];

		for (int i = 0; i < fibonacciCount + 1; i++) {

			if (i == 0) {
				fibonacciNumbers[i] = BigDecimal.valueOf(0);
			} else if (i == 1) {
				fibonacciNumbers[i] = BigDecimal.valueOf(1);
			} else {
				BigDecimal prevNumber2 = fibonacciNumbers[i - 2];
				BigDecimal prevNumber1 = fibonacciNumbers[i - 1];
				BigDecimal newNumber = prevNumber1.add(prevNumber2);
				fibonacciNumbers[i] = newNumber;
			}

		}

		return fibonacciNumbers[fibonacciCount];
	}

}
