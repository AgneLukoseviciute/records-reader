package agne.programming.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uzduotis {

	public static void main(String[] args) {
		CSVFileReader csvRead = new CSVFileReader();
		csvRead.intoObjects();
		csvRead.printObjects();
		
		JSONFileReader jsonRead = new JSONFileReader();
		jsonRead.intoObjects();
		jsonRead.printObjects();
	}
	
}

class Athlete {
	
	public Athlete(int rank, String mark, String name, String date, String location) {
		this.rank = rank;
		this.mark = mark;
		this.name = name;
		this.date = date;
		this.location = location;
	}
	
	@SerializedName("Rank")
	@Expose
	private int rank;
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

	public int getRank() {
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
	//nesugalvoju ka cia atskriti
}


class CSVFileReader extends MyFileReader{
	
	ArrayList<Athlete> csvAthleteList = new ArrayList<Athlete>();
	
	public CSVFileReader () {
		
	}
	
	public void intoObjects() {
		File csvFile = new File ("assets/records.csv");
		BufferedReader csvReader;
		try { 
			csvReader = new BufferedReader(new FileReader(csvFile));
			
			//skips first line - column names
			csvReader.readLine();
			
			String currLine;
			
			//creates an array of Athlete objects storing CSV data
			while ((currLine = csvReader.readLine()) != null) {
				String[] recordInfo = currLine.split(",");
				csvAthleteList.add(new Athlete((Integer.parseInt(recordInfo[0])), recordInfo[1], recordInfo[2], recordInfo[3], recordInfo[4]));
			}
			
			csvReader.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printObjects() {
		
		for (int i =0; i< csvAthleteList.size(); i++) {
			System.out.println(csvAthleteList.get(i).getName() + csvAthleteList.get(i).getMark());
		}
	}

}

class JSONFileReader extends MyFileReader {
	
	Athlete[] jsonAthletesArr = null;
	
	public JSONFileReader() {
		
	}
	
	public void intoObjects() {
		Gson gson = new Gson();
		File jsonFile = new File ("assets/records_tweaked.json");
		Reader jsonReader;
		
		try {
			jsonReader = new FileReader(jsonFile);
			
			//creates an array of Athlete objects storing JSON data
			jsonAthletesArr = gson.fromJson(jsonReader, Athlete[].class);

			jsonReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//for debugging
	public void printObjects() {
		
		for (int i =0; i< jsonAthletesArr.length; i++) {
			System.out.println(jsonAthletesArr[i].getName());
		}
	}
}

