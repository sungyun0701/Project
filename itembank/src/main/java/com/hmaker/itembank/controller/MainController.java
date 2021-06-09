package com.hmaker.itembank.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hmaker.itembank.entity.Role;
import com.hmaker.itembank.entity.User;
import com.hmaker.itembank.entity.UserScore;
import com.hmaker.itembank.repository.RoleJpaRepository;
import com.hmaker.itembank.repository.UserJpaRepository;
import com.hmaker.itembank.repository.UserScoreJpaRepository;




@Controller
public class MainController {

	@Autowired
	RoleJpaRepository roleJpaRepository;
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Autowired
	UserScoreJpaRepository userscoreJpaRepository;
	

	@GetMapping("/")
	public String index() {
		return "user/index";
	}
	
	@GetMapping("/user/register")
	public String register(@ModelAttribute("info") User user) {
		return "user/register";
	}
	
	@PostMapping("/user/register")
	public String register_process(@Valid @ModelAttribute("info") User info,
									BindingResult result,
//									@RequestParam("username") String username,
//									@RequestParam("password") String password,
//									@RequestParam("email") String email,
									@RequestParam("file") MultipartFile photo,
									@RequestParam("username") String username,
									@RequestParam("confirm") String button,
									Model model) throws IOException {
		if(result.hasErrors()) {return "user/register";}
//		User user = new User();
//		user.setUsername(user.);
		String checking = "";
		if(button.equals("확인")) {
			if(userJpaRepository.existsById(username)) {
				checking = "존재하는 아이디이므로 다른 아이디로 등록 바랍니다.";
				model.addAttribute("checking", checking);
				return "user/register";
			}
		}
		if(!photo.isEmpty()) {
			InputStream is = photo.getInputStream();
			byte[] image = is.readAllBytes();
			info.setPhoto(image);
		}
		
		//암호화
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(info.getPassword());
		info.setPassword(encodedPassword);
		
		
//		info.setEmail(info.getEmail());
		info = userJpaRepository.save(info);
		Role role = new Role();
		role.setUsername(info.getUsername());
		role.setRolename("ROLE_USER");
		roleJpaRepository.save(role);
		
		UserScore userscore = new UserScore();
		userscore.setUsername(info.getUsername());
		userscoreJpaRepository.save(userscore);
		
		if(info != null) {
			String message = "정상 등록되었습니다.";
			model.addAttribute("register_result", message);
			return "user/register_result";
		}
		return "user/register";
}
	

//	@RequestMapping(value = "/user/register")
//	public String rer() {
//		return "user/register";
//	}
	

	@GetMapping("/user/login")
	public String login() {
		
		return "user/login";
	}
	@PostMapping("/user/login")
	public String loginp() {
		
		return "user/index";
	}
	
	@GetMapping("/user/logout")
	public String logout() {
		return "user/logout";
	}
	
	@GetMapping("/user/logout_result")
	public String logoutresult() {
		return "user/logout_result";
	}

	

	
}

