Feature: Forking a specific gist

Scenario Outline: sending a post request to fork a specific gist
When the user forks the gist with id <id>
Then the status code is 201

Examples:
|id|
|dfeac81a9448ab22b2eab20dfd1b6440|