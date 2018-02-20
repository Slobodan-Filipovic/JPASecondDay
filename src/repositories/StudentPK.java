package repositories;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the student database table.
 * 
 */
@Embeddable
public class StudentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int year;

	private int number;

	public StudentPK() {
	}
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getNumber() {
		return this.number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StudentPK)) {
			return false;
		}
		StudentPK castOther = (StudentPK)other;
		return 
			(this.year == castOther.year)
			&& (this.number == castOther.number);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.year;
		hash = hash * prime + this.number;
		
		return hash;
	}
}