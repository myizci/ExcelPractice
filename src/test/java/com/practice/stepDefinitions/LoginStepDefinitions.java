package com.practice.stepDefinitions;

import io.cucumber.java.en.*;


public class LoginStepDefinitions {
    @Given("user in on the login page")
    public void user_in_on_the_login_page() {
        System.out.println("I am on the login page");
    }
    @When("user logs in as a store manager")
    public void user_logs_in_as_a_store_manager() {
        System.out.println("I login as a manager");
    }
    @Then("user should be able to see Dashboard page title")
    public void user_should_be_able_to_see_dashboard_page_title() {

        System.out.println("I see the Dsshboard");
    }

}
