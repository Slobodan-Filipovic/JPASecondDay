package repositories;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity//Ignore the error it works with it, its some eclipse bug or issue that I can not figure out for the life of me.
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_payment")
	private int idPayment;

	private int amount;

	//bi-directional one-to-one association to CheckPayment
	@OneToOne(mappedBy="payment")
	private CheckPayment checkPayment;

	//bi-directional one-to-one association to CreditCardPayment
	@OneToOne(mappedBy="payment")
	private CreditCardPayment creditCardPayment;

	public Payment() {
	}

	public int getIdPayment() {
		return this.idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public CheckPayment getCheckPayment() {
		return this.checkPayment;
	}

	public void setCheckPayment(CheckPayment checkPayment) {
		this.checkPayment = checkPayment;
	}

	public CreditCardPayment getCreditCardPayment() {
		return this.creditCardPayment;
	}

	public void setCreditCardPayment(CreditCardPayment creditCardPayment) {
		this.creditCardPayment = creditCardPayment;
	}

}