package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;


@Listeners(com.api.listeners.TestListeners.class)
public class LoginAPITest {

	@Test(description = "Verify if login API is working....")
	public void loginTest() {

		AuthService authservice = new AuthService();
		// Serialization ==> Java obj into Json
		LoginRequest loginRequest = new LoginRequest("minnu", "Admin@123");
		Response response = authservice.login(loginRequest);
		System.out.println(response.asPrettyString());

		// deserialization ==> login json response into java object
		LoginResponse loginresponse = response.as(LoginResponse.class);
		System.out.println(loginresponse.getToken());
		System.out.println(loginresponse.getEmail());
		System.out.println(loginresponse.getType());
		System.out.println(loginresponse.getUsername());
		System.out.println(loginresponse.getId());
		System.out.println(loginresponse.getRoles());

		Assert.assertTrue(loginresponse.getToken() != null);
		Assert.assertEquals(loginresponse.getEmail(), "viratbhai@gmail.com");
		Assert.assertEquals(loginresponse.getId(), 4868);

	}
}
