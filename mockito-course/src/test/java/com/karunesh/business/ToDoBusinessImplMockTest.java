package com.karunesh.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.karunesh.mockito.business.ToDoBusinessImpl;
import com.karunesh.mockito.data.api.ToDoService;

public class ToDoBusinessImplMockTest {

	@Test
	public void testRetriveToDoRelatedSpring_usingMock() {
		ToDoService serviceMock= mock(ToDoService.class);
		
		List<String> todos = Arrays.asList("Learn spring MVC", "Learn spring", 
				"Learn to dance");
		
		when(serviceMock.retriveToDos("dummy")).thenReturn(todos);
		
		ToDoBusinessImpl businessImpl = new ToDoBusinessImpl(serviceMock);
		
		List<String> filteredToDos = businessImpl.
				retriveToDosRelatedToSpring("dummy");
		
		assertEquals(2, filteredToDos.size());
		
		
	}

}
