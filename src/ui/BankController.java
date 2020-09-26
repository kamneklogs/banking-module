package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import model.User;
import model.CashierModule.CashierModule;
import model.QueueModule.QueueModule;

public class BankController {

	private QueueModule queueModule;

	private CashierModule cashierModule;

	@FXML
	private TextField nameUserLbl;

	@FXML
	private TextField idUserLbl1;

	@FXML
	private RadioButton nonSpecialCRB;

	@FXML
	private ToggleGroup specialCondicions;

	@FXML
	private RadioButton ancientSpecialCRB;

	@FXML
	private RadioButton discapacitySpecialCRB;

	@FXML
	private RadioButton pregnancySpecialCRB;

	@FXML
	private Label priorityLabel;

	@FXML
	private Label queueLabel;

	@FXML
	private Pane mainPane;

	@FXML
	private RadioButton girlRB;

	@FXML
	private ToggleGroup gender;

	@FXML
	private RadioButton boyRB;

	String msgQueue;

	String msgPriority;

	String[] msgs;

	public BankController() {
		queueModule = new QueueModule();
		cashierModule = new CashierModule();
		msgQueue = "";
		msgPriority = "";
		msgs = new String[2];
	}

	public void initialize() {

	}

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
	void assignTurn(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("assignTurn.fxml"));
		fxmlLoader.setController(this);
		Parent clientAccount = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(clientAccount);

	}

	@FXML
	void enqueueUserBtn(ActionEvent event) throws IOException {

		try {
			String name = nameUserLbl.getText();

			int id = Integer.parseInt(idUserLbl1.getText());

			if (idUserLbl1.getText().length() != 3) {
				Alert advertencia = new Alert(AlertType.ERROR);
				advertencia.setTitle("ERROR DE FORMATO");
				advertencia.initStyle(StageStyle.DECORATED);
				advertencia.setContentText("El número de identificación debería contener 3 dígitos exactamente");
				advertencia.showAndWait();
			}
			int specialCondition = -1;
			if (nonSpecialCRB.isSelected()) {
				specialCondition = 0;
			} else if (ancientSpecialCRB.isSelected()) {
				specialCondition = 1;
			} else if (discapacitySpecialCRB.isSelected()) {
				specialCondition = 2;
			} else if (pregnancySpecialCRB.isSelected()) {
				specialCondition = 3;
			} else {
				Alert advertencia = new Alert(AlertType.ERROR);
				advertencia.setTitle("ERROR DE FORMATO");
				advertencia.initStyle(StageStyle.DECORATED);
				advertencia.setContentText("Tiene que seleccionar una opción");
				advertencia.showAndWait();

			}

			boolean gender = false;
			if (girlRB.isSelected()) {
				gender = true;
			}

			User theNew = new User(name, id, gender, specialCondition);
			queueModule.receivePerson(theNew);

			Alert advertencia = new Alert(AlertType.CONFIRMATION);
			advertencia.setTitle("CONFIRMACIÓN");
			advertencia.initStyle(StageStyle.DECORATED);
			advertencia
					.setContentText("Generación de turno exitosa. A continuación se le mostrará el estado de la fila");
			advertencia.showAndWait();

			msgs = queueModule.returnQueue();

			if (nonSpecialCRB.isSelected()) {
				msgQueue += msgs[0];
				queueLabel.setText(msgQueue);
			} else {
				msgPriority = msgs[1];
				priorityLabel.setText(msgPriority);
			}

			assignTurn(event);
		} catch (

		NumberFormatException e) {
			Alert advertencia = new Alert(AlertType.ERROR);
			advertencia.setTitle("ERROR DE FORMATO");
			advertencia.initStyle(StageStyle.DECORATED);
			advertencia.setContentText("Ingresó caracteres no numéricos en el id");
			advertencia.show();
		}

	}
}
