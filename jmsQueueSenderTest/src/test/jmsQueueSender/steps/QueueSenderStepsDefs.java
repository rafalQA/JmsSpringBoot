package jmsQueueSender.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;
import jmsQueueSender.consumer.ItemListener;
import jmsQueueSender.model.Item;
import jmsQueueSender.validator.ItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;
import org.unitils.reflectionassert.ReflectionAssert;

import static io.restassured.RestAssured.given;

/**
 * Created by rpiotrowicz on 2017-02-27.
 */

public class QueueSenderStepsDefs extends CucumberSteps {

    @Autowired
    private ItemListener consumer;
    @Autowired
    @Qualifier("input")
    private Item inputItem;
    @Autowired
    private ItemValidator itemValidator;
    @Autowired
    private RequestSpecification spc;

    @Given("^I have item$")
    public void iHaveItem() throws Throwable {
        itemValidator.validate(inputItem);
    }

    @When("^I send it to jmsQueueSender$")
    public void iSendItToJmsQueueSender() throws Throwable {
        int statusCode = given().spec(spc)
                .body(inputItem)
                .put("/items")
                .getStatusCode();

        Assert.isTrue(statusCode == 200, "Not OK response from application");
    }

    @Then("^item is on queue$")
    public void itemIsOnQueue() throws Throwable {
        Item message = consumer.getItem();

        ReflectionAssert.assertReflectionEquals(inputItem, message);
    }
}
