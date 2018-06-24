Feature: List all gists from a specific user

Scenario Outline: sending a get all gists request passing the user Id
When the user requests all gists from user with userId <userId> gets a 200ok response
Then the list of gists is retrieved with userId <userId>

Examples:
|userId|
|g13stamat|
