package com.pack.testng.examples;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FlightBookingTest {
	
	@Ignore
	@Test(priority = 1)
	public void Signup() {
		System.out.println("Sign up");
	}

	@Test(priority = 2)
	public void Login() {
		System.out.println("Login in");
	}

	@Test
	public void SearchForTheFlight() {
		System.out.println("Search for the Flight");
	}

	@Test(priority = 4)
	public void BookTheFlight() {
		System.out.println("Book the Flight");
	}

	@Test(priority = 4)
	public void SaveTheFlight() {
		System.out.println("Save the Flight");
	}

	@Test(priority = -1)
	public void Logout() {
		System.out.println("Logout");
	}

}
