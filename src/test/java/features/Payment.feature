Feature: Validating E2E payment Scenario
  @makePayment
  Scenario: Verify if user able to make bill payment to receiver
    Given user calls "generateUserInfoAPI" with "Get" http request to generate "sender" info
    And User is on Parabank Landing page
    When Register user on Parabank site
    And user calls "generateUserInfoAPI" with "Get" http request to generate "receiver" info
    Then user make payment to sender


	 


	

	
	
	
	
	
	

	
	
	