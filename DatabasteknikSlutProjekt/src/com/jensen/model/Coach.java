package com.jensen.model;

/**
 * This class implements a coach object representing a sumo caoch.
 * @author Takeyoshi
 * @version 1.0
 */
public class Coach {

	private int id;
	private String name;
	private String birthdate;
	private String highestRank;
	private int competitiveMatches;
	private int competitiveWins;
	private int competitiveLosses;
	private String retiredFromCompeting;
	private int clubId;
	private String clubName;
	
	//Constructor for retrieving player from database
	/**
	 * This constructs a sumo coach with a specific id, name, birthdate, highest rank,
	 * total competitive matches played, total competitive wins, total competitive losses,
	 * retiring date from competing, club id and club name.
	 * @param id the id of the coach.
	 * @param name the id of the coach.
	 * @param birthdate the birhtdate of the coach.
	 * @param highestRank the coach highest rank.
	 * @param competitiveMatches total competitive matches played by the coach.
	 * @param competitiveWins the coach total competitive wins.
	 * @param competitiveLosses the coach total competitive losses.
	 * @param retiredFromCompeting the coach retiring date from competing.
	 * @param clubId the id of the club the coach coaching at.
	 * @param clubName the name of the club the coach is coaching at.
	 */
	public Coach(int id, String name, String birthdate, String highestRank, int competitiveMatches,
			int competitiveWins, int competitiveLosses, String retiredFromCompeting, int clubId, String clubName) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.highestRank = highestRank;
		this.competitiveMatches = competitiveMatches;
		this.competitiveWins = competitiveWins;
		this.competitiveLosses = competitiveLosses;
		this.retiredFromCompeting = retiredFromCompeting;
		this.clubId = clubId;
		this.clubName = clubName;
	}
	
	//Constructor for updating coach
	/**
	 * This constructs a sumo coach with a specific id, name, birthdate, highest rank,
	 * total competitive matches played, total competitive wins, total competitive losses,
	 * retiring date from competing and club id.
	 * @param id the id of the coach.
	 * @param name the id of the coach.
	 * @param birthdate the birhtdate of the coach.
	 * @param highestRank the coach highest rank.
	 * @param competitiveMatches total competitive matches played by the coach.
	 * @param competitiveWins the coach total competitive wins.
	 * @param competitiveLosses the coach total competitive losses.
	 * @param retiredFromCompeting the coach retiring date from competing.
	 * @param clubId the id of the club the coach is coaching at.
	 */
	public Coach(int id, String name, String birthdate, String highestRank, int competitiveMatches,
			int competitiveWins, int competitiveLosses, String retiredFromCompeting, int clubId) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.highestRank = highestRank;
		this.competitiveMatches = competitiveMatches;
		this.competitiveWins = competitiveWins;
		this.competitiveLosses = competitiveLosses;
		this.retiredFromCompeting = retiredFromCompeting;
		this.clubId = clubId;
	}
	
	//Constructor for creating coach
	/**
	 * This constructs a sumo coach with a specific name, birthdate, highest rank,
	 * total competitive matches played, total competitive wins, total competitive losses,
	 * retiring date from competing and club id.
	 * @param name the id of the coach.
	 * @param birthdate the birhtdate of the coach.
	 * @param highestRank the coach highest rank.
	 * @param competitiveMatches total competitive matches played by the coach.
	 * @param competitiveWins the coach total competitive wins.
	 * @param competitiveLosses the coach total competitive losses.
	 * @param retiredFromCompeting the coach retiring date from competing.
	 * @param clubId the id of the club the coach is coaching at.
	 */
	public Coach(String name, String birthdate, String highestRank, int competitiveMatches,
			int competitiveWins, int competitiveLosses, String retiredFromCompeting, int clubId) {
		this.name = name;
		this.birthdate = birthdate;
		this.highestRank = highestRank;
		this.competitiveMatches = competitiveMatches;
		this.competitiveWins = competitiveWins;
		this.competitiveLosses = competitiveLosses;
		this.retiredFromCompeting = retiredFromCompeting;
		this.clubId = clubId;
	}

	/**
	 * This constructs a sumo coach with none attribute initialized .
	 */
	public Coach() {
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
	 * This method returns the id of a coach.
	 * @return the id of a coach.
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method returns the name of a coach.
	 * @return the name of a coach.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method returns the birthdate of a coach.
	 * @return the birthdate of a coach.
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * This method returns a coach highest rank.
	 * @return a coach highest rank.
	 */
	public String getHighestRank() {
		return highestRank;
	}

	/**
	 * This method returns the total competitive matched played by a coach.
	 * @return the total competitive matched played by a coach.
	 */
	public int getCompetitiveMatches() {
		return competitiveMatches;
	}

	/**
	 * This method returns the total competitive wins played by a coach.
	 * @return the total competitive wins played by a coach.
	 */
	public int getCompetitiveWins() {
		return competitiveWins;
	}

	/**
	 * This method returns the total competitive losses played by a coach.
	 * @return the total competitive wins played by a coach.
	 */
	public int getCompetitiveLosses() {
		return competitiveLosses;
	}

	/**
	 * This method returns a coach retiring date from competing.
	 * @return a coach retiring date from competing.
	 */
	public String getRetiredFromCompeting() {
		return retiredFromCompeting;
	}

	/**
	 * This method returns the id of a club where a coach is coaching at.
	 * @return the id of a club where a coach is coaching at.
	 */
	public int getClubId() {
		return clubId;
	}

	/**
	 * This method returns the name of a club where a coach is coaching at.
	 * @return the name of a club where a coach is coaching at.
	 */
	public String getClubName() {
		return clubName;
	}

	/**
	 * This method sets the id of a coach.
	 * @param id the id of a coach.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This method sets the name of a coach.
	 * @param name the name of a coach.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method sets the birthdate of a coach.
	 * @param birthdate the birthdate of a coach.
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * This method sets a coach highest rank.
	 * @param highestRank a coach highest rank.
	 */
	public void setHighestRank(String highestRank) {
		this.highestRank = highestRank;
	}

	/**
	 * This method sets the total competitive matched played by a coach.
	 * @param competitiveMatches the total competitive matched played by a coach.
	 */
	public void setCompetitiveMatches(int competitiveMatches) {
		this.competitiveMatches = competitiveMatches;
	}

	/**
	 * This method sets the total competitive wins played by a coach.
	 * @param competitiveWins the total competitive wins played by a coach.
	 */
	public void setCompetitiveWins(int competitiveWins) {
		this.competitiveWins = competitiveWins;
	}

	/**
	 * This method sets the total competitive losses played by a coach.
	 * @param competitiveLosses the total competitive losses played by a coach.
	 */
	public void setCompetitiveLosses(int competitiveLosses) {
		this.competitiveLosses = competitiveLosses;
	}

	/**
	 * This method sets a coach retiring date from competing.
	 * @param retiredFromCompeting a coach retiring date from competing.
	 */
	public void setRetiredFromCompeting(String retiredFromCompeting) {
		this.retiredFromCompeting = retiredFromCompeting;
	}

	/**
	 * This method sets the id of a club where a coach is coaching at.
	 * @param clubId the id of a club where a coach is coaching at.
	 */
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	/**
	 * This method sets the name of a club where a coach is coaching at.
	 * @param clubName the name of a club where a coach is coaching at.
	 */
	public void setClub(String clubName) {
		this.clubName = clubName;
	}

}
