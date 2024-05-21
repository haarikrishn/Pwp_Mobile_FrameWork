Feature: Verify the functionality of Loader Module

  Background: Login to PWP Application and go to Loader Page
    Given Provide username and password to login to application
      | userId   | 101203      |
      | password | Dmart@12345 |
    And Verify that User is in PWP application's Home Page after login
    And Click on Loader Module to perform Loading operations

#  @load
  Scenario: Load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 952132149 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Logout the user from Loader application

#  @load
  Scenario: Search Delivery and Load the delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9831762446 |
    And Search the delivery in a Loader Page
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
#    And Logout the user from Loader application

#  @load
  Scenario: Remove the item from HU and load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9191355316 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Adjust the item's caselot in HU
      | itemName      | Grace Deep Impact Shower Gel 250m |
      | removeCaselot | 1                                 |
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm the loading
    Then Verify that loading operation is completed

#  @load
  Scenario: Load some of the HUs in the delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9347689470 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide HU number not to be loaded and load the remaining HUs into the truck
      | HU 3000100639 |
    And Confirm the partially loaded HU delivery
    Then Verify that loading operation is completed

#  @load
  Scenario: Load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9970654834 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm the loading
    Then Verify that loading operation is completed

#  @load
  Scenario: Consolidate HUs and load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9348268100 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Click on CONSOLIDATE button
    And Provide source HU Number
      | sourceHUNumber | 3000100683 |
    And In Consolidate HU Page click on select all checkbox
    And Click on MOVE button
    And Provide the destination HU number
      | destinationHUNumber | 3000100684 |
    And Verify that Confirm Move Item page is displayed and click on OK button
    And Verify that loader is in Delivery Details Page
    And Verify that HU is empty
    And Load the HUs into the truck
    And Confirm the loading
    Then Verify that loading operation is completed

#  @load
  Scenario: Load all the Deliveries into trucks
    And Verify that Loader is in Loader Page
    When Load all the deliveries into the truck

#  @load
  Scenario: Remove the item from HU and load the Delivery into a truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 9191355316 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Adjust the item's caselot in HU 1
      | itemName                           | removeCaselot |
      | Colgate Maxfresh Blue Gel Tp(300g) | 1             |
      | Grace Deep Impact Shower Gel 250m  | 1             |
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm the loading
    Then Verify that loading operation is completed

  @BOX
  Scenario: Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 953468753 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed

  @BOX
  Scenario: Load BOX type delivery into the truck
    And Verify that Loader is in Loader Page
    When Provide the delivery number of a Delivery for which Loading Operation is to be performed
      | deliveryNumber | 953468753 |
    And Verify the dispatch type of a delivery
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Provide the Exceptions for items in a delivery
      | items |  |  |  |
    And Load the HUs into the truck
    And Confirm Box type delivery loading
    Then Verify that Box type delivery loading operation is completed

