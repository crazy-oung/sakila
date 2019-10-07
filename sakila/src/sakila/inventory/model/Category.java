package sakila.inventory.model;

public class Category {
	private int categoryId;
	private String name;
	private String lastUpdate;
	public int getCategory_id() {
		return categoryId;
	}
	public void setCategory_id(int category_id) {
		this.categoryId = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_update() {
		return lastUpdate;
	}
	public void setLast_update(String last_update) {
		this.lastUpdate = last_update;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + categoryId + ", name=" + name + ", last_update=" + lastUpdate + "]";
	}
	
	
}
