package com.fortech.Entities;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
@ManagedBean
public class User {
	
	@Id
	@Column(name="UserName", nullable=false)
	private String userName;
	
	@Column(name="Password")
	private String password;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String user) {
		this.userName = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
