package com.pack.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports3 {

	public static void main(String[] args) throws Exception {
		ExtentReports extent = new ExtentReports();
		File file = new File("ExtentReports2.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		extent.attachReporter(spark);

		extent.createTest("Text based test").log(Status.INFO, "info1").log(Status.INFO, "<b>info3</b>").log(Status.INFO,
				"<i>info2</i>");

		String xmlData = "<menu id=\"file\" value=\"File\">\r\n" + "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n" + "  </popup>\r\n" + "</menu>";

		String jsonData = "{\"menu\": {\r\n" + "  \"id\": \"file\",\r\n" + "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n" + "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n" + "    ]\r\n" + "  }\r\n" + "}}";

		extent
		.createTest("XML based Test")
		.info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		
		extent
		.createTest("XML based Test")
		.log(Status.INFO, (MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON)));
		
		List<String> listData = new ArrayList<>();
		listData.add("Shaikshavali");
		listData.add("Zubeda");
		listData.add("Amira");
		
		Map<Integer, String> mapData = new HashMap<>();
		mapData.put(101, "Shaikshavali");
		mapData.put(102, "Zubeda");
		mapData.put(103, "Amira");
		
		Set<Integer> setData = mapData.keySet();
		
		extent
		.createTest("List based Test")
		.info(MarkupHelper.createOrderedList(listData))
		.info(MarkupHelper.createUnorderedList(listData));
		
		extent
		.createTest("Map based Test")
		.info(MarkupHelper.createOrderedList(mapData))
		.info(MarkupHelper.createUnorderedList(mapData));
		
		extent
		.createTest("Set based Test")
		.info(MarkupHelper.createOrderedList(setData))
		.info(MarkupHelper.createUnorderedList(setData));
		
		extent
		.createTest("Highlight Log Test")
		.info("This is to test Highlight")
		.info(MarkupHelper.createLabel("This is to test Highlight", ExtentColor.RED));
		
		try {
			int i = 5/0;
		}catch(Exception e) {
			extent
			.createTest("Exception")
			.fail(e);
		}
		
		Throwable t = new RuntimeException("This is a custom exception");
		extent
		.createTest("Exception1")
		.fail(t);
		
		extent
		.createTest("Exception2")
		.fail(t);
		
		
		extent.flush();
		Desktop.getDesktop().browse(new File("ExtentReports2.html").toURI());

	}

}
