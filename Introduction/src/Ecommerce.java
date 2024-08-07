import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chome.driver", "C:\\chrome-win64\\chrome-win64");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		String[] Items = {"Brocolli", "Beans", "Cucumber", "Capsicum"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		
		//WebElement cart = driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='ADD TO CART'])[3]"));
		//cart.click();
		addItems(driver, Items);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println(element.getText());
		//System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		
		
	}
	
	public static void addItems(WebDriver driver, String[] Items){
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for(int i=0; i<products.size(); i++) {
			//converting array to arraylist
			 List<String> ItemsList = Arrays.asList(Items);
			String[] vegname = products.get(i).getText().split("-");
			String formattedvegname = vegname[0].trim();
			
			//System.out.println(formattedvegname);
			
			if(ItemsList.contains(formattedvegname)) {
				driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
				
				
			}
			
		}
	}

}
