package com.cg.project.beans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSearchPage {
	
	@FindBy(how=How.ID,id="lst-ib")
	private WebElement searchElement;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")
	private WebElement button;

	public String getSearchElement() {
		return searchElement.getAttribute("value");
	}

	public void setSearchElement(String searchElement) {
		this.searchElement.sendKeys(searchElement);
	}
	
	public void clickSearchBtn() {
		button.submit();
	}

}
