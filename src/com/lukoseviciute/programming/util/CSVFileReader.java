package com.lukoseviciute.programming.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.lukoseviciute.programming.models.Athlete;

public class CSVFileReader implements FileReaderI{
	
	ArrayList<Athlete> csvAthleteList = new ArrayList<Athlete>();
	
	public CSVFileReader () {
		
	}
	
	@Override
	public List<Athlete> intoObjects(String fileStr) {
		File csvFile = new File (fileStr);
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
		
		return csvAthleteList;
			
	}

}
