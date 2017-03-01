package jmsQueueSender;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by rpiotrowicz on 2017-02-27.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
public class CucumberTests {
}
