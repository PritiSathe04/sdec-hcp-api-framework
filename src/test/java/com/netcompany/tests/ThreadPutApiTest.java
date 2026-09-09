package com.netcompany.tests;

import com.netcompany.pages.ThreadPutApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadPutApiTest {
    @ParameterizedTest
    @CsvSource({
            "THREAD-002, 200"
    })
    void verifyPutThreadResponse(String toUpdate, int expectedResponseCode) throws IOException {

        String url = "http://127.0.0.1:8080/v1/dummy/UpdateThread/";

        String requestBody = Files.readString(
                Paths.get(
                        "src/test/resources/features/jsonSchema/Requests/UpdateThreadRequest.json"
                )
        );

        ThreadPutApi threadPutApi = new ThreadPutApi();
        HttpResponse<String> response =
                threadPutApi.putApiCallToThread(url + toUpdate, requestBody);

        assertEquals(expectedResponseCode, response.statusCode());
        assertEquals(toUpdate + "  updated", response.body());
    }
}