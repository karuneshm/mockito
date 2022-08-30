package com.karunesh.junit.helper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Test;


public class ArraysCompareTest {

	@Test
	public void testArraySort_RandomArray() {
		int [] numbers = {12,3,4,1};
		int [] expected = {1,3,4,12};
		Arrays.sort(numbers);
		assertArrayEquals(expected,numbers);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testArraySort_NullArray() {
		int [] numbers = {};
		Arrays.sort(numbers);	
	}
	
	@Test(timeout = 10)
	public void testSort_performance() {
		int [] array = {12,4,5};
		for(int i=1; i<=1000000 ;i++) {
			array[0] =i;
			Arrays.sort(array);
		}
	}

}
