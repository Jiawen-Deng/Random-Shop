package test;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Back {
	@Test
	public void testMyMethod() {
		System.setProperty("webdriver.gecko.driver", "D:/Drivers/web/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		
		 //�������ҹ���
		driver.get("http://localhost:8080/rand-shop/home.jsp");
		WebElement sellerButton = driver.findElement(By.xpath("//a[contains(text(), '����ƽ̨')]"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sellerButton.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement accountInput = driver.findElement(By.name("account"));
		accountInput.sendKeys("123");

		WebElement passwordInput = driver.findElement(By.name("pwd"));
		passwordInput.sendKeys("123");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement submitButton = driver.findElement(By.className("submit"));
		submitButton.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement sellerButton2 = driver.findElement(By.xpath("//a[contains(text(), '�˺Ź���')]"));
		sellerButton2.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//�����ϸ�����
		WebElement back1 = driver.findElement(By.linkText("����"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        back1.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//����home.jsp
		WebElement back2 = driver.findElement(By.linkText("������ҳ"));
		back2.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement sellerButton1 = driver.findElement(By.xpath("//a[contains(text(), '����ƽ̨')]"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sellerButton1.click();
		//���µ�¼
		WebElement accountInput1 = driver.findElement(By.name("account"));
		accountInput1.sendKeys("123");

		WebElement passwordInput1 = driver.findElement(By.name("pwd"));
		passwordInput1.sendKeys("123");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement submitButton1 = driver.findElement(By.className("submit"));
		submitButton1.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//���ص�¼ҳ
		WebElement back3 = driver.findElement(By.linkText("���ص�¼ҳ"));
		back3.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement accountInput2 = driver.findElement(By.name("account"));
		accountInput2.sendKeys("123");

		WebElement passwordInput2 = driver.findElement(By.name("pwd"));
		passwordInput2.sendKeys("123");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement submitButton2 = driver.findElement(By.className("submit"));
		submitButton2.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
		driver.close();

	}
}
