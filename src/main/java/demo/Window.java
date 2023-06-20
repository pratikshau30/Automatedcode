package demo;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {
        ChromeDriver driver;
    
    {
        System.out.println("Constructor: Window");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: Window");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws IOException, InterruptedException{
        System.out.println("Start Test case: Window");   
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        String originalWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                driver.switchTo().window(handle);
                    String title= driver.switchTo().window(handle).getTitle();
              String url=  driver.switchTo().window(handle).getCurrentUrl(); 
              
                   System.out.println("title" +" "+title);
              System.out.println("url "+" " +url);
               }
        }
               TakesScreenshot ts= (TakesScreenshot) driver;
               File src=ts.getScreenshotAs(OutputType.FILE);
               File trg=new File(".\\screenshot\\page.png");
            FileUtils.copyFile(src, trg);
            driver.close();
            driver.switchTo().window(originalWindowHandle);
            Thread.sleep(3000);
            driver.quit();
        

    
}
}
