Feature: Send on queue

  Scenario: Send item to jms broker queue
    Given I have item
    When I send it to jmsQueueSender
    Then item is on queue