// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class CheckGoods {
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
  public void check() throws InterruptedException {
    driver.get("http://localhost:5173/");
    driver.manage().window().setSize(new Dimension(876, 674));
    driver.findElement(By.cssSelector("input:nth-child(1)")).click();
    driver.findElement(By.cssSelector("input:nth-child(1)")).sendKeys("admin123");
    driver.findElement(By.cssSelector("input:nth-child(2)")).sendKeys("admin123");
    Thread.sleep(1000);
    driver.findElement(By.cssSelector("button")).click();
    driver.findElement(By.cssSelector(".sub-category-filter > .filter-tag:nth-child(2)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".sub-category-filter > .filter-tag:nth-child(3)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".filter-tag:nth-child(4)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".filter-tag:nth-child(5)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".filter-tag:nth-child(6)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".sub-category-filter > .filter-tag:nth-child(1)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".category-filter > .filter-tag:nth-child(2)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".sub-category-filter > .filter-tag:nth-child(2)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".sub-category-filter > .filter-tag:nth-child(3)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".filter-tag:nth-child(4)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".filter-tag:nth-child(5)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".filter-tag:nth-child(6)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".sub-category-filter > .filter-tag:nth-child(1)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".category-filter > .filter-tag:nth-child(3)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".sub-category-filter > .filter-tag:nth-child(2)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".sub-category-filter > .filter-tag:nth-child(3)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".filter-tag:nth-child(4)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".filter-tag:nth-child(5)")).click();
    Thread.sleep(500);
    driver.findElement(By.cssSelector(".filter-tag:nth-child(6)")).click();
    Thread.sleep(1000);
  }
}
