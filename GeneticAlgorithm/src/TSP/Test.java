package TSP;

import java.io.File;
import java.io.IOException;

public class Test {
	private static String dataPath = "dataset";
	private static String resultPath = "../TSP_Result.xlsx";
	private static int populationSize = 3000;
	private static double mutateRatio = 0.1;
	private static final int LIMIT = 15;
	private static int loop_limit = 20; //20
	private static final double NEAR_NUM = 0.1;
	public static void main(String[] args) throws IOException {
		// folder = new File
		// if(folder is not Directory) return
		// for(each file in folder)
		// name = file.getNameWithoutExt()
		// wete.writeTitle(name)
		// readTest(file, map)
		// algorithm.execute(wete, title) -- write n rows into excel file
		long totalTimeEachTest, totalTime = 0;
		Map map = new Map();
		WriteEnvironmentToExcel wete = new WriteEnvironmentToExcel(resultPath);
		File folder = new File(dataPath);
		if (!folder.isDirectory())
			return;
		for (File file : folder.listFiles()) {
			totalTimeEachTest = 0;
			String name = file.getName().substring(0, file.getName().length() - 4);
			wete.writeTitle(name);
			System.out.println("Running data:" + name + "...");
			map.readTest(file);
			for (int loop = 1; loop <= loop_limit; loop++) {
				long time = System.currentTimeMillis();
				Environment environment = new Environment(map, populationSize, mutateRatio, wete, name);
				environment.generate();
				environment.draw(NEAR_NUM, LIMIT);
				time = (System.currentTimeMillis() - time)/1000;
				System.out.println(
						"- Complete " + loop + "th ! Time = " + time + " sec");
				totalTimeEachTest+= time;
			}
			System.out.println("Cost time of " + name + ": " + totalTimeEachTest + " sec");
			totalTime+= totalTimeEachTest;
			wete.resetRow();
		}
		System.out.println("Total time: " + totalTime);
		wete.close();

	}

}
