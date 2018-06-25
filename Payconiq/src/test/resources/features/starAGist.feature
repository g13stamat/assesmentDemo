Feature: Star a specific gist

Scenario Outline: sending a put star request passing the gist Id
When the user stars the gist with id <id>
Then the status code is 204

Examples:
|id|
|dfeac81a9448ab22b2eab20dfd1b6440|