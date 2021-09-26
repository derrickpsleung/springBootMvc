package com.spirngboot.mvc.springBootMvc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnitTrustWebController {

	@RequestMapping("/unitTrustWeb")
	public String unitTrustWeb(Model model) throws IOException {
		model.addAttribute("name", "Derrick");
		model.addAttribute("returnJson", readAllBytesJava7("json/etWealth_mip.json"));
		return "unitTrustWeb";
	}

	private String readAllBytesJava7(String jsonPath) throws IOException {

		ClassLoader classLoader = UnitTrustWebController.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(jsonPath);
		String data = readFromInputStream(inputStream);

		return data;
	}

	private String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}

}
