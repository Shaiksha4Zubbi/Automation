package com.pack.dependencyTests;

import org.testng.annotations.Test;

public class TestGroupDependency {

	@Test(groups = "sanity")
	public void Test1() {
		System.out.println("sanity");
	}

	@Test(groups = "sanity")
	public void Test2() {
		System.out.println("sanity");
	}

	@Test(groups = "sanity")
	public void Test3() {
		System.out.println(5 / 0);
	}

	@Test(groups = "smoke")
	public void Test4() {
		System.out.println("smoke");
	}

	@Test(groups = "regression")
	public void Test5() {
		System.out.println("regression");
	}

	@Test(groups = { "smoke", "regression", "sanity" })
	public void Test6() {
		System.out.println("smoke & Regression & Sanity");
	}

	@Test(dependsOnGroups = { "sanity" }, alwaysRun = true)
	public void test0() {
		System.out.println("Main test");
	}
}
