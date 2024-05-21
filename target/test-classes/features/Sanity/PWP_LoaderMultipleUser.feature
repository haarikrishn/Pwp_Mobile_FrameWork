Feature: Verify the functionality of Loader with Multiple User for same delivery

  Background: Login to PWP Application and go to Loader Page
    Given Provide username and password to login to application
      | userId   | 101203      |
      | password | Dmart@12345 |
    And Verify that User is in PWP application's Home Page after login
    And Click on Loader Module to perform Loading operations

  @Loader1
  Scenario: Perform loading of same delivery by 1st loaders at same time
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9287470682 |
    And Search the delivery in a Loader Page
    And Click on Delivery Card
    And Wait for 1 minutes
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm the loading

  @Loader2
  Scenario: Perform loading of same delivery by 2nd loaders at same time
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9287470682 |
    And Search the delivery in a Loader Page
    And Click on Delivery Card
    And Wait for 3 minutes
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm the loading
    And Verify that Error Message is displayed
#    And Provide HUs to be loaded into the truck
#      | HU Numbers |
#    And Confirm the loading
#    And Verify that loading operation is completed
#    Then Search the delivery in a Loader Page
#    And Click on Delivery Card
#    And Load remaining HUs
#    And Verify that loading operation is completed
#    And Logout the user from Loader application

