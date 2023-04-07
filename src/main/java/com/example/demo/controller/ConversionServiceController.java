package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ExchangeRateDTO;

@RestController
public class ConversionServiceController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping("/convert/{fromCurrency}/{toCurrency}/{quantity}")
	public String convertCurrency(@PathVariable String fromCurrency,@PathVariable String toCurrency,@PathVariable String quantity ) {
		RestTemplate rt=new RestTemplate();
		HashMap<String, String> pathParams=new HashMap<>();
		pathParams.put("fromCurrency", fromCurrency);
		pathParams.put("toCurrency", toCurrency);
		
		ExchangeRateDTO exchangeRateDTO = rt.getForObject("http://localhost:8081/exchange-rate/{fromCurrency}/{toCurrency}", ExchangeRateDTO.class, pathParams);
		BigDecimal exchangeValue = exchangeRateDTO.getExchangeValue();
		String serverPortNumber = exchangeRateDTO.getPort();
		System.out.println("Exchange Value is "+exchangeValue);
		System.out.println("exchangeRate:::"+exchangeValue);
		BigDecimal convertedValue=exchangeValue.multiply(new BigDecimal(quantity));
		return "converted currency value is-RestTemplate Response with port   "+serverPortNumber+"  "+convertedValue.toString();
	}
	
	@GetMapping("/convert-feign/{fromCurrency}/{toCurrency}/{quantity}")
	public String convertCurrencyByFeign(@PathVariable String fromCurrency,@PathVariable String toCurrency,@PathVariable String quantity ) {
		ExchangeRateDTO exchangeRate = currencyExchangeProxy.getExchangeRate(fromCurrency, toCurrency);
		BigDecimal exchangeValue = exchangeRate.getExchangeValue();
		System.out.println("Exchange Value is "+exchangeValue);
		System.out.println("exchangeRate:::"+exchangeRate);
		BigDecimal convertedValue=exchangeValue.multiply(new BigDecimal(quantity));
		String serverPortNumber = exchangeRate.getPort();
		return "converted currency value is with FeignClient  "+serverPortNumber+"  "+convertedValue.toString();
	}

}
