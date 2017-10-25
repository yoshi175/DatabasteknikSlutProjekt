package com.jensen.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jensen.model.Club;

/**
 * This class implements a GUI dialog window for the application sumo database that gives the user the opportunity to create a coach.
 * @author Takeyoshi
 * @version 1.0
 */
public class CreateCoachDialog extends JDialog {
	
	private static final long serialVersionUID = 7336268410422923742L;

	private final JPanel contentPanel = new JPanel();
	
	private JTextField textFieldName;
	private JTextField textFieldWins;
	private JTextField textFieldLosses;

	private JComboBox<String> comboBoxBirthdateYear;
	private JComboBox<String> comboBoxBirthdateMonth;
	private JComboBox<String> comboBoxBirthdateDay;
	private JComboBox<String> comboBoxHighestRank;
	private JComboBox<String> comboBoxRetiredYear;
	private JComboBox<String> comboBoxRetiredMonth;
	private JComboBox<Club> comboBoxClub;
	
	private JButton btnAddCoach;
	
	/**
	 * This constructs a dialog window for creating a coach.
	 */
	public CreateCoachDialog() {
		pack();
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("Create coach");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("Name");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.EAST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 0;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			textFieldName = new JTextField();
			GridBagConstraints gbc_textFieldName = new GridBagConstraints();
			gbc_textFieldName.gridwidth = 3;
			gbc_textFieldName.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldName.gridx = 1;
			gbc_textFieldName.gridy = 0;
			contentPanel.add(textFieldName, gbc_textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblBirthdate = new JLabel("Birthdate");
			GridBagConstraints gbc_lblBirthdate = new GridBagConstraints();
			gbc_lblBirthdate.anchor = GridBagConstraints.EAST;
			gbc_lblBirthdate.insets = new Insets(0, 0, 5, 5);
			gbc_lblBirthdate.gridx = 0;
			gbc_lblBirthdate.gridy = 1;
			contentPanel.add(lblBirthdate, gbc_lblBirthdate);
		}
		{
			String[] birthdateYear = new String[100];
			for(int i=0, j=2017; i<100; i++, j--) {
				birthdateYear[i] = j + "";
			}
			comboBoxBirthdateYear = new JComboBox<String>(birthdateYear);
			GridBagConstraints gbc_comboBoxBirthdateYear = new GridBagConstraints();
			gbc_comboBoxBirthdateYear.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxBirthdateYear.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxBirthdateYear.gridx = 1;
			gbc_comboBoxBirthdateYear.gridy = 1;
			contentPanel.add(comboBoxBirthdateYear, gbc_comboBoxBirthdateYear);
		}
		{
			String[] birthdateMonth = new String[12];
			for(int i=0; i<12; i++) {
				if(i<9)
					birthdateMonth[i] = "0" + (i+1);
				else
					birthdateMonth[i] = (i+1) + "";
			}
			comboBoxBirthdateMonth = new JComboBox<String>(birthdateMonth);
			GridBagConstraints gbc_comboBoxBirthdateMonth = new GridBagConstraints();
			gbc_comboBoxBirthdateMonth.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxBirthdateMonth.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxBirthdateMonth.gridx = 2;
			gbc_comboBoxBirthdateMonth.gridy = 1;
			contentPanel.add(comboBoxBirthdateMonth, gbc_comboBoxBirthdateMonth);
		}
		{
			String[] birthdateDay = new String[31];
			for(int i=0; i<31; i++) {
				if(i<9)
					birthdateDay[i] = "0" + (i+1);
				else
					birthdateDay[i] = (i+1) + "";
			}
			comboBoxBirthdateDay = new JComboBox<String>(birthdateDay);
			GridBagConstraints gbc_comboBoxBirthdateDay = new GridBagConstraints();
			gbc_comboBoxBirthdateDay.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxBirthdateDay.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxBirthdateDay.gridx = 3;
			gbc_comboBoxBirthdateDay.gridy = 1;
			contentPanel.add(comboBoxBirthdateDay, gbc_comboBoxBirthdateDay);
		}
		{
			JLabel lblHighestRank = new JLabel("Highest rank");
			GridBagConstraints gbc_lblHighestRank = new GridBagConstraints();
			gbc_lblHighestRank.anchor = GridBagConstraints.EAST;
			gbc_lblHighestRank.insets = new Insets(0, 0, 5, 5);
			gbc_lblHighestRank.gridx = 0;
			gbc_lblHighestRank.gridy = 2;
			contentPanel.add(lblHighestRank, gbc_lblHighestRank);
		}
		{
			String[] rank = {"Yokozuna", "Ozeki", "Sekiwaki", "Komusubi", "Maegashira 1", "Maegashira 2",
							 "Maegashira 3", "Maegashira 4", "Maegashira 5", "Maegashira 6", "Maegashira 7",
							 "Maegashira 8", "Maegashira 9", "Maegashira 10", "Maegashira 11", "Maegashira 12",
							 "Maegashira 13", "Maegashira 14", "Maegashira 15", "Maegashira 16"};
			comboBoxHighestRank = new JComboBox<String>(rank);
			GridBagConstraints gbc_comboBoxHighestRank = new GridBagConstraints();
			gbc_comboBoxHighestRank.gridwidth = 3;
			gbc_comboBoxHighestRank.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxHighestRank.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxHighestRank.gridx = 1;
			gbc_comboBoxHighestRank.gridy = 2;
			contentPanel.add(comboBoxHighestRank, gbc_comboBoxHighestRank);
		}
		{
			JLabel lblWins = new JLabel("Wins");
			GridBagConstraints gbc_lblWins = new GridBagConstraints();
			gbc_lblWins.anchor = GridBagConstraints.EAST;
			gbc_lblWins.insets = new Insets(0, 0, 5, 5);
			gbc_lblWins.gridx = 0;
			gbc_lblWins.gridy = 3;
			contentPanel.add(lblWins, gbc_lblWins);
		}
		{
			textFieldWins = new JTextField();
			GridBagConstraints gbc_textFieldWins = new GridBagConstraints();
			gbc_textFieldWins.gridwidth = 3;
			gbc_textFieldWins.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldWins.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWins.gridx = 1;
			gbc_textFieldWins.gridy = 3;
			contentPanel.add(textFieldWins, gbc_textFieldWins);
			textFieldWins.setColumns(10);
		}
		{
			JLabel lblLosses = new JLabel("Losses");
			GridBagConstraints gbc_lblLosses = new GridBagConstraints();
			gbc_lblLosses.anchor = GridBagConstraints.EAST;
			gbc_lblLosses.insets = new Insets(0, 0, 5, 5);
			gbc_lblLosses.gridx = 0;
			gbc_lblLosses.gridy = 4;
			contentPanel.add(lblLosses, gbc_lblLosses);
		}
		{
			textFieldLosses = new JTextField();
			GridBagConstraints gbc_textFieldLosses = new GridBagConstraints();
			gbc_textFieldLosses.gridwidth = 3;
			gbc_textFieldLosses.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldLosses.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldLosses.gridx = 1;
			gbc_textFieldLosses.gridy = 4;
			contentPanel.add(textFieldLosses, gbc_textFieldLosses);
			textFieldLosses.setColumns(10);
		}
		{
			JLabel lblRetired = new JLabel("Retired");
			GridBagConstraints gbc_lblRetired = new GridBagConstraints();
			gbc_lblRetired.anchor = GridBagConstraints.EAST;
			gbc_lblRetired.insets = new Insets(0, 0, 5, 5);
			gbc_lblRetired.gridx = 0;
			gbc_lblRetired.gridy = 5;
			contentPanel.add(lblRetired, gbc_lblRetired);
		}
		{
			String[] retiredYear = new String[100];
			for(int i=0, j=2017; i<100; i++, j--) {
				retiredYear[i] = j + "";
			}
			comboBoxRetiredYear = new JComboBox<String>(retiredYear);
			GridBagConstraints gbc_comboBoxRetiredYear = new GridBagConstraints();
			gbc_comboBoxRetiredYear.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxRetiredYear.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxRetiredYear.gridx = 1;
			gbc_comboBoxRetiredYear.gridy = 5;
			contentPanel.add(comboBoxRetiredYear, gbc_comboBoxRetiredYear);
		}
		{
			String[] retiredMonth = new String[12];
			for(int i=0; i<12; i++) {
				if(i<9)
					retiredMonth[i] = "0" + (i+1);
				else
					retiredMonth[i] = (i+1) + "";
			}
			comboBoxRetiredMonth = new JComboBox<String>(retiredMonth);
			GridBagConstraints gbc_comboBoxRetiredMonth = new GridBagConstraints();
			gbc_comboBoxRetiredMonth.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxRetiredMonth.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxRetiredMonth.gridx = 2;
			gbc_comboBoxRetiredMonth.gridy = 5;
			contentPanel.add(comboBoxRetiredMonth, gbc_comboBoxRetiredMonth);
		}
		{
			JLabel lblClub = new JLabel("Club");
			GridBagConstraints gbc_lblClub = new GridBagConstraints();
			gbc_lblClub.anchor = GridBagConstraints.EAST;
			gbc_lblClub.insets = new Insets(0, 0, 0, 5);
			gbc_lblClub.gridx = 0;
			gbc_lblClub.gridy = 6;
			contentPanel.add(lblClub, gbc_lblClub);
		}
		{
			comboBoxClub = new JComboBox<Club>();
			GridBagConstraints gbc_comboBoxClub = new GridBagConstraints();
			gbc_comboBoxClub.gridwidth = 3;
			gbc_comboBoxClub.insets = new Insets(0, 0, 0, 5);
			gbc_comboBoxClub.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxClub.gridx = 1;
			gbc_comboBoxClub.gridy = 6;
			contentPanel.add(comboBoxClub, gbc_comboBoxClub);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAddCoach = new JButton("Add");
				btnAddCoach.setActionCommand("OK");
				buttonPane.add(btnAddCoach);
				getRootPane().setDefaultButton(btnAddCoach);
			}
			{
				JButton btnCancelCreate = new JButton("Cancel");
				btnCancelCreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelCreate.setActionCommand("Cancel");
				buttonPane.add(btnCancelCreate);
			}
		}
	}

	/**
	 * This method returns the instance variable of a JTextField object, holding the name of a new coach.
	 * @return a JTextField object, holding the name of a new coach.
	 */
	public JTextField getTextFieldName() {
		return textFieldName;
	}

	/**
	 * This method returns the instance variable of a JTextField object, holding the total number of competitive wins for a new coach.
	 * @return a JTextField object, holding the total number of competitive wins for a new coach.
	 */
	public JTextField getTextFieldWins() {
		return textFieldWins;
	}

	/**
	 * This method returns the instance variable of a JTextField object, holding the total number of competitive losses for a new coach.
	 * @return a JTextField object, holding the total number of competitive losses for a new coach.
	 */
	public JTextField getTextFieldLosses() {
		return textFieldLosses;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the birth year of a new coach.
	 * @return a JComboBox object, holding the birth year of a new coach.
	 */
	public JComboBox<String> getComboBoxBirthdateYear() {
		return comboBoxBirthdateYear;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the birth month of a new coach.
	 * @return a JComboBox object, holding the birth month of a new coach.
	 */
	public JComboBox<String> getComboBoxBirthdateMonth() {
		return comboBoxBirthdateMonth;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the birth day of a new coach.
	 * @return a JComboBox object, holding the birth day of a new coach.
	 */
	public JComboBox<String> getComboBoxBirthdateDay() {
		return comboBoxBirthdateDay;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the highest rank of a new coach.
	 * @return a JComboBox object, holding the highest rank of a new coach.
	 */
	public JComboBox<String> getComboBoxHighestRank() {
		return comboBoxHighestRank;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the retired year of a new coach.
	 * @return a JComboBox object, holding the retired year of a new coach.
	 */
	public JComboBox<String> getComboBoxRetiredYear() {
		return comboBoxRetiredYear;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the retired month of a new coach.
	 * @return a JComboBox object, holding the retired month of a new coach.
	 */
	public JComboBox<String> getComboBoxRetiredMonth() {
		return comboBoxRetiredMonth;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the club name a new coach coaching at.
	 * @return a JComboBox object, holding the club name a new coach coaching at
	 */
	public JComboBox<Club> getComboBoxClub() {
		return comboBoxClub;
	}

	/**
	 * This method returns the instance variable of a JButton object, representing a add button for creating new coaches.
	 * @return a JButton object, for adding new coaches.
	 */
	public JButton getBtnAddCoach() {
		return btnAddCoach;
	}

}
