package com.yoga.practicecreatorapplication.controllers;

import com.yoga.practicecreatorapplication.models.PostureUser;
import com.yoga.practicecreatorapplication.services.PostureUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PostureUserController
{
	private PostureUserService postureUserService;

	@RequestMapping("/login")
	private boolean validatePostureUser(PostureUser postureUser) {
		return postureUserService.validateUser(postureUser.getUserName(),postureUser.getPassword());
	}

}
