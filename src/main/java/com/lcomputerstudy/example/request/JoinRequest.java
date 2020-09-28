package com.lcomputerstudy.example.request;

public class JoinRequest {
	private String username;
	private String password;
	private String name;
	private String phone;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "JoinRequest [username=" + username + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ "]";
	}
	
	
		
}
