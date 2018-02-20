package repositories;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the check_payment database table.
 * 
 */
@Entity(name = "check_payment")
@NamedQuery(name="CheckPayment.findAll", query="SELECT c FROM check_payment c")
public class CheckPayment extends Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_payment")
	private int idPayment;

	@Column(name="check_number")
	private int checkNumber;

	//bi-directional one-to-one association to Payment
	@OneToOne
	@JoinColumn(name="id_payment")
	private Payment payment;

	public CheckPayment() {
	}

	public int getIdPayment() {
		return this.idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public int getCheckNumber() {
		return this.checkNumber;
	}

	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}