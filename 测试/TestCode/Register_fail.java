// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class Register_fail {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void faillllllllll() throws InterruptedException {
    driver.get("http://localhost:5173/");
    driver.manage().window().setSize(new Dimension(876, 674));
    driver.findElement(By.linkText("注册账号")).click();
    driver.findElement(By.xpath("//div/input")).click();
    driver.findElement(By.xpath("//div/input")).sendKeys("张三");
    Thread.sleep(500);
    driver.findElement(By.xpath("//div[2]/div/div/div/input")).click();
    driver.findElement(By.xpath("//div[2]/div/div/div/input")).sendKeys("123");
    Thread.sleep(500);
    driver.findElement(By.xpath("//div[3]/div/div/div/input")).click();
    driver.findElement(By.xpath("//div[3]/div/div/div/input")).sendKeys("123456789");
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".el-button:nth-child(5)")).click();
    Thread.sleep(3000);
  }
}
