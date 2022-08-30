package com.karunesh.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import com.karunesh.mockito.business.ToDoBusinessImpl;
import com.karunesh.mockito.data.api.ToDoService;

//@RunWith(MockitoJUnitRunner.class)
public class ToDoBusinessImplMockInjectTest {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	ToDoService serviceMock;
	
	@InjectMocks
	ToDoBusinessImpl businessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgument ;

	@Test
	public void testRetriveToDoRelatedSpring_usingMock() {
		List<String> todos = Arrays.asList("Learn spring MVC", "Learn spring", 
				"Learn to dance");
		
		when(serviceMock.retriveToDos("dummy")).thenReturn(todos);
		
		
		List<String> filteredToDos = businessImpl.
				retriveToDosRelatedToSpring("dummy");
		
		assertEquals(2, filteredToDos.size());
		
		
	}
	
	
	@Test
	public void testRetriveToDoRelatedSpring_usingBDD() {
		
		
		List<String> todos = Arrays.asList("Learn spring MVC", "Learn spring", 
				"Learn to dance");
		given(serviceMock.retriveToDos("dummy")).willReturn(todos);
		
		
		//when 
		List<String> filteredToDos = businessImpl.
				retriveToDosRelatedToSpring("dummy");
		
		//then
	    assertEquals(2, filteredToDos.size());
		
		
	}
	
	@Test
	public void testDeleteTodoNotDoRelatedSpring_usingBDD() {
		
		
		
		List<String> todos = Arrays.asList("Learn spring MVC", "Learn spring", 
				"Learn to dance");
		given(serviceMock.retriveToDos("dummy")).willReturn(todos);
		
		
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
		
		
		
		List<String> todos = Arrays.asList("Learn spring mvc", "Learn spring", 
				"Learn to dance");
		given(serviceMock.retriveToDos("dummy")).willReturn(todos);
		
		
		//when 
		businessImpl.deleteToDosNotRelatedToSpring("dummy");
		
		//then
		//verify(serviceMock, times(1)).deleteToDo("Learn to dance");
		then(serviceMock).should().deleteToDo(stringArgument.capture());
		
		assertThat(stringArgument.getValue(), is("Learn to dance"));
		
//		then(serviceMock).should(times(2)).deleteToDo(stringArgiment.capture());
//		
//		assertThat(stringArgiment.getAllValues().size(), is(2));
		
		
	}

}
