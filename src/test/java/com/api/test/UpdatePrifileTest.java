package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileUpdateRequest;
import com.api.models.request.SignUpRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdatePrifileTest {

	@Test(description = "Verify if SignUp API is working....")
	public void profileUpdateTest() {

		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("minnu", "Admin@123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());

		System.out.println("----------------------------------------------------------------------");

		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());

		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);

		System.out.println(userProfileResponse.getUsername());

		Assert.assertEquals(userProfileResponse.getUsername(), "minnu");

		System.out.println("----------------------------------------------------------------------");

		ProfileUpdateRequest profileUpdateRequest = new ProfileUpdateRequest.Builder().firstName("GopiVirat")
				.lastName("virat").email("viratbhai@gmail.com").mobileNumber("9885745217").build();

		response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileUpdateRequest);

		System.out.println(response.asPrettyString());

	}
}
