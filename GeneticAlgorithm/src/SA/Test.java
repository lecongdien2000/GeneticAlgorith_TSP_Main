package SA;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	public final static int loop_limit = 20;
	public final static String DATASET_PATH = "dataset";
	public final static String RESULT_PATH = "SA_Result.xlsx";

	public static void main(String[] args) throws IOException {
		long totalTimeEachTest, totalTime = 0;
		Map map = new Map();
		WriteEnvironmentToExcel wete = new WriteEnvironmentToExcel(RESULT_PATH);
		File folder = new File(DATASET_PATH);
		if (!folder.isDirectory())
			return;
		for (File file : folder.listFiles()) {
			totalTimeEachTest = 0;
			String name = file.getName().substring(0, file.getName().length() - 4);
			wete.writeTitle(name);
			System.out.println("Running data:" + name + "...");
			ArrayList<City> cities;
			cities = map.readTest(file);
			for (int loop = 1; loop <= loop_limit; loop++) {
				long time = System.currentTimeMillis();
				Sa sa = new Sa();
				double result = sa.sa(cities);
				wete.write(result, name);
				time = (System.currentTimeMillis() - time) / 1000;
				System.out.println("- Complete " + loop + "th ! Time = " + time + " sec");
				totalTimeEachTest += time;
			}
			System.out.println("Cost time of " + name + ": " + totalTimeEachTest + " sec");
			totalTime += totalTimeEachTest;
			wete.resetRow();
		}
		System.out.println("Total time: " + totalTime);
		wete.close();

	}
}
