package com.cg.project.mainUi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainUi {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		try {
			checkBoxTest();
			radioButtonTest();
			selectItemTest();
		} catch (InterruptedException e) {

		}

	}

	private static void checkBoxTest() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.get("D:\\Html1.html");
		WebElement checkbox=driver.findElement(By.id("mayoCheckBox"));

		Thread.sleep(1000);
		checkbox.click();

		if(checkbox.isSelected())
			System.out.println("Value of check box : "+checkbox.getAttribute("value"));
	}

	private static void radioButtonTest() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.get("D:\\Html2.html");
		By elements=By.name("color");
		List<WebElement> radioButtons=driver.findElements(elements);

		WebElement radio=radioButtons.get(1);

		radio.click();

		for (WebElement radioButton : radioButtons) {
			if(radioButton.isSelected()) {
			System.out.println(radioButton.getAttribute("value"));
			}
		}
	}
	
	private static void selectItemTest() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.get("D:\\Html3.html");
		WebElement selectElement= driver.findElement(By.id("select1"));
		Select select = new Select(selectElement);
		select.selectByVisibleText("MayBe");
		
	}
}
