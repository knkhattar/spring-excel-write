package com.example.testingweb;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<DocumentResponse> getDocumentExcel() {
		ExcelHelperBase64 poiHelper = new ExcelHelperBase64();
		DocumentResponse  documentResponse = new DocumentResponse();
		try {
			
			documentResponse.setExcel(poiHelper.getExcel());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block comment updated
			e.printStackTrace();
		}
		return ResponseEntity.ok(documentResponse);
	}

}
