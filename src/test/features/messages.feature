#Author: Izertis
#Keywords Summary : event-processor
Feature: Sent messages between Management-System and Triple-Store-Adapter

  Scenario: one message is sent by Management-System and the Event-processor catches it sending again for Triple-Store-Adapter
    Given a new message in managementdata queue
    Then the Event-processor sends the new message against Triple-Store-Adapter
