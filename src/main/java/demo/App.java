/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.io.IOException;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, IOException {
        //TestCases tests = new TestCases(); // Initialize your test class
       // Amazon am =new Amazon();
       //Link li=new Link();
      // Alert al=new Alert();
      //Frames fr=new Frames();
      Window wd=new Window();

        //TODO: call your test case functions one after other here

       // am.testCase01();
       wd.testCase01();

        //END Tests


       // am.endTest(); // End your test by clearning connections and closing browser
       wd.endTest();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        new App().getGreeting();
    }
}
