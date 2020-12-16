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
	private FileOutputStream fos;
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
	
	public void close() throws IOException {
		workbook.write(fos);
		workbook.close();
		fos.close();
	}

	public void writeTitle(String name) {
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(nextColumn());
		cell.setCellValue(name);
	}

	public void write(double pathCost, String title) {
		// TODO Auto-generated method stub
		
	}

}
