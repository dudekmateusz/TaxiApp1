package taxi2.VisualApp;

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
import taxi2.VisualApp.dbEngine.JPAControl;


public class TaxiApp extends Application{

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		JPAControl c = new JPAControl();
		primaryStage.centerOnScreen();
		primaryStage.setTitle("Codeme Taxi");
		GridPane root = new GridPane();
		Label title = new Label("Available drivers");
		root.add(title, 0, 0);
		
		ListView<TaxiDriver> list = new ListView<>(c.getData());
		root.add(list, 0, 1);
		
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setScene(scene);
		scene.getFill();
		
		primaryStage.show();
		
		Button save = new Button("order");
		root.add(save, 5, 3);
		
		Button delete = new Button("delete");
		root.add(delete, 5, 4);

		save.setOnMouseClicked(new EventHandler<MouseEvent>(){
			
			
			public void handle(MouseEvent event) {
				
			}
		});

			
	}

}
