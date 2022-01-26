Feature: Register an account

Scenario: Successfully registered an account
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on My Account Menu
And Enter registered Email Address with "ngoclong09.thaihoa@gmail.com" in Email-Address textbox
And Enter your own password with "NgocLong!@#$%^&*(" in password textbox
And Click on Register button
Then User will be registered successfully and will be navigated to the Home page

Scenario: Registration with invalid Email-id
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on My Account Menu
And Enter invalid Email Address with "!$$#!$%&@gmail.com" in Email-Address textbox
And Enter your own password with "NgocLong!@#$%^&*(" in password textbox
And Click on Register button
Then Registration must fail with a warning message(ie You must enter a valid email address)

Scenario: Registration with empty Email-id
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on My Account Menu
And Enter empty Email Address in Email-Address textbox
And Enter your own password with "NgocLong!@#$%^&*(" in password textbox
And Click on Register button
Then Registration must fail with a warning message(ie You must enter a valid email address)

Scenario: Registration with empty Email-id
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on My Account Menu
And Enter valid Email Address "ngoclong10.thaihoa@gmail.com" in Email-Address textbox
And Enter empty password in password textbox
And Click on Register button
Then Registration must fail with a warning message(ie please enter an account password)

Scenario: Registration with empty Email-id and password
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on My Account Menu
And Enter empty Email Address in Email-Address textbox
And Enter empty password in password textbox
And Click on Register button
Then Registration must fail with a warning message(ie please provide valid email address)