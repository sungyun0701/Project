package com.hmaker.itembank.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hmaker.itembank.etc.Bmi;


@Controller
public class EtcController {

	@GetMapping("/user/etc")
	public String etc() {
		return "user/etc/list";
	}
	
	@GetMapping("/user/bmi")
	public String input() {
		return "user/etc/bmi";
	}
	
	@PostMapping("/user/bmi_result")
	public String result(Model model,
						@RequestParam("k") double k,
						@RequestParam("w") double w) {

		Bmi bmi = new Bmi(k,w);
		
		model.addAttribute("bmi", bmi);
		
		return "user/etc/bmi_result";
	}
	
	@GetMapping("/user/lotto")
	public String lotto_gen() {
		
		return "user/etc/lotto_gen";
	}
	
	
	
	@PostMapping("/user/lotto_show")
	public String lotto_show(Model model,
							@RequestParam("value1") Integer value1,
							@RequestParam("value2") Integer value2,
							@RequestParam("value3") Integer value3,
							@RequestParam("value4") Integer value4,
							@RequestParam("value5") Integer value5,
							@RequestParam("value6") Integer value6) {
		
		ArrayList<Integer> my_num = new ArrayList<Integer>();  //나의 번호 배열로 만들기
		my_num.add(value1);
		my_num.add(value2);
		my_num.add(value3);
		my_num.add(value4);
		my_num.add(value5);
		my_num.add(value6);
		Collections.sort(my_num);
		

		Random rand = new Random();
		
		ArrayList<Integer> result = new ArrayList<Integer>(); //로또 번호 저장할 곳 만들기
		
		for (int i = 0; i < 6; i++) {
			int num = rand.nextInt(45) + 1;
			result.add(num);
			for (int j = 0; j < i; j++) {
				if (result.get(i) == result.get(j)) {
					i--;
					break;
				}
			}
		}
		Collections.sort(result);
		
		//보너스 번호
		int num = rand.nextInt(45) + 1;
		result.add(num);
		

		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (my_num.get(i) == result.get(j)) {
					cnt += 1;				
				}
			}
		}
		
		// 보너스 맞추기
		int bonus = 0;
		for (int i=0; i<6; i++) {
			if(my_num.get(i) == result.get(6)) {
				bonus +=1;
			}
		}

		String answer = "";
		switch (cnt) {
		case 1:
			answer = "1개 맞춤.. 꽝";
			break;
		case 2:
			answer = "2개 맞춤.. 꽝";
			break;
		case 3:
			answer = "3개 맞춤! 5천원이야";
			break;
		case 4:
			answer = "4개 맞춤! 만원이야";
			break;
		case 5:
			if(bonus==1) {answer = "2등이다!! 은행가자";}
			else{answer = "5개 맞춤! 3등이다!! 확인홰봐";}
			break;

		case 6:
			answer = "다 맞춤! 짐싸자";
			break;
		default :
			answer = "하나도 못 맞춤";
			break;
		}

		model.addAttribute("mynum", my_num);
		model.addAttribute("result", result);   // 로또번호 보내기
		model.addAttribute("answer", answer);	// 당첨 결과 보내기
		
		return "user/etc/lotto_show";
	}
	
	@GetMapping("/user/number_baseball")
	public String baseball(Model model) {
//		int [] num = {0,1,2,3,4,5,6,7,8,9};
//		int [] selected_num = new int[4];
		HashSet<Integer> selected_number = new LinkedHashSet<>();
		
		// HashSet쓰는 이유 ? 중복 제거하기 위해서
		// 중복 처리가 자동으로 이루어지므로 삽입만 하면 됨
		// 하지만 중복된 수는 삽입이 거부되므로 반복 횟수가 늘어날 수 있음.
		while(selected_number.size() < 4){
		    // 
			selected_number.add((int)(Math.random() * 10));
			if(selected_number.size()<2) {
				if(selected_number.contains(0)) {
					selected_number.remove(0);
				}
			}
		}
		System.out.print(selected_number);
		model.addAttribute("selected_number", selected_number);
		
		return "user/etc/number_baseball";
	}
	
}
