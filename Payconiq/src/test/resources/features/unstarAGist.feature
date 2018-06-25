Feature: Unstaring a specific gist

Scenario Outline: sending a delete request to unstar a specific gist
When the user unstars the gist with id <id>
Then the status code is 204

Examples:
|id|
|dfeac81a9448ab22b2eab20dfd1b6440|