Feature: Listing the forks for a specific gist

Scenario Outline: sending a get request for all forks a specific gist
When the user gets all forks for the gist with id <id> gets a 200 response

Examples:
|id|
|dc520ab30a8980e8df1ab1401e5e1084|