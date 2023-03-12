package week7.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykka {
	public static void main(String[] args) throws InterruptedException{
		EdgeOptions options=new EdgeOptions();
		options.addArguments("--disable-notifications","start-Maximized");
		EdgeDriver driver=new EdgeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder=new Actions(driver);
		builder.pause(20).moveToElement(ele).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		Thread.sleep(2000);
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		
		String text1="L'Oreal Paris";
		String text2 = driver.getTitle();
		if(text2.contains(text1)) {
			System.out.println("Verified");
		}else {
			System.out.println("not verified");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		
		Set<String> parentWindow = driver.getWindowHandles();
		System.out.println(parentWindow.size());
		
		List<String> childWindow=new ArrayList<String>(parentWindow);
		driver.switchTo().window(childWindow.get(1));
		
		String text3="L'Oreal Paris Colour Protect Shampoo";
		String text4 = driver.getTitle();
		System.out.println("child window: "+driver.getTitle());
		if(text4.contains(text3)) {
			System.out.println("verified");
		}else {
			System.out.println("not verified");
		}
		
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		Thread.sleep(2000);
		String rupee = driver.findElement(By.xpath("(//span[text()='₹209'])[1]")).getText();
		System.out.println("Rupee:"+rupee);
		
		
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		String grandTotalRupee = driver.findElement(By.xpath("//p[text()='₹279']")).getText();
		System.out.println("Grand Total Amount:"+grandTotalRupee);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		WebElement noti = driver.findElement(By.xpath("//button[text()='Continue as guest']"));
		noti.click();
		Thread.sleep(2000);
		
		
		
		driver.findElement(By.xpath("(//span/img)[7]")).click();
		driver.findElement(By.xpath("//p[text()='Price Details']")).click();
		Thread.sleep(2000);
		String totalRupee = driver.findElement(By.xpath("//p[text()='₹279']")).getText();
		System.out.println("Total Rupee:"+totalRupee);
		if(grandTotalRupee.equals(totalRupee)) {
			System.out.println("The price is same");
		}else {
			System.out.println("The price is not same");
		}
		driver.quit();
		}
}


