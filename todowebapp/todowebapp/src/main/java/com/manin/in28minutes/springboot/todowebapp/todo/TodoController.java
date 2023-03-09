package com.manin.in28minutes.springboot.todowebapp.todo;

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoginName(model);
		model.put("todos", todoService.findByUsername(username));
		return "listTodos";
	}

	private String getLoginName(ModelMap model) {
		Authentication authen= SecurityContextHolder.getContext().getAuthentication();
		model.put("name", authen.getName());
		return authen.getName();
	}
	
	@RequestMapping(value="add-todo" ,method=RequestMethod.GET)
	public String addTodo(ModelMap model) {
		//ไม่ได้ return มาเป็น jsp แต่ให้ redirect ไปที่ api แทนไม่งั้นข้อฒูลที่ initial จะหายไป
		String username = getLoginName(model);
		Todo todo = new Todo(0,username,"default desc",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo" ,method=RequestMethod.POST)
	public String returnFromTodo( ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		//ไม่ได้ return มาเป็น jsp แต่ให้ redirect ไปที่ api แทนไม่งั้นข้อฒูลที่ initial จะหายไป
		String username = getLoginName(model);
		todoService.addTodo(username, todo.getDescription(), LocalDate.now(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo" , method=RequestMethod.GET)
	public String updateTodo(@RequestParam int id,ModelMap model) {
		Todo todo = todoService.updateById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo" ,method=RequestMethod.POST)
	public String updateTodo( ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		//ไม่ได้ return มาเป็น jsp แต่ให้ redirect ไปที่ api แทนไม่งั้นข้อฒูลที่ initial จะหายไป
		String username = getLoginName(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}

}
