Feature: feature to test login functionally

  Scenario: login is successful with valid credentials
    Given Open the browser
    And Enter the URL "http://practice.automationtesting.in/"
    When Click on My Account Menu
    And Enter registered username in username textbox
    And Enter password in password textbox
    And Click on login button
    Then User must successfully login to the web page

  Scenario: login is incorrect username and password
    Given Open the browser
    And Enter the URL "http://practice.automationtesting.in/"
    When Click on My Account Menu
    And Enter incorrect username in username textbox
    And Enter incorrect password in password textbox.
    And Click on login button
    Then Proper error must be displayed(ie Invalid username) and prompt to enter login again

  Scenario: login with valid username and empty password
    Given Open the browser
    And Enter the URL "http://practice.automationtesting.in/"
    When Click on My Account Menu
    And Enter valid username in username textbox
    And Now enter empty password in the password textbox
    And Click on login button
    Then Proper error must be displayed(ie Invalid password) and prompt to enter login again

  Scenario: login with empty username and valid password
    Given Open the browser
    And Enter the URL "http://practice.automationtesting.in/"
    When Click on My Account Menu
    And Enter empty username in username textbox
    And Now enter valid password in the password textbox
    And Click on login button
    Then Proper error must be displayed(ie Invalid username) and prompt to enter login again

  Scenario: check password with some characters must not visible on the screen
    Given Open the browser
    And Enter the URL "http://practice.automationtesting.in/"
    When Click on My Account Menu
    And Enter the password field with some characters.
    Then The password field should display the characters in asterisks or bullets such that the password is not visible on the screen

     Scenario: login with empty username and valid password
    Given Open the browser
    And Enter the URL "http://practice.automationtesting.in/"
    When Click on My Account Menu
    And Enter the case changed username in username textbox
    And Enter the case chenged password in the password tetxbox                         
    And Once your are logged in, sign out of the site
    And Now press back button
    Then User shouldnot be signed in to his account rather a general webpage must be visible
    