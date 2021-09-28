package com.bruno.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bruno.hroauth.entities.User;
import com.bruno.hroauth.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResources {

	@Autowired
	private UserService service;

	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {
			return ResponseEntity.ok(service.findBVyEmail(email));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

}
