package com.elorrieta.file.parser;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.elorrieta.modelo.pojo.Horario;
import com.elorrieta.utilities.TimeFormatter;

public class ParserHorarios {

	public ParserHorarios() {
		super();
	}

	public ArrayList<Horario> parseFile(String path) {

		ArrayList<Horario> listaHorarios = new ArrayList<Horario>();
		try (OPCPackage pkg = OPCPackage.open(new File(path));) {
			XSSFWorkbook wb = new XSSFWorkbook(pkg);
			DataFormatter formatter = new DataFormatter();
			Sheet sheet1 = wb.getSheetAt(0);

			// Parametros de la base de datos

			// Crear conexion a la base de datos

			for (Row row : sheet1) {
				Horario horario = new Horario();

				for (Cell cell : row) {

					if (cell.getColumnIndex() == 11 && cell.getRowIndex() > 1) {
						// Guarda cualificacion
						String text = formatter.formatCellValue(cell);
						if (!text.isBlank()) {
							String[] horas = text.split("-");
							horario.setLunesInicio(TimeFormatter.normalizar(horas[0]));
							horario.setLunesFin(TimeFormatter.normalizar(horas[1]));
						}

					}
					if (cell.getColumnIndex() == 12 && cell.getRowIndex() > 1) {
						// Guarda codigo UC
						String text = formatter.formatCellValue(cell);
						if (!text.isBlank()) {
							String[] horas = text.split("-");
							horario.setMartesInicio(TimeFormatter.normalizar(horas[0]));
							horario.setMartesFin(TimeFormatter.normalizar(horas[1]));
						}

					}
					if (cell.getColumnIndex() == 13 && cell.getRowIndex() > 1) {
						// Guarda competencia
						String text = formatter.formatCellValue(cell);
						if (!text.isBlank()) {
							String[] horas = text.split("-");
							horario.setMiercolesInicio(TimeFormatter.normalizar(horas[0]));
							horario.setMiercolesFin(TimeFormatter.normalizar(horas[1]));
						}

					}
					if (cell.getColumnIndex() == 14 && cell.getRowIndex() > 1) {
						// Guarda codigo AAFF
						String text = formatter.formatCellValue(cell);
						if (!text.isBlank()) {
							String[] horas = text.split("-");
							horario.setJuevesInicio(TimeFormatter.normalizar(horas[0]));
							horario.setJuevesFin(TimeFormatter.normalizar(horas[1]));
						}

					}
					if (cell.getColumnIndex() == 15 && cell.getRowIndex() > 1) {
						// Guarda nombre
						String text = formatter.formatCellValue(cell);
						if (!text.isBlank()) {
							String[] horas = text.split("-");
							horario.setViernesInicio(TimeFormatter.normalizar(horas[0]));
							horario.setViernesFin(TimeFormatter.normalizar(horas[1]));
						}

					}

				}
				if (!LocalTime.MIN.equals(horario.getLunesInicio()) || !LocalTime.MIN.equals(horario.getMartesInicio())
						|| !LocalTime.MIN.equals(horario.getMiercolesInicio())
						|| !LocalTime.MIN.equals(horario.getJuevesInicio())
						|| !LocalTime.MIN.equals(horario.getViernesInicio())) {
					listaHorarios.add(horario);
				}
			}

		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaHorarios;
	}
}
