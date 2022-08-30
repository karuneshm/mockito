package com.karunesh.mockito.data.api;

import java.util.List;

public interface ToDoService {
	
	public List<String> retriveToDos(String user);
	
	public void deleteToDo(String toDo);

}
