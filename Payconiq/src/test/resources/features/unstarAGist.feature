Feature: Unstaring a specific gist

Scenario Outline: sending a delete request to unstar a specific gist
When the user unstars the gist with id <id> gets a 204 response

Examples:
|id|
|dfeac81a9448ab22b2eab20dfd1b6440|