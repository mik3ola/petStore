package stepDefs;

import api_tests.EndpointParent;
import io.cucumber.java.en.*;

public class UserPetStoreSteps extends EndpointParent {
	EndpointParent storeApi = new EndpointParent();
	
	@Given("a pet order is placed with order Id (.*)$")
	public void a_pet_order_is_placed_with_order_id(String orderId) {
		storeApi.setPath("/store/order");
		storeApi.post(orderId);
	}

	@When("the order status is verified")
	public void the_order_status_is_verified() {
		storeApi.checkStatusCode(200);
	}

	@Then("the order confirmation can be viewed (.*)$")
	public void the_order_confirmation_can_be_viewed(String orderId) {
		storeApi.setPath("/store/order/"+orderId);
		storeApi.get();
	}
	
	@Given("^a pet order is retrieved with order Id (.*)$")
	public void a_pet_order_is_retrieved_with_order_id(String orderId) {
		storeApi.setPath("/store/order/"+orderId);
		storeApi.get();
	}

	@When("^the order is cancelled (.*)$")
	public void the_order_is_cancelled(String orderId) {
		storeApi.setPath("/store/order/"+orderId);
		storeApi.delete();
	}

	@When("the cancellation status is confirmed")
	public void the_cancellation_status_is_confirmed() {
		storeApi.checkStatusCode(200);
	}

	@Then("^the oder no longer exists (.*)$")
	public void the_oder_no_longer_exists(String orderId) {
		storeApi.setPath("/store/order/"+orderId);
		storeApi.get();
	}

}
