package com.javacourse.courses;

import java.util.ArrayList;
import java.util.List;

public class NestedClassExample {

	public class Age {
		public int age;

		public Age(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return String.valueOf(age);
		}
	}

	public class InnerClass1 extends Age {
		public String name;

		public InnerClass1(String val, int age) {
			super(age);
			this.name = val;
		}

		@Override
		public String toString() {
			return name + " " + super.toString();
		}
	}

	public class InnerClass2 extends Age {
		public String name;

		public InnerClass2(String val, int age) {
			super(age);
			this.name = val;
		}

		@Override
		public String toString() {
			return name + " " + super.toString();
		}
	}

	public class InnerClass3 {
		public String name;

		public InnerClass3(String val) {
			this.name = val;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public static void main(String[] args) {

		List<InnerClass1> classes1 = new ArrayList<>();
		List<InnerClass2> classes2 = new ArrayList<>();
		List<InnerClass3> classes3 = new ArrayList<>();

		classes1.add(new NestedClassExample().new InnerClass1("YUSUF ALAK", 40));
		classes1.add(new NestedClassExample().new InnerClass1("SEYDA ALAK", 33));

		classes2.add(new NestedClassExample().new InnerClass2("KEMAL EFE", 45));
		classes2.add(new NestedClassExample().new InnerClass2("DENIZ EFE", 33));

		classes3.add(new NestedClassExample().new InnerClass3("ERHAN SUNAR"));
		classes3.add(new NestedClassExample().new InnerClass3("BAHAR SUNAR"));

		printList1(classes1);
		printList1(classes2);
		printList1(classes3);

		printList2(classes1);
		printList2(classes2);
		// printList2(classes3);
	}

	private static void printList1(List<?> list) {

		list.forEach(t -> System.out.println(t.toString()));
	}

	private static void printList2(List<? extends Age> list) {

		list.forEach(t -> System.out.println(t.toString()));
	}
}
