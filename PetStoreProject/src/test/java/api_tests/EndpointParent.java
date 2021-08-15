package api_tests;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import static com.jayway.restassured.RestAssured.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EndpointParent {
	
	String orderId;
	protected Response response;
	protected ValidatableResponse validatableResponse;
	protected String baseUri = "https://petstore.swagger.io/v2";
	protected String path;
    protected RequestSpecification requestSpecification;
    protected JSONObject requestBodyJson;
//  protected JSONObject responseBodyJson;
    static DateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss.SSSZ");
    Date date = Calendar.getInstance().getTime(); 
	protected String today = df.format(date);
    
    public void setPath(String pathVar) {
    	this.path = pathVar;
    }

	public void checkStatusCode(int expectedStatusCode) {
        this.validatableResponse.statusCode(expectedStatusCode);
    }

    public void setUpRequestSpec() {
        this.requestSpecification =
                given().baseUri(this.baseUri).basePath(this.path);
    }

    public void createRequestSpec() {
        // Subclasses should set path, then create the request spec.
    	
        this.setUpRequestSpec();
    }
    
    public void get() {
    	this.createRequestSpec();
        this.response = this.requestSpecification.when().get();
        this.validatableResponse = this.response.then().log().all();

    }

    public void post(String orderId) {
        //TODO: consider putting requestBodyJson and Content-Type steps in createRequestSpec() method.
    	this.createRequestSpec();
        this.requestBodyJson = new JSONObject()
                .put("id", orderId)
                .put("petId", 101)
                .put("quantity", 1)
                .put("shipDate", "2021-08-14T17:10:53.148Z")
                .put("status", "placed")
                .put("complete", true);
        this.requestSpecification
                .header("Content-Type", "application/json")
                .body(this.requestBodyJson.toString());
        this.response = this.requestSpecification.when().post();
        this.validatableResponse = this.response.then().log().all();
    }

	public void delete() {
    	this.createRequestSpec();
        this.response = this.requestSpecification.when().delete();
        this.validatableResponse = this.response.then().log().all();
    }
    
}
