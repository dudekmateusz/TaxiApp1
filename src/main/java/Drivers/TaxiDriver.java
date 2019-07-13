package Drivers;

import java.util.Date;

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
	    private Date driverDate;

	    @Column(name = "status")
	    private boolean isAvailable;

	    public Date getDriverDate() {
			return driverDate;
		}

		public void setDriverDate(Date driverDate) {
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

		@Override
	    public String toString() {
	        return id + " | " + taxiDriver + " | " + isAvailable+" | "+driverDate;
	    }
}