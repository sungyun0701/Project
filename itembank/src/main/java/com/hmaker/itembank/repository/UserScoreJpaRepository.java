package com.hmaker.itembank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hmaker.itembank.entity.Question;
import com.hmaker.itembank.entity.UserScore;


public interface UserScoreJpaRepository extends JpaRepository<UserScore, String> {

	@Query(value = "Call score_desc;", nativeQuery =true)
	List<UserScore> score_desc();
//	
//	@Query(value = "Call leftjoin();", nativeQuery = true)
//	List<StudentScore> leftjoin();
//	
//	@Query(value = "SELECT student_no FROM student_score WHERE student_no=:no", nativeQuery = true)  //첫번째 방법
//	String haha(@Param("no") String student_no);
	
//	StudentScore findByStudentNo (String studentNo);  //두번째 방법 StudentNo jpa method naming rule 따라 써야함 해당클래스
													 // 칼럼 표시하기 ex>@Column(name="student_no")
	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "UPDATE user_score as user SET capital=?1, total = (capital+nonsense+trivia+proverb), aver = total/4 WHERE username = ?2" , nativeQuery = true)
	void findUsernameCapital(int score,String username);
	
	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "UPDATE user_score as user SET trivia=?1, total = (capital+nonsense+trivia+proverb), aver = total/4 WHERE username = ?2" , nativeQuery = true)
	void findUsernameTrivia(int score, String username);

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "UPDATE user_score as user SET proverb=?1, total = (capital+nonsense+trivia+proverb), aver = total/4 WHERE username = ?2" , nativeQuery = true)
	void findUsernameProverb(int score, String username);

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "UPDATE user_score as user SET nonsense=?1, total = (capital+nonsense+trivia+proverb), aver = total/4 WHERE username = ?2" , nativeQuery = true)
	void findUsernameNonsense(int score, String username);

}
