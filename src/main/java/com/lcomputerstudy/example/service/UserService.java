package com.lcomputerstudy.example.service;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.lcomputerstudy.example.domain.User;

public interface UserService extends UserDetailsService{
	//유저읽기
	public User readUser(String username);
	
	//유저생성
	   public void createUser(User user);

	// 유저목록 불러오기
	   public ArrayList<User> readUserList();
		
	// 시큐리티 권한 얻기
	Collection<GrantedAuthority> getAuthorities(String username);

	// 권한 생성
	public void createAuthority(User user);
}
