Feature: Account Page Feature

Background:
Given user has already logged in to application
| username | password |
| rashushobhitvarshney@gmail.com | 123456 |

Scenario: Accounts page title
Given user is on Accounts page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
| Order history and details |
| My credit slips |
| My addresses |
| My personal information |
| My wishlists |
| Home |
And accounts section count should be 6