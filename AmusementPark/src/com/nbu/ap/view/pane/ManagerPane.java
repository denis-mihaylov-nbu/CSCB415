package com.nbu.ap.view.pane;

import com.nbu.ap.DBManager;
import com.nbu.ap.entity.Manager;
import com.nbu.ap.view.UserView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ManagerPane extends GridPane {

	private UserView userView;

	private Label nameLabel = new Label("Name : ");
	private Label salaryLabel = new Label("Salary : ");
	private TextField nameField = new TextField();
	private TextField salaryField = new TextField();
	private ListView<Manager> managerListView = new ListView<Manager>();
	private Manager manager;
	
	private Button save = new Button("Save");
	private Button cancel = new Button("Cancel");
	
	public ManagerPane() {
		super();
		init();
	}

	public ManagerPane(UserView userView) {
		this();
		this.userView = userView;
	}

	private void init() {
		
		reinitListView();
		
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					saveManager(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});	

		add(managerListView, 0, 0);
		add(nameLabel, 0, 1);
		add(nameField, 1, 1);
		add(salaryLabel, 0, 2);
		add(salaryField, 1, 2);
		add(save, 0, 3);
		add(cancel, 1, 3);
	}
	
	private void reinitListView() {
		ObservableList<Manager> items = FXCollections.observableArrayList(DBManager.read(Manager.class));
		managerListView.setItems(items);	
	}
	
	private void saveManager(ActionEvent event) throws Exception {
		manager = new Manager(nameField.getText(), Double.valueOf(salaryField.getText()));
		DBManager.create(manager);
		reinitListView();
		userView.restart();
	}
	
}
