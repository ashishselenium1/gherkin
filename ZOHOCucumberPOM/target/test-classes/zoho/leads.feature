#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Leads
Feature: Managing Leads
  Creation and Deletion of Leads

  Background: Logged In
  Given I am logged in zoho.com
  And I click on 'Leads' in top menu
    
    
  @CreateLead
  Scenario Outline: Creation of a Lead
    When I go to 'create lead' page
    And enter and submit lead details 
    Then I go to 'leads detail' page
    And I verify lead details
    When I click on 'Leads' in top menu
    Then Lead should be present inside the grid
    Examples: 
      | FirstName  | LastName | Email  | Company |
      | name1      |     5 | success |  |
      
    

  @DeleteLead
  Scenario Outline: Deletion of the lead
    When I select the lead
    And I click on delete button
    Then lead should be deleted

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
