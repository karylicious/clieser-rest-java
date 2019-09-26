package com.rest;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utilities.FileHandler;

@CrossOrigin(origins = "*") // CORS access control headers (without this the client won't be able to access the response from this web service)
@RestController
public class MainController {

	
	@RequestMapping( value = "/zipfile", method = RequestMethod.POST, consumes = "multipart/form-data", produces = MediaType.APPLICATION_JSON_VALUE)
	public String uploadFile  ( @RequestPart (value="file") MultipartFile userFile) { 
		
		try {			
			String temporaryDirectoryPath = FileHandler.getTempDirectoryPath();
			FileHandler.createDirectory(temporaryDirectoryPath);
			
			String userTemporaryDirectoryName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String fileUploadLocation = temporaryDirectoryPath + "\\" + userTemporaryDirectoryName;
			
			FileHandler.createDirectory( fileUploadLocation );
						
			String userFileName = userFile.getOriginalFilename();

			FileHandler.uploadFiles(userFile, userFileName, fileUploadLocation);
			
			return stringToJson("{\"succeed\": " + true + ", \"Info\": \"File uploaded successfully\", \"d\": " + userTemporaryDirectoryName + "}");
		}
		catch(Exception exception) {
			exception.printStackTrace();			
		}
		return stringToJson("{\"succeed\": " + false + ", \"Info\": \"File not uploaded\"}");
	}
	
	private String stringToJson(String theString){
		try {
			ObjectMapper mapper = new ObjectMapper();
			Object jsonObject = mapper.readValue(theString, Object.class);
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return "";
	}
	
}
