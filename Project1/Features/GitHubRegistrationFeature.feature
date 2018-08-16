Feature: GitHub registration feature

@SmokeTest
Scenario: user is trying to register a new account in GitHub with invalid details

Given user is on the main page of 'GitHUb'
When user enters invalid name, emailId and password 
Then 'Incorrect username or username already given.' message should be displayed

@SmokeTest
Scenario: user is trying to register a new account in GitHub

Given user is on the main page of 'GitHUb'
When user enters valid name, emailId and password
Then new Github Account should be created