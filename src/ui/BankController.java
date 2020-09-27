package ui;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import model.Client;
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

	@FXML
	private TextField currentNameTF;

	@FXML
	private TextField idCurrentTF;

	@FXML
	private TextField amountTF;

	@FXML
	private TextField currentDateTF;

	@FXML
	private TextField limitCreditCardTF;

	@FXML
	private TextField genderCurrentTF;

	@FXML
	private Button createAccountButtonID;
	@FXML
	private TextField idToDeleteTF;

	@FXML
	private Button deleteAccountFinishButton;

	@FXML
	private TextField nameToDeleteTF;

	@FXML
	private TextField amountToDeleteTF;

	@FXML
	private TextField dateCreationToDeleteTF;

	@FXML
	private Button undoDeleteAccountButton;

	String msgQueue;

	String msgPriority;

	String[] msgs;

	private User current;
	private Client toDelete;

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

		List<String> choices = new ArrayList<>();
		choices.add("Prioridad");
		choices.add("Simple");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("Seleccione", choices);
		dialog.setTitle("Siguiente turno");
		dialog.setHeaderText("Elija a la fila que desea atender");
		dialog.setContentText("Filas:");

		Optional<String> result = dialog.showAndWait();

		String r = result.get();

		if (r.equals("Simple")) {
			current = queueModule.getCurrenWithoutPriority();
			cashierModule.setCurrent(current);
		} else {
			current = queueModule.getCurrentWithPriority();
			cashierModule.setCurrent(current);
		}

		currentNameTF.setText(current.getName());
		idCurrentTF.setText(current.getId() + "");

		if (current.isGender()) {
			genderCurrentTF.setText("Femenino");
		} else {
			genderCurrentTF.setText("Masculino");
		}

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

	double amount;
	double limitGenerated;
	String today;
	Date date;

	@FXML
	void loadAmountButton(ActionEvent event) {
		amount = Double.parseDouble(amountTF.getText());

		limitGenerated = amount * 0.05;

		limitCreditCardTF.setText(limitGenerated + "");

		date = new Date();
		DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");

		today = dF.format(date);

		System.out.println(date.toString());

		currentDateTF.setText(today);

		createAccountButtonID.setDisable(false);

	}

	@FXML
	void createAccountButton(ActionEvent event) {

		cashierModule.signUpClient(current, amount, 0, today, current.getSpecialCondition());
		Alert advertencia = new Alert(AlertType.CONFIRMATION);
		advertencia.setTitle("CONFIRMACIÓN");
		advertencia.initStyle(StageStyle.DECORATED);
		advertencia.setContentText("Generación de turno exitosa. A continuación se le mostrará el estado de la fila");
		advertencia.showAndWait();

	}

	@FXML
	void deleteAccountFinishButton(ActionEvent event) {

		cashierModule.deleteClientAccount(Integer.parseInt(idToDeleteTF.getText()));

		Alert advertencia = new Alert(AlertType.CONFIRMATION);
		advertencia.setTitle("CANCELACION COMPLETA");
		advertencia.initStyle(StageStyle.DECORATED);
		advertencia.setContentText("El cliente con ID " + toDelete.getId() + " fue eliminado correctamente");
		advertencia.show();

		undoDeleteAccountButton.setDisable(false);
	}

	@FXML
	void undoDeleteAccountButton(ActionEvent event) {
		Client toUndo = cashierModule.getDesertersClients().get(cashierModule.getDesertersClients().size() - 1);
		cashierModule.signUpClient(
				new User(toUndo.getName(), toUndo.getId(), toUndo.isGender(), toUndo.getSpecialCondition()),
				toUndo.getBalance(), toUndo.getCreditQuota(), toUndo.getRegistrationDate(),
				toUndo.getSpecialCondition());

		Alert advertencia = new Alert(AlertType.CONFIRMATION);
		advertencia.setTitle("ACCION DESHECHA");
		advertencia.initStyle(StageStyle.DECORATED);
		advertencia.setContentText(
				"El cliente con ID " + toDelete.getId() + " fue restaurado correctamente a la base de datos");
		advertencia.show();

	}

	@FXML
	void searchClientButton(ActionEvent event) {
		// idToDeleteTF

		if (cashierModule.searchClient(Integer.parseInt(idToDeleteTF.getText())) == null) {
			Alert advertencia = new Alert(AlertType.WARNING);
			advertencia.setTitle("USUARIO NO ENCONTRADO");
			advertencia.initStyle(StageStyle.DECORATED);
			advertencia.setContentText("El ID ingresado no se encuentra en la base de datos.\nPor favor verifique");
			advertencia.show();
		} else {
			toDelete = cashierModule.searchClient(Integer.parseInt(idToDeleteTF.getText()));
			nameToDeleteTF.setText(toDelete.getName());
			amountToDeleteTF.setText(toDelete.getBalance() + "");
			dateCreationToDeleteTF.setText(toDelete.getRegistrationDate());
			deleteAccountFinishButton.setDisable(false);
		}
	}

}