import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesHandle {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chome.driver", "C:\\chrome-win64\\chrome-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//find No. of frames in application
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class = 'demo-frame']")));
		driver.findElement(By.xpath("//div[@id = 'draggable']")).isDisplayed();

		Actions a= new Actions(driver);
		
		WebElement source = driver.findElement(By.xpath("//div[@id = 'draggable']"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		 driver.switchTo().defaultContent();
		
		

	}

}
