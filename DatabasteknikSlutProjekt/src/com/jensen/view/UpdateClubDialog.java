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

/**
 * This class implements a GUI dialog window for the application sumo database that gives the user the opportunity to update a club.
 * @author Takeyoshi
 * @version 1.0
 */
public class UpdateClubDialog extends JDialog {

	private static final long serialVersionUID = 357750033121131566L;

	private final JPanel contentPanel = new JPanel();

	private JTextField textFieldName;
	private JTextField textFieldCity;

	private JComboBox<String> comboBoxStartingYear;

	private JButton btnSaveClub;

	/**
	 * This constructs a dialog window for updating a club.
	 */
	public UpdateClubDialog() {
		pack();
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("Update club");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			textFieldName.setText("Thomas");
			GridBagConstraints gbc_textFieldName = new GridBagConstraints();
			gbc_textFieldName.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldName.gridx = 1;
			gbc_textFieldName.gridy = 0;
			contentPanel.add(textFieldName, gbc_textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblStartingYear = new JLabel("Starting year");
			GridBagConstraints gbc_lblStartingYear = new GridBagConstraints();
			gbc_lblStartingYear.anchor = GridBagConstraints.EAST;
			gbc_lblStartingYear.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartingYear.gridx = 0;
			gbc_lblStartingYear.gridy = 1;
			contentPanel.add(lblStartingYear, gbc_lblStartingYear);
		}
		{
			String[] startingYear = new String[200];
			for(int i=0, j=2017; i<200; i++, j--) {
				startingYear[i] = j + "";
			}
			comboBoxStartingYear = new JComboBox<String>(startingYear);
			GridBagConstraints gbc_comboBoxStartingYear = new GridBagConstraints();
			gbc_comboBoxStartingYear.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxStartingYear.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxStartingYear.gridx = 1;
			gbc_comboBoxStartingYear.gridy = 1;
			contentPanel.add(comboBoxStartingYear, gbc_comboBoxStartingYear);
		}
		{
			JLabel lblCity = new JLabel("City");
			GridBagConstraints gbc_lblCity = new GridBagConstraints();
			gbc_lblCity.anchor = GridBagConstraints.EAST;
			gbc_lblCity.insets = new Insets(0, 0, 0, 5);
			gbc_lblCity.gridx = 0;
			gbc_lblCity.gridy = 2;
			contentPanel.add(lblCity, gbc_lblCity);
		}
		{
			textFieldCity = new JTextField();
			GridBagConstraints gbc_textFieldCity = new GridBagConstraints();
			gbc_textFieldCity.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCity.gridx = 1;
			gbc_textFieldCity.gridy = 2;
			contentPanel.add(textFieldCity, gbc_textFieldCity);
			textFieldCity.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSaveClub = new JButton("Save");
				btnSaveClub.setActionCommand("OK");
				buttonPane.add(btnSaveClub);
				getRootPane().setDefaultButton(btnSaveClub);
			}
			{
				JButton btnCancelUpdateClub = new JButton("Cancel");
				btnCancelUpdateClub.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelUpdateClub.setActionCommand("Cancel");
				buttonPane.add(btnCancelUpdateClub);
			}
		}
	}

	/**
	 * This method returns the instance variable of a JTextField object, holding the name of a club.
	 * @return a JTextField object, holding the name of a club.
	 */
	public JTextField getTextFieldName() {
		return textFieldName;
	}

	/**
	 * This method returns the instance variable of a JTextField object, holding the name of the city where the club is located.
	 * @return a JTextField object, holding the name of a city.
	 */
	public JTextField getTextFieldCity() {
		return textFieldCity;
	}

	/**
	 * This method returns the instance variable of a JComboBox object, holding the starting year of a club.
	 * @return a JComboBox object, holding the starting year of a club.
	 */
	public JComboBox<String> getComboBoxStartingYear() {
		return comboBoxStartingYear;
	}

	/**
	 * This method returns the instance variable of a JButton object, representing a save button for updating clubs.
	 * @return a JButton object, for saving clubs.
	 */
	public JButton getBtnSaveClub() {
		return btnSaveClub;
	}

}
