package com.lcomputerstudy.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lcomputerstudy.example.config.JwtUtils;
import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.User;
import com.lcomputerstudy.example.service.BoardService;
import com.lcomputerstudy.example.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserService userService;
	
		@GetMapping("/adminPage")
//		@PreAuthorize("hasRole('ROLE_ADMIN')")
		public HashMap<String, Object>  AccessAdmin(HttpServletRequest request) {
//			String token = request.getHeader("Authorization");
//			String token2 = new String();
//			if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
//				token2 =  token.substring(7, token.length());
//			}
			List<Board> boardList = boardService.selectBoardList();
			ArrayList<User> userList = userService.readUserList();
			User userInfo = userList.get(0);
			
			HashMap<String, Object> map = new HashMap<>(); 
//			ResponseEntity<?> rEn =  new ResponseEntity<>(userList, HttpStatus.OK);
			map.put("userInfo", boardList);
			
//			logger.debug(rEn.toString());
			return map;
					
		}
}
