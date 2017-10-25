package com.jensen.model;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

/**
 * This class implements converting from a LinkedList with Player object to a TableModel representing a table with sumo players.
 * @author Takeyoshi
 * @version 1.0
 * @see javax.swing.table.TableModel
 */
public class PlayerTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -7971345418677476000L;
	
	private static final int NAME_COL = 0;
	private static final int HEIGHT_COL = 1;
	private static final int WEIGHT_COL = 2;
	private static final int BIRTHDATE_COL = 3;
	private static final int NATIVE_CITY_COL = 4;
	private static final int RANK_COL = 5;
	private static final int COACH_COL = 6;
	private static final int CLUB_COL = 7;

	String[] columnNames = {"Name", "Height (cm)", "Weight (kg)", "Birthdate", "Native city", "Rank", "Coach", "Club"};
	LinkedList<Player> players;

	/**
	 * This constructs a PlayerTableModel from a LinkedList with Player objects.
	 * @param players a LinkedList of all the players.
	 * @see Player
	 */
	public PlayerTableModel(LinkedList<Player> players) {
		this.players = players;
	}

	/**
	 * This method returns a LinkedList holding Player objects.
	 * @return a LinkedList holding Player objects.
	 * @see Player
	 */
	public LinkedList<Player> getPlayers() {
		return this.players;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return this.players.size();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Player tempPlayer = players.get(rowIndex);
		if(columnIndex == NAME_COL) {
			return tempPlayer.getName();
		}
		else if(columnIndex == HEIGHT_COL) {
			return tempPlayer.getHeightCm();
		}
		else if(columnIndex == WEIGHT_COL) {
			return tempPlayer.getWeightKg();
		}
		else if(columnIndex == BIRTHDATE_COL) {
			return tempPlayer.getBirthdate();
		}
		else if(columnIndex == NATIVE_CITY_COL) {
			return tempPlayer.getNativeCity();
		}
		else if(columnIndex == RANK_COL) {
			return tempPlayer.getRank();
		}
		else if(columnIndex == COACH_COL) {
			return tempPlayer.getCoachName();
		}
		else if(columnIndex == CLUB_COL) {
			return tempPlayer.getClubName();
		}
		return null;
	}

}
