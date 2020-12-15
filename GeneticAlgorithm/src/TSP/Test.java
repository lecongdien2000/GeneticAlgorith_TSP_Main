package TSP;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		Map map = new Map(7);
		map.setPath(0, 1, 5);
		map.setPath(0, 2, 4);
		map.setPath(0, 3, 2);
		map.setPath(0, 4, 6);
		map.setPath(0, 5, 8);
		map.setPath(0, 6, 5);
		map.setPath(1, 2, 7);
		map.setPath(1, 3, 5);
		map.setPath(1, 4, 8);
		map.setPath(1, 5, 12);
		map.setPath(1, 6, 6);
		map.setPath(2, 3, 9);
		map.setPath(2, 4, 13);
		map.setPath(2, 5, 12);
		map.setPath(2, 6, 17);
		map.setPath(3, 4, 11);
		map.setPath(3, 5, 9);
		map.setPath(3, 6, 14);
		map.setPath(4, 5, 20);
		map.setPath(4, 6, 8);
		map.setPath(5, 6, 13);
		int populationSize = 300;
		double mutateRatio = 0.01;
		int limit = 30; //note
		String path = "../TSP_Result.xlsx";
		Environment environment = new Environment(map, populationSize, mutateRatio, path);
		environment.generate();
		environment.draw(limit);
		
		
	}

}
