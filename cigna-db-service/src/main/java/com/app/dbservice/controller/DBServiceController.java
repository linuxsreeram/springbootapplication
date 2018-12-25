package com.app.dbservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dbservice.entity.Quote;
import com.app.dbservice.entity.Quotes;
import com.app.dbservice.repositroy.QuotesRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/db")
public class DBServiceController {

	@Autowired
	private QuotesRepository quotesRepository;
	
	@GetMapping("/{userName}")
	@ApiOperation(value="Get Quote By UserName")
	public List<String> getQuotes(@PathVariable final String userName)
	{
			return quotesRepository.findByUserName(userName)
					.stream()
					.map(quote -> {
						return quote.getQuote();
					}).collect(Collectors.toList());
		
	}
	private List<String> getQuotesByUserName(String userName)
	{
	 return quotesRepository.findByUserName(userName)
		.stream()
		.map(quote -> {
			return quote.getQuote();
		}).collect(Collectors.toList());
	}
	
	@ApiOperation(value="Add Quote For User")
	@PostMapping("/add")
	public List<String> addQuote(@RequestBody Quotes quotes) {
		quotes.getQuotes()
		.stream()
		.forEach(quote -> {
			quotesRepository.save(new Quote(quotes.getUserName(), quote));
		});
		return getQuotesByUserName(quotes.getUserName());
	}
	
	@DeleteMapping("/delete/{userName}")
	@ApiOperation(value="Delete Quote By UserName")
	public List<String> delete(@PathVariable final String userName) {
		List<Quote> quotes = quotesRepository.findByUserName(userName);
		quotesRepository.deleteAll(quotes);
		return getQuotesByUserName(userName);
	}
	
	@GetMapping
	@ApiOperation(value="Get All Quotes.")
	public List<Quote> getAllQuote()
	{
		return quotesRepository.findAll();
	}
}
