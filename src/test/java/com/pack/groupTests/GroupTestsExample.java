package com.pack.groupTests;

import org.testng.annotations.Test;

public class GroupTestsExample {
	
	//String[] names = {"Shaikshavali","Zubeda","Amia"};
	@Test(groups = {"smoke"})
	public void Test1() {
		System.out.println("Test1");
	}

	
	@Test(groups = {"smoke"})
	public void Test2() {
		System.out.println("Test2");
	}

	@Test(groups = {"smoke","functoinal"})
	public void Test3() {
		System.out.println("Test3");
	}

	@Test(groups = {"smoke","functoinal","Regression"})
	public void Test4() {
		System.out.println("Test4");
	}
	
	
	@Test(groups = {"smoke"})
	public void Test5() {
		System.out.println("Test5");
	}

	@Test(groups = {"smoke","sanity"})
	public void Test6() {
		System.out.println("Test6");
	}
}
