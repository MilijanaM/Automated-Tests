package newpackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brojnatemi {
	

	public void metoda() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://forum.benchmark.rs");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement brPoruke = driver.findElement(By.xpath("//*[@id=\"forum37\"]/div/ul[2]/li[2]"));
		
        
		String intValue = brPoruke.getText().replaceAll("[^0-9]", "");
		System.out.println(intValue);
		
		int br = Integer.parseInt(intValue);
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	    Date firstDate = null;
	    Date secondDate = null;
		try {
			firstDate = sdf.parse("01/01/2019");
			secondDate = new Date();
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
	 
	    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	 
		System.out.println(diff);
		
		if (br > diff) {
			System.out.println("Jeste!!!");
		}else {
			System.out.println("Nije!!!");
		}
	}
}


//*[@id="thread_446263"]/div/dl/dd[2]/text()