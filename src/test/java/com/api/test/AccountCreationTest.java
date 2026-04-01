package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "Verify if SignUp API is working....")
	public void createAccountTest() {

//		SignUpRequest signupRequest = new SignUpRequest("KohliV988530", "ram123", "KohliV@gmail.com", "ram123", "charan",
//				"7777777777");

		SignUpRequest signupRequest = new SignUpRequest.Builder().username("user" + System.currentTimeMillis())
				.password("asa123").email("test" + System.currentTimeMillis() + "@gmail.com").firstName("asa")
				.lastName("mam").mobileNumber("9885301201").build();

		AuthService authService = new AuthService();
		Response response = authService.signUp(signupRequest);

		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200);

		String message = response.asPrettyString();
		Assert.assertEquals(message, "User registered successfully!");

	}
}
