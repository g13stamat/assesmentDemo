Feature: Listing the commits for a specific gist

Scenario Outline: sending a get request for the commits of a gist passing the gist Id
When the user requests the commits for the gist with id <id>
Then the status code is 200

Examples:
|id|
|dfeac81a9448ab22b2eab20dfd1b6440|