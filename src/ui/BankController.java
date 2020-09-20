package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import model.QueueModule.QueueModule;

public class BankController {

	private QueueModule queueModule;

	@FXML
	private ToggleGroup modulos;

	@FXML
	private Pane mainPane;

	@FXML
	void loadCashierModule(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cashierModule.fxml"));
		fxmlLoader.setController(this);
		Parent cashierm = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(cashierm);
	}

	@FXML
	void loadQueueModule(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("queueModule.fxml"));
		fxmlLoader.setController(this);
		Parent queueModule = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(queueModule);
	}
}
