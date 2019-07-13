package taxi2.VisualApp;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import pl.codeme.javase14.basics.db.User;

public class ListClickTaxi implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent event) {
        if(event.getButton() == MouseButton.PRIMARY) {
            if(event.getClickCount() == 2) {
                Stage userView = new Stage();
                GridPane root = new GridPane();
                userView.setScene(new Scene(root, 300, 200));

                ListView<User> list = (ListView<User>)event.getSource();
                final User user = list.getSelectionModel().getSelectedItem();

                root.add(new Label("Data"), 0, 0);
//                root.add(new Label("Wiek"), 1, 0);
                final TextField name = new TextField(user.getUserName());
                final TextField age = new TextField(String.valueOf(user.getUserAge()));
                root.add(name, 0, 1);
                root.add(age, 1, 1);

                Button save = new Button("Zapisz");
                root.add(save, 0, 2);
                save.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        user.setUserName(name.getText());
                        user.setUserAge(Integer.valueOf(age.getText()));
                        App.em.getTransaction().begin();
                        App.em.persist(user);
                        App.em.getTransaction().commit();
                        list.refresh();
                        userView.hide();
                    }

                });

                userView.show();
            }
        }
    }

}
