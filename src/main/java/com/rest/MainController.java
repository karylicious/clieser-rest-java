package com.rest;

import java.io.IOException;

import javax.activation.DataHandler;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.utilities.FileHandler;

@RestController
public class MainController {

	@RequestMapping( value = "/zipfile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String uploadFile(@RequestBody MultipartFile file) { //@RequestParam("file")  MultipartFile[] file) {
		
		//try {
		//MultipartFile file = request.getFile("file");
			System.out.println(file.getOriginalFilename());
			String userDirectory = "";
			//FileHandler.uploadFile(userFile, fileName, uploadLocation);
			return "{'succeed': True, 'Info': 'File uploaded successfully', 'd': " + userDirectory + "}";
		//}
		//catch(IOException exception) {
			//return "{'succeed': False, 'Info': 'File not uploaded'}";
		//}
		
		
	}
}
