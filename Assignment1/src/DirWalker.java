
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class DirWalker {

	public static int totalSkipped = 0;
	public static int totalValid = 0;

	HashMap<String, Integer> countRows = new HashMap<String, Integer>();

	public void walk(String path) {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());

				System.out.println("Dir:" + f.getAbsoluteFile());

			} else {
				System.out.println("File:" + f.getAbsoluteFile());
				


				if (f.getAbsoluteFile().getName().endsWith(".csv")) {

					String file = f.getParent();
					String names[] = file.split("\\\\");
					String date = names[names.length - 3] + "\\" + names[names.length - 2] + "\\" + names[names.length - 1];
					SimpleCsvParser p = new SimpleCsvParser();
					String fileName = f.getAbsoluteFile().toString();

					countRows = p.csvParser(fileName);

					totalSkipped += countRows.get("skip");
					totalValid += countRows.get("valid");
					System.out.println("Date = " + date);

				}

			}

		}

	}

	public static void main(String[] args) {

		DirWalker fw = new DirWalker();
//		System.out.println("C:\\Users\\sarbo\\Documents\\GitHub\\MCDA5510_Assignments\\Sample Data\\Sample Data");
		System.out.println("Enter the path: ");

		

		Scanner scanner = new Scanner(System.in);

		try {
			String filePath = scanner.nextLine();

			final long startTime = SimpleLogging.startTime();

			fw.walk(filePath);
			final long endTime = SimpleLogging.endTime();
			System.out.println("Total execution time: " + (endTime - startTime) + " ms");
		} finally {
			scanner.close();
		}

		System.out.println("Total rows skipped= " + totalSkipped);
		System.out.println("Total rows valid= " + totalValid);

	}

}