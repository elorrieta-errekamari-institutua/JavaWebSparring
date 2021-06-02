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

import com.elorrieta.modelo.pojo.Aula;
import com.elorrieta.modelo.pojo.Curso;
import com.elorrieta.modelo.pojo.Edicion;
import com.elorrieta.modelo.pojo.Horario;
import com.elorrieta.utilities.TimeFormatter;

public class ParserEdiciones {

    public ParserEdiciones() {
        super();
    }

    public static ArrayList<Edicion> parseFile(String path) {

        ArrayList<Edicion> listaEdiciones = new ArrayList<Edicion>();
        java.util.Date fecha;
        try (OPCPackage pkg = OPCPackage.open(new File(path));) {
            XSSFWorkbook wb = new XSSFWorkbook(pkg);
            Sheet sheet1 = wb.getSheetAt(0);

            // Parametros de la base de datos

            // Crear conexion a la base de datos

            for (Row row : sheet1) {
                Edicion edicion = new Edicion();
                Curso curso = new Curso();
                Horario horario = new Horario();
                ArrayList<Aula> aulas = new ArrayList<Aula>();

                for (Cell cell : row) {

                    if (cell.getColumnIndex() == 1 && cell.getRowIndex() > 1) {
                        // Guarda codigo labbide
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            edicion.setCodigoLanbide(text);
                        }

                    }

                    else if (cell.getColumnIndex() == 2 && cell.getRowIndex() > 1) {
                        // Guarda cualificacion
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            curso.setCualificacion(text);
                        }
                    }

                    else if (cell.getColumnIndex() == 3 && cell.getRowIndex() > 1) {
                        // Guarda codigo UC
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            curso.setCodigoUc(text);
                        }
                    }

                    else if (cell.getColumnIndex() == 4 && cell.getRowIndex() > 1) {
                        // Guarda competencia
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            curso.setCompetencia(text);
                        }
                    }

                    else if (cell.getColumnIndex() == 5 && cell.getRowIndex() > 1) {
                        // Guarda codigo AAFF
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            curso.setCodigoAaff(text);
                        }
                    }

                    else if (cell.getColumnIndex() == 6 && cell.getRowIndex() > 1) {
                        // Guarda nombre
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            curso.setNombre(text);
                        }
                    }

                    else if (cell.getColumnIndex() == 7 && cell.getRowIndex() > 1) {
                        // Guarda horas curso
                        try {
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            int text = (int) cell.getNumericCellValue();
                            curso.setHorasCurso(text);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    else if (cell.getColumnIndex() == 8 && cell.getRowIndex() > 1) {
                        // Guarda fecha inicio
                        try {
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            fecha = cell.getDateCellValue();
                            edicion.setFechaInicio(new Date(fecha.getTime()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    else if (cell.getColumnIndex() == 9 && cell.getRowIndex() > 1) {
                        // Guarda fecha fin
                        try {
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            fecha = cell.getDateCellValue();
                            edicion.setFechaFin(new Date(fecha.getTime()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    else if (cell.getColumnIndex() == 11 && cell.getRowIndex() > 1) {
                        // Guarda horario lunes
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            String[] horas = text.split("-");
                            horario.setLunesInicio(TimeFormatter.normalizar(horas[0]));
                            horario.setLunesFin(TimeFormatter.normalizar(horas[1]));
                        }
                    }

                    else if (cell.getColumnIndex() == 12 && cell.getRowIndex() > 1) {
                        // Guarda horario martes
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            String[] horas = text.split("-");
                            horario.setMartesInicio(TimeFormatter.normalizar(horas[0]));
                            horario.setMartesFin(TimeFormatter.normalizar(horas[1]));
                        }
                    }

                    else if (cell.getColumnIndex() == 13 && cell.getRowIndex() > 1) {
                        // Guarda horario miercoles
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            String[] horas = text.split("-");
                            horario.setMiercolesInicio(TimeFormatter.normalizar(horas[0]));
                            horario.setMiercolesFin(TimeFormatter.normalizar(horas[1]));
                        }
                    }

                    else if (cell.getColumnIndex() == 14 && cell.getRowIndex() > 1) {
                        // Guarda horario jueves
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            String[] horas = text.split("-");
                            horario.setJuevesInicio(TimeFormatter.normalizar(horas[0]));
                            horario.setJuevesFin(TimeFormatter.normalizar(horas[1]));
                        }
                    }

                    else if (cell.getColumnIndex() == 15 && cell.getRowIndex() > 1) {
                        // Guarda horario viernes
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            String[] horas = text.split("-");
                            horario.setViernesInicio(TimeFormatter.normalizar(horas[0]));
                            horario.setViernesFin(TimeFormatter.normalizar(horas[1]));
                        }
                    }

                    else if (cell.getColumnIndex() == 19 && cell.getRowIndex() > 1) {
                        // Guarda aula 1
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            Aula aula = new Aula();
                            aula.setNombre(text);
                            aulas.add(aula);
                        }
                    }

                    else if (cell.getColumnIndex() == 20 && cell.getRowIndex() > 1) {
                        // Guarda aula 2
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String text = cell.getStringCellValue();
                        if (!text.isBlank()) {
                            Aula aula = new Aula();
                            aula.setNombre(text);
                            aulas.add(aula);
                        }
                    }
                }
                if (!"".equalsIgnoreCase(edicion.getCodigoLanbide())) {
                    edicion.setCurso(curso);
                    edicion.setHorario(horario);
                    edicion.setAulas(aulas);
                    listaEdiciones.add(edicion);
                }
            }

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaEdiciones;
    }
}
