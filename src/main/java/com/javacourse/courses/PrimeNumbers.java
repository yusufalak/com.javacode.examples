package com.javacourse.courses;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {

	public static void main(String[] args) {

		int primeNumberMax = 50;

		List<Integer> primeNumbers = new ArrayList<>();
		for (int numberToCheck = 2; numberToCheck <= primeNumberMax; numberToCheck++) {

			boolean isPrime = true;
			for (int factor = 2; factor <= numberToCheck / 2; factor++) {
				if (numberToCheck % factor == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				primeNumbers.add(numberToCheck);
		}

		primeNumbers.forEach(f -> System.out.println(String.valueOf(f)));
	}

}
