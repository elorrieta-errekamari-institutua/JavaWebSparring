package com.elorrieta.utilities;

import java.io.IOException;
import java.util.ArrayList;

import com.elorrieta.controller.commons.BackofficeController;
import com.elorrieta.file.parser.ParserEdiciones;
import com.elorrieta.file.parser.ParserParticipantes;
import com.elorrieta.modelo.dao.DAOEdicion;
import com.elorrieta.modelo.dao.DAOParticipante;
import com.elorrieta.modelo.pojo.Edicion;
import com.elorrieta.modelo.pojo.Participante;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class OperationsExcel {

	/**
	 * Genera una lista de ediciones a partir de un archivo xlsx en sesion,
	 * introduce en sesion la lista y todos los datos necesarios para mostrarla en
	 * una tabla y redirige a la pagina de preview
	 * 
	 * @param request         HttpServletRequest
	 * @param response        HttpServletResponse
	 * @param uploadPath      la ruta del archivo xlsx
	 * @param daoParticipante daoParticipante
	 * @param daoEdicion      DAOEdicion
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void parseExcel(HttpServletRequest request, HttpServletResponse response, String uploadPath,
			DAOParticipante daoParticipante, DAOEdicion daoEdicion) throws ServletException, IOException {
		// Recoger la sesion e incializar las tablas que se rellenaran mas adelante
		HttpSession session = request.getSession();
		ArrayList<String> listaHead = new ArrayList<String>();
		ArrayList<ArrayList<String>> listaBody = new ArrayList<ArrayList<String>>();

		// Guardar el archivo de la sesion
		String fileName = UploadFile.upload(request, uploadPath, "file");

		String tipoFichero = request.getParameter("fileType");

		if ("participantes".equalsIgnoreCase(tipoFichero)) {

			ArrayList<Participante> listaParticipantes = ParserParticipantes.parseFile(uploadPath + fileName);

			listaHead = Participante.setHeadersList();

			for (Participante participante : listaParticipantes) {
				try {
					Participante participanteTemporal = daoParticipante.getByDni(participante.getDni());
					if (participanteTemporal.getId() > 0) {
						participante.setGuardado(true);
					}
					listaBody.add(participante.setDataList());
				} catch (Exception e) {
					System.out.println("Error SQL");
					e.printStackTrace();
				}
			}

			session.setAttribute("lista", listaParticipantes);
			session.setAttribute("clase", BackofficeController.PARTICIPANTE);
		}

		if ("cursos".equalsIgnoreCase(tipoFichero)) {

			ArrayList<Edicion> listaEdiciones = ParserEdiciones.parseFile(uploadPath + fileName);

			listaHead = Edicion.setHeadersList();

			for (Edicion edicion : listaEdiciones) {
				try {
					Edicion edicionDB = daoEdicion.getByCodigoLanbide(edicion.getCodigoLanbide());
					if (edicionDB.getId() > 0) {
						edicion.setGuardado(true);
					}
					listaBody.add(edicion.setDataList());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			session.setAttribute("lista", listaEdiciones);
			session.setAttribute("clase", BackofficeController.EDICION);
		}
		session.setAttribute("title", "Confirme los datos");
		session.setAttribute("tableHeader", listaHead);
		session.setAttribute("tableBody", listaBody);
		request.getRequestDispatcher("previewDocumentData.jsp").forward(request, response);

	}

}
