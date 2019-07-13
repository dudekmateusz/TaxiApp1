package taxi2.VisualApp;

import java.time.LocalDate;
import java.util.Calendar;

import Drivers.TaxiDriver;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import taxi2.VisualApp.dbEngine.JPAControl;

public class ListClickTaxi implements EventHandler<MouseEvent> {
		JPAControl jpa = new JPAControl();
    @Override
    public void handle(MouseEvent event) {
        if(event.getButton() == MouseButton.PRIMARY) {
            if(event.getClickCount() == 2) {
                Stage userView = new Stage();
                GridPane root = new GridPane();
                userView.setScene(new Scene(root, 300, 200));

                ListView<TaxiDriver> list = (ListView<TaxiDriver>)event.getSource();
                final TaxiDriver driver = list.getSelectionModel().getSelectedItem();

                root.add(new Label("Fill in date"), 0, 0);
                
                Calendar calendar = Calendar.getInstance();

                DatePicker d;
                
                if(driver.getDriverDate() != null) {
                	calendar.setTime(driver.getDriverDate());
                	d = new DatePicker(LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)));
                	} else {
                	d = new DatePicker();
                	}
                
                

                
                
                root.add(d, 0, 1);

                Button order = new Button("order");
                root.add(order, 0, 2);
                Button delete = new Button("delete");
                root.add(delete, 1, 2);
                
                order.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
                    @Override
                    public void handle(MouseEvent event) {
                    
                	Calendar c = Calendar.getInstance();
                	c.set(Calendar.YEAR, d.getValue().getYear());
                	c.set(Calendar.MONTH, d.getValue().getMonth().getValue());
                	c.set(Calendar.DAY_OF_MONTH, d.getValue().getDayOfMonth());
                    driver.setDriverDate(c.getTime());
                    driver.setDriverStatus(true);
                    list.refresh();
                    userView.hide();
                    jpa.update(driver);
                    

                    	
//                        driver.getDriver(taxiDriver.getText());
//                        user.setUserAge(Integer.valueOf(age.getText()));
//                        TaxiApp.em.getTransaction().begin();
//                        TaxiApp.em.persist(user);
//                        TaxiApp.em.getTransaction().commit();
//                        list.refresh();
//                        userView.hide();
                    }

                });

                userView.show();
                
                delete.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                    	
                    	driver.setDriverDate(null);
                        driver.setDriverStatus(false);
                        list.refresh();
                        userView.hide();
                        jpa.update(driver);
//                        user.setUserName(name.getText());
//                        user.setUserAge(Integer.valueOf(age.getText()));
//                        TaxiApp.em.getTransaction().begin();
//                        TaxiApp.em.persist(user);
//                        TaxiApp.em.getTransaction().commit();
//                        list.refresh();
//                        userView.hide();
                    }

                });

                userView.show();
            }
        }
    }

}
