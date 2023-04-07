package com.example.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.ExchangeRateDTO;

//@FeignClient(name ="currency-exchange",url = "localhost:8081")
@FeignClient(name ="currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/exchange-rate/{fromCurrency}/{toCurrency}")
	public ExchangeRateDTO getExchangeRate(@PathVariable String fromCurrency,@PathVariable String toCurrency) ;
	
	

}
