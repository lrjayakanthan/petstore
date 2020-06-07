package com.api.automation.steps;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.api.automation.tests.PetService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.json.JSONException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class PetServiceSteps {

	@Steps
	PetService petService;
	
	Logger logger = Logger.getLogger(PetServiceSteps.class.getName());;
	Response petServiceResponse = null;
	Response findByPetIdResponse = null;
	Response updatePetResponse = null;
	Response  findByStatusResponse = null;

	@Given("^I submit a request to create a new pet with below details$")
	public void createPet(String petData){
		petServiceResponse = petService.createPet(petData);
	}

	@Then("^The status of the create pet response should be (\\d+)$")
	public void validateResponseForCreatePet(int expectedStatusCode){
		Assert.assertEquals(expectedStatusCode,petServiceResponse.getStatusCode());
	}

	@When("^I find the crated pet by id (\\d+) from pet service$")
	public void findByPetId(int petId){
		findByPetIdResponse = petService.findByPetId(petId);
	}

	@Then("^I validate the response code should be (\\d+) for find by pet id service$")
	public void validateResponseForFindByPetId(int expectedStatusCode){
		Assert.assertEquals(expectedStatusCode,findByPetIdResponse.getStatusCode());
	}

	@And("^I validate the find by pet id service response should have below data$")
	public void validateResponseData(String expectedData){
		System.out.println(findByPetIdResponse.body().asString());
		Assert.assertEquals(expectedData,findByPetIdResponse.body().asString());
	}

	@When("^I update the status of the existing pet given below$")
	public void updateExistingPet(String dataToUpdate){
		updatePetResponse = petService.updateExistingPet(dataToUpdate);
	}

	@Then("^I validate the response code should be (\\d+) for update pet$")
	public void validateStatusCodeForUpdate(int expectedStatusCode){
		Assert.assertEquals(expectedStatusCode,updatePetResponse.getStatusCode());
	}

	@When("^I search for pets that are \"(.*?)\" status from findByStatus service$")
	public void findByStatusStep(String statusToFind){
		findByPetIdResponse = petService.findByStatus(statusToFind);
		System.out.println(findByPetIdResponse.asString());
	}

	@Then("^The response code should be (\\d+) for findByStatus service$")
	public void validateFindByStatusResponse(int expectedStatusCode){
		Assert.assertEquals(expectedStatusCode,findByPetIdResponse.getStatusCode());
	}
}