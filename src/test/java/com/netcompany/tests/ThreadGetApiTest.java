package com.netcompany.tests;

import com.netcompany.pages.ThreadGetApi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ThreadGetApiTest {

    @Test
    void verifyGetThreadResponseCode() {

        String url = "http://127.0.0.1:8080/v1/dummy/THREAD-002";
        int expectedResponseCode = 200;

        ThreadGetApi threadGetApi = new ThreadGetApi();

        int actualResponseCode = threadGetApi.getApiCallToThread(url);

        assertEquals(
                expectedResponseCode,
                actualResponseCode,
                "Expected response code: " + expectedResponseCode
                        + ", but actual response code was: " + actualResponseCode
        );
    }

    @Test
    void verifyGetThreadResponseCodeNonExistentThread() {

        String url = "http://127.0.0.1:8080/v1/dummy/TEST-999";
        int expectedResponseCode = 204;

        ThreadGetApi threadGetApi = new ThreadGetApi();

        int actualResponseCode = threadGetApi.getApiCallToThread(url);

        assertEquals(
                expectedResponseCode,
                actualResponseCode,
                "Expected response code: " + expectedResponseCode
                        + ", but actual response code was: " + actualResponseCode
        );
    }
}
