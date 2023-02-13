//https://jbehave.org/reference/latest/developing-stories.html

Narrative: As a userI want open google home page and search for keyword ”JBehave” so that I can search for JBehave information.

Scenario: DEMO Test
Given I open Google
When I search for my blogs
Then I assert the URL
