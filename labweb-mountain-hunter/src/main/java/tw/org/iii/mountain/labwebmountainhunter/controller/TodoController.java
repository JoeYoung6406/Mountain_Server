package tw.org.iii.mountain.labwebmountainhunter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.org.iii.mountain.labwebmountainhunter.entity.Todo;
import tw.org.iii.mountain.labwebmountainhunter.service.TodoService;

@RestController
@RequestMapping("/api")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("/todos")
	public ResponseEntity getTodos() {
		Iterable<Todo> todoList = todoService.getTodo();
		return ResponseEntity.status(HttpStatus.OK).body(todoList);
	}
	
	@GetMapping("/todos/{id}")
    public Optional<Todo> getTodo(@PathVariable Integer id) {
        Optional<Todo> todo = todoService.findById(id);
        return todo;
    }
	
	 @PostMapping("/todos")
	    public ResponseEntity createTodo(@RequestBody Todo todo) {
	        Integer rlt = todoService.createTodo(todo);
	        return ResponseEntity.status(HttpStatus.CREATED).body(rlt);
	    }
	 
	 @PutMapping("/todos/{id}")
	    public ResponseEntity upadteTodo(@PathVariable Integer id, @RequestBody Todo todo) {
	        Boolean rlt = todoService.updateTodo(id ,todo);
	        if (!rlt) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status 欄位不能為空");
	        }
	        return ResponseEntity.status(HttpStatus.OK).body("");
	    }
	 
	 @DeleteMapping("/todos/{id}")
	    public ResponseEntity deleteTodo(@PathVariable Integer id) {
	        Boolean rlt = todoService.deleteTodo(id);
	        if (!rlt) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id 不存在");
	        }
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
	    }
}
