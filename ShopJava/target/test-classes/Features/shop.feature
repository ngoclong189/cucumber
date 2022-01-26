Feature: check function of shop

  Scenario: shop-filter by price functionaly
    Given Open the browser
    When Enter the URL "http://practice.automationtesting.in/"
    And Click on Shop Menu
    And Adjust the filter by price between 150 to 450 rps
    And Now click on Filter button
    Then User can view books only between 150 to 450 rps price

  Scenario: Shop-Product Categories Functionality
    Given Open the browser
    When Enter the URL "http://practice.automationtesting.in/"
    And Click on Shop Menu
    And Click any of the product links available in the product category
    Then Now user can view only that particular product

  Scenario: Shop-Default Sorting by Popularity Functionality
    Given Open the browser
    When Enter the URL "http://practice.automationtesting.in/"
    And Click on Shop Menu
    And Click on Sort by Popularity item in Default sorting dropdown
    Then Now user can view the popular products only

  Scenario: Shop-Default Sorting by Average Functionality
    Given Open the browser
    When Enter the URL "http://practice.automationtesting.in/"
    And Click on Shop Menu
    And Click on Sort by Average ratings in Default sorting dropdown
    Then Now user can view the popular products only

  Scenario: Shop-Default Sorting by Newness  Functionality
    Given Open the browser
    When Enter the URL "http://practice.automationtesting.in/"
    And Click on Shop Menu
    And Click on Sort by Newness ratings in Default sorting dropdown
    Then Now user can view the popular products only

  Scenario: Shop-Default Sorting by Low to High Functionality
    Given Open the browser
    When Enter the URL "http://practice.automationtesting.in/"
    And Click on Shop Menu
    And Click on Sort by Low to High Item  in Default sorting dropdown
    Then Now user can view the popular products only

  Scenario: Shop-Default Sorting by High to Low Functionality
    Given Open the browser
    When Enter the URL "http://practice.automationtesting.in/"
    And Click on Shop Menu
    And Click on Sort by High to Low Item  in Default sorting dropdown
    Then Now user can view the popular products only

  Scenario: Shop-Add to Basket-View Basket Functionality
    Given Open the browser
    When Enter the URL "http://practice.automationtesting.in/"
    And Click on Shop Menu
    And Click on the Add To Basket button which adds that book to your basket
    Then User can view that Book in the Menu item with price.
    When Now click on View Basket link which navigates to proceed to check out page.
    When Now user can find total and subtotal values just above the Proceed to Checkout button.
    Then The total always smaller than subtotal because taxes are added in the subtotal
    When Now click on Proceed to Check out button which navigates to payment gateway page.
    Then User can view Billing Details,Order Details,Additional details and Payment gateway details.
    When Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
    When Now click on Place Order button to complete process
    Then On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.
