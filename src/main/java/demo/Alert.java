package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
 
    ChromeDriver driver;
    public Alert()
    {
        System.out.println("Constructor: Alert");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: Alert");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");   
        driver.get("https://web-locators-static-site-qa.vercel.app/Alerts");
        driver.findElement(By.xpath("//p[text()='Add Remarks']")).click();
        driver.switchTo().alert().sendKeys("Good");
        driver.switchTo().alert().accept();
        WebElement text=driver.findElement(By.xpath("//p[@class='Alert_remarkContent']"));
        System.out.println("Given display "+" "+text.isDisplayed());
    }
}
