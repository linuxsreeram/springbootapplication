package com.app.dbservice.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.dbservice.entity.Quote;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, Integer>{

	List<Quote> findByUserName(String userName);


	

}
