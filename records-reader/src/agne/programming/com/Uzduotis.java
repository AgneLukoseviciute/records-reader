package agne.programming.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Uzduotis {

	public static void main(String[] args) {

		String csvFile = "/Users/user/Documents/records.csv";

		try {
			BufferedReader reader = new BufferedReader(new FileReader(csvFile));
			
			//skips first line "Athlete, Mark"
			String currLine = reader.readLine();

			while ((currLine = reader.readLine()) != null){

				String[] recordInfo = currLine.split(",");
				System.out.println(recordInfo[2] + ", " + recordInfo[1]);
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
