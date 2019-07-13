package taxi2.VisualApp.dbEngine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Drivers.TaxiDriver;

public class JPAConnect {

	private EntityManager em;

//Konstruktor
	public JPAConnect() {
		this.em = Persistence.createEntityManagerFactory("codeme_taxi2-ds").createEntityManager();
	}

//Pobieranie z bazy danych listy taks�wek
	public List<TaxiDriver> getList() {
		TypedQuery<TaxiDriver> q = em.createQuery("SELECT u FROM TaxiDriver u", TaxiDriver.class);
		List<TaxiDriver> res = q.getResultList();
		return res;
	}

//Aktualizowanie w bazie danych statusu taks�wki
	public void addToDatabase(TaxiDriver user) {
		em.getTransaction().begin();
		try {
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}

