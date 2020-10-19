package com.lcomputerstudy.example.response;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.lcomputerstudy.example.domain.UserInfo;

public class JwtResponse1 {
	private List<UserInfo> userList;
	private List<GrantedAuthority> readAuthorities_all;
	public JwtResponse1(List<UserInfo> userList, List<GrantedAuthority> userList_auth) {
		this.userList = userList;
		this.readAuthorities_all = userList_auth;
	}

	public List<UserInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

	public List<GrantedAuthority> getReadAuthorities_all() {
		return readAuthorities_all;
	}
	public void setReadAuthorities_all(List<GrantedAuthority> readAuthorities_all) {
		this.readAuthorities_all = readAuthorities_all;
	}
	@Override
	public String toString() {
		return "JwtResponse1 [userList=" + userList + ", readAuthorities_all=" + readAuthorities_all + "]";
	}
	
	
}
