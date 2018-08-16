package com.cg.project.beans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage {
	
	@FindBy(how=How.ID,id="twotabsearchtextbox")
	private WebElement findElement;

	@FindBy(how=How.XPATH,xpath="//*[@id=\"nav-search\"]/form/div[2]/div/input")
	private WebElement button;
	

	public String getFindElement() {
		return findElement.getAttribute("value");
	}

	public void setFindElement(String findElement) {
		this.findElement.sendKeys(findElement);
	}

	public void clickSearchBtn() {
		button.submit();
	}

	/*public void setButton(WebElement button) {
		this.button = button;
	}
	*/
	
	
}
