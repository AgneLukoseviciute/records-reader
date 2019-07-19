package agne.programming.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uzduotis {

	public static void main(String[] args) {

		try {

			
			File csvFile = new File ("assets/records.csv");
			
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

class athlete {
	
	@SerializedName("Rank")
	@Expose
	private Integer rank;
	@SerializedName("Mark")
	@Expose
	private String mark;
	@SerializedName("Athlete")
	@Expose
	private String athlete;
	@SerializedName("Date")
	@Expose
	private String date;
	@SerializedName("Location")
	@Expose
	private String location;

	public Integer getRank() {
		return rank;
	}

	public String getMark() {
		return mark;
	}

	public String getAthlete() {
		return athlete;
	}

	public String getDate() {
		return date;
	}

	public String getLocation() {
		return location;
	}

}

abstract class fileReader{

}


class csvFileReader extends fileReader{

}

class JSONFileReader extends fileReader {
	
	
}

