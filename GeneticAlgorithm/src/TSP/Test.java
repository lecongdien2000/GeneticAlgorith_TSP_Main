package TSP;

import java.io.File;
import java.io.IOException;

public class Test {
	private static String dataPath = "dataset";
	private static String resultPath = "../TSP_Result.xlsx";
	private static int populationSize = 3000;
	private static double mutateRatio = 0.1;
	private static int limit = 300;
	public static void main(String[] args) throws IOException {
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
			long time = System.currentTimeMillis();
			System.out.println("Running data:" + name + "...");
			Environment environment = new Environment(map, populationSize, mutateRatio, wete, name);
			environment.generate();
			environment.draw(limit);
			wete.resetRow();
			System.out.println("Complete! " + (System.currentTimeMillis() - time)/1000 + " sec");
		}
		wete.close();
		
		
		
		
	}

}
