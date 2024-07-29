package com.saucedemo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.saucedemo.TestBase.TestBase;

public class SwagLabsPage extends TestBase{
	
	Select select;
	public SwagLabsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//title")
	WebElement title;
	
	@FindBy(css = "select.product_sort_container")
	WebElement filter;
	
	public String getTitle() {
		return title.getText();
	}
	
	public void setFilter() {
		select = new Select(filter);
		select.selectByValue("lohi");
	}
}
