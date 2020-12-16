package TSP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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

	public void readTest(File file) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String str;
		do {
			str = bf.readLine();
		} while (!str.equals("NODE_COORD_SECTION"));
		// List<Point> list
		// while(str!=EOF)
		// str = readLine()
		// strArr = split(str, " ");
		// list.addX(toDouble(strArr[1]))
		// list.addY(toDouble(strArr[2]));

		// new Map(list.size)
		// for(i = 0 to list.size - 1)
		// for(j = i + 1 to list.size - 1)
		// map[i,j] = distance(list[i], list[j])
		// map[j,i] = map[i,j]
	}

}
