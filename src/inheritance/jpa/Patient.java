package inheritance.jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import repositories.Person;

@Entity
@DiscriminatorValue(value = "patient")
public class Patient extends Person{
	private String insured;

	public String getInsured() {
		return insured;
	}

	public void setInsured(String insured) {
		this.insured = insured;
	}
	
	

}
