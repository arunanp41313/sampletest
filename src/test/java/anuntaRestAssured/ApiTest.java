package anuntaRestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ApiTest {

	@Test(enabled=false)
	private void apiMethod() throws IOException 
	{
		System.out.println("done---------------1");
		//Browser launch
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("done----------------2");	
	}
	
	@Test(enabled=false)
	private void getMethod2() throws IOException 
	{
		System.out.println("done---------------1");
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
     	System.out.println("done---------------2");
	}
	
	
	@Test(enabled=true)
	private void apiMethod45() throws IOException 
	{
		// Launch browser
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/login.php/");
		
		//Create folder
		System.out.println("done---------------1");
		Date currentDate = new Date();
        // Define the format pattern and locale
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yy_HHmmss", Locale.ENGLISH);
        // Format the date according to the defined pattern
        String formattedDate = dateFormat.format(currentDate);
        // Print the formatted date and time
        System.out.println("Formatted Date and Time: " + formattedDate);;
		
		// Get the Jenkins workspace directory
        String jenkinsWorkspace = System.getenv("WORKSPACE");
        System.out.println(jenkinsWorkspace);
        
        String directoryPath = jenkinsWorkspace + "//" + formattedDate;
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
     	System.out.println("done---------------2");
     	
     	
     	//take ss
     	//METHOD-- 1 ( It requires common.io dependency for using fileutils
     			TakesScreenshot screenshot= (TakesScreenshot) driver;
     			File sourcefile= screenshot.getScreenshotAs(OutputType.FILE);
     			String directoryPathSS = jenkinsWorkspace + "//" + formattedDate + "//screenshot1.jpg";
     			File destinationfile= new File(directoryPathSS);
     			FileUtils.copyFile(sourcefile, destinationfile);
    };
			
}

