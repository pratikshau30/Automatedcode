package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
    
    ChromeDriver driver;
    public Frames()
    {
        System.out.println("Constructor: Frames");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: Frames");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");  
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        	driver.switchTo().frame("frame-top");
            driver.switchTo().frame("frame-left");
            String text=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
            System.out.println("the frame is"+text);
            driver.switchTo().parentFrame();
            driver.switchTo().frame("frame-middle");
            String val=driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]")).getText();
            System.out.println("the frame is"+val);
            driver.switchTo().parentFrame();
            driver.switchTo().frame("frame-right");
            String context=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
            System.out.println("the frame is"+context);
            driver.switchTo().defaultContent();
            driver.switchTo().frame("frame-bottom");
            String cot=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]")).getText();
            System.out.println("the frame is"+cot); 

}
}