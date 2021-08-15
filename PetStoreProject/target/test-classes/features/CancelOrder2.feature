Feature: 
	As a Product owner
	I want to check that customers can check the status of an order and cancel an order
	
	Scenario:
		Given a pet order <orderId> is retrieved
		When the order is cancelled
		And the cancellation status is confirmed
		Then the oder no longer exists
		Examples: 
    |orderId|
    |				|