package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReProduct {
	@Test
	public void testMyMethod() {
		System.setProperty("webdriver.gecko.driver", "D:/Drivers/web/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		//�����¼���Ʒ
		driver.get("http://localhost:8080/rand-shop/home.jsp");
		WebElement sellerButton = driver.findElement(By.xpath("//a[contains(text(), '����ƽ̨')]"));

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
		WebElement accountInput = driver.findElement(By.name("account"));
		accountInput.sendKeys("123");

		WebElement passwordInput = driver.findElement(By.name("pwd"));
		passwordInput.sendKeys("123");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement submitButton = driver.findElement(By.className("submit"));
		submitButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement sellerButton2 = driver.findElement(By.xpath("//a[contains(text(), '���ܹ���')]"));
		sellerButton2.click();
		
		WebElement sellerButton3 = driver.findElement(By.xpath("//a[contains(text(), '�����¼�')]"));
		sellerButton3.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//��Ҳ鿴
		driver.get("http://localhost:8080/rand-shop/home.jsp");
		WebElement Button = driver.findElement(By.xpath("//a[contains(text(), '���ƽ̨')]"));
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Button.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.close();
	}
}
