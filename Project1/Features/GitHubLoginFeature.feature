Feature: GitHub login feature
				 using this feature user can able to login to his account
				 
@Execute
Scenario: user is trying to signin to GitHub account with invalid username and password

Given user is on GitHub login page
When user enter invalid username and password
Then 'Incorrect username and password' message should be displayed

@Execute
Scenario: user is trying to signin to GitHub account using valid username and password

Given user is on GitHub login page
When user enter valid username and password
Then user should successfully loggedin to his account