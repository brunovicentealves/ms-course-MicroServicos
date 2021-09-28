package com.bruno.hroauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.hroauth.entities.User;
import com.bruno.hroauth.feignclients.UserFeignClient;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;

	public User findBVyEmail(String email) {

		User user = userFeignClient.findbyEmail(email).getBody();

		if (user == null) {
			log.error("Email not found" + email);
			throw new IllegalArgumentException("Email not found");
		}
		log.info("Email found :{}", email);
		return user;

	}

}
