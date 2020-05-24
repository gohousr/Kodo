// Validation of product on the basis of synonyms
package SearchFunctionality.kodo;


import org.openqa.selenium.By;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ElementsList.SearchElements;

public class SynonymsValidation extends Base{
	
String URL = "http://automationpractice.com/index.php"; 

	@Test(dataProvider= "synonyms")
	public void validation (String synonyms) throws InterruptedException {
		driver.get(URL);
		SearchElements se = new SearchElements(driver);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(synonyms);
		se.SubmitButton().submit();
		Thread.sleep(5000);
		Assert.assertTrue(se.ProductName().isDisplayed());  
		
		//check if correct product is displayed
	    int productcount = driver.findElements(By.xpath("//div[@class='product-container']//div[2]//h5//a")).size();
		for (int i=0;i < productcount;i++) {
			String productName = driver.findElements(By.xpath("//div[@class='product-container']//div[2]//h5//a")).get(i).getText();
			Thread.sleep(5000);
			//System.out.println(productName);
			Assert.assertTrue(productName.contains("Blouse"));
		}}
		
	 @AfterMethod
	    public void afterEachMethod() throws InterruptedException {
	        Thread.sleep(2000);
	    }
	@DataProvider(name = "synonyms")
    public String[][] synonyms() {
        return new String[][] {
                {"tops"},               
                {"blouse"},
                {"short tops"}
        };}
}