package com.lukoseviciute.programming;


import java.util.ArrayList;
import com.lukoseviciute.programming.util.*;
import com.lukoseviciute.programming.models.Athlete;

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
			currCsvAthlete.checkForDifferences(currJsonAthlete);
		}
	}
	
}

