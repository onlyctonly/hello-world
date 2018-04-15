package com.bashfan.array;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		double[] arr = {0.2, 8.9, 0.3, 0.1, 0.5, 10.0};
		Arrays.sort(arr);
		display(arr);
		int location = Arrays.binarySearch(arr, 0.5);
		if (location>=0) {
			System.out.printf("found 0.5, index %d \n", location);
		} else {
			System.out.println("not found 0.5");
		}
	}
	
	private static void display(double[] arr) {
		
		for (double d : arr) {
			System.out.println(d);
		}
	}
	
}
