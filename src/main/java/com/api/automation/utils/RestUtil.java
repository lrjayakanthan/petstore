package com.api.automation.utils;

import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static com.api.automation.helper.Constants.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.File;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class RestUtil {

	public static Response PostJSONRequest(String strWSURL, String strJSONRequest) {
		return given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(strJSONRequest)
				.when()
				.post(strWSURL);
	}

	public static Response PutJSONRequest(String strWSURL, String strJSONRequest) {
		return given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(strJSONRequest)
				.when()
				.put(strWSURL);
	}

	public static Response GetJSONRequest(String wsURL) {
		return given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.get(wsURL);
	}

	public static Response OptionsRequest(String strWSEndpoint) {
		return given()
				.options(strWSEndpoint);
	}

	public static String getResponseData(String path, String apiResponse) {
		JsonPath response = new JsonPath(apiResponse);
		return response.getString(path);
	}
	
}
