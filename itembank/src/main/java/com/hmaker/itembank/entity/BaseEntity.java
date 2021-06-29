package com.hmaker.itembank.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass

public class BaseEntity {

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createDate;
	
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}


	
}
