package taxi2.VisualApp;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Drivers.TaxiDriver;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class TaxiApp extends Application{

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.centerOnScreen();
		primaryStage.setTitle("Codeme Taxi");
		GridPane root = new GridPane();
		Label title = new Label("Dost�pni kierowcy");
		root.add(title, 0, 0);
		
//		ListView<TaxiDriver> list = new ListView<TaxiDriver>(getData());
//		root.add(list, 0, 1);
		
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setScene(scene);
		scene.getFill();
		
		primaryStage.show();
		
		Button save = new Button("Zam�w");
		root.add(save, 5, 4);
		
		Button delete = new Button("Usu�");
		root.add(delete, 5, 5);
		
		save.setOnMouseClicked(new EventHandler<MouseEvent>(){
			
			
			public void handle(MouseEvent event) {
				
			}
		});

			
	}

}
