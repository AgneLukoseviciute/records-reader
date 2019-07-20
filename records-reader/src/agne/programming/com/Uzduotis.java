package agne.programming.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Uzduotis {

	public static void main(String[] args) {

		Gson gson = new Gson();
		File jsonFile = new File ("assets/records_tweaked.json");
		File csvFile = new File ("assets/records.csv");
		
		try {
	
			
			Reader jsonReader = new FileReader(jsonFile);
			
			//create Athlete objects from JSON
			Athlete[] athletes = gson.fromJson(jsonReader, Athlete[].class);
			
			for (int i =0; i< athletes.length; i++) {
				System.out.println(athletes[i].getName());
			}
			
			//System.out.println(athlete);
			
			BufferedReader csvReader = new BufferedReader(new FileReader(csvFile));

			//skips first line "Athlete, Mark"
			String currLine = csvReader.readLine();

			while ((currLine = csvReader.readLine()) != null){

				String[] recordInfo = currLine.split(",");
				System.out.println(recordInfo[2] + ", " + recordInfo[1]);
			}
			csvReader.close();
			jsonReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class Athlete {
	
	@SerializedName("Rank")
	@Expose
	private Integer rank;
	@SerializedName("Mark")
	@Expose
	private String mark;
	@SerializedName("Athlete")
	@Expose
	private String name;
	@SerializedName("Date")
	@Expose
	private String date;
	@SerializedName("Location")
	@Expose
	private String location;

	/*public Athlete(Integer rank, String mark, String name, String date, String location) {
		this.rank = rank;
		this.mark = mark;
		this.name = name;
		this.date = date;
		this.location = location; 
	}*/

	public Integer getRank() {
		return rank;
	}

	public String getMark() {
		return mark;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getLocation() {
		return location;
	}

}

abstract class MyFileReader{

}


class CSVFileReader extends MyFileReader{
	

}

class JSONFileReader extends MyFileReader {
	
	
}

