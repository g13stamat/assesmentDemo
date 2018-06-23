package payconiq.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import payconiq.testbase.TestBase;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/")
public class GistRunner extends TestBase {
	
	

}
