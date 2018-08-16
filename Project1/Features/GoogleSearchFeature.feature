Feature: Google Serach feature
				 Using this feature user can explore various websites
@Tag				 
Scenario: user want to search information about 'Agile methodology' by entering valid set of words

Given user is on Google homepage
When user searches for 'Agile methodology' 
Then all page links should be displayed for 'Agile methodology'