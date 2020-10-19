package com.lcomputerstudy.example.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserInfo {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String name;
	private String phone;
	private Collection<? extends GrantedAuthority> authorities;
	private String auth;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}



	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
		
	}



	public String getAuth() {
		return auth;
	}



	public void setAuth(String auth) {
////		this.authorities = ;
//		authorities.add(new SimpleGrantedAuthority(auth));
		//this.auth = auth;
		this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(auth);	
	}
	
	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", authorities=" + authorities + ", auth=" + auth + "]";
	}


	
	
}
