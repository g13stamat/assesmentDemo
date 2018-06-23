package payconiq.junit;



import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import payconiq.cucumber.serenity.GistsSteps;
import payconiq.testbase.TestBase;


@RunWith(SerenityRunner.class)
public class EditGist  extends TestBase{
	
	
	@Steps
	GistsSteps steps;

	@Title("This will edit a gist")
	@Test
	public void editGist()
	{
		
		//updating description , filename and content
		steps.editGist("new updated description for 2nd gist", "fileGist1.txt", "newfileGist1.txt", " Giorgos content file of Gist", "c3b3662910a4816b780b1b0900bbb2b5").log().all().statusCode(200);
		
		//updating description and adding a second file
		steps.editGist("3rd file", "3rdfile.txt", "3rdfile.txt", "this is a 3rd file", "c3b3662910a4816b780b1b0900bbb2b5").log().all().statusCode(200);
		
//		//deleting the first file of the Gist
//		steps.editGist("this is further updated description for 2nd gist", "updated2ndGist.txt", "", "", "261d84dbaad89661c4c7bf84ce3a2cdf").log().all().statusCode(200);
//		
	}

}

	


