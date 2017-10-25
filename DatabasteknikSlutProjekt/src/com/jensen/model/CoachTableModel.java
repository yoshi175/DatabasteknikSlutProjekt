package com.jensen.model;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

/**
 * This class implements converting from a LinkedList with Coach object to a TableModel representing a table with sumo coaches.
 * @author Takeyoshi
 * @version 1.0
 * @see javax.swing.table.TableModel
 */
public class CoachTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 5251316223561046956L;
	
	private static final int NAME_COL = 0;
	private static final int BIRTHDATE_COL = 1;
	private static final int HIGHEST_RANK_COL = 2;
	private static final int COMPETITIVE_MATCHES_COL = 3;
	private static final int COMPETITIVE_WINS_COL = 4;
	private static final int COMPETITIVE_LOSSES_COL = 5;
	private static final int RETIRED_COL = 6;
	private static final int CLUB_COL = 7;

	private String[] columnNames = {"Name", "Birthdate", "Highest rank", "Competitive matches", "Competitive wins", "Competitive losses", "Retired", "Club"};
	private LinkedList<Coach> coaches;

	/**
	 * This constructs a CoachTableModel from a LinkedList with Coach objects.
	 * @param coaches a LinkeList of all the coaches.
	 * @see Coach
	 */
	public CoachTableModel(LinkedList<Coach> coaches) {
		this.coaches = coaches;
	}

	/**
	 * This method returns a LinkedList holding Coach objects.
	 * @return a LinkedList holding Coach objects.
	 * @see Coach
	 */
	public LinkedList<Coach> getCoaches() {
		return this.coaches;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int column) {
		return this.columnNames[column];
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return coaches.size();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Coach tempCoach = coaches.get(rowIndex);
		if(columnIndex == NAME_COL) {
			return tempCoach.getName();
		}
		else if(columnIndex == BIRTHDATE_COL) {
			return tempCoach.getBirthdate();
		}
		else if(columnIndex == HIGHEST_RANK_COL) {
			return tempCoach.getHighestRank();
		}
		else if(columnIndex == COMPETITIVE_MATCHES_COL) {
			return tempCoach.getCompetitiveMatches();
		}
		else if(columnIndex == COMPETITIVE_WINS_COL) {
			return tempCoach.getCompetitiveWins();
		}
		else if(columnIndex == COMPETITIVE_LOSSES_COL) {
			return tempCoach.getCompetitiveLosses();
		}
		else if(columnIndex == RETIRED_COL) {
			return tempCoach.getRetiredFromCompeting();
		}
		else if(columnIndex == CLUB_COL) {
			return tempCoach.getClubName();
		}
		return null;
	}
}
