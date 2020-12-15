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

public class WriteEnvironmentToExcel {
	private FileOutputStream fos;
	private SXSSFWorkbook workbook;
	private SXSSFSheet sheet;
	private int current = -1;

	private int generation;
	private int ordinary;
	private String path;
	private double cost;
	
	private HashMap<Integer, String> columns;

	public WriteEnvironmentToExcel(String path) throws IOException {
		columns = new HashMap<Integer, String>();
		File file = new File("../dataset");
		if (!file.isDirectory())
			return;
		fos = new FileOutputStream(path);
		workbook = new SXSSFWorkbook(new XSSFWorkbook());
		sheet = workbook.createSheet("Genetic Algorithm");
		Row row = sheet.createRow(nextRow());
		Cell cell = row.createCell(0);
		cell.setCellValue("Generation");
		int i = 1;
		for (File child : file.listFiles()) {
			cell = row.createCell(i);
			String name = child.getName().substring(0, child.getName().length() - 4);
			columns.put(i, name);
			cell.setCellValue(name);
			i++;
		}
	}

	public void write(double value) throws IOException {
		Row row = sheet.createRow(nextRow());
		Cell cell = row.createCell(0);
		cell.setCellValue(generation);
		cell = row.createCell(1);
		cell.setCellValue(value);
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
