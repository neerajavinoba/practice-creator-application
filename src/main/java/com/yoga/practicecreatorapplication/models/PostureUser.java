package com.yoga.practicecreatorapplication.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="postures_user")
public class PostureUser
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String userName;

	@NotNull
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "postures_role",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<PostureRole> roles = new HashSet<>();

	public PostureUser()
	{
	}

	public PostureUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Set<PostureRole> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<PostureRole> roles)
	{
		this.roles = roles;
	}

}
