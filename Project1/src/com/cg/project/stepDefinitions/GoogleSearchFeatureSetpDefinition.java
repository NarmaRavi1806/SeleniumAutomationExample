package com.cg.project.stepDefinitions;

import java.sql.Driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.project.beans.GoogleSearchPage;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchFeatureSetpDefinition {

	private WebDriver driver;
	private GoogleSearchPage googlePage;

	@Before
	public void setUpStepEvent() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}
	
	@Given("^user is on Google homepage$")
	public void user_is_on_Google_homepage() throws Throwable {
		
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		googlePage=new GoogleSearchPage();
		PageFactory.initElements(driver, googlePage);
	}

	@When("^user searches for 'Agile methodology'$")
	public void user_searches_for_Agile_methodology() throws Throwable {
		/*WebElement searchElement=driver.findElement(By.id("lst-ib"));
		searchElement.sendKeys("Agile methodology");
		searchElement.submit();*/
		googlePage.setSearchElement("Agile methodology");
		googlePage.clickSearchBtn();
	}

	@Then("^all page links should be displayed for 'Agile methodology'$")
	public void all_page_links_should_be_displayed_for_Agile_methodology() throws Throwable {
		String actualTitle=driver.getTitle();
		String expectedTitle="Agile methodology - Google Search";
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}

	/*driver.Close();*/
}
