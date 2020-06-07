Feature: Validate Login Service

  @SmokeTest
  Scenario: To validate the new pet creation in pet service
    Given I submit a request to create a new pet with below details
    """
    {
  "id": 100,
  "category": {
    "id": 0,
    "name": "dog"
  },
  "name": "harry",
  "status": "available"
}
    """
    Then The status of the create pet response should be 200
    When I find the crated pet by id 100 from pet service
    Then I validate the response code should be 200 for find by pet id service
    And I validate the find by pet id service response should have below data
    """
    {"id":100,"category":{"id":0,"name":"dog"},"name":"harry","photoUrls":[],"tags":[],"status":"available"}
    """
    When I update the status of the existing pet given below
    """
    {
  "id": 100,
  "category": {
    "id": 0,
    "name": "dog"
  },
  "name": "harry",
  "status": "sold"
}
    """
    Then I validate the response code should be 200 for update pet

  @SmokeTest
  Scenario: Search for Pet id which is not available
    When I find the crated pet by id 1001 from pet service
    Then I validate the response code should be 404 for find by pet id service
    And I validate the find by pet id service response should have below data
    """
    {"code":1,"type":"error","message":"Pet not found"}
    """

  @SmokeTest
  Scenario: Invalid input to create pet service
    Given I submit a request to create a new pet with below details
    """
    {
        "test": "test"
     }
    """
    Then The status of the create pet response should be 405

  @SmokeTest
  Scenario: Updating an unavailable pet id
    When I update the status of the existing pet given below
        """
        {
          "id": 10001,
          "category": {
            "id": 0,
            "name": "dog"
          },
          "name": "harry",
          "status": "sold"
        }
        """
    Then I validate the response code should be 404 for update pet

    @SmokeTest
    Scenario: Validate the findbyStatus service for valid status values
      When I search for pets that are "available" status from findByStatus service
      Then The response code should be 200 for findByStatus service
      When I search for pets that are "pending" status from findByStatus service
      Then The response code should be 200 for findByStatus service
      When I search for pets that are "sold" status from findByStatus service
      Then The response code should be 200 for findByStatus service
      When I search for pets that are "available,pending,sold" status from findByStatus service
      Then The response code should be 200 for findByStatus service
      When I search for pets that are "available,pending" status from findByStatus service
      Then The response code should be 200 for findByStatus service

    @SmokeTest
    Scenario: Validate the findbyStatus service for invalid status values
      When I search for pets that are "onhold" status from findByStatus service
      Then The response code should be 400 for findByStatus service