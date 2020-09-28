package com.lcomputerstudy.example.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import com.lcomputerstudy.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthTokenFilter extends  OncePerRequestFilter{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserService userService;
	
	
	//filter -> servelet 실행 전 실행 dofilter 실행시 최종적으로  dofilterInternal 을 실행 doFilter는 전후처리
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			//parseJwt 메소드 사용
			String jwt = parseJwt(request);
			
			//jwt 토큰이 null 이 아니고 유효한 토큰일때
			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
				//jwt를 통한 회원 아이디 추출
				String username = jwtUtils.getUserNameFromJwtToken(jwt);
				
				//security를 통한 인증 로직
				UserDetails userDetails = userService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {}", e);
		}

		filterChain.doFilter(request, response);
		
	}


	private String parseJwt(HttpServletRequest request) {
		//header 중에서 Authorization key의 value 값을 가져옴
		String headerAuth = request.getHeader("Authorization");
		
		//jwt 가져옴
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
	
	
}
