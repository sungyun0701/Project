package com.hmaker.itembank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hmaker.itembank.entity.UserScore;


public interface UserScoreJpaRepository extends JpaRepository<UserScore, String> {

	@Query(value = "Call no_desc();", nativeQuery =true)
	List<UserScore> no_desc();
//	
//	@Query(value = "Call leftjoin();", nativeQuery = true)
//	List<StudentScore> leftjoin();
//	
//	@Query(value = "SELECT student_no FROM student_score WHERE student_no=:no", nativeQuery = true)  //첫번째 방법
//	String haha(@Param("no") String student_no);
	
//	StudentScore findByStudentNo (String studentNo);  //두번째 방법 StudentNo jpa method naming rule 따라 써야함 해당클래스
													 // 칼럼 표시하기 ex>@Column(name="student_no")

}
