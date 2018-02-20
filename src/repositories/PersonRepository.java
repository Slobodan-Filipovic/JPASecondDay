package repositories;

import javax.persistence.EntityManager;

public class PersonRepository {

	private EntityManager em;

	public PersonRepository(EntityManager em) {

		this.em = em;
		}
	public void insertPerson(Person p) {
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		}

		catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

}
