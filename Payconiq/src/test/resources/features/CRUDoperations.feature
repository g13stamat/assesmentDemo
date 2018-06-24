Feature: Creating Updating Reading and Deleting a gist

Scenario Outline: performing create update read and delete operations on gist
When the user creates a gist with description <description>, isPublic set <isPublic>, file name <fileName> and content <content>
Then the status code is 201
Then the user updates that gist with description <newDescription>, new name <newName>, new file name <newFileName> and content <newContent>
Then the status code is 200
Then the user reads that gist
Then the status code is 200
Then the user deletes that gist
Then the status code is 204
Examples:
|description|isPublic|fileName|content|newDescription|newName|newFileName|newContent|
|my first description|true|CRUD1.txt|these are the contents of CRUD1 file|second description|second name|secondFile.txt|content for the new file|

