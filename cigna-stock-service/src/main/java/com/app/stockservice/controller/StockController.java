package com.app.stockservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.stockservice.model.Quote;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;


@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private RestTemplate restTemplate;

	
	
	@GetMapping("/{userName}")
	public List<String> getStock(@PathVariable final String userName) throws IOException{
		
		System.out.println(userName);
		List<String> quotes = (List<String>)restTemplate.getForObject("http://db-service/rest/db/"+userName, Object.class);
		 
		return quotes;
	}
}
