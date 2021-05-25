@login
Feature: Swag Labs Login feature
  I want to validate Swag Labs login functionality

  @success
  Scenario: As a user I want to validate successful login
    Given I navigate to Swag Labs website
    When I enter username as "standard_user"
    And password as "secret_sauce"
    And I click on Login button
    Then I should be able to login successfully

  @failure
  Scenario Outline:  As a user I want to validate error messages for wrong login credentials
    Given I navigate to Swag Labs website
    When I enter username as "<userName>"
    And password as "<password>"
    And I click on Login button
    Then I should see error message as "<errorMessage>"
  Examples: 
      | 	userName  	 |   password   | 									errorMessage  														 |
      |     empty      | secret_sauce | 						Username is required 						 	  						 |
      | standard_user  |    empty     | 					 	Password is required  													 |
			|  username123   |  password123 | Username and password do not match any user in this service  |
			| locked_out_user|  secret_sauce| 					Sorry, this user has been locked out.						   |