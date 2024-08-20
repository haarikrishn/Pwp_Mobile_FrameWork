Feature: Verify the functionality of poss login page

  Background: login to the application
    Given Verify that User is in poss application's Home Page after login
      | userName | password |
      | 1234     | 321      |

  @poss_Wails_FlowOneTime
  Scenario Outline: launch the poss application
#    Given Verify that User is in poss application's Home Page after login
#      | userName | password |
#      | 1234     | 321      |
    And add required cash to cash counter
      | OpenCashcouterBalance |
      | 3000                  |
    When add items to items details page "<eanNumber>"
    And After entering items details add payment details "<PaymentType>"
    And after payment click on new terminal

    Examples:
      | eanNumber  | PaymentType |
      | 1000097663 | Cash        |
#      | 1001340751 | Cash        |
#
##==================================================================================
  @poss_Wails_Flow_Multiple
  Scenario Outline: launch the poss application
    And add required cash to cash counter
      | OpenCashcouterBalance |
      | 3000                  |
    When add items to items details page  for multiple payments
      | eanNumber  |
      | 1000097663 |
      | 1000098691 |
      | 1000098660 |
      | 1000098677 |
      | 1000098684 |
    And Add all Required payment types to arrayList
      | PaymentType |
      | Cash        |
      | Card        |
      | Cheque      |
      | Upi         |

    And After entering items details add payment details "<PaymentType>" for multiple payments
    And after payment click on new terminal for multiple apyments

    Examples:
      | PaymentType |
      | Cash        |
      | Card        |
#      | Cheque      |
#      | Upi         |


  @poss_Wails_FlowExcel
  Scenario Outline: launch the poss applicatio
    And add required cash to cash counter
      | OpenCashcouterBalance |
      | 3000                  |
    And Add all Required payment types to arrayList
      | PaymentType |
      | Cash        |
      | Card        |
      | Cheque      |
      | Upi         |
    And enter itemdetails payment details after payment click  on new using excel "<SheetName>" "<requiredTasks>" "<PamentType>" "<excelFile>"
    Examples:
      | excelFile     | SheetName | requiredTasks | PamentType |
      | Possdata.xlsx | ReadData  | 5             | Cash       |
      | Possdata.xlsx | ReadData  | 5             | Cash       |

  @poss_Wails_FlowDataTable
  Scenario: launch the poss application usin data table
    And add required cash to cash counter
      | OpenCashcouterBalance |
      | 5000                  |
    And Add all Required payment types to arrayList
      | PaymentType |
      | Cash        |
      | Card        |
      | Cheque      |
      | Upi         |
    And enter itemdetails payment details after payment click  on new using data table
      | excelFile     | SheetName | requiredTasks | PamentType |
      | Possdata.xlsx | ReadData  | 2             | Cash       |
#      | Possdata.xlsx | ReadData  | 2             | Card       |
#      | Possdata.xlsx | ReadData  | 2             | Cheque     |
#      | Possdata.xlsx | ReadData  | 2             | Upi        |
#      | Possdata.xlsx | ReadData  | 2             | Cash       |
#      | Possdata.xlsx | ReadData  | 2             | Cash       |
#      | Possdata.xlsx | ReadData  | 2             | Cash       |
#      | Possdata.xlsx | ReadData  | 2             | Cash       |
#      | Possdata.xlsx | ReadData  | 2             | Cash       |


#  =================================================================================================================
  @poss_Wails_FlowPractise
  Scenario: launch the poss application usin data table
    And add required cash to cash counter using practise method
      | OpenCashcouterBalance |
      | 5000                  |
    And Add all Required payment types to arrayList using practise method
      | PaymentType |
      | Cash        |
      | Card        |
      | Cheque      |
      | Upi         |
    And enter itemdetails payment details after payment click  on new using data table practise method
      | excelFile     | SheetName | requiredTasks | PamentType |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Card       |
      | Possdata.xlsx | ReadData  | 1             | Cheque     |
      | Possdata.xlsx | ReadData  | 1             | Upi        |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |
#      | Possdata.xlsx | ReadData  | 1             | Cash       |