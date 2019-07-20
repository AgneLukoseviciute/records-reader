package agne.programming.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uzduotis {

	public static void main(String[] args) {
		CSVFileReader csvRead = new CSVFileReader();
		csvRead.printInfo();
		
		JSONFileReader jsonRead = new JSONFileReader();
		jsonRead.printInfo();
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
	
	public CSVFileReader () {
		
	}
	
	public void printInfo() {
		File csvFile = new File ("assets/records.csv");
		BufferedReader csvReader;
		try {
			csvReader = new BufferedReader(new FileReader(csvFile));
			
			//skips first line "Athlete, Mark"
			String currLine = csvReader.readLine();

			while ((currLine = csvReader.readLine()) != null){

				String[] recordInfo = currLine.split(",");
				System.out.println(recordInfo[2] + ", " + recordInfo[1]);
			}
			
			csvReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class JSONFileReader extends MyFileReader {
	
	public JSONFileReader() {
		
	}
	
	public void printInfo() {
		Gson gson = new Gson();
		File jsonFile = new File ("assets/records_tweaked.json");
		Reader jsonReader;
		
		try {
			jsonReader = new FileReader(jsonFile);
			
			//creates an array of athlete objects storing JSON data
			Athlete[] athletes = gson.fromJson(jsonReader, Athlete[].class);
			
			for (int i =0; i< athletes.length; i++) {
				System.out.println(athletes[i].getName());
			}
			jsonReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

