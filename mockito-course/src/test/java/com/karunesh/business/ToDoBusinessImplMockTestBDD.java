package com.karunesh.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.karunesh.mockito.business.ToDoBusinessImpl;
import com.karunesh.mockito.data.api.ToDoService;

public class ToDoBusinessImplMockTestBDD {

	@Test
	public void testRetriveToDoRelatedSpring_usingBDD() {
		
		//Given 
		ToDoService serviceMock= mock(ToDoService.class);
		
		List<String> todos = Arrays.asList("Learn spring MVC", "Learn spring", 
				"Learn to dance");
		given(serviceMock.retriveToDos("dummy")).willReturn(todos);
		
		ToDoBusinessImpl businessImpl = new ToDoBusinessImpl(serviceMock);
		
		//when 
		List<String> filteredToDos = businessImpl.
				retriveToDosRelatedToSpring("dummy");
		
		//then
	    assertEquals(2, filteredToDos.size());
		
		
	}
	
	@Test
	public void testDeleteTodoNotDoRelatedSpring_usingBDD() {
		
		//Given 
		ToDoService serviceMock= mock(ToDoService.class);
		
		List<String> todos = Arrays.asList("Learn spring MVC", "Learn spring", 
				"Learn to dance");
		given(serviceMock.retriveToDos("dummy")).willReturn(todos);
		
		ToDoBusinessImpl businessImpl = new ToDoBusinessImpl(serviceMock);
		
		//when 
		businessImpl.deleteToDosNotRelatedToSpring("dummy");
		
		//then
		//verify(serviceMock, times(1)).deleteToDo("Learn to dance");
		then(serviceMock).should().deleteToDo("Learn to dance");
		
		//verify(serviceMock, never()).deleteToDo("Learn spring MVC");
		then(serviceMock).should(never()).deleteToDo("Learn spring MVC");
		
		//verify(serviceMock, never()).deleteToDo("Learn spring");
		then(serviceMock).should(never()).deleteToDo("Learn spring");
		
		
	}
	
	
	@Test
	public void testDeleteTodoNotDoRelatedSpring_usingBDD_ArgumentCapture() {
		
		//Declare Argument captor
		ArgumentCaptor<String> stringArgiment = ArgumentCaptor.forClass(String.class);
		
		//Given 
		ToDoService serviceMock= mock(ToDoService.class);
		
		List<String> todos = Arrays.asList("Learn Rock and Roll", "Learn spring", 
				"Learn to dance");
		given(serviceMock.retriveToDos("dummy")).willReturn(todos);
		
		ToDoBusinessImpl businessImpl = new ToDoBusinessImpl(serviceMock);
		
		//when 
		businessImpl.deleteToDosNotRelatedToSpring("dummy");
		
		//then
		//verify(serviceMock, times(1)).deleteToDo("Learn to dance");
		then(serviceMock).should().deleteToDo(stringArgiment.capture());
		
		assertThat(stringArgiment.getValue(), is("Learn to dance"));
		
//		then(serviceMock).should(times(2)).deleteToDo(stringArgiment.capture());
//		
//		assertThat(stringArgiment.getAllValues().size(), is(2));
		
		
	}

}
