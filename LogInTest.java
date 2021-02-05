package newpackage;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogInTest {

	@Test
	public void loginInPass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jovana.mihajlovic\\Desktop\\chromedriver_win32-Error\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://forum.benchmark.rs");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("RADI!!!!");

		//Finds username button and enters value "milijana91"
		WebElement usernameTextbox = driver.findElement(By.id("navbar_username"));
		usernameTextbox.sendKeys("milijana91");
		
		//This is timeout of 2s
		Thread.sleep(2000);
		//Click on keyboard button "Tab"
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		
		//Finds password button and enters value "milijana"
		WebElement passwordTextbox = driver.findElement(By.id("navbar_password"));
		passwordTextbox.sendKeys("milijana");

		//Finds button "prijava' and clicks on it
		WebElement submitButton = driver.findElement(By.className("loginbutton"));
		submitButton.click();

		//Takes value from welcome link and prints it in console
		WebElement welcome = driver.findElement(By.className("welcomelink"));
		System.out.println(welcome.getText());

		//Verify that text is equals
		if (welcome != null && welcome.getText().equals("Dobrodošli, milijana91.")) {
			System.out.println("Uspesno prosao test: loginInPass");
		} else {
			System.out.println("Neuspesan test: loginInPass");
		}

	}

}