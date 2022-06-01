package com.javacourse.courses;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MinPossitiveNumber {

	public static void main(String[] args) {
		// int[] values = { -1, -3, 0, 1, -2, -4, 5, 6, 3, 2, 9 };

		int[] values = new int[9_000_000];
		for (int i = 0; i < 9_000_000; i++) {
			Random ran = new Random();
			values[i] = ran.nextInt();
		}

		long start = System.currentTimeMillis();
		int value = findMissing(values);
		long end = System.currentTimeMillis();

		System.out.println("Value: " + value + " Time: " + (end - start) + " millis."); // %100

		start = System.currentTimeMillis();
		value = find(values);
		end = System.currentTimeMillis();

		System.out.println("Value: " + value + " Time: " + (end - start) + " millis."); // %55
	}

	private static int findMissing(int arr[]) {
		int size = arr.length;
		int shift = segregate(arr, size);
		int arr2[] = new int[size - shift];
		int j = 0;
		for (int i = shift; i < size; i++) {
			arr2[j] = arr[i];
			j++;
		}
		return findMissingPositive(arr2, j);
	}

	private static int segregate(int arr[], int size) {
		int j = 0, i;
		for (i = 0; i < size; i++) {
			if (arr[i] <= 0) {
				int temp;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		return j;
	}

	private static int findMissingPositive(int arr[], int size) {
		int i;
		for (i = 0; i < size; i++) {
			int x = Math.abs(arr[i]);
			if (x - 1 < size && arr[x - 1] > 0)
				arr[x - 1] = -arr[x - 1];
		}

		for (i = 0; i < size; i++)
			if (arr[i] > 0)
				return i + 1;

		return size + 1;
	}

	private static int find(int[] A) {
		List<Integer> sorttedList = Arrays.stream(A).boxed().filter(i -> i > 0).sorted().collect(Collectors.toList());
		for (int i = 0; i < sorttedList.size(); i++) {
			if (!sorttedList.contains(i + 1)) {
				return i + 1;
			}
		}

		return sorttedList.isEmpty() ? 1 : sorttedList.get(sorttedList.size() - 1) + 1;
	}
}
