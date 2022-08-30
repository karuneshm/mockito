package com.karunesh.mockito.business;



import java.util.List;
import java.util.stream.Collectors;

import com.karunesh.mockito.data.api.ToDoService;

public class ToDoBusinessImpl {
	
	private ToDoService service;

	public ToDoBusinessImpl(ToDoService service) {
		this.service = service;
	}
	
	public List<String> retriveToDosRelatedToSpring(String user) {
		
		List<String> todos = service.retriveToDos(user);
		List<String> filteredList = todos.
				stream().filter(todo -> todo.contains("spring")).collect(Collectors.toList());
		
		
		return filteredList;
		
	}
	
	public void deleteToDosNotRelatedToSpring(String user) {
		List<String> todos = service.retriveToDos(user);
		for(String todo : todos) {
			if(!todo.contains("spring")) {
				service.deleteToDo(todo);
			}
		}
	}
	
	

}
