Feature: Check if a gist is starred

Scenario Outline: sending a get request to check if a gist is starred
When the user checks if the gist with id <id> is starred gets a 204 response

Examples:
|id|
|dfeac81a9448ab22b2eab20dfd1b6440|