package com.hmaker.itembank.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hmaker.itembank.entity.User;
import com.hmaker.itembank.entity.UserScore;
import com.hmaker.itembank.repository.UserJpaRepository;
import com.hmaker.itembank.repository.UserScoreJpaRepository;





@Controller
public class UserScoreController {
	
	@Autowired
	UserJpaRepository userJpaRepository;
	@Autowired
	UserScoreJpaRepository userScoreJpaRepository;
	
	@GetMapping("/user/scorelist")
	public String scorelist(Model model) {
	
		List <UserScore> userscore = userScoreJpaRepository.no_desc();
		model.addAttribute("userscore", userscore);
		return "user/scorelist";
	
	}
	
	@GetMapping("/user/quiz_result")
	public String Quiz_result_score(Model model,
							Principal principal,
//							@RequestParam("username") String username,
							@RequestParam("subject") String subject,
							@RequestParam("score") String score) {
		System.out.print(subject+"1");
		UserScore user = (UserScore) userScoreJpaRepository.findByUsernameAndSubject(principal.getName(), subject);
		System.out.print("1");
//		if (principal==(null)) {
//			model.addAttribute("username", "GEST");
//			model.addAttribute("subject", subject);
//			model.addAttribute("score", Integer.parseInt(count)*20);
//		}
//		else {
//			String username = principal.getName();
//			Optional<UserScore> userscore = userScoreJpaRepository.findById(username);
//			if(userscore.isPresent()) {
//				UserScore userScore = userscore.orElse(null);
//				System.out.println(userScore);
//				userScore.setCapital(Integer.parseInt(count)*20);
//				System.out.println(userScore);
//				model.addAttribute("username", username);
//				model.addAttribute("subject", subject);
//				model.addAttribute("score", Integer.parseInt(count)*20);
//			}
//		}
		userScoreJpaRepository.save(user);
		System.out.print("2");
		List <UserScore> userscoreList = userScoreJpaRepository.no_desc();
		System.out.print("3");
		model.addAttribute("userscore", userscoreList);
		System.out.print("4");
		return "user/scorelist";
	}
	
	@GetMapping("/admin/score_list")
	public String admin_scorelist(Model model) {
		
		List <UserScore> userscore = userScoreJpaRepository.no_desc();
		model.addAttribute("userscore", userscore);

		return "admin/score_list";
	}
	
	@GetMapping("/admin/scoreremove/{username}")
	public String student_remove(Model model,
								@ModelAttribute("userscore") UserScore userscore) {
		String username = userscore.getUsername();
		userScoreJpaRepository.deleteById(userscore.getUsername());
//		userScoreJpaRepository.deleteById(username);
		List<UserScore> info = userScoreJpaRepository.no_desc();
		model.addAttribute("userscore", info);
		return "admin/score_list";
	}
	
	@GetMapping("/admin/scoreedit/{username}")
	public String student_edit(@ModelAttribute("userscore") UserScore userscore,
								Model model) {	
		
		model.addAttribute("userscore", userscore);
		
		
		return "admin/scoreedit";
	}
	
	@GetMapping("/user/get_image/{username}")  //이미지 뿌리기
	public void get_image(@PathVariable("username") String no,  // get_image/6 이렇게 쓰기 위해 씀
//							@RequestParam("id") int id,  // get_image?id=6  이렇게 씀
							HttpServletResponse response) throws IOException {
		
		Optional<User> userinfo = userJpaRepository.findById(no);
		
		if(userinfo.isPresent()) {
			User userInfo = userinfo.orElse(null);
		System.out.println(userInfo);
		
		response.setContentType(userInfo.getContent_type());
		OutputStream os = response.getOutputStream();
		byte byteArray[] =  userInfo.getPhoto();
		os.write(byteArray);
		os.flush();
		os.close();
		}		
	}
	
	
}
