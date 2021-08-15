Feature: 
	As a Product owner
	I want to check that customers can place an order and check the status of the order
	
	Scenario:
		Given a pet order is placed with order Id <orderId>
		When the order status is verified
		Then the order confirmation can be viewed <orderId>
		Examples: 
    |orderId|
    |99			|