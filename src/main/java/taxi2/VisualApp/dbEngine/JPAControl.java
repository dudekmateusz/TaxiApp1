package taxi2.VisualApp.dbEngine;

import Drivers.TaxiDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JPAControl {

		JPAConnect jpa = new JPAConnect();
		
		public ObservableList<TaxiDriver> getData(){
			return FXCollections.observableArrayList(jpa.getList());
			}
		

		public void update (TaxiDriver user) {
			jpa.addToDatabase(user);
		}

}
