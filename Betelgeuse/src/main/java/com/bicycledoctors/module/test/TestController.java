package com.bicycledoctors.module.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestController {

	@RequestMapping(value = "/publicCorona1JsonNodeList")
	public String publicCorona1JsonNodeList(Model model) throws Exception {
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq?serviceKey=zqlWVM2F%2FQpG1ToA6Q9qGMc%2FoaXaE7AwvaMLt5ryWTVOBc2d2X7xxlYrqDHDmjnwBrtvIy9to4o2PlIqgbImFQ%3D%3D&numOfRows=3&pageNo=1&type=json";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}

		bufferedReader.close();
		httpURLConnection.disconnect();

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(stringBuilder.toString());
		
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		System.out.println("node.get(\"body\").get(\"items\").asText(): " + node.get("body").get("items").get(1).get("KIT_PROD_QTY").asText());
		System.out.println("node.get(\"body\").get(\"items\").asText(): " + node.get("body").get("items").get(1).get("KIT_EXPRT_QTY").asText());
		
		model.addAttribute("node", node);
		
//		model.addAttribute(node);
		
		return "test/publicCorona1JsonNodeList";
	}
	@RequestMapping(value = "/publicCorona2JsonNodeList")
	public String publicCorona2JsonNodeList(Model model) throws Exception {
		
		String apiUrl = "http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getMmCovidDagnsRgntExprtStusInq?serviceKey=zqlWVM2F%2FQpG1ToA6Q9qGMc%2FoaXaE7AwvaMLt5ryWTVOBc2d2X7xxlYrqDHDmjnwBrtvIy9to4o2PlIqgbImFQ%3D%3D&numOfRows=3&pageNo=1&type=json";
		
		URL url = new URL(apiUrl);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		
		BufferedReader bufferedReader;
		if (httpURLConnection.getResponseCode() >= 200 && httpURLConnection.getResponseCode() <= 300) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		} else {
			bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line: " + line);
			stringBuilder.append(line);
		}
		
		bufferedReader.close();
		httpURLConnection.disconnect();
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(stringBuilder.toString());
		
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		System.out.println("node.get(\"body\").get(\"items\").asText(): " + node.get("body").get("items").get(2).get("KIT_EXPRT_QTY").asText());
		
		model.addAttribute("node", node);
		
//		model.addAttribute(node);
		
		return "test/publicCorona1JsonNodeList";
	}
}
