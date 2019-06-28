package com.learnframework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver){
		this.driver=ldriver;
	} 
	
	By emailField = By.name("email");
	By passField = By.name("password");
	By loginButton = By.xpath("//div[@class='ui fluid large blue submit button']");
	
	
	public void login(String email, String password){
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

}
