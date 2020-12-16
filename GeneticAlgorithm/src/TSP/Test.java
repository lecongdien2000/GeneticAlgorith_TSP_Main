package TSP;

import java.io.File;
import java.io.IOException;

public class Test {
	private static String dataPath = "dataset";
	private static String resultPath = "../TSP_Result.xlsx";
	private static int populationSize = 300;
	private static double mutateRatio = 0.01;
	private static int limit = 30;
	public static void main(String[] args) throws IOException {
		/*
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
		
		*/

		//folder = new File
		//if(folder is not Directory) return
		//for(each file in folder)
			//name = file.getNameWithoutExt() 
			//wete.writeTitle(name)
			//readTest(file, map)
			//algorithm.execute(wete, title) -- write n rows into excel file
		Map map = new Map();
		WriteEnvironmentToExcel wete = new WriteEnvironmentToExcel(resultPath);
		File folder = new File(dataPath);
		if(!folder.isDirectory()) return;
		for(File file: folder.listFiles()) {
			String name = file.getName().substring(0, file.getName().length() - 4);
			wete.writeTitle(name);
			map.readTest(file);
			Environment environment = new Environment(map, populationSize, mutateRatio, wete, name);
			environment.generate();
			environment.draw(limit);
		}
		
		//1. Truy cap vao dataset
		//2. Duyet tung file trong dataset
			//2.1 Viet ten test vao excel
			//2.2 Doc test, luu vao map
			//2.3 Chay thuat toan, ghi n dong vao excel
		
		
		
	}

}
