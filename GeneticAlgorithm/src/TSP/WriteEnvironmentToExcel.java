package TSP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//This class can write each row by title (column)
public class WriteEnvironmentToExcel {
	private SXSSFWorkbook workbook;
	private SXSSFSheet sheet;
	private int currentRow = -1;
	private String path;
	private int currentColumn = -1;
	private HashMap<String, Integer> columns;

	public WriteEnvironmentToExcel(String path) throws IOException {
		workbook = new SXSSFWorkbook();
		this.path = path;
		sheet = workbook.createSheet("Genetic Algorithm");
		columns = new HashMap<String, Integer>();
		nextRow();
	}

	public void write(double value) throws IOException {
		//TODO
	}

	private int nextRow() {
		currentRow++;
		return currentRow;
	}

	private int nextColumn() {
		currentColumn++;
		return currentColumn;
	}
	
	public void resetRow() {
		currentRow = 0;
	}
	
	public void close() throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fos.close();
	}

	public void writeTitle(String name) {
		Row row;
		if((row = sheet.getRow(currentRow))==null) 
			row = sheet.createRow(currentRow);
		Cell cell = row.createCell(nextColumn());
		cell.setCellValue(name);
		columns.put(name, currentColumn);
	}

	public void write(double pathCost, String title) {
		Row row;
		if((row = sheet.getRow(nextRow()))==null) 
			row = sheet.createRow(currentRow);
		Cell cell = row.createCell(columns.get(title));
		cell.setCellValue(pathCost);
	}

}
