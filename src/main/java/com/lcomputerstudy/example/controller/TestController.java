package com.lcomputerstudy.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcomputerstudy.example.domain.Board;
import com.lcomputerstudy.example.domain.User;
import com.lcomputerstudy.example.request.JoinRequest;
import com.lcomputerstudy.example.service.BoardService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  userAccess() {
		List<Board> boardList = boardService.selectBoardList();
		return ResponseEntity.ok(boardList);
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('Admin')")
	public String adminAccess() {
		return "Admin Content.";
	}
	
	@GetMapping("/boardDetail")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  boardDetail(@RequestParam int bId) {
		
		logger.info("///"+bId);
		
		Board board = boardService.selectBoardDetail(bId);
		return ResponseEntity.ok(board);
	}
	
	@DeleteMapping("/boardDelete/{bId}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?>  boardDelete(@PathVariable(value = "bId") int bId) {
		
		logger.info("delete"+bId);
		boardService.deleteBoard(bId);
	
		return ResponseEntity.ok(bId);
	}
	

}
