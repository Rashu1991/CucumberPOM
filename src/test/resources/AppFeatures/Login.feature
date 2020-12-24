Feature: Login page feature

Scenario: Login Page title
Given user is on the login page
When user gets the title of the page
Then the title of the login page should be "Login - My Store"

Scenario: Forgot Password Link
Given user is on the login page
Then forgot password link should be displayed

Scenario: Login with valid credentials
Given user is on the login page
When user enters username "rashushobhitvarshney@gmail.com"
And user enters password "123456"
And user clicks on sign in button
Then user gets the title of the page
And page title should be "My account - My Store"