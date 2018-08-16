Feature: Amazon Search feature
				 using this feature user can search various products

			 
Scenario: user is trying to search for 'Redmi Note5' mobile in Amazon.com

Given user is on the main page of Amazon website
When user search for Redmi Note5 mobile in search tab
Then the page should be updated with various models of Redmi Note5 mobile 