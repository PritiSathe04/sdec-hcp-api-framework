package com.netcompany.tests;

import com.netcompany.pages.ThreadPutApi;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadPutApiTest {
    @Test
    void verifyPutThreadResponse() throws IOException {
        String url = "http://127.0.0.1:8080/v1/dummy/UpdateThread/";
        String toUpdate = "THREAD-001";

        String requestBody = Files.readString(
                Paths.get(
                        "src/test/resources/features/jsonSchema/Requests/UpdateThreadRequest.json"
                )
        );

        ThreadPutApi threadPutApi = new ThreadPutApi();
        HttpResponse<String> response = threadPutApi.putApiCallToThread(url+toUpdate,requestBody);

        int expectedResponseCode = 200;
        assertEquals(expectedResponseCode,response.statusCode());
        assertEquals(toUpdate+"  updated",response.body());

    }
}
