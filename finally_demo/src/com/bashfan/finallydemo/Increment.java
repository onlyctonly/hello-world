package com.bashfan.finallydemo;

public class Increment {

	public static void main(String[] args) {
		System.out.println(test());
	}
	public static int test() {
		int i=1;
		try {
			System.out.println("try");
			return i;
		} finally {
			System.out.println("finally");
			i++;
		}
	}
}
