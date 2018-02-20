package repositories;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	/*Kada imamo vise od jedne kolone koja sadrzi kljuc i onda smo napravili kompozitni kljuc.*/
	@EmbeddedId
	private StudentPK id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	public Student() {
	}

	public StudentPK getId() {
		return this.id;
	}

	public void setId(StudentPK id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}