package com.cg.project.beans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
	
	@FindBy(how=How.ID,id="user_login")
	private WebElement username;
	
	@FindBy(how=How.ID,id="user_email")
	private WebElement emailId;
	
	@FindBy(how=How.ID,id="user_password")
	private WebElement password;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"signup-form\"]/div")
	private WebElement actualErrorMsg;
	
	@FindBy(how=How.ID,id="signup_button")
	private WebElement button;

	public String getUsername() {
		return username.getAttribute("value");
	}

	public void setUasername(String username) {
		this.username.sendKeys(username);
	}

	public String getEmailId() {
		return emailId.getAttribute("value");
	}

	public void setEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
	}

	public String getPassword() {
		return password.getAttribute("value");
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public String getActualErrorMsg() {
		return actualErrorMsg.getText();
	}

	public void clickSignup() {
		button.submit();;
	}

	/*public void setButton(WebElement button) {
		this.button = button;
	}*/
	
	

	/*public void setActualErrorMsg(WebElement actualErrorMsg) {
		this.actualErrorMsg = actualErrorMsg;
	}*/
	
	

}
