import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class SimpleCsvParser {
	public HashMap<String, Integer> count = new HashMap<String, Integer>();
	public int countSkip = 0, countValid = 0;

	public HashMap<String, Integer> csvParser(String file) {

		ArrayList<CustomerInfo> listCustomer = new ArrayList<>();
		String fileName = file;
		BufferedReader bufferedReader = null;

		try {

			Reader in;
			in = new FileReader(fileName);
			// Always wrap FileReader in BufferedReader.
			bufferedReader = new BufferedReader(in);

			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(bufferedReader);

			try {
			for (CSVRecord record : records) {

				String firstName = record.get(0);

				String secondName = record.get(1);
				String streetNumber = record.get(2);
				String streeName = record.get(3);
				String city = record.get(4);
				String province = record.get(5);

				String postalCode = record.get(6);
				String country = record.get(7);
				String phoneNumber = record.get(8);
				String email = record.get(9);

				listCustomer.add(new CustomerInfo(firstName, secondName, postalCode, province, streeName, city, country,
						email, streetNumber, phoneNumber));

			}
			} catch (ArrayIndexOutOfBoundsException aex) {
				SimpleLogging.errorLog("SimpleCsv Class ", "Error with " + aex);
			} 

			for (CustomerInfo customerInfo : listCustomer) {

				if (empty(customerInfo.getSecondName()) || empty(customerInfo.getSecondName())) {
					SimpleLogging.customLog("ParserClass", "Skipped row- Invalid Data");
					countSkip++;
				} else if (empty(customerInfo.getStreetNumber()) || empty(customerInfo.getStreeName())
						|| empty(customerInfo.getPostalCode())) {
					SimpleLogging.customLog("ParserClass", "Skipped row- Invalid Data");
					countSkip++;
				} else if (empty(customerInfo.getEmail()) || empty(customerInfo.getPhoneNumber())) {
					SimpleLogging.customLog("ParserClass", "Skipped row- Invalid Data");
					countSkip++;
				} else if (empty(customerInfo.getCity()) || empty(customerInfo.getProvince())
						|| empty(customerInfo.getCountry())) {
					SimpleLogging.customLog("ParserClass", "Skipped row- Invalid Data");
					countSkip++;
				} else {
					SimpleLogging.customLog("ParserClass", "Valid Data");
					countValid++;
				}
			}

		}catch (FileNotFoundException ex) {
			SimpleLogging.errorLog("Unable to open file '", fileName + "'");
		} catch (IOException e) {
			SimpleLogging.errorLog("Error reading file '", fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		} finally {

			try {
				// Always close files.
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		SimpleLogging.customLog("Simple Parser","skipped row in each file=" + countSkip);
		count.put("skip", countSkip);
		count.put("valid", countValid);

		return count;
	}

	public static boolean empty(final String s) {
		return s == null || s.trim().isEmpty();
	}

}
