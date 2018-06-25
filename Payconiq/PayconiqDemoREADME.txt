Overview:

This is a java maven project and tests the API with restAssured and cucumber in the Serenity framework.
The tests are writen feature files using gkerkin keywords, the phrases used in the features are mapped to user actions in the 
GistCucumberSteps.java file and these user actions are made from the steps that are implemented in the GistsSteps.java file. 

Execution:
In order execute the tests you need to create a maven run configuration that will point to project directory
and for goals you must set : clean verify serenity:aggregate
The authentication token is required for some of the tests and you must set the myToken string located:
/Payconiq/src/test/java/payconiq/cucumber/serenity/GistsSteps.java with the token provided by email.
The build will actually fail, as there is one test that fail (due to test data) but the rest of them will execute
and the report will be produced. 


Tests:
The tests are individual feature files with 1 or more steps and can be found under the folder:
/Payconiq/src/test/resources/features
By default the system will execute all feature file under that folder.
If you want to execute only some of them, move the rest to the /Payconiq/src/test/resources/notExecuted folder. 



Reports:
The project build the serenity reports under the folder:
/Payconiq/target/site/serenity/index.html
