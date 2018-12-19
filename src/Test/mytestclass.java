package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mytestclass {

 public static void main(String[] args) {
  //set geckodriver path.
  System.setProperty("webdriver.gecko.driver","BrowsersAndSources//geckodriver");
  //initialize firefox driver object to open firefox browser.
    WebDriver driver = new FirefoxDriver();
    //open URL in browser.
    driver.get("http://only-testing-blog.blogspot.in");
    String i = driver.getCurrentUrl();
    System.out.println(i);
    driver.close();
   }
}
