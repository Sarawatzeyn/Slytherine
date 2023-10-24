package com.facebook.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.TakesScreenshot;
import com.facebook.base.BaseTest;

public class ScreenShot {
	public void webElementSreenShot(WebElement user, String screenShotName){
	File SrcFile=user.getScreenshotAs(OutputType.FILE);
	long time=System.currentTimeMillis();
	String fileWithPath= "screenShot/"+time+screenShotName+".png";
	File DestFile=new File(fileWithPath);
	try {
		FileUtils.copyFile(SrcFile, DestFile);
	
	}
		catch(IOException e) {
			e.printStackTrace();
		}
		}
	public void takescreenShot(String screenShotName) {
		BaseTest b=new BaseTest();
		WebDriver driver = b.openApp();
		//convert web driver object to TakeScreenShot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//call getScreenShotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		long time = System.currentTimeMillis();
		String fileWithPath="screenShot/"+time+screenShotName+".png";
	File DestFile=new File(fileWithPath);
	//roll over
	//String destFilePath=System.getProperty("user.dir")+\\ScreenShot\\+"test"+.png;
	//File DestFile=new file(detFilePath);
	//copy file at destination
	try {
		FileUtils.copyFile(SrcFile, DestFile);
	}catch (IOException e) {
		e.printStackTrace();
	}
	
	
	}

}
