package com.bashfan.finallydemo;

public class Main {
	public static void main(String[] args) {
//		try {
//			System.out.println("try");
////			System.exit(0); //this cause no finally
//			System.out.println(33/0);
//		} finally {
//			System.out.println("finally");
//		}
		System.out.println(test());
	}
	
	public static int test() {
		int i = 1;
//			if (i==1) 
//				return 0;
		System.out.println("prior try");
//		i=i/0;
		try {
			System.out.println("try");
			return i;
		} finally {
			System.out.println("finally");
		}
	}
}

