package repositories;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the credit_card_payment database table.
 * 
 */
@Entity(name="credit_card_payment")
@NamedQuery(name="CreditCardPayment.findAll", query="SELECT c FROM credit_card_payment c")
public class CreditCardPayment extends Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_payment")
	private int idPayment;

	private String account;

	//bi-directional one-to-one association to Payment
	@OneToOne
	@JoinColumn(name="id_payment")
	private Payment payment;

	public CreditCardPayment() {
	}

	public int getIdPayment() {
		return this.idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}


	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount() {
		return this.account;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}