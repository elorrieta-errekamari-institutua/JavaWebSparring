package com.elorrieta.file.parser;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.elorrieta.modelo.pojo.Edicion;

public class ParserEdiciones {
	java.util.Date fecha;

	public ParserEdiciones() {
		super();
	}

	public ArrayList<Edicion> parseFile(String path) {

		ArrayList<Edicion> listaEdiciones = new ArrayList<Edicion>();
		try (OPCPackage pkg = OPCPackage.open(new File(path));) {
			XSSFWorkbook wb = new XSSFWorkbook(pkg);
			Sheet sheet1 = wb.getSheetAt(0);

			// Parametros de la base de datos

			// Crear conexion a la base de datos

			for (Row row : sheet1) {
				Edicion edicion = new Edicion();

				for (Cell cell : row) {

					if (cell.getColumnIndex() == 1 && cell.getRowIndex() > 1) {
						// Guarda codigo labbide
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String text = cell.getStringCellValue();
						if (!text.isBlank()) {
							edicion.setCodigoLanbide(text);
						}

					}
					if (cell.getColumnIndex() == 8 && cell.getRowIndex() > 1) {
						// Guarda fecha inicio
						try {
							cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							fecha = cell.getDateCellValue();
							edicion.setFechaInicio(new Date(fecha.getTime()));
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
					if (cell.getColumnIndex() == 9 && cell.getRowIndex() > 1) {
						// Guarda fecha fin
						try {
							cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							fecha = cell.getDateCellValue();
							edicion.setFechaFin(new Date(fecha.getTime()));
						} catch (Exception e) {
							e.printStackTrace();
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
