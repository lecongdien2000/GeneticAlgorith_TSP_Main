package dataset;

import java.io.InputStream;
import java.util.Scanner;

import ga_TSP.City;

public class ReadDataset {
	public enum DataSet {
		pr439
	}

	public static String readFile(String fileName) {
		InputStream stream = ReadDataset.class.getResourceAsStream(fileName);
		Scanner s = new Scanner(stream).useDelimiter("EOF");
		return s.hasNext() ? s.next() : " ";
	}

	private static String removeSpace(String s) {
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
				if (i != s.length()) {
					s = s.substring(0, i) + s.substring(i + 1, s.length());
					i--;
				} else {
					s = s.substring(0, i);
					i--;
				}
			}
		}
		return s;
	}

	public City[] getCities(DataSet dataSet) {
		String dataSetName;
		int initialLine;

		if (dataSet == DataSet.pr439) {
			dataSetName = "pr439.tsp";
			initialLine = 6;
		} else {
			dataSetName = "a280.tsp";
			initialLine = 6;
		}
		String[] lines = readFile(dataSetName).split("\n");
		String[] data = lines[3].split(" ");
		int numOfCities = Integer.parseInt(data[data.length - 1]);
		City[] cities = new City[numOfCities];
		// đọc từng dòng và đưa vào City
		for (int i = initialLine; i < initialLine + numOfCities; i++) {
			// xóa nếu gặp khoảng trắng
			String[] datum = removeSpace(lines[i]).trim().split(" ");
			int x = (int)Double.parseDouble(datum[1].trim());
            int y = (int)Double.parseDouble(datum[2].trim());
            City city = new City(datum[0], x, y);
            cities[i - initialLine] = city;
		}
		return cities;
	}
}
