package taxi2.VisualApp;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Drivers.TaxiDriver;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class TaxiApp extends Application{
	EntityManager em = Persistence.createEntityManagerFactory("codeme_taxi2").createEntityManager();

	private ObservableList<TaxiDriver> getData(){
	TypedQuery<TaxiDriver> q = em.createQuery("SELECT p FROM taxiDriver p", TaxiDriver.class);
	return FXCollections.observableArrayList(q.getResultList());
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.centerOnScreen();
		primaryStage.setTitle("Codeme Taxi");
		GridPane root = new GridPane();
		Label title = new Label("Dostêpni kierowcy");
		root.add(title, 0, 0);
		
		ListView<TaxiDriver> list = new ListView<TaxiDriver>(getData());
		root.add(list, 0, 1);
		
		Scene scene = new Scene(root,1000,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
