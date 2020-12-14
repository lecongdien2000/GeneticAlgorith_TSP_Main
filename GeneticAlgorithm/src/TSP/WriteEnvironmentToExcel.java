package TSP;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteEnvironmentToExcel {
	private FileOutputStream fos;
	private SXSSFWorkbook workbook;
	private SXSSFSheet sheet;
	private int current = -1; 
    
	private int generation;
	private int ordinary;
	private String path;
	private double cost;
	public WriteEnvironmentToExcel(String path) throws IOException {
		fos = new FileOutputStream(path);
		workbook = new SXSSFWorkbook(new XSSFWorkbook());
		sheet = workbook.createSheet("Genetic Algorithm Sheet");
		Row row = sheet.createRow(nextRow());
		Cell cell = row.createCell(0);
		cell.setCellValue("Generation");
		cell = row.createCell(1);
		cell.setCellValue("Ordinal Number");
		cell = row.createCell(2);
		cell.setCellValue("Path");
		cell = row.createCell(3);
		cell.setCellValue("Cost");
	}
	
	public void write() throws IOException {
		Row row = sheet.createRow(nextRow());
		Cell cell = row.createCell(0);
		cell.setCellValue(generation);
		cell = row.createCell(1);
		cell.setCellValue(ordinary);
		cell = row.createCell(2);
		cell.setCellValue(path);
		cell = row.createCell(3);
		cell.setCellValue(cost);
	}
	
	
	
	private int nextRow() {
		current++;
		return current;
	}
	
	public void close() throws IOException {
		workbook.write(fos);
		workbook.close();
		fos.close();
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public int getOrdinary() {
		return ordinary;
	}

	public void setOrdinary(int ordinary) {
		this.ordinary = ordinary;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getGeneration() {
		return generation;
	}
	
	
}
