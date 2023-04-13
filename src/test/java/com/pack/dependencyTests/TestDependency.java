package com.pack.dependencyTests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestDependency {
	static String trackingNumber = null;
	
	@Ignore  //dependent method never ignored
	@Test()
	public void CreateShipment() {
		System.out.println(5/0);
		System.out.println("Create Shipment");
		trackingNumber = "ABC123";
	}

	@Test(priority =1,dependsOnMethods= {"CreateShipment"},alwaysRun= true)
	public void TrackShipment() throws Exception {
		if (trackingNumber != null)
			System.out.println("Track Shipment");
		else
			throw new Exception("invalid tracking number");
	}

	@Test(priority=3, dependsOnMethods= {"CreateShipment"})
	public void CancelShipment() throws Exception {
		if (trackingNumber != null)
			System.out.println("Cancel Shipment");
		else
			throw new Exception("invalid tracking number");
	}
}
