package inheritance.jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import repositories.Person;

@Entity
@DiscriminatorValue(value = "doctor")
public class Doctor extends Person{
	
	private String acredited;

	public String getAcredited() {
		return acredited;
	}

	public void setAcredited(String acredited) {
		this.acredited = acredited;
	}
	

}
