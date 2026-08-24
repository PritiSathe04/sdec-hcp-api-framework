package com.netcompany.tests;

import com.netcompany.pages.ThreadPostApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadPostApiTest {

    @ParameterizedTest
    @ValueSource(ints = {201})
    void verifyPostThreadResponseCode(int expectedResponseCode) throws IOException {

        String url = "http://127.0.0.1:8080/v1/dummy/create-thread";

        String requestBody = Files.readString(
                Paths.get(
                        "src/test/resources/features/jsonSchema/Requests/CreateThreadRequest.json"
                )
        );

        ThreadPostApi threadPostApi = new ThreadPostApi();

        int actualResponseCode =
                threadPostApi.postApiCallToThread(url, requestBody);

        assertEquals(
                expectedResponseCode,
                actualResponseCode
        );
    }

}
