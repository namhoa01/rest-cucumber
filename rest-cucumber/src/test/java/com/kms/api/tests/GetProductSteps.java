package com.kms.api.tests;

import com.kms.api.model.LaptopBag;
import com.kms.api.requests.RequestFactory;
import com.kms.api.util.ValidationUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static com.kms.api.util.RestUtil.mapRestResponseToPojo;

public class GetProductSteps extends TestBase {

  private String path = "";
  private Response res;
  private LaptopBag resAddLaptop;

  @Given("^the path \"([^\"]*)\" to the endpoint of getting request$")
  public void thePathToGetTheProduct(String path) {
    this.path = path;
  }

  @When("^I perform request to get a product$")
  public void iPerformTheRequestToApplication() {
    res = RequestFactory.getProduct(path, String.valueOf(id));
    resAddLaptop = mapRestResponseToPojo(res, LaptopBag.class);
  }

  @Then("^the status code \"([^\"]*)\" should return for getting request$")
  public void theStatusCodeShouldReturn(String statusCode) {
    ValidationUtil.validateStatusCode(res, Integer.parseInt(statusCode));
  }
  @And("^the product is returned successfully with the provided Id$")
  public void theProductIsReturnedSuccessfullyWithTheProvidedId() {
    ValidationUtil.validateStringEqual(resAddLaptop.getId(), id);
  }
}
