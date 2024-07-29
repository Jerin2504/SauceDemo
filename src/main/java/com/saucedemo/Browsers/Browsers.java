package com.saucedemo.Browsers;

public enum Browsers {

	CHROME("Google Chrome"), 
	FIREFOX("Mozilla Firefox"), 
	EDGE("Microsoft");

	private String browserNameWithCompany;

	Browsers(String browser) {
		this.browserNameWithCompany = browser;
	}

	public String getBrowserNameWithCompany() {
		return browserNameWithCompany;
	}

}
