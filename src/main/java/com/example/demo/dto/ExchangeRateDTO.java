package com.example.demo.dto;

import java.math.BigDecimal;

public class ExchangeRateDTO {
	
	private String fromCurrency;
	
	private String toCurrency;
	
	private BigDecimal exchangeValue;
	
	private String port;

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public BigDecimal getExchangeValue() {
		return exchangeValue;
	}

	public void setExchangeValue(BigDecimal exchangeValue) {
		this.exchangeValue = exchangeValue;
	}
	

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public ExchangeRateDTO(String fromCurrency, String toCurrency, BigDecimal exchangeValue) {
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.exchangeValue = exchangeValue;
	}

	public ExchangeRateDTO() {
	}

	public ExchangeRateDTO(String fromCurrency, String toCurrency, BigDecimal exchangeValue, String port) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.exchangeValue = exchangeValue;
		this.port = port;
	}
	
	

}
