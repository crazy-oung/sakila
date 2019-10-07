package sakila.inventory.model;

public class FilmCategory {
	private Actor actor;
	private Category category;
	private String lastUpdate;
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getLast_update() {
		return lastUpdate;
	}
	public void setLast_update(String last_update) {
		this.lastUpdate = last_update;
	}
	@Override
	public String toString() {
		return "FilmCategory [actor=" + actor + ", category=" + category + ", last_update=" + lastUpdate + "]";
	}
}
