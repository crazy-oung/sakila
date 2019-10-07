package sakila.inventory.model;

public class Film {
	private Language language;
	private Film film;
	private String title;
	private String description;
	private String releaseYear;
	private int originalLanguageId;
	private int rentalDuration;
	private int length;
	private double rentalRate;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private String lastUpdate;
	@Override
	public String toString() {
		return "Film [language=" + language + ", film=" + film + ", title=" + title + ", description=" + description
				+ ", releaseYear=" + releaseYear + ", originalLanguage_id=" + originalLanguageId + ", rentalDuration="
				+ rentalDuration + ", length=" + length + ", rentalRate=" + rentalRate + ", replacementCost="
				+ replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures + ", lastUpdate="
				+ lastUpdate + "]";
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
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
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getOriginalLanguage_id() {
		return originalLanguageId;
	}
	public void setOriginalLanguage_id(int originalLanguage_id) {
		this.originalLanguageId = originalLanguage_id;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
