package test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import au.com.bytecode.opencsv.CSVReader;

public class Updatepwd_fail {
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
    public void testMyMethod() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.gecko.driver", "D:/Drivers/web/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		// 卖家登录
		driver.get("http://localhost:8080/rand-shop/home.jsp");
		String expectedUrl = "http://localhost:8080/rand-shop/seller_login.jsp";
		WebElement sellerButton = driver.findElement(By.xpath("//a[contains(text(), '卖家平台')]"));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sellerButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String currentUrl = driver.getCurrentUrl();
		assertTrue("未能成功跳转", currentUrl.equals(expectedUrl));
		for (String key : map.keySet()) {
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

		WebElement Button = driver.findElement(By.xpath("//a[contains(text(), '账号管理')]"));
		Button.click();
		try (CSVReader reader = new CSVReader(new FileReader("D:\\JavaScr\\1\\src\\file\\new-errorpwd.csv"))) {  //修改密码
			reader.readNext();
			List<String[]> rows = reader.readAll();
			for (String[] row : rows) {
				WebElement oldPasswordInput = driver.findElement(By.name("old_pwd"));
				WebElement newPasswordInput = driver.findElement(By.name("new_pwd"));
				oldPasswordInput.sendKeys(row[0]);
				newPasswordInput.sendKeys(row[1]);
				WebElement Button1 = driver.findElement(By.className("submit"));
				Button1.click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
		}
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.close();

    }
}
