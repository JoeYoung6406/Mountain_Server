package tw.org.iii.mountain.labwebmountainhunter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.org.iii.mountain.labwebmountainhunter.entity.wp_usermeta;
import tw.org.iii.mountain.labwebmountainhunter.service.userService;

@RestController
@RequestMapping("/api")
public class userController {

	@Autowired
	userService userService;
	
	@GetMapping("/users")
	public ResponseEntity getUsers() {
		Iterable<wp_usermeta> userList = userService.getUser();
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}
	
	@GetMapping("/users/{id}")
	public Optional<wp_usermeta> getUser(@PathVariable Integer id) {
		Optional<wp_usermeta> user = userService.findById(id);
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody wp_usermeta user) {
		Integer rlt = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(rlt);
		
	}
}
