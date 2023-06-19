package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {
    ChromeDriver driver;
    public Link()
    {
        System.out.println("Constructor: Amazon");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: Link");
        driver.close();
        driver.quit();

    }
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement>link=driver.findElements(By.tagName("a"));
        System.out.println("Total links on page"+" "+link.size());
        System.out.println("end Test case: testCase01");
        
    }
}
