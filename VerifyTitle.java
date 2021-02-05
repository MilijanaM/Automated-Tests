package newpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyTitle {
	
	@Test
	public void verifyApplicationTitle(){
		
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://forum.benchmark.rs");
    
    String my_title = driver.getTitle();
    
    System.out.println("Title is"+my_title);
    String expected_title = "Benchmark forum";
    
    //Assert.assertEquals(my_title, expected_title);
    
    Assert.assertTrue(my_title.contains("Benchmark forum"));
    
    System.out.println("Test completed-Page verified");
		
	}

}
