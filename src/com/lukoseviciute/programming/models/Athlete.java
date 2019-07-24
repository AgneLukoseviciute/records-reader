package com.lukoseviciute.programming.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Athlete {

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

	public void checkForDifferences(Athlete athlete) {
		this.checkRank(athlete);
		this.checkMark(athlete);
		this.checkName(athlete);
		this.checkDate(athlete);
		this.checkLocation(athlete);
	}

	public void checkRank(Athlete athlete) {
		if (this.rank != athlete.rank){
			System.out.println("Athlete: " + this.getName() + ". Mismatch value: rank. CSV: " + this.getRank() + ", JSON: " + athlete.getRank());
		}
		else
			return;
	}

	public void checkMark(Athlete athlete) {
		if (!(this.mark.equals(athlete.mark))) {
			System.out.println("Athlete: " + this.getName() + ". Mismatch value: mark. CSV: " + this.getMark() + ", JSON: " + athlete.getMark());
		}
		else
			return;
	}

	public void checkName(Athlete athlete) {
		if (!(this.name.equals(athlete.name))) {
			System.out.println("Athlete: " + this.getName() + ". Mismatch value: name. CSV: " + this.getName() + ", JSON: " + athlete.getName());
		}
		else
			return;
	}

	public void checkDate(Athlete athlete) {
		if (!(this.date.equals(athlete.date))) {
			System.out.println("Athlete: " + this.getName() + ". Mismatch value: date. CSV: " + this.getDate() + ", JSON: " + athlete.getDate());
		}
		else
			return;
	}

	public void checkLocation(Athlete athlete) {
		if (!(this.location.equals(athlete.location))) {
			System.out.println("Athlete: " + this.getName() + ". Mismatch value: location. CSV: " + this.getLocation() + ", JSON: " + athlete.getLocation());
		}
		else
			return;
	}

}

