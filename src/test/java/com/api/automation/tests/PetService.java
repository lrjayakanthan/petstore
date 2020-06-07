package com.api.automation.tests;

import com.api.automation.utils.PropertyUtil;
import com.api.automation.utils.RestUtil;
import io.restassured.response.Response;
import static com.api.automation.helper.Constants.*;

public class PetService {
	
	public Response createPet(String petData) {
		return RestUtil.PostJSONRequest(PropertyUtil.getProperty(END_POINT)
				+PropertyUtil.getProperty(PET_SERVICE), petData.toString());
	}

	public Response findByPetId(int petId){
		return RestUtil.GetJSONRequest(PropertyUtil.getProperty(END_POINT)
				+PropertyUtil.getProperty(PET_SERVICE)+"/"+petId);
	}

	public Response updateExistingPet(String updateData){
		return RestUtil.PutJSONRequest(PropertyUtil.getProperty(END_POINT)
				+PropertyUtil.getProperty(PET_SERVICE),updateData);
	}

	public Response findByStatus(String statusToFind) {
		return RestUtil.GetJSONRequest(PropertyUtil.getProperty(END_POINT)
				+PropertyUtil.getProperty(FIND_BY_STATUS_SERVICE)+statusToFind);
	}
}
