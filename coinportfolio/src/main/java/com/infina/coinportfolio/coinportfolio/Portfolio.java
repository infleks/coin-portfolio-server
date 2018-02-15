package com.infina.coinportfolio.coinportfolio;

import java.math.BigDecimal;

public class Portfolio {
	private String name;
	private Integer portfolioId;

	private BigDecimal balance;
	
	
	public Portfolio(String d, BigDecimal b, Integer portId) {
		super();
		this.name = d;
		this.balance = b;
		this.portfolioId = portId;
	}


	public Integer getPortfolioId() {
		return portfolioId;
	}



	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getName() {
		return name;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
}
