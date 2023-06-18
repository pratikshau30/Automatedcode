package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
    ChromeDriver driver;
    public Amazon()
    {
        System.out.println("Constructor: Amazon");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: Amazon");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
		driver.findElement(By.id("APjFqb")).sendKeys("amazon");
		driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Amazon.in'])[1]"));
        System.out.println("end Test case: testCase01");
    }

}