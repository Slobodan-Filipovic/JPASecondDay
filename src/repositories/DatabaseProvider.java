package repositories;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DatabaseProvider {
	
	private static EntityManager entityManager;
	public static EntityManager getEntityManager() {
		if(entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory("JpaSecondDay").createEntityManager();
		}
		return entityManager;
	}

}
