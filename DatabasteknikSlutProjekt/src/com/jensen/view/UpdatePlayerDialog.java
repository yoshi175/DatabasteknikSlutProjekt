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
import com.jensen.model.Coach;

/**
 * This class implements a GUI dialog window for the application sumo database that gives the user the opportunity to update a player.
 * @author Takeyoshi
 * @version 1.0
 */
public class UpdatePlayerDialog extends JDialog {

	private static final long serialVersionUID = 2783170328861860527L;

	private final JPanel contentPanel = new JPanel();
	
	private JTextField textFieldName;
	private JTextField textFieldHeight;
	private JTextField textFieldWeight;
	private JTextField textFieldNativeCity;

	private JComboBox<String> comboBoxBirthdateYear;
	private JComboBox<String> comboBoxBirthdateMonth;
	private JComboBox<String> comboBoxBirthdateDay;
	private JComboBox<String> comboBoxRank;
	private JComboBox<Coach> comboBoxCoach;
	private JComboBox<Club> comboBoxClub;

	private JButton btnSaveUpdate;

	/**
	 * This constructs a dialog window for updating a player.
	 */
	public UpdatePlayerDialog() {
		pack();
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("Update player");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldName.gridx = 1;
			gbc_textFieldName.gridy = 0;
			contentPanel.add(textFieldName, gbc_textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblHeightcm = new JLabel("Height (cm)");
			GridBagConstraints gbc_lblHeightcm = new GridBagConstraints();
			gbc_lblHeightcm.anchor = GridBagConstraints.EAST;
			gbc_lblHeightcm.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeightcm.gridx = 0;
			gbc_lblHeightcm.gridy = 1;
			contentPanel.add(lblHeightcm, gbc_lblHeightcm);
		}
		{
			textFieldHeight = new JTextField();
			GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
			gbc_textFieldHeight.gridwidth = 3;
			gbc_textFieldHeight.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldHeight.gridx = 1;
			gbc_textFieldHeight.gridy = 1;
			contentPanel.add(textFieldHeight, gbc_textFieldHeight);
			textFieldHeight.setColumns(10);
		}
		{
			JLabel lblWeightkg = new JLabel("Weight (kg)");
			GridBagConstraints gbc_lblWeightkg = new GridBagConstraints();
			gbc_lblWeightkg.anchor = GridBagConstraints.EAST;
			gbc_lblWeightkg.insets = new Insets(0, 0, 5, 5);
			gbc_lblWeightkg.gridx = 0;
			gbc_lblWeightkg.gridy = 2;
			contentPanel.add(lblWeightkg, gbc_lblWeightkg);
		}
		{
			textFieldWeight = new JTextField();
			GridBagConstraints gbc_textFieldWeight = new GridBagConstraints();
			gbc_textFieldWeight.gridwidth = 3;
			gbc_textFieldWeight.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldWeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWeight.gridx = 1;
			gbc_textFieldWeight.gridy = 2;
			contentPanel.add(textFieldWeight, gbc_textFieldWeight);
			textFieldWeight.setColumns(10);
		}
		{
			JLabel lblBirthdate = new JLabel("Birthdate");
			GridBagConstraints gbc_lblBirthdate = new GridBagConstraints();
			gbc_lblBirthdate.anchor = GridBagConstraints.EAST;
			gbc_lblBirthdate.insets = new Insets(0, 0, 5, 5);
			gbc_lblBirthdate.gridx = 0;
			gbc_lblBirthdate.gridy = 3;
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
			gbc_comboBoxBirthdateYear.gridy = 3;
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
			gbc_comboBoxBirthdateMonth.gridy = 3;
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
			gbc_comboBoxBirthdateDay.gridy = 3;
			contentPanel.add(comboBoxBirthdateDay, gbc_comboBoxBirthdateDay);
		}
		{
			JLabel lblNativeCity = new JLabel("Native city");
			GridBagConstraints gbc_lblNativeCity = new GridBagConstraints();
			gbc_lblNativeCity.anchor = GridBagConstraints.EAST;
			gbc_lblNativeCity.insets = new Insets(0, 0, 5, 5);
			gbc_lblNativeCity.gridx = 0;
			gbc_lblNativeCity.gridy = 4;
			contentPanel.add(lblNativeCity, gbc_lblNativeCity);
		}
		{
			textFieldNativeCity = new JTextField();
			GridBagConstraints gbc_textFieldNativeCity = new GridBagConstraints();
			gbc_textFieldNativeCity.gridwidth = 3;
			gbc_textFieldNativeCity.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldNativeCity.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldNativeCity.gridx = 1;
			gbc_textFieldNativeCity.gridy = 4;
			contentPanel.add(textFieldNativeCity, gbc_textFieldNativeCity);
			textFieldNativeCity.setColumns(10);
		}
		{
			JLabel lblRank = new JLabel("Rank");
			GridBagConstraints gbc_lblRank = new GridBagConstraints();
			gbc_lblRank.anchor = GridBagConstraints.EAST;
			gbc_lblRank.insets = new Insets(0, 0, 5, 5);
			gbc_lblRank.gridx = 0;
			gbc_lblRank.gridy = 5;
			contentPanel.add(lblRank, gbc_lblRank);
		}
		{
			String[] rank = {"Yokozuna", "Ozeki", "Sekiwaki", "Komusubi", "Maegashira 1", "Maegashira 2",
							 "Maegashira 3", "Maegashira 4", "Maegashira 5", "Maegashira 6", "Maegashira 7",
							 "Maegashira 8", "Maegashira 9", "Maegashira 10", "Maegashira 11", "Maegashira 12",
							 "Maegashira 13", "Maegashira 14", "Maegashira 15", "Maegashira 16"};
			comboBoxRank = new JComboBox<String>(rank);
			GridBagConstraints gbc_comboBoxRank = new GridBagConstraints();
			gbc_comboBoxRank.gridwidth = 3;
			gbc_comboBoxRank.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxRank.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxRank.gridx = 1;
			gbc_comboBoxRank.gridy = 5;
			contentPanel.add(comboBoxRank, gbc_comboBoxRank);
		}
		{
			JLabel lblCoach = new JLabel("Coach");
			GridBagConstraints gbc_lblCoach = new GridBagConstraints();
			gbc_lblCoach.anchor = GridBagConstraints.EAST;
			gbc_lblCoach.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoach.gridx = 0;
			gbc_lblCoach.gridy = 6;
			contentPanel.add(lblCoach, gbc_lblCoach);
		}
		{
			comboBoxCoach = new JComboBox<Coach>();
			GridBagConstraints gbc_comboBoxCoach = new GridBagConstraints();
			gbc_comboBoxCoach.gridwidth = 3;
			gbc_comboBoxCoach.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxCoach.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxCoach.gridx = 1;
			gbc_comboBoxCoach.gridy = 6;
			contentPanel.add(comboBoxCoach, gbc_comboBoxCoach);
		}
		{
			JLabel lblClub = new JLabel("Club");
			GridBagConstraints gbc_lblClub = new GridBagConstraints();
			gbc_lblClub.anchor = GridBagConstraints.EAST;
			gbc_lblClub.insets = new Insets(0, 0, 0, 5);
			gbc_lblClub.gridx = 0;
			gbc_lblClub.gridy = 7;
			contentPanel.add(lblClub, gbc_lblClub);
		}
		{
			comboBoxClub = new JComboBox<Club>();
			GridBagConstraints gbc_comboBoxClub = new GridBagConstraints();
			gbc_comboBoxClub.gridwidth = 3;
			gbc_comboBoxClub.insets = new Insets(0, 0, 0, 5);
			gbc_comboBoxClub.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxClub.gridx = 1;
			gbc_comboBoxClub.gridy = 7;
			contentPanel.add(comboBoxClub, gbc_comboBoxClub);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSaveUpdate = new JButton("Save");
				btnSaveUpdate.setActionCommand("Save");
				buttonPane.add(btnSaveUpdate);
				getRootPane().setDefaultButton(btnSaveUpdate);
			}
			{
				JButton btnCancelUpdate = new JButton("Cancel");
				btnCancelUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelUpdate.setActionCommand("Cancel");
				buttonPane.add(btnCancelUpdate);
			}
		}
	}

	/**
	 * This method returns the instance variable of a JTextField object, holding the name of a player.
	 * @return a JTextField object, holding the name of a player.
	 */
	public JTextField getTextFieldName() {
		return textFieldName;
	}

	/**
	 * This method returns the instance variable of a JTextField object, holding the height of a player.
	 * @return a JTextField object, holding the height of a player.
	 */
	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	/**
	 * This method returns the instance variable of a JTextField object, holding the weight of a player.
	 * @return a JTextField object, holding the weight of a player.
	 */
	public JTextField getTextFieldWeight() {
		return textFieldWeight;
	}

	/**
	 * This method returns the instance variable of a JTextField object, holding a players native city.
	 * @return a JTextField object, holding a players native city.
	 */
	public JTextField getTextFieldNativeCity() {
		return textFieldNativeCity;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the birth year of a player.
	 * @return a JComboBox object, holding the birth year of a player.
	 */
	public JComboBox<String> getComboBoxBirthdateYear() {
		return comboBoxBirthdateYear;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the birth month of a player.
	 * @return a JComboBox object, holding the birth month of a player.
	 */
	public JComboBox<String> getComboBoxBirthdateMonth() {
		return comboBoxBirthdateMonth;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the birth day of a player.
	 * @return a JComboBox object, holding the birth day of a player.
	 */
	public JComboBox<String> getComboBoxBirthdateDay() {
		return comboBoxBirthdateDay;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the rank of a player.
	 * @return a JComboBox object, holding the rank of a player.
	 */
	public JComboBox<String> getComboBoxRank() {
		return comboBoxRank;
	}
	
	/**
	 * This method returns the instance variable of a JComboBox object, holding a players coach name.
	 * @return a JComboBox object, holding a players coach name.
	 */
	public JComboBox<Coach> getComboBoxCoach() {
		return comboBoxCoach;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding a players club name.
	 * @return a JComboBox object, holding a players club name.
	 */
	public JComboBox<Club> getComboBoxClub() {
		return comboBoxClub;
	}

	/**
	 * This method returns the instance variable of a JButton object, representing a save button for updating players.
	 * @return a JButton object, for saving players.
	 */
	public JButton getBtnSaveUpdate() {
		return btnSaveUpdate;
	}

}
