package com.cg.project.stepDefinitions;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.project.beans.RegistrationPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GitHubRegistrationFeatureStepDefinition {
	
	private WebDriver driver;
	private RegistrationPage regPage;
	
	@Before
	public void setUpStepEvent() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}
	
	@Given("^user is on the main page of 'GitHUb'$")
	public void user_is_on_the_main_page_of_GitHUb() throws Throwable {
		
		driver=new ChromeDriver();
		driver.get("https://github.com/join?source=header-home");
		regPage=new RegistrationPage();
		PageFactory.initElements(driver, regPage);
		
	}
	
	@When("^user enters invalid name, emailId and password$")
	public void user_enters_invalid_name_emailId_and_password() throws Throwable {
		
		/*WebElement usernameElement=driver.findElement(By.id("user_login"));
		WebElement mailIdElement=driver.findElement(By.id("user_email"));
		WebElement passwordElement=driver.findElement(By.id("user_password"));
		usernameElement.sendKeys("NarmaRavi1806");
		mailIdElement.sendKeys("narmatharavi1997@gmail.com");
		passwordElement.sendKeys("Redmi Note5");
		passwordElement.submit();*/
		regPage.setUasername("NarmaRavi1806");
		regPage.setEmailId("narmatharavi1997@gmail.com");
		regPage.setPassword("Redmi Note5");
		regPage.clickSignup();
	}

	@Then("^'Incorrect username or username already given\\.' message should be displayed$")
	public void incorrect_username_or_username_already_given_message_should_be_displayed() throws Throwable {
	    //String actualErrMessage=driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div")).getText();
	    String expectedErrMessage="There were problems creating your account.";
	    Assert.assertEquals(expectedErrMessage, regPage.getActualErrorMsg());
	}

	@When("^user enters valid name, emailId and password$")
	public void user_enters_valid_name_emailId_and_password() throws Throwable {
		//driver.get("https://github.com/join?source=header-home");
		/*WebElement usernameElement=driver.findElement(By.id("user_login"));
		WebElement mailIdElement=driver.findElement(By.id("user_email"));
		WebElement passwordElement=driver.findElement(By.id("user_password"));
		usernameElement.sendKeys("Natalie8866");
		mailIdElement.sendKeys("sure90018@gmail.com");
		passwordElement.sendKeys("sure900");
		passwordElement.submit();*/
		regPage.setUasername("Nataliecris18");
		regPage.setEmailId("sure90020@gmail.com");
		regPage.setPassword("sure900");
		regPage.clickSignup();
		WebElement continueElement=driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/div[3]/button"));
		continueElement.submit();
		WebElement SkipElement=driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div/form/a"));
		SkipElement.click();
		
	}

	@Then("^new Github Account should be created$")
	public void new_Github_Account_should_be_created() throws Throwable {
		String actualTitle=driver.getTitle();
		String expectedTitle="Your Actions";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}


}
