package com.yoga.practicecreatorapplication.repositories;

import com.yoga.practicecreatorapplication.models.PostureUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostureUserRepository extends JpaRepository<PostureUser,Integer>
{
	PostureUser findByUserName(String userName);

	boolean existsByUserName(String userName);
}
