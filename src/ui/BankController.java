package ui;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import model.Client;
import model.User;
import model.CashierModule.CashierModule;
import model.QueueModule.QueueModule;

public class BankController {

	
    @FXML
    private TableView<Client> clientsTV;

    @FXML
    private TableColumn<Client, String> nameTC;

    @FXML
    private TableColumn<Client, String> idTC;

    @FXML
    private TableColumn<Client, String> genderTC;

    @FXML
    private TableColumn<Client, String> balanceTC;

    @FXML
    private TableColumn<Client, String> creditCuotaTC;

    @FXML
    private TableColumn<Client, String> openingDateTC;

    @FXML
    private TableColumn<Client, String> specialConditionTC;
    
    public void initializeTableView() {
    	
    	ObservableList<Client> observableList;
    	
    	observableList = FXCollections.observableArrayList(cashierModule.getAllClients());
    	
    	clientsTV.setItems(observableList);
    	
    	nameTC.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
    	idTC.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
    	genderTC.setCellValueFactory(new PropertyValueFactory<Client, String>("genderTableView"));
    	balanceTC.setCellValueFactory(new PropertyValueFactory<Client, String>("balance"));
    	creditCuotaTC.setCellValueFactory(new PropertyValueFactory<Client, String>("creditQuota"));
    	openingDateTC.setCellValueFactory(new PropertyValueFactory<Client, String>("registrationDate"));
    	specialConditionTC.setCellValueFactory(new PropertyValueFactory<Client, String>("specialConditionTableView"));
    	
    }
    
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

	@FXML
	private Label currentUserLbl;
	@FXML
	private TextField valuePay;

	String msgQueue;

	String msgPriority;

	int seleccion;

	private User current;

	private Client toDelete;

	@FXML
	private TextField idToDoPayTF;

	@FXML
	private TextField accountToDoPayTF;

	@FXML
	private Button doPayButton;

	@FXML
	private Button doPayCreditCardButton;

	@FXML
	private TextField IDToPayCreditCardTF;

	@FXML
	private TextField AccountToPayCreditCardTF;

	@FXML
	private TextField nameSearchTF;

	@FXML
	private TextField idToSearchTF;

	@FXML
	private TextField genderSearchTF;

	@FXML
	private TextField balanceSearchTF;

	@FXML
	private TextField creditSearchTF;

	@FXML
	private TextField creationSearchTF;

	@FXML
	private TextField specialConditionSearchTF;


	@FXML
	private Pane userInformation;

	@FXML
	private TextField nameCurrentUser;

	@FXML
	private TextField idCurrentUser;

	@FXML
	private TextField specialCurrentUser;

	@FXML
	private TextField genderCurrentUser;

	@FXML
	private TextField nameNextUser;

	@FXML
	private TextField idNextUser;

	@FXML
	private TextField specialNextUser;

	@FXML
	private TextField genderNextUser;

	private int queueType;

	public BankController() {

		queueModule = new QueueModule();
		cashierModule = new CashierModule();
		msgQueue = "";
		msgPriority = "";
		seleccion = -1;
		queueType = -1;
		cashierModule.signUpClient(new User("Andrea", 001, true, 0), 322, 0, "29/09/2020", 0);
		cashierModule.signUpClient(new User("Danna", 257, true, 2), 2, 3, "29/07/2020", 2);
		cashierModule.signUpClient(new User("Camilo", 999, false, 0), 10000, 0, "29/09/2020", 0);
	}

	@FXML
	void nextUserSimple(ActionEvent event) {
		try {
			if (queueModule.countSimpleQueue == 0) {
				throw new Exception("No hay personas agregadas en la fila simple");
			}
			current = queueModule.getCurrenWithoutPriority2();
			cashierModule.setCurrent(current);

			currentUserLbl.setText(current.getName() + " - ID: " + current.getId());

			queueType = 0;

			msgQueue = queueModule.getCurrentState()[0];
			msgPriority = queueModule.getCurrentState()[1];

			userInformationQueue(event);

		} catch (Exception e) {
			Alert advertencia = new Alert(AlertType.ERROR);
			advertencia.setTitle("ACCION INVALIDA");
			advertencia.initStyle(StageStyle.DECORATED);
			advertencia.setContentText(e.getMessage());
			e.printStackTrace();
			advertencia.showAndWait();

		}
	}

	@FXML
	void nextUserPriority(ActionEvent event) {
		try {
			if (queueModule.countPriorityQueue == 0) {
				throw new Exception("No hay personas agregadas en la fila de prioridad");
			}
			current = queueModule.getCurrentWithPriority2();
			cashierModule.setCurrent(current);

			currentUserLbl.setText(current.getName() + " - ID: " + current.getId());

			queueType = 1;

			msgQueue = queueModule.getCurrentState()[0];
			msgPriority = queueModule.getCurrentState()[1];

			userInformationQueue(event);
			
		} catch (Exception e) {
			Alert advertencia = new Alert(AlertType.ERROR);
			advertencia.setTitle("ACCION INVALIDA");
			advertencia.initStyle(StageStyle.DECORATED);
			advertencia.setContentText(e.getMessage());
			e.printStackTrace();
			advertencia.showAndWait();
		}
	}

	@FXML
	void verifyID(ActionEvent event) {
		if (cashierModule.searchClient(Integer.parseInt(idUserLbl1.getText())) != null) {

			User temp = cashierModule.searchClient(Integer.parseInt(idUserLbl1.getText()));
			nameUserLbl.setText(temp.getName());

			if (temp.getSpecialCondition() == 0) {
				nonSpecialCRB.setSelected(true);
				nonSpecialCRB.setDisable(false);
			} else if (temp.getSpecialCondition() == 1) {
				ancientSpecialCRB.setSelected(true);
				ancientSpecialCRB.setDisable(false);

			} else if (temp.getSpecialCondition() == 2) {
				discapacitySpecialCRB.setSelected(true);
				discapacitySpecialCRB.setDisable(false);
			} else {
				pregnancySpecialCRB.setSelected(true);
				pregnancySpecialCRB.setDisable(false);
			}

			if (temp.isGender()) {
				girlRB.setSelected(true);
				girlRB.setDisable(false);
			} else {
				boyRB.setSelected(true);
				boyRB.setDisable(false);
			}

		} else {
			nameUserLbl.setEditable(true);
			nonSpecialCRB.setDisable(false);
			ancientSpecialCRB.setDisable(false);
			discapacitySpecialCRB.setDisable(false);
			pregnancySpecialCRB.setDisable(false);
			girlRB.setDisable(false);
			boyRB.setDisable(false);

		}
	}

	String r;

	@FXML
	void createAClientAccount(ActionEvent event) throws IOException {

		try {

			if (cashierModule.getCurrent() instanceof Client) {
				throw new Exception();
			}
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createClientAccount.fxml"));
			fxmlLoader.setController(this);
			Parent clientAccount = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.getChildren().add(clientAccount);
			currentNameTF.setText(current.getName());
			idCurrentTF.setText(current.getId() + "");

			if (current.isGender()) {
				genderCurrentTF.setText("Femenino");
			} else {
				genderCurrentTF.setText("Masculino");
			}

		} catch (Exception e) {
			Alert advertencia = new Alert(AlertType.ERROR);
			advertencia.setTitle("ACCION INVALIDA");
			advertencia.initStyle(StageStyle.DECORATED);
			advertencia.setContentText("El usuario que ingresó ya se encuentra registrado.");
			advertencia.showAndWait();
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
		
		cashierModule.unifyClients();
		initializeTableView();
	}

	@FXML
	void assignTurn(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("assignTurn.fxml"));
		fxmlLoader.setController(this);
		Parent clientAccount = fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(clientAccount);
		
		queueLabel.setText(msgQueue);
		priorityLabel.setText(msgPriority);
	}

	@FXML
	void userInformationQueue(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("userInformation.fxml"));
		fxmlLoader.setController(this);
		Parent userInformation= fxmlLoader.load();
		mainPane.getChildren().clear();
		mainPane.getChildren().add(userInformation);

		//Simple queue
		if (queueType == 0) {
			//Actual user
			User current = queueModule.getCurrenWithoutPriority2();
			nameCurrentUser.setText(current.getName());
			idCurrentUser.setText(current.getId() + "");
			specialCurrentUser.setText("Ninguna condición especial");
			boolean gender = current.isGender();
			String g = "";
			if (gender == true) {
				g = "Mujer";
			} else {
				g = "Hombre";
			}
			genderCurrentUser.setText(g);

			queueModule.simpleQueue.dequeue();

			//Next user
			if (queueModule.getCurrenWithoutPriority2() != null) {
				nameNextUser.setText(queueModule.getCurrenWithoutPriority2().getName());
				idNextUser.setText(queueModule.getCurrenWithoutPriority2().getId() + "");
				specialNextUser.setText("Ninguna condición especial");
				gender = queueModule.getCurrenWithoutPriority2().isGender();
				g = "";
				if (gender == true) {
					g = "Mujer";
				} else {
					g = "Hombre";
				}
				genderNextUser.setText(g);
			}

		//Priority queue
	} else if (queueType == 1) {
			User current = queueModule.getCurrentWithPriority2();
			nameCurrentUser.setText(current.getName());
			idCurrentUser.setText(current.getId() + "");
			String sp = "";
			if (current.getSpecialCondition() == 1) {
				sp = "Tercera edad";
			} else if (current.getSpecialCondition() == 2) {
				sp = "Discapacidad";
			} else {
				sp = "Embarazo o niños en brazos";
			}
			specialCurrentUser.setText(sp);
			boolean gender = current.isGender();
			String g = "";
			if (gender == true) {
				g = "Mujer";
			} else {
				g = "Hombre";
			}
			genderCurrentUser.setText(g);

			queueModule.priorityQueue.dequeue();

			// Next user
			if (queueModule.getCurrentWithPriority2() != null) {
				nameNextUser.setText(queueModule.getCurrentWithPriority2().getName());
				idNextUser.setText(queueModule.getCurrentWithPriority2().getId() + "");
				specialNextUser.setText("Ninguna condición especial");
				gender = queueModule.getCurrentWithPriority2().isGender();
				g = "";
				if (gender == true) {
					g = "Mujer";
				} else {
					g = "Hombre";
				}
				genderNextUser.setText(g);
			}
		}
	}

	@FXML
	void enqueueUserBtn(ActionEvent event) throws IOException {
		String name;
		try {
			name = nameUserLbl.getText();

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

			if (specialCondition != -1 && !(name.equals("")) && !(idUserLbl1.getText().equals(""))) {
				User theNew = new User(name, id, gender, specialCondition);
				queueModule.receivePerson(theNew);

				Alert advertencia = new Alert(AlertType.CONFIRMATION);
				advertencia.setTitle("CONFIRMACIÓN");
				advertencia.initStyle(StageStyle.DECORATED);
				advertencia.setContentText(
						"Generación de turno exitosa." + "\n" + "A continuación se le mostrará el estado de la fila");
				advertencia.showAndWait();
			} else {
				Alert advertencia = new Alert(AlertType.ERROR);
				advertencia.setTitle("DATOS INCOMPLETOS");
				advertencia.initStyle(StageStyle.DECORATED);
				advertencia.setContentText("No ha ingresado los datos completos, revise por favor");
				advertencia.showAndWait();
			}

			if (nonSpecialCRB.isSelected()) {
				seleccion = 0;
			} else {
				seleccion = 1;
			}

			msgQueue = queueModule.getCurrentState()[0];
			msgPriority = queueModule.getCurrentState()[1];
			assignTurn(event);

		} catch (

		NumberFormatException e) {

			Alert advertencia = new Alert(AlertType.ERROR);
			advertencia.setTitle("ERROR DE FORMATO");
			advertencia.initStyle(StageStyle.DECORATED);
			advertencia.setContentText("Ingresó caracteres no numéricos en el ID");
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

	@FXML
	void doPayButton(ActionEvent event) {
		cashierModule.doPay(Integer.parseInt(idToDoPayTF.getText()), Double.parseDouble(accountToDoPayTF.getText()));

		Alert advertencia = new Alert(AlertType.CONFIRMATION);
		advertencia.setTitle("OPERACION EXITOSA");
		advertencia.initStyle(StageStyle.DECORATED);
		advertencia.setContentText("Se realizo la consignacion por valor de $" + accountToDoPayTF.getText()
				+ "\na la cuenta con ID " + idToDoPayTF.getText());
		advertencia.show();

	}

	@FXML
	void verifyIDtoDoPay(ActionEvent event) {

		if (cashierModule.searchClient(Integer.parseInt(idToDoPayTF.getText())) != null) {
			accountToDoPayTF.setEditable(true);
			doPayButton.setDisable(false);

		} else {
			Alert advertencia = new Alert(AlertType.WARNING);
			advertencia.setTitle("USUARIO NO ENCONTRADO");
			advertencia.initStyle(StageStyle.DECORATED);
			advertencia.setContentText("El ID ingresado no se encuentra en la base de datos.\nPor favor verifique");
			advertencia.show();
		}
	}

	@FXML
	void doPayCreditCardAccion(ActionEvent event) {

	}

	@FXML
	void verifyIDToPayCreditCard(ActionEvent event) {
		if (cashierModule.searchClient(Integer.parseInt(IDToPayCreditCardTF.getText())) != null) {

			AccountToPayCreditCardTF.setText(
					"" + cashierModule.searchClient(Integer.parseInt(IDToPayCreditCardTF.getText())).getCreditQuota());

			if (cashierModule.searchClient(Integer.parseInt(IDToPayCreditCardTF.getText())).getCreditQuota() != 0) {
				valuePay.setEditable(true);
				doPayCreditCardButton.setDisable(false);
			}

		}
	}

	@FXML
	void searchClientButtonAction(ActionEvent event) {

		if (cashierModule.searchClient(Integer.parseInt(idToSearchTF.getText())) != null) {

			Client temp = cashierModule.searchClient(Integer.parseInt(idToSearchTF.getText()));

			nameSearchTF.setText(temp.getName());
			if (temp.isGender()) {
				genderSearchTF.setText("Mujer");
			} else {
				genderSearchTF.setText("Mujer");
			}

			balanceSearchTF.setText(temp.getBalance() + "");
			creditSearchTF.setText(temp.getCreditQuota() + "");
			creationSearchTF.setText(temp.getRegistrationDate());

			if (temp.getSpecialCondition() == 0) {
				specialConditionSearchTF.setText("Sin condicion especial");
			} else if (temp.getSpecialCondition() == 1) {
				specialConditionSearchTF.setText("Persona de la tercera edad");
			} else if (temp.getSpecialCondition() == 2) {
				specialConditionSearchTF.setText("Persona con discapacidad");
			} else {
				specialConditionSearchTF.setText("Mujer embarazada o persona con niño en brazos");
			}
		} else {
			Alert advertencia = new Alert(AlertType.WARNING);
			advertencia.setTitle("USUARIO NO ENCONTRADO");
			advertencia.initStyle(StageStyle.DECORATED);
			advertencia.setContentText("El ID ingresado no se encuentra en la base de datos.\nPor favor verifique");
			advertencia.show();
		}

	}
}