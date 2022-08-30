package com.karunesh.business;
import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;

import com.karunesh.mockito.business.ToDoBusinessImpl;
import com.karunesh.mockito.data.api.ToDoService;
import com.karunesh.mockito.data.api.ToDoServiceStub;

public class ToDoBusinessImplStubTest {

	@Test
	public void testRetriveToDoRelatedSpring_usingStub() {
		ToDoService serviceStub = new ToDoServiceStub();
		ToDoBusinessImpl businessImpl = new ToDoBusinessImpl(serviceStub);
		
		List<String> filteredToDos = businessImpl.
				retriveToDosRelatedToSpring("dummy");
		
		assertEquals(2, filteredToDos.size());
		
		
	}
	
	@Test
	public void testRetriveToDoRelatedSpring_usingStub2() {
		ToDoService serviceStub = new ToDoServiceStub();
		ToDoBusinessImpl businessImpl = new ToDoBusinessImpl(serviceStub);
		
		List<String> filteredToDos = businessImpl.
				retriveToDosRelatedToSpring("dummy");
		
		assertEquals(0, filteredToDos.size());
		
		
	}

}
