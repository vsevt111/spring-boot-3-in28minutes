package com.manin.in28minutes.springboot.todowebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int countTodoList=0;
	static {
		todos.add(new Todo(++countTodoList,"Learn AWS Certified","in28minutes",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++countTodoList,"Learn DevOps","in28minutes",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++countTodoList,"Learn Full Stack Developer","in28minutes",LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = todo->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description , LocalDate targetDate, boolean done) {
		Todo addTodo = new Todo(++countTodoList,description,username,targetDate.plusYears(1),false);
		todos.add(addTodo);
	}
	
	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todo->todo.getId()==id;
		todos.removeIf(predicate);
	}

	public Todo updateById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = todo->todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodo(todo.getId());
		todos.add(todo);
	}

}
