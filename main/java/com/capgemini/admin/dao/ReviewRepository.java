package com.capgemini.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.admin.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	
}
