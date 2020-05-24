
// Validate alert message for incorrect search input

package SearchFunctionality.kodo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ElementsList.SearchElements;

public class IncorrectInput extends Base{

	@Test (dataProvider= "incorrectdata")
	public void incorrectdata (String incorrectdata ) throws IOException, InterruptedException {
		SearchElements se = new SearchElements(driver);
		se.SearchBar().clear();
		se.SearchBar().sendKeys(incorrectdata);
		se.SubmitButton().submit();
		Thread.sleep(2000);
		String Text = se.AlertMessage().getText();
		//System.out.println(Text);
		String alert = "No results were found for your search \"" + incorrectdata + "\"" ;
		Assert.assertEquals(alert, Text);
	}
	@AfterMethod
    public void afterEachMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
	@DataProvider(name = "incorrectdata")
    public String[][] incorrectdata() {
        return new String[][] {
                {"@"},
                {"!"},
                {"#"}
        };}
}