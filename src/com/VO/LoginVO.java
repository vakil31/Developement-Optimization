package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LoginVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="loginId")
	private int loginId;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	@Column(name="enable")
	private int enable;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
