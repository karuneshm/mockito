package com.karunesh.junit.helper;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class StringHelperTest {
	StringHelper helper;
	
	
	@Before
	public void before() {
		helper = new StringHelper();
	}
	

	@Test
	public void testTruncateAInFirst2Positions_condition1() {
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
		
	}
	
	@Test
	public void testTruncateAInFirst2Positions_condition2() {
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
		
	}

	@Test
	public void testTruncateAInFirst2Positions_condition3() {
		assertEquals("CDEF",helper.truncateAInFirst2Positions("CDEF"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_condition4() {
		assertEquals("CDAA",helper.truncateAInFirst2Positions("CDAA"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_condition1() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_condition2() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@After
	public void teadDown() {
		System.out.println("After test");
	}
}

