package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import model.QueueModule.QueueModule;
import model.cashierModule.CashierModule;

public class BankController {

	private QueueModule queueModule;

	private CashierModule cashierModule;

	@FXML
	private ToggleGroup opsCashiersModule;

	@FXML
	private ToggleGroup opsQueueModule;

	@FXML
	private Pane mainPane;

	@FXML
	void createAClientAccount(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createClientAccount.fxml"));
		fxmlLoader.setController(this);
		Parent clientAccount = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(clientAccount);
	}

	@FXML
	void deleteClientAccount(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("deleteClientAccount.fxml"));
		fxmlLoader.setController(this);
		Parent clientAccount = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(clientAccount);
	}

	@FXML
	void doPayOption(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("doPayOption.fxml"));
		fxmlLoader.setController(this);
		Parent clientAccount = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(clientAccount);
	}

	@FXML
	void payCreditCard(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("payCreditCard.fxml"));
		fxmlLoader.setController(this);
		Parent clientAccount = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(clientAccount);
	}

	@FXML
	void searchAClient(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("searchAClient.fxml"));
		fxmlLoader.setController(this);
		Parent clientAccount = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(clientAccount);
	}

	@FXML
	void seeClientsDataBase(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("seeClientsDataBase.fxml"));
		fxmlLoader.setController(this);
		Parent clientAccount = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(clientAccount);
	}

	@FXML
	void seeQueuesState(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("seeQueuesState.fxml"));
		fxmlLoader.setController(this);
		Parent clientAccount = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(clientAccount);
	}

	@FXML
	void assignTurn(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("assignTurn.fxml"));
		fxmlLoader.setController(this);
		Parent clientAccount = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(clientAccount);
	}
}
