
Feature: Pick the items in Delivery and load the Delivery into the truck

  @PicingSevenItemsAndLoadPositiveflow
  Scenario Outline: pick the Picker1SevenItemsAndLoad
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to PickerSevenItems
#    And moving remaining items to pick list
    Then verify Items picked or not
    And Logout the user from Picker application

    Given Enter username "<username>" and password "<password>" to login to the picker application
    And Verify that User is in PWP application's Home Page
    And Click on Loader Module to perform Loading operations
    And Verify that Loader is in Loader Page
    When Get the delivery number to load the Delivery into the truck
    And Search the delivery in a Loader Page
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Logout the user from Loader application
    Examples:
      | username   | password   |
#      | 9000680178 | Sweety123@ |
    | 101203   | Dmart@12345 |
#===================================================================================================================
  @PickerOneDeliveryTwoHUsAndLoad
 Scenario Outline: One Delivery Two HUs
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList one HU
    And user verify the items one By One  and move to pickList Second HU
    Then verify Items picked or not In Two HUs
    And Logout the user from Picker application
#    And Logout the user from application

    Given Enter username "<username>" and password "<password>" to login to the picker application
    And Verify that User is in PWP application's Home Page
    And Click on Loader Module to perform Loading operations
    And Verify that Loader is in Loader Page
    When Get the delivery number to load the Delivery into the truck
    And Search the delivery in a Loader Page
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Logout the user from Loader application
    Examples:
      | username   | password   |
#      | 9000680178 | Sweety123@ |
    | 101203   | Dmart@12345 |
#  ===================================================================================================================
  @PickerInvalidQunatityAndLoad
  Scenario Outline: pick the items with invalid quantity
    Given Enter username "<username>" and password "<password>" to login to the picker application
    When user verify the items one By One  and move to pickList with invalid Quantity
      | ShortItem   | Short   |
      | DamagedItem | Damaged |
    And moving remaining items to pick list for invalid Quantity
      | ShortItem   | Short   |
      | DamagedItem | Damaged |
    Then verify Items picked or not with invalid Quantity
#    And Logout the user from Picker application
    And Logout the user from application

    Given Enter username "<username>" and password "<password>" to login to the picker application
    And Verify that User is in PWP application's Home Page
    And Click on Loader Module to perform Loading operations
    And Verify that Loader is in Loader Page
    When Get the delivery number to load the Delivery into the truck
    And Search the delivery in a Loader Page
    And Click on Delivery Card
    And Verify that loader is in Delivery Details Page
    And Load the HUs into the truck
    And Confirm the loading
    Then Verify that loading operation is completed
    And Logout the user from Loader application
    Examples:
      | username   | password   |
#      | 9000680178 | Sweety123@ |
      | 101203   | Dmart@12345 |




