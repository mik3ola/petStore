package api_tests;

import org.testng.annotations.Test;

public class TestSteps extends EndpointParent {
	EndpointParent storeApi = new EndpointParent();
	
	@Test(description ="When a pet order is submitted, the api confirms status via status code.")
	public void orderPet() {
		storeApi.setPath("/store/order");
		storeApi.post(orderId);
		// status code should output 201 and not 200. Api code irregularity noticed
		storeApi.checkStatusCode(200);
	}

	@Test(description ="Get order details through order Id.")
	public void getOrder() {
		storeApi.setPath("/store/order/"+orderId);
		storeApi.get();
		storeApi.checkStatusCode(200);
	}
	
	@Test(description ="Delete an existing order and verify action status code")
	public void deleteOrder() {
		storeApi.setPath("/store/order/"+orderId);
		storeApi.delete();
		// status code should output 204 and not 200. Api code irregularity noticed
		storeApi.checkStatusCode(200);
	}
}