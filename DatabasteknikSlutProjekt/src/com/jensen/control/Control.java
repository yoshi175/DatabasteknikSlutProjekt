package com.jensen.control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.jensen.model.Club;
import com.jensen.model.ClubTableModel;
import com.jensen.model.Coach;
import com.jensen.model.CoachTableModel;
import com.jensen.model.Model;
import com.jensen.model.Player;
import com.jensen.model.PlayerTableModel;
import com.jensen.view.CreateClubDialog;
import com.jensen.view.CreateCoachDialog;
import com.jensen.view.CreatePlayerDialog;
import com.jensen.view.MainFrame;
import com.jensen.view.UpdateClubDialog;
import com.jensen.view.UpdateCoachDialog;
import com.jensen.view.UpdatePlayerDialog;

/**
 * This class controls the integration between the "model" and the "view".
 * @author Takeyoshi
 * @version 1.0
 */
public class Control extends MouseAdapter implements ActionListener {

	private Model model;
	private MainFrame view;

	private ClubTableModel clubTableModel;
	private CoachTableModel coachTableModel;
	private PlayerTableModel playerTableModel;

	private CreateClubDialog createClubDialog;
	private CreateCoachDialog createCoachDialog;
	private CreatePlayerDialog createPlayerDialog;

	private UpdateClubDialog updateClubDialog;
	private UpdateCoachDialog updateCoachDialog;
	private UpdatePlayerDialog updatePlayerDialog;

	private LinkedList<Club> tempClubList;
	private LinkedList<Coach> tempCoachList;
	private LinkedList<Player> tempPlayerList;

	private Club tempClub;
	private Coach tempCoach;
	private Player tempPlayer;

	/**
	 * This constructor control the integration between the "model" and the "view".
	 * @param model a model object, the logic.
	 * @param view a view object, the GUI.
	 */
	public Control(Model model, MainFrame view) {
		this.model = model;
		this.view = view;

		clubTableModel = new ClubTableModel(model.readAllClubs());
		view.getClubTable().setModel(clubTableModel);

		coachTableModel = new CoachTableModel(model.readAllCoaches());
		view.getCoachTable().setModel(coachTableModel);

		playerTableModel = new PlayerTableModel(model.readAllPlayers());
		view.getPlayerTable().setModel(playerTableModel);

		view.getBtnSearchClub().addActionListener(this);
		view.getBtnSearchCoach().addActionListener(this);
		view.getBtnSearchPlayer().addActionListener(this);

		view.getBtnCreateClub().addActionListener(this);
		view.getBtnCreateCoach().addActionListener(this);
		view.getBtnCreatePlayer().addActionListener(this);

		view.getClubTable().addMouseListener(this);
		view.getMenuItemUpdateClub().addActionListener(this);
		view.getMenuItemDeleteClub().addActionListener(this);

		view.getCoachTable().addMouseListener(this);
		view.getMenuItemUpdateCoach().addActionListener(this);
		view.getMenuItemDeleteCoach().addActionListener(this);

		view.getPlayerTable().addMouseListener(this);
		view.getMenuItemUpdatePlayer().addActionListener(this);
		view.getMenuItemDeletePlayer().addActionListener(this);

		/*
		//Start - Mouse listener for "GROUP BY" columns
		view.getClubTable().getTableHeader().addMouseListener(new MouseListener() {
		boolean nameState = true;
		boolean startingYearState = true;
		boolean cityState = true;
			@Override
			public void mouseClicked(MouseEvent e) {
					int columnClub = view.getClubTable().columnAtPoint(e.getPoint());
					String columnClubName = view.getClubTable().getColumnName(columnClub);

					//int columnCoach = view.getCoachTable().columnAtPoint(e.getPoint());
					//String columnCoachName = view.getCoachTable().getColumnName(columnCoach);

					//int columnPlayer = view.getPlayerTable().columnAtPoint(e.getPoint());
					//String columnPlayerName = view.getPlayerTable().getColumnName(columnPlayer);

			        if(columnClubName.equals("Name")) {
			        	clubTableModel = new ClubTableModel(model.readClubsGroupByName(view.getTextFieldClubName().getText(), nameState));
			        	view.getClubTable().setModel(clubTableModel);
			        	System.out.println("GROUP BY name");
			        	if(!nameState)
			        		nameState = !nameState;
			        	else
			        		nameState = !nameState;
			        	System.out.println(nameState);
			        }
			        else if(columnClubName.equals("Starting year")) {
			        	clubTableModel = new ClubTableModel(model.readClubsGroupByStartingYear(view.getTextFieldClubName().getText(), startingYearState));
			        	view.getClubTable().setModel(clubTableModel);
			        	if(!startingYearState)
			        		startingYearState = !startingYearState;
			        	else
			        		startingYearState = !startingYearState;
			        	System.out.println("GROUP BY starting_year");
			        }
			        else if(columnClubName.equals("City")) {
			        	clubTableModel = new ClubTableModel(model.readClubsGroupByCity(view.getTextFieldClubName().getText(), cityState));
			        	view.getClubTable().setModel(clubTableModel);
			        	if(!cityState)
			        		cityState = !cityState;
			        	else
			        		cityState = !cityState;
			        	System.out.println("GROUP BY city");
			        }
			        //System.out.println("Column index selected " + col + " " + name);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		// End
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == view.getBtnSearchClub()) {
			clubTableModel = new ClubTableModel(model.searchClub(view.getTextFieldClubName().getText()));
			view.getClubTable().setModel(clubTableModel);
		}

		if (e.getSource() == view.getBtnSearchCoach()) {
			coachTableModel = new CoachTableModel(model.searchCoach(view.getTextFieldCoachName().getText()));
			view.getCoachTable().setModel(coachTableModel);
		}

		if (e.getSource() == view.getBtnSearchPlayer()) {
			playerTableModel = new PlayerTableModel(model.searchPlayer(view.getTextFieldPlayerName().getText()));
			view.getPlayerTable().setModel(playerTableModel);
		}

		if(e.getSource() == view.getBtnCreateClub()) {
			createClubDialog = new CreateClubDialog();
			createClubDialog.getBtnAddClub().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String startingYear = (String) createClubDialog.getComboBoxStartingYear().getSelectedItem() + "-01-01";
					model.createClub(new Club(createClubDialog.getTextFieldName().getText(), startingYear,
							createClubDialog.getTextFieldCity().getText()));
					view.getClubTable().setModel(new ClubTableModel(model.readAllClubs()));
					createClubDialog.dispose();
				}
			});
		}

		if(e.getSource() == view.getBtnCreateCoach()) {
			createCoachDialog = new CreateCoachDialog();
			for(int i=0; i<model.readAllClubs().size(); i++) {
				createCoachDialog.getComboBoxClub().addItem(model.readAllClubs().get(i));
			}

			createCoachDialog.getBtnAddCoach().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String coachBirthdate = (String) createCoachDialog.getComboBoxBirthdateYear().getSelectedItem() + "-" +
							(String) createCoachDialog.getComboBoxBirthdateMonth().getSelectedItem() + "-" +
							(String) createCoachDialog.getComboBoxBirthdateDay().getSelectedItem();
					int coachWins = Integer.parseInt(createCoachDialog.getTextFieldWins().getText());
					int coachLosses = Integer.parseInt(createCoachDialog.getTextFieldLosses().getText());
					int totalMatches = coachWins + coachLosses;
					String coachRank = (String) createCoachDialog.getComboBoxHighestRank().getSelectedItem();
					String coachRetired = (String) createCoachDialog.getComboBoxRetiredYear().getSelectedItem() + "-" +
							(String) createCoachDialog.getComboBoxRetiredMonth().getSelectedItem() + "-01";
					Club tempClub = (Club) createCoachDialog.getComboBoxClub().getSelectedItem();
					model.createCoach(new Coach(createCoachDialog.getTextFieldName().getText(),
							coachBirthdate,
							coachRank,
							totalMatches,
							coachWins,
							coachLosses,
							coachRetired,
							tempClub.getId()));
					view.getCoachTable().setModel(new CoachTableModel(model.readAllCoaches()));
					createCoachDialog.dispose();
				}
			});
		}

		if(e.getSource() == view.getBtnCreatePlayer()) {
			createPlayerDialog = new CreatePlayerDialog();
			createPlayerDialog.setAlwaysOnTop(true);
			for(int i=0; i<model.readAllCoaches().size(); i++) {
				createPlayerDialog.getComboBoxCoach().addItem(model.readAllCoaches().get(i));
			}
			for(int i=0; i<model.readAllClubs().size(); i++) {
				createPlayerDialog.getComboBoxClub().addItem(model.readAllClubs().get(i));
			}
			createPlayerDialog.getBtnAddPlayer().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String birthdate = (String) createPlayerDialog.getComboBoxBirthdateYear().getSelectedItem() + "-" +
							(String) createPlayerDialog.getComboBoxBirthdateMonth().getSelectedItem() + "-" +
							(String) createPlayerDialog.getComboBoxBirthdateDay().getSelectedItem();
					String rank = (String) createPlayerDialog.getComboBoxRank().getSelectedItem();
					Coach tempCoach = (Coach) createPlayerDialog.getComboBoxCoach().getSelectedItem();
					Club tempClub = (Club) createPlayerDialog.getComboBoxClub().getSelectedItem();

					model.createPlayer(new Player(createPlayerDialog.getTextFieldName().getText(),
							Integer.parseInt(createPlayerDialog.getTextFieldHeight().getText()),
							Integer.parseInt(createPlayerDialog.getTextFieldWeight().getText()),
							birthdate,
							createPlayerDialog.getTextFieldNativeCity().getText(),
							rank,
							tempCoach.getId(),
							tempClub.getId()));
					view.getPlayerTable().setModel(new PlayerTableModel(model.readAllPlayers()));
					createPlayerDialog.dispose();
				}
			});
		}

		if(e.getSource() == view.getMenuItemUpdateClub()) {
			updateClubDialog = new UpdateClubDialog();
			clubTableModel = (ClubTableModel) view.getClubTable().getModel();
			tempClubList = clubTableModel.getClubs();
			tempClub = tempClubList.get(view.getClubTable().getSelectedRow());
			String startingYear = tempClub.getStartingYear().substring(0, 4);

			updateClubDialog.getTextFieldName().setText(tempClub.getName());
			updateClubDialog.getComboBoxStartingYear().setSelectedItem(startingYear);
			updateClubDialog.getTextFieldCity().setText(tempClub.getCity());

			updateClubDialog.getBtnSaveClub().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int id = tempClub.getId();
					String name = updateClubDialog.getTextFieldName().getText();
					String clubStartingYear = (String) updateClubDialog.getComboBoxStartingYear().getSelectedItem() + "-01-01";
					String city = updateClubDialog.getTextFieldCity().getText();

					model.updateClub(new Club(id, name, clubStartingYear, city));
					view.getClubTable().setModel(new ClubTableModel(model.readAllClubs()));
					updateClubDialog.dispose();
				}
			});
		}

		if(e.getSource() == view.getMenuItemUpdateCoach()) {
			updateCoachDialog = new UpdateCoachDialog();
			coachTableModel = (CoachTableModel) view.getCoachTable().getModel();
			tempCoachList = coachTableModel.getCoaches();
			tempCoach = tempCoachList.get(view.getCoachTable().getSelectedRow());

			updateCoachDialog.getTextFieldName().setText(tempCoach.getName());
			updateCoachDialog.getComboBoxBirthdateYear().setSelectedItem(tempCoach.getBirthdate().substring(0, 4));
			updateCoachDialog.getComboBoxBirthdateMonth().setSelectedItem(tempCoach.getBirthdate().substring(5, 7));
			updateCoachDialog.getComboBoxBirthdateDay().setSelectedItem(tempCoach.getBirthdate().substring(8, 10));
			updateCoachDialog.getComboBoxHighestRank().setSelectedItem(tempCoach.getHighestRank());
			updateCoachDialog.getTextFieldWins().setText(tempCoach.getCompetitiveWins() + "");
			updateCoachDialog.getTextFieldLosses().setText(tempCoach.getCompetitiveLosses() + "");
			updateCoachDialog.getComboBoxRetiredYear().setSelectedItem(tempCoach.getRetiredFromCompeting().substring(0, 4));
			updateCoachDialog.getComboBoxRetiredMonth().setSelectedItem(tempCoach.getRetiredFromCompeting().substring(5, 7));

			tempClubList = model.readAllClubs();
			for(int i=0; i<tempClubList.size(); i++) {
				updateCoachDialog.getComboBoxClub().addItem(tempClubList.get(i));
				if(tempClubList.get(i).toString().equals(tempCoach.getClubName())){
					updateCoachDialog.getComboBoxClub().setSelectedItem(tempClubList.get(i));
				}
			}

			updateCoachDialog.getBtnSaveUpdate().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int id = tempCoach.getId();
					String name = updateCoachDialog.getTextFieldName().getText();
					String birthdateYear = (String) updateCoachDialog.getComboBoxBirthdateYear().getSelectedItem();
					String birthdateMonth = (String) updateCoachDialog.getComboBoxBirthdateMonth().getSelectedItem();
					String birthdateDay = (String) updateCoachDialog.getComboBoxBirthdateDay().getSelectedItem();
					String birthdate = birthdateYear + "-"  + birthdateMonth + "-" + birthdateDay;
					String highestRank = (String) updateCoachDialog.getComboBoxHighestRank().getSelectedItem();
					int competitiveWins = Integer.parseInt(updateCoachDialog.getTextFieldWins().getText());
					int competitiveLosses = Integer.parseInt(updateCoachDialog.getTextFieldLosses().getText());
					int competitiveMatches = competitiveWins + competitiveLosses;
					String retiredYear = (String) updateCoachDialog.getComboBoxRetiredYear().getSelectedItem();
					String retiredMonth = (String) updateCoachDialog.getComboBoxRetiredMonth().getSelectedItem();
					String retired = retiredYear + "-" + retiredMonth + "-01";
					int clubId  = ((Club) updateCoachDialog.getComboBoxClub().getSelectedItem()).getId();

					model.updateCoach(new Coach(id, name, birthdate, highestRank, competitiveMatches,
							competitiveWins, competitiveLosses, retired, clubId));
					view.getCoachTable().setModel(new CoachTableModel(model.readAllCoaches()));
					updateCoachDialog.dispose();

				}
			});

		}

		if(e.getSource() == view.getMenuItemUpdatePlayer()) {
			updatePlayerDialog = new UpdatePlayerDialog();
			playerTableModel = (PlayerTableModel) view.getPlayerTable().getModel();
			tempPlayerList = playerTableModel.getPlayers();
			tempPlayer = tempPlayerList.get(view.getPlayerTable().getSelectedRow());

			updatePlayerDialog.getTextFieldName().setText(tempPlayer.getName());
			updatePlayerDialog.getTextFieldHeight().setText(tempPlayer.getHeightCm() + "");
			updatePlayerDialog.getTextFieldWeight().setText(tempPlayer.getWeightKg() + "");
			updatePlayerDialog.getComboBoxBirthdateYear().setSelectedItem(tempPlayer.getBirthdate().substring(0, 4));
			updatePlayerDialog.getComboBoxBirthdateMonth().setSelectedItem(tempPlayer.getBirthdate().substring(5, 7));
			updatePlayerDialog.getComboBoxBirthdateDay().setSelectedItem(tempPlayer.getBirthdate().substring(8, 10));
			updatePlayerDialog.getTextFieldNativeCity().setText(tempPlayer.getNativeCity());
			updatePlayerDialog.getComboBoxRank().setSelectedItem(tempPlayer.getRank());

			tempCoachList = model.readAllCoaches();
			for(int i=0; i<tempCoachList.size(); i++) {
				updatePlayerDialog.getComboBoxCoach().addItem(tempCoachList.get(i));
				if(tempCoachList.get(i).toString().equals(tempPlayer.getCoachName())){
					updatePlayerDialog.getComboBoxCoach().setSelectedItem(tempCoachList.get(i));
				}
			}

			tempClubList = model.readAllClubs();
			for(int i=0; i<tempClubList.size(); i++) {
				updatePlayerDialog.getComboBoxClub().addItem(tempClubList.get(i));
				if(tempClubList.get(i).toString().equals(tempPlayer.getClubName())){
					updatePlayerDialog.getComboBoxClub().setSelectedItem(tempClubList.get(i));
				}
			}
			
			updatePlayerDialog.getBtnSaveUpdate().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int id = tempPlayer.getId();
					String name = updatePlayerDialog.getTextFieldName().getText();
					int height = Integer.parseInt(updatePlayerDialog.getTextFieldHeight().getText());
					int weight = Integer.parseInt(updatePlayerDialog.getTextFieldWeight().getText());
					String birthdateYear = (String) updatePlayerDialog.getComboBoxBirthdateYear().getSelectedItem();
					String birthdateMonth = (String) updatePlayerDialog.getComboBoxBirthdateMonth().getSelectedItem();
					String birthdateDay = (String) updatePlayerDialog.getComboBoxBirthdateDay().getSelectedItem();
					String birthdate = birthdateYear + "-" + birthdateMonth + "-" + birthdateDay;
					String nativeCity = updatePlayerDialog.getTextFieldNativeCity().getText();
					String rank = (String) updatePlayerDialog.getComboBoxRank().getSelectedItem();
					int coachId = ((Coach) updatePlayerDialog.getComboBoxCoach().getSelectedItem()).getId();
					int clubId = ((Club) updatePlayerDialog.getComboBoxClub().getSelectedItem()).getId();

					model.updatePlayer(new Player(id, name, height, weight, birthdate, nativeCity, rank, coachId, clubId));
					view.getPlayerTable().setModel(new PlayerTableModel(model.readAllPlayers()));
					updatePlayerDialog.dispose();
				}
			});
		}

		if(e.getSource() == view.getMenuItemDeleteClub()) {
			int answer = JOptionPane.showConfirmDialog(null, "Delete "
					+ clubTableModel.getClubs().get(view.getClubTable().getSelectedRow()).getName()
					+ "?", "Confirm deleting", JOptionPane.YES_NO_OPTION);
			if(answer == 0) {
				System.out.println("yes");
				model.deleteClub(clubTableModel.getClubs().get(view.getClubTable().getSelectedRow()));
				view.getClubTable().setModel(new ClubTableModel(model.readAllClubs()));
			}
		}

		if(e.getSource() == view.getMenuItemDeleteCoach()) {
			int answer = JOptionPane.showConfirmDialog(null, "Delete "
					+ coachTableModel.getCoaches().get(view.getCoachTable().getSelectedRow()).getName()
					+ "?", "Confirm deleting", JOptionPane.YES_NO_OPTION);
			if(answer == 0) {
				model.deleteCoach(coachTableModel.getCoaches().get(view.getCoachTable().getSelectedRow()));
				view.getCoachTable().setModel(new CoachTableModel(model.readAllCoaches()));
			}
		}

		if(e.getSource() == view.getMenuItemDeletePlayer()) {
			System.out.println("Delete Player");
			int answer = JOptionPane.showConfirmDialog(null, "Delete "
					+ playerTableModel.getPlayers().get(view.getPlayerTable().getSelectedRow()).getName()
					+ "?", "Confirm deleting", JOptionPane.YES_NO_OPTION);
			if(answer == 0) {
				System.out.println("yes");
				model.deletePlayer(playerTableModel.getPlayers().get(view.getPlayerTable().getSelectedRow()));
				view.getPlayerTable().setModel(new PlayerTableModel(model.readAllPlayers()));
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// selects the row at which point the mouse is clicked
		if(event.getSource() == view.getClubTable()){
			Point pointClub = event.getPoint();
			int currentRowClubTable = view.getClubTable().rowAtPoint(pointClub);
			view.getClubTable().setRowSelectionInterval(currentRowClubTable, currentRowClubTable);
		}

		if(event.getSource() == view.getCoachTable()){
			Point pointCoach = event.getPoint();
			int currentRowCoachTable = view.getCoachTable().rowAtPoint(pointCoach);
			view.getCoachTable().setRowSelectionInterval(currentRowCoachTable, currentRowCoachTable);
		}

		if(event.getSource() == view.getPlayerTable()){
			Point pointPlayer = event.getPoint();
			int currentRowPlayerTable = view.getPlayerTable().rowAtPoint(pointPlayer);
			view.getPlayerTable().setRowSelectionInterval(currentRowPlayerTable, currentRowPlayerTable);
		}
	}

}
