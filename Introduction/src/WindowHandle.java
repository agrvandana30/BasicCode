import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chome.driver", "C:\\chrome-win64\\chrome-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		
		driver.findElement(By.cssSelector("a[class = 'blinkingText']")).click();
		
		//Window handle in browser
		Set<String> window = driver.getWindowHandles();
		java.util.Iterator<String> it = window.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		
		System.out.println(driver.findElement(By.cssSelector("p[class = 'im-para red']")).getText());
	String s  = driver.findElement(By.cssSelector("p[class = 'im-para red']")).getText().split("at")[1].trim().split(" ")[0];
	driver.switchTo().window(parentid);
	driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(s);
	driver.quit();
	
		
		
		
		
		
	}

}
