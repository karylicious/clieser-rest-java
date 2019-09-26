package com.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;

public class FileHandler {
	 public static void uploadFile(DataHandler userFile, String fileName, String uploadLocation) throws IOException {           
        InputStream input = userFile.getInputStream();
        OutputStream output = new FileOutputStream( new File(uploadLocation + "\\"+ fileName));

        // Reads at most 100000 bytes from the supplied input stream and
        // returns them as a byte array
        byte[] b = new byte[100000];
        int bytesRead = 0;

        // iterate as long as bytesRead  is not -1 or End Of File is reached
        // write the bytes into the new file
        while ((bytesRead = input.read(b)) != -1) {
            output.write(b, 0, bytesRead);
        }         
    }
}
