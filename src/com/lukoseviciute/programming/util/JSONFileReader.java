package com.lukoseviciute.programming.util;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lukoseviciute.programming.models.Athlete;

public class JSONFileReader {
	
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
