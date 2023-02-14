
Narrative: As a user I want open google home page and search for keyword ”JBehave” so that I can search for JBehave information.

Scenario: DEMO Test
Given The test user open Google using Google Chrome
When User search for key word JBehave
Then User assert the results include string “What is JBehave?”
