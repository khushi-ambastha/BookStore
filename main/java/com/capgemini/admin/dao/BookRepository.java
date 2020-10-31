package com.capgemini.admin.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.admin.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


}
