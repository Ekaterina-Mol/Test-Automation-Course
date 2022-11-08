Feature: As a user
  I want to get ability to use menu sections
  So that I can see context menu specific for each menu item

  Scenario Outline: Auto flea market menu item has appropriate context menu
    Given the user opens Onliner main page
    When the user hovers "<menuItem>" menu item
    Then context menu with categories is displayed

    Examples:
   |menuItem|
   |Автобарахолка|
   |Дома и квартиры|