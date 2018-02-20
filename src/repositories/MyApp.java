package repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import inheritance.jpa.Patient;
import model.Address;

public class MyApp {
	public static void main(String[] args) {
		EntityManager em = DatabaseProvider.getEntityManager();
		//em.createQuery("SELECT p FROM Person p").getResultList();
		System.out.println("proslo");
		// insertgeneratedPerson(em);
		// insertEditedPerson(em);
		// insertGeneratedPerson(em);
		//batchProcessing(em);
		//insertPatient(em);/*mora truncate table da bi radilo.*/
		//em.createNativeQuery(sqlString) For SQL syntax
		//em.createQuery("SELECT p FROM Person p").getResultList().forEach(System.out::println);//pukne jer ne moze da ispise tipove zbog diskriminator kolone.
		insertCreditCardPayment(em);
	}
	/**
	 * Cant get it to work from this point on. Issue with Eclipse generated models for Payment, CreditcardPayment and CheckPayment
	 * @param em
	 */
	public static void insertCreditCardPayment(EntityManager em) {
		CreditCardPayment creditcardPayment = new CreditCardPayment();
		creditcardPayment.setAccount("123-456ABC");
		creditcardPayment.setAmount(87123);
		em.getTransaction().begin();
		em.persist(creditcardPayment);
		em.getTransaction().commit();
	}

	public static void insertPatient(EntityManager em) {
		Patient p = new Patient();
		p.setInsured("DELTA OSIGURANJE");
		p.setFirstName("PACIJENT IME");
		p.setLastName("PACIJENT LAST NAME");
		p.setAddress(new Address("PacijentoGrad", "PatientLand", "PatientStreet"));
		PersonRepository personRepository = new PersonRepository(em);
		personRepository.insertPerson(p);
		

	}
	/*
	 * public static void insertEditedPerson(EntityManager em) { Address address =
	 * new Address("NBG", "SERBIA", "Street"); }
	 */
	/*
	 * public static void insertGeneratedPerson(EntityManager em) { Address address
	 * = new Address("NBG", "SERBIA", "NEKA ULICA"); Person person = new Person();
	 * person.setType("NEKI TIP PERSONE"); person.setLastName("PREZIMENKOVIC");
	 * person.setFirstName("IMENKO"); person.setAcredited("akreditovan");
	 * person.setInsured("jeste osiguran, ne smaraj"); person.setAddress(address);
	 * PersonRepository personRepository = new PersonRepository(em);
	 * personRepository.insertPerson(person);
	 * 
	 * }
	 */

	/*
	 * public static void insertgeneratedPerson(EntityManager em) { PersonRepository
	 * personRepository = new PersonRepository(em); Person person = new Person();
	 * person.setFirstName("Mika"); person.setLastName("Mikic");
	 * person.setInsured("DELTA"); person.setAcredited("YesAcreddited");
	 * person.setCity("Belgrad"); person.setCountry("Serbia");
	 * person.setType("neki tip test"); person.setStreet("Ulica1");
	 * personRepository.insertPerson(person); }
	 */

	public static void batchProcessing(EntityManager em) {
		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		try {// try catch be trebalo staviit u fon loop tako da kad pukne rollbackuje samo
				// trenutnu iteraciju a ne sve da prestane, i spolja staviti jos jedan
				// try/finally
				// za transaction.commit() da bi se zavrsilo u ubacilo poslednje i zatvorilo

			/*
			 * Prvih 50 Persona ubaci, delimo batch na manje delove tako da kad failuje ne
			 * zakaze sve nego samo manji paket koji ubacimo. Ako imamo 10 000 upisa,
			 */
			for (int i = 0; i < 1000; i++) {
				if (i > 0 && i % 50 == 0) {
					em.flush();// puni
					em.clear();// cisti da bi mogao da puni ponovo
					transaction.commit();
					transaction.begin();
				}
				Address address = new Address("NBG", "SERBIA", "NEKA ULICA" + i);
				Person person = new Person();
				// person.setType("NEKI TIP PERSONE" + i);
				person.setLastName("PREZIMENKOVIC" + i);
				person.setFirstName("IMENKO" + i);
				// person.setAcredited("akreditovan");
				// person.setInsured("jeste osiguran, ne smaraj");
				person.setAddress(address);
				em.persist(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			transaction.commit();
		}
	}

}
