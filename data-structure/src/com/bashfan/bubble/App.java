package com.bashfan.bubble;

public class App {

	public static void main(String[] args) {
		int[] intArray = { 1, -15, 28, 11, 6, -55, 2 };
		for (int lastUnsorted = intArray.length - 1; lastUnsorted < intArray.length; lastUnsorted--) {
			for (int i = 0; i < lastUnsorted; i++) {
				if (intArray[i]>intArray[i+1]) {
					swap(i, i+1, intArray);
				}
			}
			
		}
		printArray(intArray);
	}

	public static void printArray(int[] r) {
		for (int entry : r) {
			System.out.println(entry);
		}
	}

	public static void swap(int a, int b, int[] intArray) {
		if (a == b) {
			return;
		}
		int temp = intArray[b];
		intArray[b] = intArray[a];
		intArray[a] = temp;
	}

}
