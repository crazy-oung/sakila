package sakila.inventory.model;

public class FilmText {
	private String filmId;
	private String title;
	private String description;
	
	public String getFilmId() {
		return filmId;
	}
	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "FilmText [filmId=" + filmId + ", title=" + title + ", description=" + description + "]";
	}
}
