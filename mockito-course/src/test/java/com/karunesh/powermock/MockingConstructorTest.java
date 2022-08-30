package com.karunesh.powermock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.karunesh.mockito.business.ToDoBusinessImpl;
import com.karunesh.mockito.data.api.ToDoService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructorTest {
	
//	@Rule
//	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	//Specific Runner Class
	//Initialize the class

	
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Captor
	ArgumentCaptor<String> stringArgument ;
	
	@Mock
	ArrayList mockList;

	@Test
	public void testRetriveToDoRelatedSpring_usingMock() throws Exception {
		when(mockList.size()).thenReturn(5);
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		 int size = systemUnderTest.methodUsingAnArrayListConstructor();
		 assertEquals(5, size);
		
	}
}
