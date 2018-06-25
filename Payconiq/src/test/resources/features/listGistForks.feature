Feature: Listing the forks for a specific gist

Scenario Outline: sending a get request for all forks a specific gist
When the user gets all forks for the gist with id <id>
Then the status code is 200

Examples:
|id|
|41105f52c05abe426a22b052c1032274|