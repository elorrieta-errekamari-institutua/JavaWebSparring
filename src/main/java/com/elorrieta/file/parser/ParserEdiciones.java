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

import com.elorrieta.modelo.pojo.Edicion;

public class ParserEdiciones {

	public ParserEdiciones() {
		super();
	}

	public ArrayList<Edicion> parseFile(String path) {

		ArrayList<Edicion> listaEdiciones = new ArrayList<Edicion>();
		try (OPCPackage pkg = OPCPackage.open(new File(path));) {
			XSSFWorkbook wb = new XSSFWorkbook(pkg);
			DataFormatter formatter = new DataFormatter();
			Sheet sheet1 = wb.getSheetAt(0);

			// Parametros de la base de datos

			// Crear conexion a la base de datos

			for (Row row : sheet1) {
				Edicion edicion = new Edicion();

				for (Cell cell : row) {

					if (cell.getColumnIndex() == 1 && cell.getRowIndex() > 1) {
						// Guarda cualificacion
						String text = formatter.formatCellValue(cell);
						if (!text.isBlank()) {
							edicion.setCodigoLanbide(text);
						}

					}
					if (cell.getColumnIndex() == 8 && cell.getRowIndex() > 1) {
						// Guarda codigo UC
						String text = formatter.formatCellValue(cell);
						if (!text.isBlank()) {
							String[] date = text.split("/");
							text = date[2] + "-" + date[1] + "-" + date[0];
							edicion.setFechaInicio(Date.valueOf(text));
						}

					}
					if (cell.getColumnIndex() == 9 && cell.getRowIndex() > 1) {
						// Guarda competencia
						String text = formatter.formatCellValue(cell);
						if (!text.isBlank()) {
							String[] date = text.split("/");
							text = date[2] + "-" + date[1] + "-" + date[0];
							edicion.setFechaFin(Date.valueOf(text));
						}
					}
				}
				if (!"".equalsIgnoreCase(edicion.getCodigoLanbide()))
					listaEdiciones.add(edicion);
			}

		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaEdiciones;
	}
}
