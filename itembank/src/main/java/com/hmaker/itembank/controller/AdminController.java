package com.hmaker.itembank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hmaker.itembank.entity.Role;
import com.hmaker.itembank.entity.User;
import com.hmaker.itembank.entity.UserScore;
import com.hmaker.itembank.repository.RoleJpaRepository;
import com.hmaker.itembank.repository.UserJpaRepository;
import com.hmaker.itembank.repository.UserScoreJpaRepository;



@Controller
public class AdminController {

	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Autowired
	UserScoreJpaRepository userScoreJpaRepository;
	
	@Autowired
	RoleJpaRepository roleJpaRepository;
	
	@GetMapping("/admin/scoreremove/{username}")
	public String user_remove(Model model,
								@ModelAttribute("userscore") UserScore userscore) {
		String username = userscore.getUsername();
		Long userId = roleJpaRepository.findId(username);
		System.out.println(userId);
		roleJpaRepository.deleteById(userId);
		userScoreJpaRepository.deleteById(username);
		userJpaRepository.deleteById(userscore.getUsername());
		List<UserScore> totalscore = userScoreJpaRepository.score_desc();
		model.addAttribute("totalscore", totalscore);
		return "admin/score_list";
	}
	
	@GetMapping("/admin/scoreedit/{username}")
	public String user_edit(@ModelAttribute("userscore") UserScore userscore,
								Model model) {	
		
		model.addAttribute("userscore", userscore);
		
		
		return "admin/scoreedit";
	}
	@PostMapping("/admin/scoreeditresult")
	public String user_edit_result(Model model,
			@Valid @ModelAttribute("userscore") UserScore userscore,
			BindingResult bindingResult
			) {
		userScoreJpaRepository.save(userscore);
		model.addAttribute("usertscore", userscore);
		
		List<UserScore> totalscore = userScoreJpaRepository.score_desc();
		model.addAttribute("totalscore", totalscore);
		return "admin/score_list";
	}
	
	@GetMapping("/admin/score_list")
	public String admin_scorelist(Model model) {
		
		List <UserScore> totalscore = userScoreJpaRepository.score_desc();
		model.addAttribute("totalscore", totalscore);

		return "admin/score_list";
	}
}
