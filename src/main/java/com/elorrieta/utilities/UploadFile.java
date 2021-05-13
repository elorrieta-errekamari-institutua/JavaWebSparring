/**
 * 
 */
package com.elorrieta.utilities;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 * @author cursos_externos
 *
 */
public class UploadFile {

	public static String upload(HttpServletRequest request, String path) throws IOException, ServletException {
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		File uploadDir = new File(path);
//		Si no existe el directorio lo creamos
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		for (Part part : request.getParts()) {
			part.write(path + fileName);
		}
		return fileName;
	}

}
