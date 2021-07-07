package tw.org.iii.mountain.labwebmountainhunter.controller;

import java.util.List;

import javax.persistence.Id;

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

import tw.org.iii.mountain.labwebmountainhunter.dao.UserRepository;
import tw.org.iii.mountain.labwebmountainhunter.entity.User;
import tw.org.iii.mountain.labwebmountainhunter.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(user));
	}
	
	@GetMapping("/users")
	public ResponseEntity getUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getGroup());
	}

	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable Integer id) {
		return userService.findById(id);
	}
	 
	@GetMapping("/users/account/{account}")
	public ResponseEntity getInfoByAccount(@PathVariable String account) {
		if (userService.getUserIdByLogin(account) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(userService.getUserIdByLogin(account));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO this account, try again");
	}

	@GetMapping("/users/account")
	public ResponseEntity getInfoBodyAccount(@RequestBody User user) {
		User rlt = userService.getUserIdByLogin(user.getAccount());
		if (rlt != null) {
			return ResponseEntity.status(HttpStatus.OK).body(rlt);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Try again");
	}
	@PutMapping("/users/{id}")
	public ResponseEntity UpdateUser(@PathVariable Integer id, @RequestBody User user) {
		 if (userService.updateUser(id, user)) {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
		} return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Try Again!");
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable Integer id) {
		if (userService.deleteUser(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Success!");
		}return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Try Again!");
	}
	@GetMapping("/rank")
	public ResponseEntity showRank() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.showRank());
	}
	
//	@PutMapping("/users/change/{account}")
//	public ResponseEntity changePasswordByword(@PathVariable String account , @RequestBody User user) {
//		if (userService.changInfo(account,  user)) {
//			return ResponseEntity.status(HttpStatus.OK).body(userService.getUserIdByLogin(account));
//		} return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Try Again!");
//	}
}
