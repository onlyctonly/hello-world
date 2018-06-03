package com.bashfan.finallydemo;

public class Zero {

	public static void main(String[] args) {
		System.out.println(test());
	}
	static int test() {
		try {
			return 0;
		} finally {
			return 1;
		}
	}

}
