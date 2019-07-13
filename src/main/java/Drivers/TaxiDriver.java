package Drivers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxi_driver")
public class TaxiDriver {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "taxidriver")
	    private String taxiDriver;
	    
	    @Column(name = "date")
	    private String driverDate;

	    @Column(name = "status")
	    private boolean isAvailable;

	    public String getDriverDate() {
			return driverDate;
		}

		public void setDriverDate(String driverDate) {
			this.driverDate = driverDate;
		}

		public boolean isDriverStatus() {
			return isAvailable;
		}

		public void setDriverStatus(boolean driverStatus) {
			this.isAvailable = driverStatus;
		}

		public int getId() {
			return id;
		}

		public String getTaxiDriver() {
			return taxiDriver;
		}

//		@Override
//	    public String toString() {
//	        return id + "|" + userName + "|" + userAge;
//	    }
}