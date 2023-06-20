package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Linkedin {
    
   
        ChromeDriver driver;
        public Linkedin()
        {
            System.out.println("Constructor: Linkedin");
            WebDriverManager.chromedriver().timeout(30).setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
        }
        public void endTest()
        {
            System.out.println("End Test: Linkedin");
            driver.close();
            driver.quit();
    
        }
    
        
        public  void testCase01(){
            System.out.println("Start Test case: Linkedin");
            driver.get("https://www.linkedin.com ");
            driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("");
        	driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("");
            driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
            String text=driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'])[1]/strong")).getText();
            System.out.println("numer of people who view profile:"+text);
            String impression=driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'])[2]/strong")).getText();
            System.out.println("number of impression on post:"+impression);

            driver.findElement(By.xpath("//span[text()='Start a post']")).click();
            driver.findElement(By.xpath("//*[local-name()='svg' and  @data-test-icon='caret-medium']")).click();
            driver.findElement(By.xpath("//*[@id='CONNECTIONS_ONLY']/span[1]/span/li-icon")).click();
            		driver.findElement(By.xpath("//span[text()='Done']")).click();
                    driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']")).sendKeys("This is my first post");
                    	driver.findElement(By.xpath("//span[text()='Post']")).click();
        



            
            
}

}