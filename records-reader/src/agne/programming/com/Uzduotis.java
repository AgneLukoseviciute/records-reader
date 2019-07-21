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
import com.google.gson.reflect.TypeToken;

public class Uzduotis {
	

	public static void main(String[] args) {
		CSVFileReader csvRead = new CSVFileReader();
		csvRead.intoObjects();
		
		JSONFileReader jsonRead = new JSONFileReader();
		jsonRead.intoObjects();
		
		Uzduotis uzduotis = new Uzduotis();
		uzduotis.printDifferences(CSVFileReader.csvAthleteList, JSONFileReader.jsonAthleteList);
	}
	
	public void printDifferences(ArrayList<Athlete> csvObjectList, ArrayList<Athlete> jsonObjectList) {
		for (int i = 0; i < csvObjectList.size(); i++) {
			Athlete currCsvAthlete = csvObjectList.get(i);
			Athlete currJsonAthlete = jsonObjectList.get(i);
			currCsvAthlete.checkForDifference(currJsonAthlete);
		}
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
	
	//reikia pakeisti jei gali buti daugiau negu viena klaida
	public void checkForDifference(Athlete athlete) {
		//finds what the difference is and provides that value of CSV and SJON
		if (this.rank != athlete.rank){
			System.out.println(this.getName() + " rank mismatch. CSV: " + this.getRank() + ", JSON: " + athlete.getRank());
		}
		else if (!(this.mark.equals(athlete.mark))) {
			System.out.println(this.getName() + " mark mismatch. CSV: " + this.getMark() + ", JSON: " + athlete.getMark());
		}
		else if (!(this.name.equals(athlete.name))) {
			System.out.println(this.getName() + " name mismatch. CSV: " + this.getName() + ", JSON: " + athlete.getName());
		}
		else if (!(this.date.equals(athlete.date))) {
			System.out.println(this.getName() + " date mismatch. CSV: " + this.getDate() + ", JSON: " + athlete.getDate());
		}
		else if (!(this.location.equals(athlete.location))) {
			System.out.println(this.getName() + " location mismatch. CSV: " + this.getLocation() + ", JSON: " + athlete.getLocation());
		}
		else
			return;
	}
	

}

abstract class MyFileReader{
	//nesugalvoju ka cia atskriti
}


class CSVFileReader extends MyFileReader{
	
	public static ArrayList<Athlete> csvAthleteList = new ArrayList<Athlete>();
	
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
	
}

class JSONFileReader extends MyFileReader {
	
	public static ArrayList<Athlete> jsonAthleteList = new ArrayList<Athlete>();
	
	public JSONFileReader() {
		
	}
	
	public void intoObjects() {
		Gson gson = new Gson();
		File jsonFile = new File ("assets/records_tweaked.json");
		Reader jsonReader;
		
		try {
			jsonReader = new FileReader(jsonFile);
			
			//creates an array of Athlete objects storing JSON data
			jsonAthleteList = gson.fromJson(jsonReader, new TypeToken<ArrayList<Athlete>>(){}.getType());
			

			jsonReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

