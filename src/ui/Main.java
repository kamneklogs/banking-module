package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import model.QueueModule.PriorityQueueue.MyHeap;

public class Main extends Application {

	private BankController bc;

	public Main() {
		bc = new BankController();
	}

	public static void main(String[] args) {
	
		//launch(args);

		MyHeap mH = new MyHeap();

		mH.insert(new User("Danna", 45342, 2));
		mH.insert(new User("Andrea", 12213, 3));
		mH.insert(new User("La Nunez", 5422, 4));

		System.out.println(mH.elements.get(0).getName());
		System.out.println(mH.elements.get(1).getName());
		System.out.println(mH.elements.get(2).getName());

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("Main.fxml"));
		fxmll.setController(bc);
		Parent root = fxmll.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Banking & service");
		primaryStage.show();
	}

}