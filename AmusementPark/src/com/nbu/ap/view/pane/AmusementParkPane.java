package com.nbu.ap.view.pane;

import com.nbu.ap.DBManager;
import com.nbu.ap.entity.AmusementPark;
import com.nbu.ap.entity.Attraction;
import com.nbu.ap.entity.Manager;
import com.nbu.ap.view.UserView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AmusementParkPane extends GridPane {

	private UserView userView;
	private AmusementPark amusementPark;
	private Label amusementParkLabel = new Label("Amusement park : ");
	private Label nameLabel = new Label("Name : ");
	private Label incomeTresholdLabel = new Label("Income treshold : ");
	private Label managerLabel = new Label("Manager : ");
	private Label attractionsLabel = new Label("Attractions : ");		
	private TextField nameField = new TextField();
	private TextField incomeTresholdField = new TextField();
	
	private ComboBox<AmusementPark> amusementParksComboBox;
	private ComboBox<Manager> managersComboBox;
	private ComboBox<Attraction> attractionsComboBox;

	private ListView<Attraction> attractionsListView = new ListView<Attraction>();
	
	private Button attractionAdd = new Button("Add");
	private Button save = new Button("Save");
	private Button cancel = new Button("Cancel");
	
	public AmusementParkPane() {
		super();
		init();
	}

	public AmusementParkPane(UserView userView) {
		this();
		this.userView = userView;
	}

	private void init() {
		ObservableList<AmusementPark> amusementParks =
		    FXCollections.observableArrayList(DBManager.read(AmusementPark.class));
		amusementParksComboBox = new ComboBox<AmusementPark>(amusementParks);
		
		ObservableList<Manager> managers = 
		    FXCollections.observableArrayList(DBManager.read(Manager.class));
		managersComboBox = new ComboBox<Manager>(managers);
		
		ObservableList<Attraction> attractions = 
		    FXCollections.observableArrayList(DBManager.read(Attraction.class));
		attractionsComboBox = new ComboBox<Attraction>(attractions);

		amusementParksComboBox.valueProperty().addListener(new ChangeListener<AmusementPark>() {

			@Override
			public void changed(ObservableValue<? extends AmusementPark> observable, AmusementPark oldValue,
					AmusementPark newValue) {
				amusementPark = amusementParksComboBox.getValue();
				fillAmusementPark(amusementPark);
			}
	    });
		
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					saveAmusementPark(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
				
		attractionAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				addAttraction(e);
			}
		});

		add(amusementParkLabel, 0, 0);
		add(amusementParksComboBox, 1, 0, 2, 1);
		add(nameLabel, 0, 1);
		add(nameField, 1, 1);
		add(managerLabel, 0, 2);
		add(managersComboBox, 1, 2);
		add(incomeTresholdLabel, 0, 3);
		add(incomeTresholdField, 1, 3);
		add(attractionsLabel, 0, 4);
		add(attractionsComboBox, 1, 4);
		add(attractionAdd, 2, 4);
		add(attractionsListView, 0, 5, 2, 1);
		add(save, 0, 6);
		add(cancel, 1, 6);
	}

	private void saveAmusementPark(ActionEvent event) throws Exception {
		if (amusementPark != null && amusementPark.getId() > 0) {
			amusementPark.setManager(managersComboBox.getValue());
			amusementPark.setName(nameField.getText());
			amusementPark.setIncomeTreshold(Double.valueOf(incomeTresholdField.getText()));
			amusementPark.setAttractions(attractionsListView.getItems());
			DBManager.update(amusementPark);
		} else {
			amusementPark = new AmusementPark(nameField.getText(), Double.valueOf(incomeTresholdField.getText()), managersComboBox.getValue(), attractionsListView.getItems());
			DBManager.create(amusementPark);
		}
		userView.restart();
	}
	
	private void addAttraction(ActionEvent event) {
		if (!attractionsListView.getItems().contains(attractionsComboBox.getValue())) {
			attractionsListView.getItems().add(attractionsComboBox.getValue());
		}
	}
	
	private void fillAmusementPark(AmusementPark amusementPark) {
		this.amusementPark = amusementPark;
		nameField.setText(amusementPark.getName());
		managersComboBox.setValue(amusementPark.getManager());
		incomeTresholdField.setText(String.valueOf(amusementPark.getIncomeTreshold()));
		attractionsListView.setItems(FXCollections.observableArrayList(amusementPark.getAttractions()));
	}
	
}