package taxi2.VisualApp.dbEngine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Drivers.TaxiDriver;

public class JPAConnect {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("codeme_taxi2").createEntityManager();
		TaxiDriver user = new TaxiDriver();
		
		em.getTransaction().begin();
		try {
			em.persist(user);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		}
	}
		
		public List<TaxiDriver> getList(EntityManager em) {
			TypedQuery<TaxiDriver> q = em.createQuery("SELECT u FROM TaxiDriver u", TaxiDriver.class);
			List<TaxiDriver> res =  q.getResultList();
			return res;
		}
		
		

	}


