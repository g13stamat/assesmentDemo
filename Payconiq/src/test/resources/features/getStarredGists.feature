Feature: List starred gists

Scenario: sending a get starred gists request
When the user requests all starred gists
Then the status code is 200
