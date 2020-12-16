package TSP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Map {
	private double[][] map;
	
	public Map(int size) {
		map = new double[size][size];
	}
	
	public void setPath(int a, int b, double path) {
		map[a][b] = path;
		map[b][a] = path;
	}
	public double getPath(int a, int b) {
		return map[a][b];
	}
	
	public int size() {
		return map.length;
	}
	
	public int[][] readData() throws FileNotFoundException{
		File dataSet = new File("dataset");
		if (dataSet.isDirectory()) {
			FileOutputStream fos = new FileOutputStream(dataSet);
			for (File child: dataSet.listFiles()) {
				
			}
		}
		
		return null;
	}
	
}
