import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleLogging {

	SimpleLogging simpleLog = new SimpleLogging();

	public static long startTime() {
		final long startTime = System.currentTimeMillis();

		SimpleLogging.customLog("SimpleLogging", "Start of program = " + startTime);
		System.setProperty("java.util.logging.config.file", "./logging.properties");
		return startTime;
	}

	public static long endTime() {

		final long endTime = System.currentTimeMillis();
		SimpleLogging.customLog("SimpleLogger", "End of the Program = " + endTime);
		return endTime;
	}

	public static void customLog(String className, String logText) {
		// TODO Auto-generated method stub
		Logger.getLogger(className).log(Level.INFO, logText);

	}

	public static void errorLog(String className, String logText) {
		// TODO Auto-generated method stub
		Logger.getLogger(className).log(Level.SEVERE, logText);

	}

}
