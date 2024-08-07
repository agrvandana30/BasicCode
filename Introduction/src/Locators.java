import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chome.driver", "C:\\chrome-win64\\chrome-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("vandana");
		driver.findElement(By.name("inputPassword")).sendKeys("test123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println( driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Riya");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("riya.tester.com");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9090887766");
		driver.findElement(By.className("reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

	}

}
