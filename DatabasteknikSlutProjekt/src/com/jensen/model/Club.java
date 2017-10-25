package com.jensen.model;

/**
 * This class implements a club object representing a sumo club.
 * @author Takeyoshi
 * @version 1.0
 */
public class Club {

	private int id;
	private String name;
	private String startingYear;
	private String city;

	//Constructor for retrieving and update club from database
	/**
	 * This constructs a sumo club with a specific id, name, starting year and city.
	 * @param id the id of the club.
	 * @param name the name of the club.
	 * @param startingYear the starting year of the club.
	 * @param city the city of the club.
	 */
	public Club(int id, String name, String startingYear, String city) {
		this.id = id;
		this.name = name;
		this.startingYear = startingYear;
		this.city = city;
	}

	//Constructor for creating club
	/**
	 * This constructs a sumo club with a specific name, starting year and city.
	 * @param name the name of the club.
	 * @param startingYear  the starting year of the club.
	 * @param city city of the club.
	 */
	public Club(String name, String startingYear, String city) {
		this.name = name;
		this.startingYear = startingYear;
		this.city = city;
	}

	/**
	 * This constructs a sumo club with none attribute initialized .
	 */
	public Club() {
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String toString = name;
		return toString;
	}

	/**
	 * This method returns the id of a club.
	 * @return the id of a club.
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method returns the name of a club.
	 * @return the name of a club.
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method returns the starting year of a club.
	 * @return the starting year of a club.
	 */
	public String getStartingYear() {
		return startingYear;
	}

	/**
	 * This method returns the city where the club is located.
	 * @return the city where the club is located.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * This method sets the id of a club.
	 * @param id the id of a club.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This method sets the name of a club.
	 * @param name the name of a club.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method sets the starting year of a club.
	 * @param startingYear the starting year of a club.
	 */
	public void setStartingYear(String startingYear) {
		this.startingYear = startingYear;
	}

	/**
	 * This method sets the city where the club is located.
	 * @param city the city where the club is located.
	 */
	public void setCity(String city) {
		this.city = city;
	}

}
