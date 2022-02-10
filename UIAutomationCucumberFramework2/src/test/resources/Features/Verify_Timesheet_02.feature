@Timesheet
Feature: This feature is to get timesheet
Scenario: This is to verify timesheet
Given User is  in homepage
When User selects timesheet option
And Enters the name as "John Smith"
And User clicks view button
Then User should see Message  as "No Timesheets Found"