package com.lukoseviciute.programming;

import java.util.List;
import com.lukoseviciute.programming.util.*;
import com.lukoseviciute.programming.models.Athlete;

public class Uzduotis {
	
	public Uzduotis(String csvFile, String jsonFile) {
		csvRead = new CSVFileReader();
		jsonRead = new JSONFileReader();
		csvAthleteList = csvRead.intoObjects(csvFile);
		jsonAthleteList = jsonRead.intoObjects(jsonFile);
	}
	
	private CSVFileReader csvRead;
	private JSONFileReader jsonRead;
	private List<Athlete> csvAthleteList;
	private List<Athlete> jsonAthleteList;

	public static void main(String[] args) {
		
		Uzduotis uzduotis = new Uzduotis("assets/records.csv", "assets/records_tweaked.json");
		uzduotis.printDifferences(uzduotis.csvAthleteList, uzduotis.jsonAthleteList);
	
	}
	
	public void printDifferences(List<Athlete> csvObjectList, List<Athlete> jsonObjectList) {
		for (int i = 0; i < csvObjectList.size(); i++) {
			Athlete currCsvAthlete = csvObjectList.get(i);
			Athlete currJsonAthlete = jsonObjectList.get(i);
			currCsvAthlete.checkForDifferences(currJsonAthlete);
		}
	}
	
}

