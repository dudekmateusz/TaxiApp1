package taxi2.VisualApp.dbEngine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;

public class JPAConnect {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("codeme_taxi2").createEntityManager();
		User user = new User();
		user.setUserName("Ela");
		user.setUserAge(36);
		
		
		em.getTransaction().begin();
		try {
			em.persist(user);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		}
		
		TypedQuery<User> q = em.createQuery("SELECT u FROM User u", User.class);
		List<User> res =  q.getResultList();
		for(User item : res) {
			System.out.println(item);
		}

	}

}
