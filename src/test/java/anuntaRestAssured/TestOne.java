package anuntaRestAssured;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestOne 
{
	@Test(enabled=false)
	private void getMethod() throws IOException 
	{
		/*
		//for print console details into text file
		String testResultFile="Console.txt";
		File file = new File(testResultFile);  
		FileOutputStream fis = new FileOutputStream(file);  
		PrintStream out = new PrintStream(fis);  	
		System.setOut(out);
		*/ 
		//Browser launch
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("done-----1");	
		//Find element
		try 
		{
			driver.findElement(By.id("wed")).click();
		} catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		System.out.println("done----2");
	}

	@Test(enabled=false)
	private String getMethod2() throws IOException 
	{
		Date currentDate = new Date();
        // Define the format pattern and locale
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yy_HHmmss", Locale.ENGLISH);
        // Format the date according to the defined pattern
        String formattedDate = dateFormat.format(currentDate);
        // Print the formatted date and time
        System.out.println("Formatted Date and Time: " + formattedDate);
        // Define the directory where you want to create the file
        String projectRootPath = System.getProperty("user.dir");
        System.err.println(projectRootPath);
        String directoryPath = projectRootPath + "//" + formattedDate;
        // Create a File object representing the directory
        File directory = new File(directoryPath);
     	if (!directory.exists()) {
            boolean created = directory.mkdirs(); // Create directories recursively
            if (created) {
                System.out.println("Directory created: " + directory.getAbsolutePath());
            } else {
                throw new IOException("Failed to create directory: " + directory.getAbsolutePath());
            }
        } else {
            System.out.println("Directory already exists: " + directory.getAbsolutePath());
        }
     	return directory.getAbsolutePath();
	}
	
	@Test(enabled=false)
	private void getMethod3() throws IOException 
	{
		TestOne one= new TestOne();
		one.getMethod2();
	}
	
}
