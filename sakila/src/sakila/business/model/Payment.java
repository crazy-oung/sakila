package sakila.business.model;

import sakila.customer.model.Customer;

public class Payment {
	private String paymentId;
	private Customer customer;
	private Staff staff;
	private Rental rental;
	private double amount;
	private String entDate;
	private String lastUpdate;
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Rental getRental() {
		return rental;
	}
	public void setRental(Rental rental) {
		this.rental = rental;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getEntDate() {
		return entDate;
	}
	public void setEntDate(String entDate) {
		this.entDate = entDate;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", customer=" + customer + ", staff=" + staff + ", rental=" + rental
				+ ", amount=" + amount + ", entDate=" + entDate + ", lastUpdate=" + lastUpdate + "]";
	}
		
}
