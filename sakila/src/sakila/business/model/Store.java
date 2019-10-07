package sakila.business.model;

import sakila.customer.model.Address;

public class Store {
	private String StoreId;
	private Staff staff;
	private Address address;
	private String lastUpdate;
	public String getStoreId() {
		return StoreId;
	}
	public void setStoreId(String storeId) {
		StoreId = storeId;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "Store [StoreId=" + StoreId + ", staff=" + staff + ", address=" + address + ", lastUpdate=" + lastUpdate
				+ "]";
	}
	
}
