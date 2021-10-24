package com.example.testingweb;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	public @ResponseBody String greeting() {
		return "Hello, World";
	}
	@RequestMapping("/documentExcel")
	public @ResponseBody String getDocumentExcel() {
		ExcelHelper poiHelper = new ExcelHelper();
		try {
			poiHelper.writeExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "documentExcel";
	}

}
