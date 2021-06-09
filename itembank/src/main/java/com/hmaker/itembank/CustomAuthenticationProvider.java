package com.hmaker.itembank;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hmaker.itembank.entity.Role;
import com.hmaker.itembank.entity.User;
import com.hmaker.itembank.repository.RoleJpaRepository;
import com.hmaker.itembank.repository.UserJpaRepository;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserJpaRepository userJpaRepository;
	@Autowired
	RoleJpaRepository roleJpaRepository;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		//username 확인
		Optional<User> userOptional = userJpaRepository.findById(username);
		User user = new User();
		if(userOptional.isPresent()) {
			user = userOptional.get();
		}
		else {
			throw new UsernameNotFoundException("Invalid username");
		}
		
		
		// 비밀번호 암호화
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		Optional<List<Role>> roleListOptional = null;
		if(bCryptPasswordEncoder.matches(password, user.getPassword())) {
			roleListOptional = roleJpaRepository.findByUsername(username);	
		}
		else {
			throw new BadCredentialsException("Invalid username");
		}
		
		//인증 토큰
		Set<GrantedAuthority> grantedAuthorityList = new HashSet<>();
		if(roleListOptional.isPresent()) {
			for (Role role : roleListOptional.get()) {
				grantedAuthorityList.add(new SimpleGrantedAuthority(role.getRolename()));
			}
		}
		return new UsernamePasswordAuthenticationToken (username, password, grantedAuthorityList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
