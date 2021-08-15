Feature: 
	As a Product owner
	I want to check that customers can check the status of an order and cancel an order
	
	Scenario:
		Given a pet order is retrieved with order Id <orderId>
		When the order is cancelled <orderId>
		And the cancellation status is confirmed
		Then the oder no longer exists <orderId>
		Examples: 
    |orderId|
    |99			|