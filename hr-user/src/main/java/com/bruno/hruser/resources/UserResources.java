package com.bruno.hruser.resources;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bruno.hruser.entities.User;
import com.bruno.hruser.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResources {

	@Autowired
	private UserRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<User> findbyId(@PathVariable Long id) {

		Optional<User> user = repository.findById(id);

		return ResponseEntity.ok(user.get());
	}

	@GetMapping("/search")
	public ResponseEntity<User> findbyEmail(@RequestParam String email) {

		User user = repository.findByEmail(email);

		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(user);
	}

}
