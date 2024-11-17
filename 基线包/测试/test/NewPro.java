package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
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

public class NewPro {
	HashMap<String, String> map = new HashMap<String, String>();

	@Before
	public void set() throws IOException {
		String path = "D:\\JavaScr\\1\\src\\file\\log-suc.csv";
		CSVReader reader = new CSVReader(new FileReader(path));
		String[] l;
		reader.readNext();
		while ((l = reader.readNext()) != null) {
			String[] data = l;
			map.put(data[0], data[1]);
		}
	}

	@Test
	public void test() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.gecko.driver", "D:/Drivers/web/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        //���ҵ�¼
        driver.get("http://localhost:8080/rand-shop/home.jsp");
        String expectedUrl = "http://localhost:8080/rand-shop/seller_login.jsp";
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

        String currentUrl = driver.getCurrentUrl();
        assertTrue("δ�ܳɹ���ת", currentUrl.equals(expectedUrl));
        for(String key : map.keySet()) {    	
        	 WebElement accountInput = driver.findElement(By.name("account"));
             accountInput.sendKeys(key);
        	
             WebElement passwordInput = driver.findElement(By.name("pwd"));
             passwordInput.sendKeys(map.get(key));
        	try {
        		Thread.sleep(1000); 
        	} catch (InterruptedException e) {
        		e.printStackTrace();
        	}
        	
        	WebElement submitButton = driver.findElement(By.className("submit"));
            submitButton.click();       	
        }
        try {
        	Thread.sleep(1000); 
        } catch (InterruptedException e) {
        	e.printStackTrace();
        } 
        
        WebElement sellerButton1 = driver.findElement(By.xpath("//a[contains(text(), '���ܹ���')]"));
		sellerButton1.click();
        try {
        	Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement back = driver.findElement(By.linkText("����"));
        back.click();
        WebElement sellerButton2 = driver.findElement(By.xpath("//a[contains(text(), '��Ʒ����')]"));
	    sellerButton2.click();
		try (CSVReader reader = new CSVReader(new FileReader("D:\\JavaScr\\1\\src\\file\\product.csv"))) {
			reader.readNext();
			List<String[]> rows = reader.readAll();
	        for (String[] row : rows) {
	                // ������Ʒ��
	        WebElement nameInput = driver.findElement(By.name("name"));
	        nameInput.clear();
	        nameInput.sendKeys(row[0]);
	        System.out.println(row[0]);

                // ������Ʒ����
            WebElement descInput = driver.findElement(By.name("desc"));
            descInput.clear();
            descInput.sendKeys(row[1]);
            System.out.println(row[1]);

                // ������Ʒ�۸�
            WebElement valueInput = driver.findElement(By.name("value"));
            valueInput.clear();
            valueInput.sendKeys(row[2]);
            System.out.println(row[2]);

            System.out.println(row[3]);
            WebElement imgInput = driver.findElement(By.name("file"));
            imgInput.clear();
            imgInput.sendKeys(row[3]);
	        //driver.findElement(By.name("file")).sendKeys("D:\\JavaScr\\rand-shop\\src\\img\\wine.jpg");
	        
	            
	            try {
	            	Thread.sleep(1000); 
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            } 
	                // �ύ��
	            WebElement submitButton = driver.findElement(By.className("submit"));
	            submitButton.click();       
	            try {
	            	Thread.sleep(1000); 
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }   
	                // ������Ʒ����ҳ���Խ�����һ�β���
	            WebElement back1 = driver.findElement(By.linkText("����"));
	    		try {
	    			Thread.sleep(1000);
	    		} catch (InterruptedException e) {
	    			e.printStackTrace();
	    		}
	            back1.click();
	            WebElement sellerButton3 = driver.findElement(By.xpath("//a[contains(text(), '���ܹ���')]"));
	    		sellerButton3.click();
	            try {
	            	Thread.sleep(1000); 
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
}
