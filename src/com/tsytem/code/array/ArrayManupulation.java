package com.tsytem.code.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ArrayManupulation {

	static void pushxToEnd(int arr[], int n, int x) {
		int count = 0;

		for (int i = 0; i < n; i++)
			if (arr[i] != x)
				arr[count++] = arr[i];

		while (count < n)
			arr[count++] = x;

	}

	static HashMap<Integer, Integer> findIndexandValueOfMultipleOfZ(int arr[], int n, int z) {
		HashMap<Integer, Integer> mutipleofZIndexandValueMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++)
			if (arr[i] % z == 0)
				mutipleofZIndexandValueMap.put(i, arr[i]);

		return mutipleofZIndexandValueMap;

	}

	public static void main(String[] args) {
		int[] y = { 10, 77, 92, 1, 30, 81, 1, 4, 1, 20, 17, 1, 16, 33 };
		int n = y.length;
		int x = 1;
		int z = 10;
		pushxToEnd(y, n, x);
		for (int i = 0; i < n; i++)
			System.out.print(y[i] + " ");
		
		System.out.println();

		HashMap<Integer, Integer> mutipleofZIndexandValueMap = findIndexandValueOfMultipleOfZ(y, n, z);
		if(!mutipleofZIndexandValueMap.isEmpty()) {
			for (Entry<Integer, Integer> entry : mutipleofZIndexandValueMap.entrySet())
	            System.out.println("index " + entry.getKey() +
	                             ", and value = " + entry.getValue());
		} else {
			System.out.println("There is no mutiple of "+z+" present in the array");
		}
		
	}

}
