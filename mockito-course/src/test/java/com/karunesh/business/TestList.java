package com.karunesh.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class TestList {

	@Test
	public void testListSize() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	
	@Test
	public void testListSize_MultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	
	@Test
	public void testListGet() {
		List listMock = mock(List.class);
		//Agrument matchers
		when(listMock.get(0)).thenReturn("Karunesh");
		assertEquals("Karunesh", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}
	
	@Test
	public void testListGet2() {
		List listMock = mock(List.class);
		//Agrument matchers
		when(listMock.get(anyInt())).thenReturn("Karunesh");
		assertEquals("Karunesh", listMock.get(0));
		assertEquals("Karunesh", listMock.get(1));
	}
	
	@Test(expected = RuntimeException.class)
	public void testListGet3() {
		List listMock = mock(List.class);
		//Agrument matchers
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));
		listMock.get(0);
	}
	
	
	@Test
	public void testListGet_usingBDD() {
		//Given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("Karunesh");
		//When
		String actual = listMock.get(0);
		
		//Then
		assertThat(actual, is("Karunesh"));
	
	}

}
