package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test(description = "Verify if ForgotPassword API is working....")
	public void forgotPassword() {

		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("vaka" + System.currentTimeMillis() + "@gmail.com");

		System.out.println(response.asPrettyString());

		String message = response.jsonPath().getString("message");

		Assert.assertEquals(message, "If your email exists in our system, you will receive reset instructions.");
		Assert.assertEquals(response.getStatusCode(), 200);

	}
}
