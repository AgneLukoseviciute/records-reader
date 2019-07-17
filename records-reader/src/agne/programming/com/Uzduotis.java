package agne.programming.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Uzduotis {

	public static void main(String[] args) {

		if(args.length < 1) {
			System.out.println("No text file provided");
			System.exit(1);
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
			String currLine = "";

			while ((currLine = reader.readLine()) != null){

				String[] recordInfo = currLine.split(",");
				System.out.println(recordInfo[2] + ", " + recordInfo[1]);
			}


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
