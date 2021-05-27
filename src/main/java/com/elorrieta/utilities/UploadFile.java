/**
 * 
 */
package com.elorrieta.utilities;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

/**
 * @author cursos_externos
 *
 */
public class UploadFile {

	/**
	 * Almacena en el servidor el archivo recibido en una peticion y devuelve el
	 * nombre
	 * 
	 * @param request   la peticion recibida en el servidor
	 * @param path      la ruta en la que queremos almacenar el archivo
	 * @param attribute el nombre del atributo de la peticion en el que esta el
	 *                  archivo
	 * @return el nombre del archivo
	 * @throws IOException
	 * @throws ServletException
	 */
	public static String upload(HttpServletRequest request, String path, String attribute)
			throws IOException, ServletException {
		Part filePart = request.getPart(attribute);
		String fileName = filePart.getSubmittedFileName();
		File uploadDir = new File(path);
		// Si no existe el directorio lo creamos
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		for (Part part : request.getParts()) {
			part.write(path + fileName);
		}
		return fileName;
	}

}
