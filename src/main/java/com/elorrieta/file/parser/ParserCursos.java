package com.elorrieta.file.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.elorrieta.modelo.pojo.Curso;

public class ParserCursos {

	public ParserCursos() {
		super();
	}

	public ArrayList<Curso> parseFile(String path) {

		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		try (OPCPackage pkg = OPCPackage.open(new File(path));) {
			XSSFWorkbook wb = new XSSFWorkbook(pkg);
			DataFormatter formatter = new DataFormatter();
			Sheet sheet1 = wb.getSheetAt(0);

			// Parametros de la base de datos

			// Crear conexion a la base de datos

			for (Row row : sheet1) {
				Curso curso = new Curso();

				for (Cell cell : row) {

					if (cell.getColumnIndex() == 2 && cell.getRowIndex() > 1) {
						// Guarda cualificacion
						String text = formatter.formatCellValue(cell);
						curso.setCualificacion(text);

					}
					if (cell.getColumnIndex() == 3 && cell.getRowIndex() > 1) {
						// Guarda codigo UC
						String text = formatter.formatCellValue(cell);
						curso.setCodigoUc(text);

					}
					if (cell.getColumnIndex() == 4 && cell.getRowIndex() > 1) {
						// Guarda competencia
						String text = formatter.formatCellValue(cell);
						curso.setCompetencia(text);

					}
					if (cell.getColumnIndex() == 5 && cell.getRowIndex() > 1) {
						// Guarda codigo AAFF
						String text = formatter.formatCellValue(cell);
						curso.setCodigoAaff(text);

					}
					if (cell.getColumnIndex() == 6 && cell.getRowIndex() > 1) {
						// Guarda nombre
						String text = formatter.formatCellValue(cell);
						curso.setNombre(text);

					}
					if (cell.getColumnIndex() == 7 && cell.getRowIndex() > 1) {
						// Guarda horas curso
						String text = formatter.formatCellValue(cell);
						if (!"".equalsIgnoreCase(text))
							curso.setHorasCurso(Integer.parseInt(text));
					}

				}
				if (!"".equalsIgnoreCase(curso.getCodigoAaff()))
					listaCursos.add(curso);
			}

		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaCursos;
	}

}
