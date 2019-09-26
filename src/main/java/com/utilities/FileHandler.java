package com.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileHandler {
	
	private static final String TEMPORARY_DIRECTORY_PATH = System.getProperty("user.dir") + "\\clieser\\clieser_temporary";
	
	public static String getTempDirectoryPath(){ return TEMPORARY_DIRECTORY_PATH; }
	
	public static void createDirectory(String directory) throws Exception{
        if (!(Files.exists(Paths.get(directory)))) 
            Files.createDirectories(Paths.get(directory));        
    }  
		 
	public static void uploadFiles(MultipartFile userFile, String fileName, String uploadLocation)  throws IOException {	
		File uploadedFile = new File ( uploadLocation + "\\"+ fileName );
        FileOutputStream fileOutputStream = new FileOutputStream( uploadedFile );
		
        // Writes bytes from the specified byte array to the file output stream 
        fileOutputStream.write(userFile.getBytes());
        fileOutputStream.close();
	}
}
