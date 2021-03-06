
//Validate if relevant product are displayed in plural form

package SearchFunctionality.kodo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementsList.SearchElements;

public class PluralValidation extends Base{
	String productContainer = "//div[@class='product-container']//div[2]//h5//a";
	
	
		@Test    //expected to fail as one item is t-shirt
		public void dresses () throws InterruptedException {
			SearchElements se = new SearchElements(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			se.SearchBar().clear();
			se.SearchBar().sendKeys("Dresses");
			se.SubmitButton().submit();
			int productcount = driver.findElements(By.xpath(productContainer)).size();
			//System.out.println(productcount);
			
			for (int i=0;i<productcount;i++) {
				String productName = driver.findElements(By.xpath(productContainer)).get(i).getText();
				Thread.sleep(5000);
				//System.out.println(productName);
				AssertJUnit.assertTrue(productName.contains("Dress"));
				
			}}
		@Test
		public void tshirts () throws InterruptedException {
			SearchElements se = new SearchElements(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			se.SearchBar().clear();
			se.SearchBar().sendKeys("t-shirts");
			se.SubmitButton().submit();
			int productcount = driver.findElements(By.xpath(productContainer)).size();
			//System.out.println(productcount);
			
			for (int i=0;i<productcount;i++) {
				String productName = driver.findElements(By.xpath(productContainer)).get(i).getText();
				Thread.sleep(2000);
				//System.out.println(productName);
				AssertJUnit.assertTrue(productName.contains("T-shirts"));
				
			}}

}
