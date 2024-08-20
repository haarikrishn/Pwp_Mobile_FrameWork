Feature: Verify the functionality of poss login page

  Background: login to the application
    Given Verify that User is in poss application's Home Page after login
      | userName | password |
      | 1234     | 321      |

  @poss_Wails_FlowDataTable
  Scenario: launch the poss application using data table
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
      | Possdata.xlsx | ReadData  | 50            | Cash       |
      | Possdata.xlsx | ReadData  | 50            | Card       |
      | Possdata.xlsx | ReadData  | 50            | Cheque     |
      | Possdata.xlsx | ReadData  | 50            | Upi        |
