package repositories;

import java.io.Serializable;
import javax.persistence.*;

import model.Address;

/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Person implements Serializable {
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_person")
	private int idPerson;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private Address address;
	/*@Column(name = "type", insertable = false, updatable = false)
	private String type;*/

	 

	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person() {
	}

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	/*
	 * public String getAcredited() { return this.acredited; }
	 * 
	 * public void setAcredited(String acredited) { this.acredited = acredited; }
	 */

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/*
	 * public String getInsured() { return this.insured; }
	 * 
	 * public void setInsured(String insured) { this.insured = insured; }
	 */

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * public String getType() { return this.type; }
	 * 
	 * public void setType(String type) { this.type = type; }
	 */

}