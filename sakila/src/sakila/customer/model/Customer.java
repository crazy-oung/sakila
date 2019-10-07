package sakila.customer.model;

public class Customer {
	private String customerId;
	private String storeId;
	private String firstName;
	private String lastName;
	private String email;
	private String addressId;
	private String active;
	private String createDate;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", store_id=" + storeId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", addressId="
				+ addressId + ", active=" + active + ", createDate=" + createDate + ", last_update=" + last_update
				+ "]";
	}

	public String getStore_id() {
		return storeId;
	}
	public void setStore_id(String store_id) {
		this.storeId = store_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	private String last_update;
}
