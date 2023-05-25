package com.javacourse.courses;

public class PyramidAndPattern {

	public static void main(String[] args) {
		int rows = 10;
		// floydsTriangle(rows);
		// pascalsTriangle(rows);
		// upStartsPrintTriangle(rows);
		// downStartsPrintTriangle(rows);
		tree();
	}

	// public static void main(String[] args) {
	// int rows = 7; // Number of Rows we want to print
	//
	// StringBuilder buf = new StringBuilder();
	// // Printing the pattern
	// for (int i = 1; i <= rows; i++) {
	// for (int j = 1; j < i; j++) {
	// buf.append(" ");
	// }
	// for (int j = i; j <= rows; j++) {
	// buf.append("* ");
	// }
	// buf.append("\n");
	// }
	//
	// // Printing the reverse pattern
	// for (int i = rows - 1; i >= 1; i--) {
	// for (int j = 1; j < i; j++) {
	// buf.append(" ");
	// }
	// for (int j = i; j <= rows; j++) {
	// buf.append("* ");
	// }
	// buf.append("\n");
	// }
	// System.out.print(buf.toString());
	// }

	private static void pascalsTriangle(int rows) {
		int coef = 1;

		for (int i = 0; i < rows; i++) {
			for (int space = 1; space < rows - i; ++space) {
				System.out.print("  ");
			}

			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == 0)
					coef = 1;
				else
					coef = coef * (i - j + 1) / j;

				System.out.printf("%4d", coef);
			}

			System.out.println();
		}
	}

	private static void floydsTriangle(int rows) {
		int number = 1;

		for (int i = 1; i <= rows; i++) {

			for (int j = 1; j <= i; j++) {
				System.out.print(number + " ");
				++number;
			}

			System.out.println();
		}
	}

	private static void upStartsPrintTriangle(int r) {
		int c = 0;

		StringBuilder buf = new StringBuilder();
		for (int i = 1; i <= r; ++i) {
			c = 0;
			for (int s = 1; s <= r - i; ++s) {
				buf.append("- ");
			}

			for (int x = 0; x < 2 * i - 1; x++) {
				buf.append("* ");
				++c;
			}

			for (int s = c; s < r + c - i; ++s) {
				buf.append("- ");
			}

			buf.append("\n");
		}
		System.out.print(buf.toString());
	}

	private static void tree() {

		int height = 5;
		int width = 5;
		int space = width * 5;

		int x = 1;

		StringBuilder buf = new StringBuilder();

		for (int a = 0; a < height; a++) {

			for (int i = x; i <= width; i++) {

				for (int j = space; j >= i; j--) {

					buf.append(" ");
				}

				for (int k = 1; k <= i; k++) {

					buf.append("* ");
				}
				buf.append("\n");
			}

			x = x + 2;
			width = width + 2;
		}

		for (int i = 0; i < 10; i++) {

			for (int j = space - 3; j >= 1; j--) {
				buf.append(" ");
			}

			for (int k = 1; k <= 4; k++) {
				buf.append("+ ");
			}

			buf.append("\n");
		}

		System.err.println(buf.toString());
	}

	private static void downStartsPrintTriangle(int row) {
		StringBuilder buf = new StringBuilder();

		int r = row * 2;

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j < i; j++) {
				buf.append("- ");
			}
			for (int j = i; j <= r; j++) {
				buf.append("* ");
			}
			buf.append("\n");
		}
		System.out.print(buf.toString());
	}

}
