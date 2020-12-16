package TSP;

import java.io.File;

public class Map {
	private double[][] map;
	
	public Map(int size) {
		map = new double[size][size];
	}
	
	public Map() {
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

	public void readTest(File file) {
		// TODO Auto-generated method stub
		
	}
	
	
}
