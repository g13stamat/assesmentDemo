Feature: List a specific gist

Scenario Outline: sending a get gist request passing the gist Id
When the user requests the gist with id <id>
Then the status code is 200

Examples:
|id|
|dfeac81a9448ab22b2eab20dfd1b6440|