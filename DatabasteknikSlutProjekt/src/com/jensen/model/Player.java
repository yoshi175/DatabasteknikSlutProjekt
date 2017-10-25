package com.jensen.model;

/**
 * This class implements a player object representing a sumo player.
 * @author Takeyoshi
 * @version 1.0
 */
public class Player {

	private int id;
	private String name;
	private int heightCm;
	private int weightKg;
	private String birthdate;
	private String nativeCity;
	private String rank;
	private int coachId;
	private int clubId;
	private String coachName;
	private String clubName;

	//Constructor for retrieving player from database
	/**
	 * This constructs a sumo player with a specific id, name, height in CM, weight in KG,
	 * birthdate, native city, rank, the coach id the player is being coached by,
	 * the club id the player is playing in, the coach name the player is coached by and
	 * the club name the player is playing in.
	 * @param id the id of the player.
	 * @param name the name of the player.
	 * @param heightCm the height in CM, of the player.
	 * @param weightKg the weight in KG, of the player.
	 * @param birthdate the birthdate of the player.
	 * @param nativeCity the native city of the player.
	 * @param rank the rank of the player.
	 * @param coachId the id of the coach the player is being coached by.
	 * @param clubId the id of the club the player is playing in.
	 * @param coachName the name of the coach the player is being coached by.
	 * @param clubName the name of the club the player is playing in.
	 */
	public Player(int id, String name, int heightCm, int weightKg, String birthdate, String nativeCity, String rank, int coachId, int clubId, String coachName, String clubName) {
		this.id = id;
		this.name = name;
		this.heightCm = heightCm;
		this.weightKg = weightKg;
		this.birthdate = birthdate;
		this.nativeCity = nativeCity;
		this.rank = rank;
		this.coachId = coachId;
		this.clubId = clubId;
		this.coachName = coachName;
		this.clubName = clubName;
	}

	//Constructor for creating player
	/**
	 * This constructs a sumo player with a specific id, name, height in CM, weight in KG,
	 * birthdate, native city, rank, the coach id the player is being coached by and
	 * the club id the player is playing in.
	 * @param id the id of the player.
	 * @param name the name of the player.
	 * @param heightCm the height in CM, of the player.
	 * @param weightKg the weight in KG, of the player.
	 * @param birthdate the birthdate of the player.
	 * @param nativeCity the native city of the player.
	 * @param rank the rank of the player.
	 * @param coachId the id of the coach the player is being coached by.
	 * @param clubId the id of the club the player is playing in.
	 */
	public Player(int id, String name, int heightCm, int weightKg, String birthdate, String nativeCity, String rank, int coachId, int clubId) {
		this.id = id;
		this.name = name;
		this.heightCm = heightCm;
		this.weightKg = weightKg;
		this.birthdate = birthdate;
		this.nativeCity = nativeCity;
		this.rank = rank;
		this.coachId = coachId;
		this.clubId = clubId;
	}

	//Constructor for updating player
	/**
	 * This constructs a sumo player with a specific name, height in CM, weight in KG,
	 * birthdate, native city, rank, the coach id the player is being coached by and
	 * the club id the player is playing in.
	 * @param name the name of the player.
	 * @param heightCm the height in CM, of the player.
	 * @param weightKg the weight in KG, of the player.
	 * @param birthdate the birthdate of the player.
	 * @param nativeCity the native city of the player.
	 * @param rank the rank of the player.
	 * @param coachId the id of the coach the player is being coached by.
	 * @param clubId the id of the club the player is playing in.
	 */
	public Player(String name, int heightCm, int weightKg, String birthdate, String nativeCity, String rank, int coachId, int clubId) {
		this.name = name;
		this.heightCm = heightCm;
		this.weightKg = weightKg;
		this.birthdate = birthdate;
		this.nativeCity = nativeCity;
		this.rank = rank;
		this.coachId = coachId;
		this.clubId = clubId;
	}

	/**
	 * This constructs a player with none attribute initialized .
	 */
	public Player() {
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String toString = id + ", " + name + ", " + heightCm + ", " + weightKg + ", " + birthdate + ", " + nativeCity + ", " + rank + ", " + coachId + ", " + clubId;
		return toString; 
	}
	
	/**
	 * This method returns the id of a player.
	 * @return the id of a player.
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method returns the name of a player.
	 * @return the name of a player.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method returns the height of a player in CM.
	 * @return the height of a player in CM.
	 */
	public int getHeightCm() {
		return heightCm;
	}

	/**
	 * This method returns the weight of a player in KG.
	 * @return the weight of a player in KG.
	 */
	public int getWeightKg() {
		return weightKg;
	}

	/**
	 * This method returns the birthdate of a player.
	 * @return the birthdate of a player.
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * This method returns a players native city.
	 * @return a players native city.
	 */
	public String getNativeCity() {
		return nativeCity;
	}

	/**
	 * This method returns the rank of a player.
	 * @return the rank of a player.
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * This method returns the id of the coach a player is being coached by.
	 * @return the id of the coach a player is being coached by.
	 */
	public int getCoachId() {
		return coachId;
	}

	/**
	 * This method returns the id of a club where a player is playing in.
	 * @return the id of a club where a player is playing in.
	 */
	public int getClubId() {
		return clubId;
	}

	/**
	 * This method returns the name of the coach a player is being coached by.
	 * @return the name of the coach a player is being coached by.
	 */
	public String getCoachName() {
		return coachName;
	}

	/**
	 * This method returns the name of a club where a player is playing in.
	 * @return the name of a club where a player is playing in.
	 */
	public String getClubName() {
		return clubName;
	}

	/**
	 * This method sets the id of a player.
	 * @param id the id of a player.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This method sets the name of a player.
	 * @param name the name of a player.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *  This method sets the height of a player in CM.
	 * @param heightCm the height of a player in CM.
	 */
	public void setHeightCm(int heightCm) {
		this.heightCm = heightCm;
	}

	/**
	 * This method sets the weight of a player in KG.
	 * @param weightKg the weight of a player in KG.
	 */
	public void setWeightKg(int weightKg) {
		this.weightKg = weightKg;
	}

	/**
	 * This method sets the birthdate of a player.
	 * @param birthdate the birthdate of a player.
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * This method sets a players native city.
	 * @param nativeCity a players native city.
	 */
	public void setNativeCity(String nativeCity) {
		this.nativeCity = nativeCity;
	}

	/**
	 * This method sets the rank of a player.
	 * @param rank the rank of a player.
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * This method sets the id of the coach a player is being coached by.
	 * @param coachId the id of the coach a player is being coached by.
	 */
	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}

	/**
	 * This method sets the id of a club where a player is playing in.
	 * @param clubId the id of a club where a player is playing in.
	 */
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	/**
	 * This method sets the name of the coach a player is being coached by.
	 * @param coachName the name of the coach a player is being coached by.
	 */
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	/**
	 * This method sets the name of a club where a player is playing in.
	 * @param clubName the name of a club where a player is playing in.
	 */
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

}
