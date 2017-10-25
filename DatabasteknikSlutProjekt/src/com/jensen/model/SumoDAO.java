package com.jensen.model;

import java.util.LinkedList;

/**
 * This interface implements methods, used to communicate with database mananger (MySQL), on the CRUD terms.
 * @author Takeyoshi
 * @version 1.0
 */
public interface SumoDAO {

	/**
	 * This method creates a new club in the database.
	 * @param clubObject a Club object that holding all the information about the new club.
	 * @see Club
	 */
	void createClub(Club clubObject);
	/**
	 * This method returns a LinkedList holding all the clubs in the database.
	 * @return a LinkedList holding all the clubs in the database.
	 * @see Club
	 */
	LinkedList<Club> readAllClubs();
	/**
	 * This method updates an existing club in the database.
	 * @param clubObject a Club object that holding all the new information about the club that wants to be updated.
	 * @see Club
	 */
	void updateClub(Club clubObject);
	/**
	 * This method deletes an existing club in the database.
	 * @param clubObject a Club object that holding all the information about the club that wants to be deleted.
	 * @see Club
	 */
	void deleteClub(Club clubObject);
	/**
	 * This method returns a LinkedList holding clubs of a search by club name, in the database.
	 * @param name a club name that wishes to be searched for.
	 * @return a LinkedList holding all the clubs that meets the searching terms.
	 * @see Club
	 */
	LinkedList<Club> searchClub(String name);

	/**
	 * This method creates a new coach in the database.
	 * @param coachObject a Coach object that holding all the information about the new coach.
	 * @see Coach
	 */
	void createCoach(Coach coachObject);
	/**
	 * This method returns a LinkedList holding all the coaches in the database.
	 * @return a LinkedList holding all the coaches in the database.
	 * @see Coach
	 */
	LinkedList<Coach> readAllCoaches();
	/**
	 * This method updates an existing coach in the database.
	 * @param coachObject a Coach object that holding all the new information about the coach that wants to be updated.
	 * @see Coach
	 */
	void updateCoach(Coach coachObject);
	/**
	 * This method deletes an existing coach in the database.
	 * @param coachObject
	 * @see Coach a Coach object that holding all the information about the coach that wants to be deleted.
	 */
	void deleteCoach(Coach coachObject);
	/**
	 * This method returns a LinkedList holding coaches of a search by club name, in the database.
	 * @param name  a coach name that wishes to be searched for.
	 * @return a LinkedList holding all the coaches that meets the searching terms.
	 * @see Coach
	 */
	LinkedList<Coach> searchCoach(String name);

	/**
	 * This method creates a new player in the database.
	 * @param playerObject a Player object that holding all the information about the new player.
	 * @see Player
	 */
	void createPlayer(Player playerObject);
	/**
	 * This method returns a LinkedList holding all the players in the database.
	 * @return a LinkedList holding all the players in the database.
	 * @see Player
	 */
	LinkedList<Player> readAllPlayers();
	/**
	 * This method updates an existing player in the database.
	 * @param playerOject a Coach object that holding all the new information about the player that wants to be updated.
	 * @see Player
	 */
	void updatePlayer(Player playerOject);
	/**
	 * This method deletes an existing player in the database.
	 * @param playerObject a Player object that holding all the information about the player that wants to be deleted.
	 * @see Player
	 */
	void deletePlayer(Player playerObject);
	/**
	 * This method returns a LinkedList holding players of a search by club name, in the database.
	 * @param name  a player name that wishes to be searched for.
	 * @return a LinkedList holding all the players that meets the searching terms.
	 * @see Player
	 */
	LinkedList<Player> searchPlayer(String name);

}
