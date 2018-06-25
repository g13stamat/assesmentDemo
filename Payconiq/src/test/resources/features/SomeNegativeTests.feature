Feature: Some negative tests from all calls

Scenario Outline: sending erroneous requests and checking the responses
When the user checks if the gist with id <id> is starred
Then the status code is 404
When the user requests all gists from user with userId <userId>
Then the status code is 404
When the user requests the gist with id <id>
Then the status code is 404
When the user creates a gist with description <description>, isPublic set <isPublic>, file name <fileName> and content <content>
Then the status code is 422

Examples:
|id|userId|description|isPublic|fileName|content|
|UNKNOWN|999hhhbbtfsz532|||||