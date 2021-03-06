

//Validate product search on base of age
//Assuming we do not have products for kids and boys
package SearchFunctionality.kodo;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import elementsList.SearchElements;
 
public class AgeValidation extends Base
{

	String productContainer = "//div[@class='product-container']//div[2]//h5//a";
	SearchElements se = new SearchElements(driver);

	@Test(dataProvider = "age")     
	public void womenDress(String age ) throws InterruptedException {
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(age);
		se.SubmitButton().submit();
		String expectedAlert = "No results were found for your search \"" + age + "\"";
		String actualAlert = se.AlertMessage().getText();
		AssertJUnit.assertEquals(actualAlert, expectedAlert);
		
		 }
	
	@DataProvider(name = "age")
    public String[][] age() {
        return new String[][] {
                {"toddler"},
                {"girls"},
                {"kids"}
        };}
	
}
