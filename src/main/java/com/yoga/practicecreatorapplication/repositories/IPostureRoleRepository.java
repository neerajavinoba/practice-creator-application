package com.yoga.practicecreatorapplication.repositories;

import com.yoga.practicecreatorapplication.models.PostureRole;
import com.yoga.practicecreatorapplication.models.RoleEnum;

import java.util.Optional;

public interface IPostureRoleRepository
{
	Optional<PostureRole> findbyUserName(RoleEnum roleName);
}
