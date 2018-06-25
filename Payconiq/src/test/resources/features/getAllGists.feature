Feature: List all gists

Scenario: sending a get all gists request
When the user requests all gists
Then the status code is 200
