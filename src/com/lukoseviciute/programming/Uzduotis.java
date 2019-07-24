package com.lukoseviciute.programming;

import java.util.List;
import com.lukoseviciute.programming.util.*;
import com.lukoseviciute.programming.models.Athlete;

public class Uzduotis {
	
	public Uzduotis(String csvFile, String jsonFile, String xmlFile) {
		csvRead = new CSVFileReader();
		jsonRead = new JSONFileReader();
		xmlRead = new XMLFileReader();
		csvAthleteList = csvRead.intoObjects(csvFile);
		jsonAthleteList = jsonRead.intoObjects(jsonFile);
		xmlAthleteList = xmlRead.intoObjects(xmlFile);
	}
	
	private CSVFileReader csvRead;
	private JSONFileReader jsonRead;
	private XMLFileReader xmlRead;
	private List<Athlete> csvAthleteList;
	private List<Athlete> jsonAthleteList;
	private List<Athlete> xmlAthleteList;

	public static void main(String[] args) {
		
		Uzduotis uzduotis = new Uzduotis("assets/records.csv", "assets/records_tweaked.json", "assets/records_tweaked.xml");
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

