package com.kms.api.requests;

import com.kms.api.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;
import java.util.logging.Logger;

public class RequestFactory extends TestBase {

  private static final Logger logger = Logger.getLogger(String.valueOf(RequestFactory.class));

  /**
   * Send request to create a new product
   *
   * @param requestPayload
   * @return Response of the request
   */
  public static Response addProduct(String path, Object requestPayload) {
    logger.info("Adding new product.");
    Response res = RestClient.doPostRequestWithPayload(path, ContentType.JSON, requestPayload);
    logger.info(String.format("The request for adding the product completed"));
    return res;
  }

  /**
   * Send request to get a product
   *
   * @param productId
   * @return Response of the request
   */
  public static Response getProduct(String path, String productId) {
    logger.info("Get a product.");
    Map<String, String> params = Map.of("id", productId);
    Response res = RestClient.doGetRequestWithParams(path, params, ContentType.JSON);
    logger.info(String.format("The request for getting the product completed"));
    return res;
  }

  /**
   * Send request to update an existing product
   *
   * @param requestPayload
   * @return Response of the request
   */
  public static Response updateProduct(String path, Object requestPayload) {
    logger.info("Updating a product.");
    Response res = RestClient.doPutRequestWithPayload(path, ContentType.JSON, requestPayload);
    logger.info(String.format("The request for updating the product completed"));
    return res;
  }

  /**
   * Send request to update an existing product
   *
   * @param path
   * @return Response of the request
   */
  public static Response deleteProduct(String path, String productId) {
    logger.info("Delete an existing product.");
    Map<String, String> params = Map.of("id", productId);
    Response res = RestClient.doDeleteRequestWithParams(path, params);
    logger.info(String.format("The request for deleting the product completed"));
    return res;
  }
}
