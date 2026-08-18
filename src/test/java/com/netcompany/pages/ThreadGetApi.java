package com.netcompany.pages;

import static io.restassured.RestAssured.given;


import static org.testng.Assert.assertEquals;


public class ThreadGetApi {
    private int actualResponseCode;
    public void getApiCallToThread(String url)
    {
        actualResponseCode = given()
                .when()
                .get(url)
                .getStatusCode();

        System.out.println("GET URL: " + url);
        System.out.println("Response Code: " + actualResponseCode);
    }

    public void verifyResponseCode(String responseCode) {
        int expectedCode = Integer.parseInt(responseCode);

        assertEquals(
                expectedCode,
                actualResponseCode,
                "Expected response code: " + expectedCode +
                        ", but actual response code was: " + actualResponseCode
        );
    }
}