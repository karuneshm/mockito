package com.karunesh.mockito.data.api;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements ToDoService {

	@Override
	public List<String> retriveToDos(String user) {
		return Arrays.asList("Learn spring MVC", "Learn spring", 
				"Learn to dance");
	}

	@Override
	public void deleteToDo(String toDo) {
		// TODO Auto-generated method stub
		
	}

}
