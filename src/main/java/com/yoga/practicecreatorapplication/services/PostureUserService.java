package com.yoga.practicecreatorapplication.services;

import com.yoga.practicecreatorapplication.repositories.IPostureUserRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class PostureUserService implements IPostureUserService
{
	@Autowired
	private IPostureUserRepository postureUserRepository;

	public boolean validateUser(String userName, String password)
	{
		return postureUserRepository.findByUserName(userName).getPassword().equals(password);
	}
}
