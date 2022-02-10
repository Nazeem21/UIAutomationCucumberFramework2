@GetCeoName
Feature: This feature is to get CEO name from ORG
Scenario: This is to verify CEO name
Given User logged in successfully
When User selects directory option
And select the job title as "Chief Executive Officer" from drop down using "text"
And User clicks Search button
Then User should name as "John Smith"