package com.saucedemo.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.TestBase.TestBase;

public class CommonUtils extends TestBase {
	
	public static String username = "Admin";
	public static String password = "Admin@1234";

	public static String getTextFromElements(WebElement element) {
		return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element))
				.getText().trim().replaceAll("\n", "");

	}
	
	public static  String[] genreateRandomNames() {
		String[] firstName = new String[] {"James", "George", "Albert", "Thomas", "John"};
		String[] middleName = new String[] {"Levi", "Johnathan", "Wilfred", "Joshua", "Xavier"};
		String[] lastName = new String[] {"Peter", "Samuel", "William", "Wilfred", "Sam"};
		
		Random random = new Random();
		
		return new String[] {firstName[random.nextInt(5)], middleName[random.nextInt(5)], lastName[random.nextInt(5)]};
	}
	
	public static void takeFailedTestScreenShot(String testCaseName) {
		// Get the current date and Time
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		// Save the screen shot in a file
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot
		try {
			FileUtils.copyFile(screenShotFile,
					new File("/Users/jerinraj/eclipse-workspace/OrangeHRM/FailedScreenShot/" + "_" + testCaseName + "_" + timeStamp + ".jpeg"));
		} catch (IOException e) {
			System.out.println("Unable to save or take screen shot of failed test " + testCaseName);

		}

	}
}
