Feature: Star a specific gist

Scenario Outline: sending a put star request passing the gist Id
When the user stars the gist with id <id> gets a 200ok response

Examples:
|id|
|dfeac81a9448ab22b2eab20dfd1b6440|