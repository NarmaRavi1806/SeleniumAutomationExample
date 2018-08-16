package com.cg.project.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cg.project.beans.LoginPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GitHubLoginFeature2StepDefinition {

	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void setUpStepEvent() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}

	@Given("^user is on GitHub login page$")
	public void user_is_on_GitHub_login_page() throws Throwable {
		
		driver=new ChromeDriver();
		driver.get("https://github.com/login");
		loginPage=new LoginPage();
		PageFactory.initElements(driver, loginPage);

	}

	@When("^user enter invalid username and password$")
	public void user_enter_invalid_username_and_password() throws Throwable {
		
		/*WebElement usernameElement=driver.findElement(By.id("login_field"));
		WebElement passwordElement=driver.findElement(By.id("password"));
		usernameElement.sendKeys("narma@ravi");
		passwordElement.sendKeys("Narma@ravi");
		passwordElement.submit();*/
		loginPage.setUsername("narma@ravi");
		loginPage.setPassword("Narma@ravi");
		loginPage.clickTheBtn();
	}

	@Then("^'Incorrect username and password' message should be displayed$")
	public void incorrect_username_and_password_message_should_be_displayed() throws Throwable {
		//String actual=driver.findElement(By.xpath("//*[@id=\"js-flash-container\"]/div/div")).getText();
		String expected="Incorrect username or password.";
		Assert.assertEquals(expected, loginPage.getActualErrorMessage());
	}

	/*@Given("^user is on Github login page$")
	public void user_is_on_Github_login_page() throws Throwable {
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://github.com/login");
	}*/

	@When("^user enter valid username and password$")
	public void user_enter_valid_username_and_password() throws Throwable {
		
		/*WebElement usernameElement=driver.findElement(By.id("login_field"));
		WebElement passwordElement=driver.findElement(By.id("password"));
		usernameElement.sendKeys("NarmaRavi1806");
		passwordElement.sendKeys("narma@vani1806");
		passwordElement.submit();*/
		loginPage.setUsername("NarmaRavi1806");
		loginPage.setPassword("narma@vani1806");
		loginPage.clickTheBtn();
	}

	@Then("^user should successfully loggedin to his account$")
	public void user_should_successfully_loggedin_to_his_account() throws Throwable {
		
		/*WebElement actuallink=driver.findElement(By.linkText("https://avatars2.githubusercontent.com/u/41135685?s=40&v=4"));
		actuallink.click();*/
		WebDriverWait driverWait=new WebDriverWait(driver, 20);
		driverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"user-links\"]/li[3]/details/details-menu/ul/li[1]/a/strong"),"NarmaRavi1806"));
		String actual=driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/details/details-menu/ul/li[1]/a/strong")).getText();
		String expected="NarmaRavi1806";
		Assert.assertEquals(expected, actual);
		driver.close();
	}

}
