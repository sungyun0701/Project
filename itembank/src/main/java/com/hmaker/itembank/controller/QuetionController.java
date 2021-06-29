package com.hmaker.itembank.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hmaker.itembank.entity.Question;
import com.hmaker.itembank.entity.User;
import com.hmaker.itembank.entity.UserScore;
import com.hmaker.itembank.etc.Quiz;
import com.hmaker.itembank.repository.QuestionJpaRepository;
import com.hmaker.itembank.repository.UserScoreJpaRepository;

@Controller
public class QuetionController {

	@Autowired
	QuestionJpaRepository questionJpaRepository;
	
	@Autowired
	UserScoreJpaRepository userScoreJpaRepository;
	
//	@GetMapping("/user/quiz")
//	public String test(@ModelAttribute("kind") String kind) {
//		return "user/quiz";
//	}
	
//	@PostMapping("/user/quiz/{kind}")
//	public String quiz(@PathVariable("kind") String kind,
//						@RequestParam("kind") String kind,
//						Model model) {
//		
//		if(kind.equals("capital")) {
//			List<Question> questionList = questionJpaRepository.findQuestionByKind(kind);
//			List<Quiz> quiz = new ArrayList();
//			System.out.println(questionList);
//			
//			model.addAttribute("questionList", questionList);
//			return "user/quiz/capital";
//		}
//		else if(kind.equals("trivia")) {
//			return "user/quiz_trivia";
//		}
//		else if(kind.equals("trivia")) {
//			return "user/quiz_trivia";
//		}
//		else {
//			return "user/nonsense";
//		}
//		
//		
//	}
	@GetMapping("/user/game")
	public String gameList() {
		return "user/gameList";
	}
	
	@GetMapping("/user/quiz/capital")
	public String quiz_capital(Model model) {
	
		List<Question> questionList = questionJpaRepository.findQuestionByKind("capital");
		List<Quiz> quiz = new ArrayList();
		System.out.println(questionList);
		
		model.addAttribute("questionList", questionList);
		return "user/quiz/capital";
	}
	
	
	@GetMapping("/user/quiz/trivia")
	public String quiz_trivia(Model model) {
	
		List<Question> questionList = questionJpaRepository.findQuestionByKind("trivia");
		List<Quiz> quiz = new ArrayList();
		System.out.println(questionList);
		
		model.addAttribute("questionList", questionList);
		return "user/quiz/trivia";
	}
	
	@GetMapping("/user/quiz/proverb")
	public String quiz_proverb(Model model) {
	
		List<Question> questionList = questionJpaRepository.findQuestionByKind("proverb");
		List<Quiz> quiz = new ArrayList();
		System.out.println(questionList);
		
		model.addAttribute("questionList", questionList);
		return "user/quiz/proverb";
	}
	
	@GetMapping("/user/quiz/nonsense")
	public String quiz_nonsense(Model model) {
	
		List<Question> questionList = questionJpaRepository.findQuestionByKind("nonsense");
		List<Quiz> quiz = new ArrayList();
		System.out.println(questionList);
		
		model.addAttribute("questionList", questionList);
		return "user/quiz/nonsense";
	}
	
	@GetMapping("/user/quiz/result")
	public String quiz_result(@RequestParam("count") String count,
							@RequestParam("subject") String subject,
							Principal principal,
							Model model
							) throws IOException{
		
		if (principal==(null)) {
			model.addAttribute("username", "GEST");
			model.addAttribute("subject", subject);
			model.addAttribute("score", Integer.parseInt(count)*20);
		}
		else {
			String username = principal.getName();
			Optional<UserScore> userscore = userScoreJpaRepository.findById(username);
			if(userscore.isPresent()) {
				UserScore userScore = userscore.orElse(null);
				System.out.println(userScore);
				userScore.setCapital(Integer.parseInt(count)*20);
				System.out.println(userScore);
				model.addAttribute("username", username);
				model.addAttribute("subject", subject);
				model.addAttribute("score", Integer.parseInt(count)*20);
			}
		}		
		return "user/quiz/result";
	}
	
}
