package com.karunesh.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List<String> arrayListMock = mock(ArrayList.class);
		assertEquals(0,arrayListMock.size());
		stub(arrayListMock.size()).toReturn(5);
		arrayListMock.add("dummy");
		assertEquals(5,arrayListMock.size());
		
	}
	
	@Test
	public void testSpy() {
		List<String> arrayListMock = spy(ArrayList.class);
		assertEquals(0,arrayListMock.size());
		stub(arrayListMock.size()).toReturn(5);
		arrayListMock.add("dummy");
		assertEquals(5,arrayListMock.size());
		
	}

}
