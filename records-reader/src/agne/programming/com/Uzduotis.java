package agne.programming.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import com.google.gson.Gson;

public class Uzduotis {

	public static void main(String[] args) {
		
		//Gson gson;
		

		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					Thread.currentThread().getContextClassLoader().getResourceAsStream("records.csv")));
					
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
