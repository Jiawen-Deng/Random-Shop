package test;

import static org.junit.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import au.com.bytecode.opencsv.CSVReader;

public class Standby {
	private static final String path = "D:\\JavaScr\\1\\src\\file\\log-suc.csv";
	HashMap<String, String> map = new HashMap<String, String>();

	@Before
	public void set() throws IOException {
		CSVReader reader = new CSVReader(new FileReader(path));
		String[] l;
		reader.readNext();
		while ((l = reader.readNext()) != null) {
			String[] data = l;
			map.put(data[0], data[1]);
		}
	}

	@Test
    public void testMyMethod() throws IOException {
		System.setProperty("webdriver.gecko.driver", "D:/Drivers/web/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        
		driver.get("http://localhost:8080/rand-shop/home.jsp");
		WebElement Button = driver.findElement(By.xpath("//a[contains(text(), '买家平台')]"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Button.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement sellerButton1 = driver.findElement(By.xpath("//a[contains(text(), '申请候补')]"));
        sellerButton1.click();
        
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        try (CSVReader reader = new CSVReader(new FileReader("D:\\JavaScr\\1\\src\\file\\putbuyer-standby.csv"))) { // 提交信息
			reader.readNext();
			List<String[]> rows1 = reader.readAll();
			for (String[] row : rows1) {
				WebElement descInput = driver.findElement(By.id("Desc"));
				descInput.sendKeys(row[0]);
				WebElement submitButton2 = driver.findElement(By.xpath("//button[text()='提交']"));
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				submitButton2.click();
			}
		}
        
        //看看新候补
        driver.get("http://localhost:8080/rand-shop/seller_login.jsp");
        for(String key : map.keySet()) {    	
       	 WebElement accountInput = driver.findElement(By.name("account"));
            accountInput.sendKeys(key);
       	
            WebElement passwordInput = driver.findElement(By.name("pwd"));
            passwordInput.sendKeys(map.get(key));
       	try {
       		Thread.sleep(2000); 
       	} catch (InterruptedException e) {
       		e.printStackTrace();
       	}
       	
       	WebElement submitButton = driver.findElement(By.className("submit"));
           submitButton.click();       	
       }
       try {
       		Thread.sleep(3000); 
       	} catch (InterruptedException e) {
       		e.printStackTrace();
       	} 
        WebElement sellerButton6 = driver.findElement(By.xpath("//a[contains(text(), '订单管理')]"));
        sellerButton6.click();
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
		driver.close();

	}
}
