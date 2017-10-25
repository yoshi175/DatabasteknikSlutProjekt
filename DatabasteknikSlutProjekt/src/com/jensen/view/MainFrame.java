package com.jensen.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
/**
 * This class implements a GUI main frame for the application sumo database.
 * @author Takeyoshi
 * @version 1.0
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = -3446350319019047187L;

	private JPanel contentPane;
	
	private JTextField textFieldClubName;
	private JTextField textFieldCoachName;
	private JTextField textFieldPlayerName;
	
	private JTable clubTable;
	private JTable coachTable;
	private JTable playerTable;
	
	private JButton btnSearchClub;
	private JButton btnSearchCoach;
	private JButton btnSearchPlayer;
	
	private JButton btnCreateClub;
	private JButton btnCreateCoach;
	private JButton btnCreatePlayer;
	
	private JMenuItem menuItemUpdateClub;
	private JMenuItem menuItemDeleteClub;
	
	private JMenuItem menuItemUpdateCoach;
	private JMenuItem menuItemDeleteCoach;
	
	private JMenuItem menuItemUpdatePlayer;
	private JMenuItem menuItemDeletePlayer;

	/**
	 * This constructs an application window for a register of sumo clubs, coaches and players.
	 */
	public MainFrame() {
		setLocalTheme(this);
		pack();
		setVisible(true);
		setTitle("Sumo database");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel clubPanel = new JPanel();
		tabbedPane.addTab("Club", null, clubPanel, null);
		clubPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel searchClubPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) searchClubPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		clubPanel.add(searchClubPanel, BorderLayout.NORTH);
		
		JLabel lblEnterClubName = new JLabel("Enter club name");
		searchClubPanel.add(lblEnterClubName);
		
		textFieldClubName = new JTextField();
		searchClubPanel.add(textFieldClubName);
		textFieldClubName.setColumns(10);
		
		btnSearchClub = new JButton("Search");
		searchClubPanel.add(btnSearchClub);
		
		JScrollPane scrollPaneClub = new JScrollPane();
		clubPanel.add(scrollPaneClub, BorderLayout.CENTER);
		
		clubTable = new JTable();
		scrollPaneClub.setViewportView(clubTable);
		
		JPanel createClubPanel = new JPanel();
		clubPanel.add(createClubPanel, BorderLayout.SOUTH);
		
		btnCreateClub = new JButton("Create new club");
		createClubPanel.add(btnCreateClub);
		
		JPanel coachPanel = new JPanel();
		tabbedPane.addTab("Coach", null, coachPanel, null);
		coachPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel searchCoachPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) searchCoachPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		coachPanel.add(searchCoachPanel, BorderLayout.NORTH);
		
		JLabel lblEnterCoachName = new JLabel("Enter coach name");
		searchCoachPanel.add(lblEnterCoachName);
		
		textFieldCoachName = new JTextField();
		searchCoachPanel.add(textFieldCoachName);
		textFieldCoachName.setColumns(10);
		
		btnSearchCoach = new JButton("Search");
		searchCoachPanel.add(btnSearchCoach);
		
		JScrollPane scrollPaneCoach = new JScrollPane();
		coachPanel.add(scrollPaneCoach, BorderLayout.CENTER);
		
		coachTable = new JTable();
		scrollPaneCoach.setViewportView(coachTable);
		
		JPanel createCoachPanel = new JPanel();
		coachPanel.add(createCoachPanel, BorderLayout.SOUTH);
		
		btnCreateCoach = new JButton("Create new coach");
		createCoachPanel.add(btnCreateCoach);
		
		JPanel playerPanel = new JPanel();
		tabbedPane.addTab("Player", null, playerPanel, null);
		playerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel searchPlayerPanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) searchPlayerPanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		playerPanel.add(searchPlayerPanel, BorderLayout.NORTH);
		
		JLabel lblEnterPlayerName = new JLabel("Enter player name");
		searchPlayerPanel.add(lblEnterPlayerName);
		
		textFieldPlayerName = new JTextField();
		searchPlayerPanel.add(textFieldPlayerName);
		textFieldPlayerName.setColumns(10);
		
		btnSearchPlayer = new JButton("Search");
		searchPlayerPanel.add(btnSearchPlayer);
		
		JScrollPane scrollPanePlayer = new JScrollPane();
		playerPanel.add(scrollPanePlayer, BorderLayout.CENTER);
		
		playerTable = new JTable();
		scrollPanePlayer.setViewportView(playerTable);
		
		JPanel createPlayerPanel = new JPanel();
		playerPanel.add(createPlayerPanel, BorderLayout.SOUTH);
		
		btnCreatePlayer = new JButton("Create new player");
		createPlayerPanel.add(btnCreatePlayer);
		
		JPopupMenu popupMenuClub = new JPopupMenu();
		menuItemUpdateClub = new JMenuItem("Update");
		menuItemDeleteClub = new JMenuItem("Delete");
		popupMenuClub.add(menuItemUpdateClub);
		popupMenuClub.add(menuItemDeleteClub);
		clubTable.setComponentPopupMenu(popupMenuClub);
		
		JPopupMenu popupMenuCoach = new JPopupMenu();
		menuItemUpdateCoach = new JMenuItem("Update");
		menuItemDeleteCoach = new JMenuItem("Delete");
		popupMenuCoach.add(menuItemUpdateCoach);
		popupMenuCoach.add(menuItemDeleteCoach);
		coachTable.setComponentPopupMenu(popupMenuCoach);
		
		JPopupMenu popupMenuPlayer = new JPopupMenu();
		menuItemUpdatePlayer = new JMenuItem("Update");
		menuItemDeletePlayer = new JMenuItem("Delete");
		popupMenuPlayer.add(menuItemUpdatePlayer);
		popupMenuPlayer.add(menuItemDeletePlayer);
		playerTable.setComponentPopupMenu(popupMenuPlayer);
	}
	/**
	 * This method returns the instance variable of a JTextField object, holding a name of a club.
	 * @return a JTextField object.			//this GUI's text field for club name.
	 */
	public JTextField getTextFieldClubName() {
		return textFieldClubName;
	}
	
	/**
	 * This method returns the instance variable of a JTextField object, holding a name of a coach.
	 * @return this GUI's text field for coach name.
	 */
	public JTextField getTextFieldCoachName() {
		return textFieldCoachName;
	}
	
	/**
	 * This method returns the instance variable of a JTextField object, holding a name of a player.
	 * @return this GUI's text field for player name.
	 */
	public JTextField getTextFieldPlayerName() {
		return textFieldPlayerName;
	}
	
	/**
	 * This method returns the instance variable of a JTable object, holding club objects.
	 * @return this GUI's table, representing clubs.
	 */
	public JTable getClubTable() {
		return clubTable;
	}
	
	/**
	 * This method returns the instance variable of a JTable object, holding coach objects.
	 * @return this GUI's table, representing coaches.
	 */
	public JTable getCoachTable() {
		return coachTable;
	}
	
	/**
	 * This method returns the instance variable of a JTable object, holding player objects.
	 * @return this GUI's table, representing players.
	 */
	public JTable getPlayerTable() {
		return playerTable;
	}
	
	/**
	 * This method returns the instance variable of a JButton object, representing a search button for searching clubs.
	 * @return this GUI's search button, for searching clubs.
	 */
	public JButton getBtnSearchClub() {
		return btnSearchClub;
	}
	
	/**
	 * This method returns the instance variable of a JButton object, representing a search button for searching coaches.
	 * @return this GUI's search button, for searching coaches.
	 */
	public JButton getBtnSearchCoach() {
		return btnSearchCoach;
	}
	
	/**
	 * This method returns the instance variable of a JButton object, representing a search button for searching players.
	 * @return this GUI's search button, for searching players.
	 */
	public JButton getBtnSearchPlayer() {
		return btnSearchPlayer;
	}
	
	/**
	 * This method returns the instance variable of a JButton object, representing a create button for creating clubs.
	 * @return this GUI's create button, for creating clubs.
	 */
	public JButton getBtnCreateClub() {
		return btnCreateClub;
	}
	
	/**
	 * This method returns the instance variable of a JButton object, representing a create button for creating coaches.
	 * @return this GUI's create button, for creating coaches.
	 */
	public JButton getBtnCreateCoach() {
		return btnCreateCoach;
	}
	
	/**
	 * This method returns the instance variable of a JButton object, representing a create button for creating players.
	 * @return this GUI's create button, for creating players.
	 */
	public JButton getBtnCreatePlayer() {
		return btnCreatePlayer;
	}

	/**
	 * This method returns the instance variable of a JMenuItem object, representing a update "button" (JMenuItem) for updating clubs.
	 * @return this GUI's update "button" (JMenuItem), for updating clubs.
	 */
	public JMenuItem getMenuItemUpdateClub() {
		return menuItemUpdateClub;
	}
	
	/**
	 * This method returns the instance variable of a JMenuItem object, representing a delete "button" (JMenuItem) for deleting clubs.
	 * @return this GUI's delete "button" (JMenuItem), for deleting clubs.
	 */
	public JMenuItem getMenuItemDeleteClub() {
		return menuItemDeleteClub;
	}
	
	/**
	 * This method returns the instance variable of a JMenuItem object, representing a update "button" (JMenuItem) for updating coaches.
	 * @return this GUI's update "button" (JMenuItem), for updating coaches.
	 */
	public JMenuItem getMenuItemUpdateCoach() {
		return menuItemUpdateCoach;
	}
	
	/**
	 * This method returns the instance variable of a JMenuItem object, representing a delete "button" (JMenuItem) for deleting coaches.
	 * @return this GUI's delete "button" (JMenuItem), for deleting coaches.
	 */
	public JMenuItem getMenuItemDeleteCoach() {
		return menuItemDeleteCoach;
	}
	
	/**
	 * This method returns the instance variable of a JMenuItem object, representing a update "button" (JMenuItem) for updating players.
	 * @return this GUI's update "button" (JMenuItem), for updating players.
	 */
	public JMenuItem getMenuItemUpdatePlayer() {
		return menuItemUpdatePlayer;
	}
	
	/**
	 * This method returns the instance variable of a JMenuItem object, representing a delete "button" (JMenuItem) for deleting players.
	 * @return this GUI's delete "button" (JMenuItem), for deleting players.
	 */
	public JMenuItem getMenuItemDeletePlayer() {
		return menuItemDeletePlayer;
	}
	
	/**
	 * This method sets the "look and feel" to the default theme depending on the driver.
	 * @param componet to change the "look and feel" (e.g. JFrame).
	 */
	private static void setLocalTheme(Component componet) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(componet);
	}
}
