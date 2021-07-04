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
	
		List <UserScore> totalscore = userScoreJpaRepository.score_desc();
		model.addAttribute("totalscore", totalscore);
		return "user/scorelist";
	
	}
	
	@GetMapping("/user/quiz_result")
	public String Quiz_result_score(Model model,
							Principal principal,
//							@RequestParam("username") String username,
							@RequestParam("subject") String subject,
							@RequestParam("score") String score) {
		System.out.println(subject);
		System.out.print(score);
		System.out.println(subject);
		String username = "";
		if (principal==(null)) {
			System.out.println(subject);	
			username = "gest";
		}
		else {
			username = principal.getName();
		}
		
//		repository에서 db에 넘길때 ''가 붙어서 넘어가서 subject를 넘기면 칼럼으로 인식이 안되어서 이렇게 repository에서 직접 쓰고 스위치문으로 대체함
		switch(subject) {
			case "capital" :
				userScoreJpaRepository.findUsernameCapital(score,username);
				break;
			case "trivia":
				userScoreJpaRepository.findUsernameTrivia(score,username);
				break;
			case "Proverb":
				userScoreJpaRepository.findUsernameProverb(score,username);
				break;
			case "Nonsense":
				userScoreJpaRepository.findUsernameNonsense(score,username);
				break;
		}
		List <UserScore> totalscore = userScoreJpaRepository.score_desc();
		model.addAttribute("totalscore", totalscore);

		return "user/scorelist";
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
