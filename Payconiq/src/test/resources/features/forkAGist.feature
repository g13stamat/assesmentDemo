Feature: Forking a specific gist

Scenario Outline: sending a post request to fork a specific gist
When the user forks the gist with id <id> gets a 201 response

Examples:
|id|
|dfeac81a9448ab22b2eab20dfd1b6440|