package com.lukoseviciute.programming;


import java.util.List;

import com.lukoseviciute.programming.util.*;
import com.lukoseviciute.programming.models.Athlete;

public class Uzduotis {
	

	public static void main(String[] args) {
		CSVFileReader csvRead = new CSVFileReader();
		List<Athlete> csvAthleteList = csvRead.intoObjects("assets/records.csv");
		
		JSONFileReader jsonRead = new JSONFileReader();
		List<Athlete> jsonAthleteList = jsonRead.intoObjects("assets/records_tweaked.json");
		
		Uzduotis uzduotis = new Uzduotis();
		uzduotis.printDifferences(csvAthleteList, jsonAthleteList);
	}
	
	public void printDifferences(List<Athlete> csvObjectList, List<Athlete> jsonObjectList) {
		for (int i = 0; i < csvObjectList.size(); i++) {
			Athlete currCsvAthlete = csvObjectList.get(i);
			Athlete currJsonAthlete = jsonObjectList.get(i);
			currCsvAthlete.checkForDifferences(currJsonAthlete);
		}
	}
	
}

