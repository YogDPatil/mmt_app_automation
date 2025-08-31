Feature: User login to the mmt app

  @login
  Scenario: validate user login to the app using valid cred
    Given user is on login page
    When user enters valid login cred
    Then user should login successfully
