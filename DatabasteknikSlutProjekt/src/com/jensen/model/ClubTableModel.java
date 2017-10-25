package com.jensen.model;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

/**
 * This class implements converting from a LinkedList with Club object to a TableModel representing a table with sumo clubs.
 * @author Takeyoshi
 * @version 1.0
 * @see javax.swing.table.TableModel
 */
public class ClubTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -448727296796243150L;
	
	private static final int NAME_COL = 0;
	private static final int STARTING_YEAR_COL = 1;
	private static final int CITY_COL = 2;

	private String[] columnNames = {"Name", "Starting year", "City"};
	private LinkedList<Club> clubs;

	/**
	 * This constructs a ClubTableModel from a LinkedList with Club objects.
	 * @param clubs a LinkedList of all the clubs.
	 * @see Club
	 */
	public  ClubTableModel(LinkedList<Club> clubs) {
		this.clubs = clubs;
	}
	
	/**
	 * This method returns a LinkedList holding Club objects.
	 * @return a LinkedList holding Club objects.
	 * @see Club
	 */
	public LinkedList<Club> getClubs() {
		return clubs;
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
		return this.columnNames.length;
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return clubs.size();
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Club tempClub = clubs.get(rowIndex);
		if(columnIndex == NAME_COL) {
			return tempClub.getName();
		}
		else if(columnIndex == STARTING_YEAR_COL) {
			return tempClub.getStartingYear();
		}
		else if(columnIndex == CITY_COL) {
			return tempClub.getCity();
		}
		return clubs.get(rowIndex);
	}

}
