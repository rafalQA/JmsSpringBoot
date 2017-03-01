package jmsQueueSender.steps;

import cucumber.api.junit.Cucumber;
import jmsQueueSender.config.DefaultConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by rpiotrowicz on 2017-02-27.
 */
@RunWith(Cucumber.class)
@ContextConfiguration(classes = DefaultConfig.class)
class CucumberSteps {
}
