package com.jensen.model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

/**
 * This class implements the connection to the sumo database manager (MySQL), using Java Database Connectivity (JDBC).
 * @author Takeyoshi
 * @version 1.0
 */
public class Model implements SumoDAO {

	Connection connection;
	PreparedStatement statement;
	ResultSet result;

	LinkedList<Club> clubList;
	LinkedList<Coach> coachList;
	LinkedList<Player> playerList;

	/**
	 * This constructs a connection to the database.
	 */
	public Model() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("config.properties"));
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sumo", "root", "");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method returns a LinkedList object holding all the clubs in the database.
	 * @return a LinkedList object holding all the clubs in the database.
	 * @see Club
	 */
	public LinkedList<Club> getClubList() {
		return clubList;
	}

	/**
	 * This method returns a LinkedList object holding all the coaches in the database.
	 * @return a LinkedList object holding all the coaches in the database.
	 * @see Coach
	 */
	public LinkedList<Coach> getCoachList() {
		return coachList;
	}

	/**
	 * This method returns a LinkedList object holding all the players in the database.
	 * @return a LinkedList object holding all the players in the database.
	 * @see Player
	 */
	public LinkedList<Player> getPlayerList() {
		return playerList;
	}
	
	//Club methods
	private Club convertRowToClubObject(ResultSet result) {
		Club club = new Club();
		try {
			club.setId(result.getInt("id"));
			club.setName(result.getString("name"));
			club.setStartingYear(result.getString("starting_year"));
			club.setCity(result.getString("city"));
			//Club club = new Club(result.getInt("id"), result.getString("name"), result.getString("starting_year"), result.getString("city"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return club;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#createClub(com.jensen.model.Club)
	 */
	@Override
	public void createClub(Club clubObject) {
		try {
			statement = connection.prepareStatement("INSERT INTO club (name, starting_year, city) VALUES (?, ?, ?)");
			statement.setString(1, clubObject.getName());
			statement.setString(2, clubObject.getStartingYear());
			statement.setString(3, clubObject.getCity());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#readAllClubs()
	 */
	@Override
	public LinkedList<Club> readAllClubs() {
		this.clubList = new LinkedList<>();

		try {
			this.statement = connection.prepareStatement("SELECT * FROM club GROUP BY name");
			this.result = statement.executeQuery();
			while(this.result.next()) {
				clubList.add(convertRowToClubObject(this.result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clubList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#updateClub(com.jensen.model.Club)
	 */
	@Override
	public void updateClub(Club clubObject) {

		try {
			statement = connection.prepareStatement("UPDATE club SET name=?, starting_year=?, city=? WHERE id=?");
			statement.setString(1, clubObject.getName());
			statement.setString(2, clubObject.getStartingYear());
			statement.setString(3, clubObject.getCity());
			statement.setInt(4, clubObject.getId());
			statement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#deleteClub(com.jensen.model.Club)
	 */
	@Override
	public void deleteClub(Club clubObject) {
		try {
			statement = connection.prepareStatement("DELETE FROM club WHERE id=?");
			statement.setInt(1, clubObject.getId());
			statement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#searchClub(java.lang.String)
	 */
	@Override
	public LinkedList<Club> searchClub(String name) {
		name = "%" + name + "%";
		LinkedList<Club> tempClubList = new LinkedList<>();
		this.clubList = new LinkedList<>();
		try {
			statement = connection.prepareStatement("SELECT * FROM club WHERE name LIKE ? GROUP BY name");
			statement.setString(1, name);
			result = statement.executeQuery();
			while(result.next()) {
				tempClubList.add(convertRowToClubObject(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.clubList = tempClubList;
		return this.clubList;
	}
	//Club methods ends ------------------------------------------------------------------------------------

	//Coach methods
	private Coach convertRowToCoachObject(ResultSet result) {
		Coach coach = new Coach();
		try {
			coach.setId(result.getInt("id"));
			coach.setName(result.getString("name"));
			coach.setBirthdate(result.getString("birthdate"));
			coach.setHighestRank(result.getString("highest_rank"));
			coach.setCompetitiveMatches(result.getInt("competitive_matches"));
			coach.setCompetitiveWins(result.getInt("competitive_wins"));
			coach.setCompetitiveLosses(result.getInt("competitive_losses"));
			coach.setRetiredFromCompeting(result.getString("retired_from_competing"));
			coach.setClubId(result.getInt("club_id"));
			coach.setClub(result.getString("club_name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coach;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#createCoach(com.jensen.model.Coach)
	 */
	@Override
	public void createCoach(Coach coachObject) {

		try {
			statement = connection.prepareStatement("INSERT INTO coach (name, birthdate, highest_rank,"
					+ "competitive_matches, competitive_wins, competitive_losses, retired_from_competing,"
					+ "club_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, coachObject.getName());
			statement.setString(2, coachObject.getBirthdate());
			statement.setString(3, coachObject.getHighestRank());
			statement.setInt(4, coachObject.getCompetitiveMatches());
			statement.setInt(5, coachObject.getCompetitiveWins());
			statement.setInt(6, coachObject.getCompetitiveLosses());
			statement.setString(7, coachObject.getRetiredFromCompeting());
			statement.setInt(8, coachObject.getClubId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#readAllCoaches()
	 */
	@Override
	public LinkedList<Coach> readAllCoaches() {
		this.coachList = new LinkedList<>();
		try {
			statement = connection.prepareStatement("SELECT * FROM fullCoach GROUP BY name");
			result = statement.executeQuery();
			while(result.next()) {
				coachList.add(convertRowToCoachObject(result));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return coachList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#updateCoach(com.jensen.model.Coach)
	 */
	@Override
	public void updateCoach(Coach coachObject) {
		try {
			statement = connection.prepareStatement("UPDATE coach SET name=?, birthdate=?,"
					+ "highest_rank=?, competitive_matches=?, competitive_wins=?,"
					+ "competitive_losses=?, retired_from_competing=?, club_id=? WHERE id=?");
			statement.setString(1, coachObject.getName());
			statement.setString(2, coachObject.getBirthdate());
			statement.setString(3, coachObject.getHighestRank());
			statement.setInt(4, coachObject.getCompetitiveMatches());
			statement.setInt(5, coachObject.getCompetitiveWins());
			statement.setInt(6, coachObject.getCompetitiveLosses());
			statement.setString(7, coachObject.getRetiredFromCompeting());
			statement.setInt(8, coachObject.getClubId());
			statement.setInt(9, coachObject.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#deleteCoach(com.jensen.model.Coach)
	 */
	@Override
	public void deleteCoach(Coach coachObject) {
		try {
			statement = connection.prepareStatement("DELETE FROM coach WHERE id=?");
			statement.setInt(1, coachObject.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#searchCoach(java.lang.String)
	 */
	@Override
	public LinkedList<Coach> searchCoach(String name) {
		name = "%" + name + "%";
		LinkedList<Coach> tempCoachList = new LinkedList<>();
		try {
			statement = connection.prepareStatement("SELECT * FROM fullCoach WHERE name LIKE ? GROUP BY name");
			statement.setString(1, name);
			result = statement.executeQuery();
			while(result.next()) {
				tempCoachList.add(convertRowToCoachObject(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.coachList = tempCoachList;
		return this.coachList;
	}
	//Coach methods ends ------------------------------------------------------------------------------------

	//Player methods
	private Player convertRowToPlayerObject(ResultSet result) {
		Player player = new Player();
		try {
			player.setId(result.getInt("id"));
			player.setName(result.getString("name"));
			player.setHeightCm(result.getInt("height_cm"));
			player.setWeightKg(result.getInt("weight_kg"));
			player.setBirthdate(result.getString("birthdate"));
			player.setNativeCity(result.getString("native_city"));
			player.setRank(result.getString("rank"));
			player.setCoachId(result.getInt("coach_id"));
			player.setClubId(result.getInt("club_id"));
			player.setCoachName(result.getString("coach_name"));
			player.setClubName(result.getString("club_name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return player;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#createPlayer(com.jensen.model.Player)
	 */
	@Override
	public void createPlayer(Player playerObject) {
		try {
			statement = connection.prepareStatement("INSERT INTO player (name, height_cm, weight_kg,"
					+ "birthdate, native_city, rank, coach_id, club_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, playerObject.getName());
			statement.setInt(2, playerObject.getHeightCm());
			statement.setInt(3, playerObject.getWeightKg());
			statement.setString(4, playerObject.getBirthdate());
			statement.setString(5, playerObject.getNativeCity());
			statement.setString(6, playerObject.getRank());
			statement.setInt(7, playerObject.getCoachId());
			statement.setInt(8, playerObject.getClubId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#readAllPlayers()
	 */
	@Override
	public LinkedList<Player> readAllPlayers() {
		this.playerList = new LinkedList<>();
		try {
			statement = connection.prepareStatement("SELECT * FROM fullPlayer GROUP BY name");
			result = statement.executeQuery();
			while(result.next()) {
				playerList.add(convertRowToPlayerObject(result));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return playerList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#updatePlayer(com.jensen.model.Player)
	 */
	@Override
	public void updatePlayer(Player playerOject) {
		try {
			statement = connection.prepareStatement("UPDATE player SET name=?, height_cm=?, weight_kg=?,"
					+ "birthdate=?, native_city=?, rank=?, coach_id=?, club_id=? WHERE id=?");
			statement.setString(1, playerOject.getName());
			statement.setInt(2, playerOject.getHeightCm());
			statement.setInt(3, playerOject.getWeightKg());
			statement.setString(4, playerOject.getBirthdate());
			statement.setString(5, playerOject.getNativeCity());
			statement.setString(6, playerOject.getRank());
			statement.setInt(7, playerOject.getCoachId());
			statement.setInt(8, playerOject.getClubId());
			statement.setInt(9, playerOject.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#deletePlayer(com.jensen.model.Player)
	 */
	@Override
	public void deletePlayer(Player playerObject) {
		try {
			statement = connection.prepareStatement("DELETE FROM player WHERE id=?");
			statement.setInt(1, playerObject.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jensen.model.SumoDAO#searchPlayer(java.lang.String)
	 */
	@Override
	public LinkedList<Player> searchPlayer(String name) {
		name = "%" + name + "%";
		LinkedList<Player> tempPlayerList = new LinkedList<>();
		try {
			statement = connection.prepareStatement("SELECT * FROM fullPlayer WHERE name LIKE ? GROUP BY name");
			statement.setString(1, name);
			result = statement.executeQuery();
			while(result.next()) {
				tempPlayerList.add(convertRowToPlayerObject(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.playerList = tempPlayerList;
		return playerList;
	}
	//Player methods ends ------------------------------------------------------------------------------------

}
