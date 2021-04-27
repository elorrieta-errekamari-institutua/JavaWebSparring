package com.elorrieta.file.parser;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParserParticipantes {

	public ParserParticipantes() {
		super();
	}

	public static void parseFile(String path) {
		path = "./src/java/main/resources/excel/input/participantes.xlsx";
		try (OPCPackage pkg = OPCPackage.open(new File(path)); XSSFWorkbook wb = new XSSFWorkbook(pkg);) {
			DataFormatter formatter = new DataFormatter();
			Sheet sheet1 = wb.getSheetAt(2);

			// Parametros de la base de datos

			// Crear conexion a la base de datos

			for (Row row : sheet1) {
				System.out.println("Participante nuevo");
				for (Cell cell : row) {
					if (cell.getColumnIndex() == 0 && cell.getRowIndex() > 0) {
						// TODO Copiar nombre
						String text = formatter.formatCellValue(cell);
						System.out.println(text);

					}
					if (cell.getColumnIndex() == 1 && cell.getRowIndex() > 0) {
//						CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
//						System.out.print(cellRef.formatAsString());
//						System.out.print(" - ");
						// get the text that appears in the cell by getting the cell value and applying
						// any data formats (Date, 0.00, 1.23e9, $1.23, etc)
						String text = formatter.formatCellValue(cell);
						System.out.println(text);

					}

				}
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		parseFile("");
	}
}
