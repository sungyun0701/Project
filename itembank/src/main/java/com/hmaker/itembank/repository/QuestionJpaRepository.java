package com.hmaker.itembank.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hmaker.itembank.entity.Question;

public interface QuestionJpaRepository extends JpaRepository<Question, Long> {
	@Query(value = "SELECT * FROM question as q WHERE q.kind = :kind order by rand() limit 20;", nativeQuery = true)
//	Page<Question> findQuestionByKind(@Param("kind") String kind);
		List<Question> findQuestionByKind(@Param("kind") String kind);
	
}
