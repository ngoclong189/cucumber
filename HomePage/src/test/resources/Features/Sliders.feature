Feature: feature to test sliders

Scenario: check Home Page with three Sliders only
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on Shop Menu
And  Now click on Home menu button
And Test whether the Home page has Three Arrivals only
Then The Home page must contains only three Arrivals


Scenario: Home page with three Arrivals only
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on Shop Menu
And  Now click on Home menu button
And Test whether the Home page has Three Arrivals only
Then The Home page must contains only three Arrivals

Scenario: Images in Arrivals should navigate
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on Shop Menu
And  Now click on Home menu button
And Test whether the Home page has Three Arrivals only
Then The Home page must contains only three Arrivals
When Now click the image in the Arrivals
Then Test whether it is navigating to next page where the user can add that book into his basket.
And Image should be clickable and shoul navigate to next page where user can add that book to his basket

Scenario: Arrivals-Images-Description
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on Shop Menu
And  Now click on Home menu button
And Test whether the Home page has Three Arrivals only
Then The Home page must contains only three Arrivals
When Now click the image in the Arrivals
Then Test whether it is navigating to next page where the user can add that book into his basket.
And Image should be clickable and shoul navigate to next page where user can add that book to his basket
When Click on Description tab for the book you clicked on.
Then There should be a description regarding that book the user clicked on

Scenario: Add to Basket-Items
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on Shop Menu
And  Now click on Home menu button
And Test whether the Home page has Three Arrivals only
Then The Home page must contains only three Arrivals
When Now click the image in the Arrivals
Then Test whether it is navigating to next page where the user can add that book into his basket.
And Image should be clickable and shoul navigate to next page where user can add that book to his basket
When Click on the Add To Basket button which adds that book to your basket
Then User can view that Book in the Menu item with price.
When Now click on Item link which navigates to proceed to check out page.
Then User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page

Scenario: Add to Basket-Items-Coupon value <450
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on Shop Menu
And  Now click on Home menu button
And Test whether the Home page has Three Arrivals only
Then The Home page must contains only three Arrivals
When Now click the image in the Arrivals
Then Test whether it is navigating to next page where the user can add that book into his basket.
And Image should be clickable and shoul navigate to next page where user can add that book to his basket
When Click on the Add To Basket button which adds that book to your basket
Then User can view that Book in the Menu item with price.
When Now click on Item link which navigates to proceed to check out page.
When Enter the Coupon code as "krishnasakinala" to get 50rps off on the total.
Then  User can not able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price because the coupon is applicable for the book price > 450 rps

Scenario: Add to Basket-Items-Remove book
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on Shop Menu
And  Now click on Home menu button
And Test whether the Home page has Three Arrivals only
Then The Home page must contains only three Arrivals
When Now click the image in the Arrivals
Then Test whether it is navigating to next page where the user can add that book into his basket.
And Image should be clickable and shoul navigate to next page where user can add that book to his basket
When Click on the Add To Basket button which adds that book to your basket
Then User can view that Book in the Menu item with price.
When Now click on Remove this icon in Check out page which removes that book from the grid.
Then User has the feasibility to remove the book at the time of check out also

Scenario: Add to Basket-Items-Check-out-Update Basket
Given Open the browser
When Enter the URL "http://practice.automationtesting.in/"
And Click on Shop Menu
And  Now click on Home menu button
And Test whether the Home page has Three Arrivals only
Then The Home page must contains only three Arrivals
When Now click the image in the Arrivals
Then Test whether it is navigating to next page where the user can add that book into his basket.
And Image should be clickable and shoul navigate to next page where user can add that book to his basket
When Click on the Add To Basket button which adds that book to your basket
Then User can view that Book in the Menu item with price.
When Click on textbox value under quantity in Check out page to add or subtract books.
When Now click on Update Basket to reflect those changes
Then User has the feasibility to Update Basket at the time of check out.

