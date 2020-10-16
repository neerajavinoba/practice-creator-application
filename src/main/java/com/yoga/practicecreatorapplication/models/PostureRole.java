package com.yoga.practicecreatorapplication.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class PostureRole
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private RoleEnum roleName;

	public PostureRole() {

	}

	public PostureRole(RoleEnum roleName) {
		this.roleName = roleName;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public RoleEnum getRoleName()
	{
		return roleName;
	}

	public void setRoleName(RoleEnum roleName)
	{
		this.roleName = roleName;
	}
}
