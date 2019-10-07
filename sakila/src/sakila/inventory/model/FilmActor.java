package sakila.inventory.model;

public class FilmActor {
	private Actor actor;
	private Film film;
	private String lastUpdate;
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public String getLast_update() {
		return lastUpdate;
	}
	public void setLast_update(String last_update) {
		this.lastUpdate = last_update;
	}
	@Override
	public String toString() {
		return "FilmActor [actor=" + actor + ", film=" + film + ", last_update=" + lastUpdate + "]";
	}
	
}
