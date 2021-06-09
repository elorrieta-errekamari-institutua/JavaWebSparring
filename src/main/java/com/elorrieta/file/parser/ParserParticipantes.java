package com.elorrieta.file.parser;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.elorrieta.modelo.pojo.Participante;

public class ParserParticipantes {

	public ParserParticipantes() {
		super();
	}

	/**
	 * Generamos un ArrayList de participantes a partir de un documento xlsx
	 * 
	 * @param path la ruta en la que se encuentra el documento
	 * @return ArrayList<Participante> con todos los participantes del documento
	 */
	public static ArrayList<Participante> parseFile(String path) {

		ArrayList<Participante> listaParticipantes = new ArrayList<Participante>();
		try (OPCPackage pkg = OPCPackage.open(new File(path));) {
			XSSFWorkbook wb = new XSSFWorkbook(pkg);
			DataFormatter formatter = new DataFormatter();
			Sheet sheet1 = wb.getSheetAt(2);

			// Generamos un participante por fila
			for (Row row : sheet1) {
				Participante participante = new Participante();

				// Comparamos >0 porque la primera fila contiene titulos
				for (Cell cell : row) {

					if (cell.getColumnIndex() == 0 && cell.getRowIndex() > 0) {
						// Guarda DNI
						String text = formatter.formatCellValue(cell);
						participante.setDni(text);

					} else if (cell.getColumnIndex() == 1 && cell.getRowIndex() > 0) {
						// Guarda nombre
						String text = formatter.formatCellValue(cell);
						participante.setNombreCompleto(text);

					} else if (cell.getColumnIndex() == 2 && cell.getRowIndex() > 0) {
						// Guarda Telefono
						String text = formatter.formatCellValue(cell);
						participante.setTelefono(text);

					} else if (cell.getColumnIndex() == 3 && cell.getRowIndex() > 0) {
						// Guarda Email
						String text = formatter.formatCellValue(cell);
						participante.setEmail(text);

					} else if (cell.getColumnIndex() == 4 && cell.getRowIndex() > 0) {
						// Guarda Fecha de nacimiento
						String text = formatter.formatCellValue(cell);
						String[] date = text.split("/");
						text = date[2] + "-" + date[1] + "-" + date[0];
						participante.setFechaDeNacimiento(Date.valueOf(text));

					} else if (cell.getColumnIndex() == 5 && cell.getRowIndex() > 0) {
						// Guarda Direccion
						String text = formatter.formatCellValue(cell);
						participante.setDireccion(text);

					} else if (cell.getColumnIndex() == 6 && cell.getRowIndex() > 0) {
						// Guarda Codigo postal
						String text = formatter.formatCellValue(cell);
						participante.setCodigoPostal(text);

					} else if (cell.getColumnIndex() == 7 && cell.getRowIndex() > 0) {
						// Guarda Municipio
						String text = formatter.formatCellValue(cell);
						participante.setMunicipio(text);

					} else if (cell.getColumnIndex() == 8 && cell.getRowIndex() > 0) {
						// Guarda Provincia
						String text = formatter.formatCellValue(cell);
						participante.setProvincia(text);

					} else if (cell.getColumnIndex() == 14 && cell.getRowIndex() > 0) {
						// Guardar si esta en ERTE o no
						String text = formatter.formatCellValue(cell);
						if (!"no".equalsIgnoreCase(text))
							participante.setErte(true);

					} else if (cell.getColumnIndex() == 15 && cell.getRowIndex() > 0) {
						// Guarda Situacion Laboral
						String text = formatter.formatCellValue(cell);
						participante.setSituacionLaboral(text);

					} else if (cell.getColumnIndex() == 16 && cell.getRowIndex() > 0) {
						// Guarda Situacion administrativa
						String text = formatter.formatCellValue(cell);
						participante.setSituacionAdministrativa(text);

					} else if (cell.getColumnIndex() == 19 && cell.getRowIndex() > 0) {
						// Guarda titulacion
						String text = formatter.formatCellValue(cell);
						participante.setTitulacion(text);

					}

				}

				listaParticipantes.add(participante);
			}

		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		listaParticipantes.remove(0);

		return listaParticipantes;
	}

}
