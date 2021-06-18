package tw.org.iii.mountain.labwebmountainhunter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

	// 查找所有資料
	@GetMapping("/todos")
	public ResponseEntity getTodos() {
		Iterable<Todo> todoList = todoService.getTodo();
		return ResponseEntity.status(HttpStatus.OK).body(todoList);
	}

	// 根據id查找單筆資料，回傳
	@GetMapping("/todos/{id}")
	public ResponseEntity findId(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(todoService.getId(id));
	}

	// 根據帳號，查找單筆資料
	@GetMapping("/todos/account/{account}")
	public ResponseEntity findAccount(@PathVariable String account) {
		Todo accountTodo = todoService.getAccount(account);
		return ResponseEntity.status(HttpStatus.OK).body(accountTodo);
	}
	// 根據帳號，查找單筆資料
	@GetMapping("/todos/accounts")
	public ResponseEntity findAccounts(@RequestBody Todo todo) {
		Todo accountTodo = todoService.getAccount(todo.getAccount());
		return ResponseEntity.status(HttpStatus.OK).body(accountTodo);
	}
	
	
	// 輸入json回傳，匯入資料庫，回傳id值
	@PostMapping(value = "/todos", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity createTodo(@RequestBody Todo todo) {
		Integer rlt = todoService.createTodo(todo);
		return ResponseEntity.status(HttpStatus.CREATED).body(rlt);
	}

	// 更新指定id資料
	@PutMapping("/todos/{id}")
	public ResponseEntity upadteTodo(@PathVariable Integer id, @RequestBody Todo todo) {
		Boolean rlt = todoService.updateTodo(id, todo);
		if (rlt) {
			return ResponseEntity.status(HttpStatus.OK).body(todoService.findById(id));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("該筆ID為空");
		}
	}

//	@DeleteMapping("/todos/{id}")
//	public ResponseEntity deleteTodo(@PathVariable Integer id) {
//		Boolean rlt = todoService.deleteTodo(id);
//		if (!rlt) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id 不存在");
//		}
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
//	}

	// 刪除單筆id裡的資料
	@DeleteMapping("/todos/{id}")
	public ResponseEntity DeleteTodo(@PathVariable Integer id) {
		if (todoService.deleteTodo(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Delete ID=" + id + " Success!");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found, Faild!");
	}
}
