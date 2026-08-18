package com.netcompany.steps;

import com.netcompany.pages.ThreadGetApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ThreadGetSteps {
    private final ThreadGetApi threadGetPage = new ThreadGetApi();

    @Given("I make a get api call to {string}")
    public void iMakeAGetApiCallTo(String url) {
        threadGetPage.getApiCallToThread(url);
    }

    @Then("I verify the response code is {string}")
    public void iVerifyTheResponseCodeIs(String responseCode) {
        threadGetPage.verifyResponseCode(responseCode);
    }
}
