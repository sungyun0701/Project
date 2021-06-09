package com.hmaker.itembank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table
public class User extends BaseEntity {

	
	@Id
	@NotNull
	private String username;
	@NotBlank
	private String password;
	private String email;
	private byte[] photo;
	private String content_type;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(@NotBlank String username, @NotBlank String password, String email, byte[] photo, String content_type) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.photo = photo;
		this.content_type = content_type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
}
