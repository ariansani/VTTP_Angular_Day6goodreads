package vttpnusiss.day36.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class BookDetails {

    private String bookId;
    private String title;
    private String author;
    private String description;
    private Integer pages;
    private Double rating;
    private String image;
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPages() {
        return pages;
    }
    public void setPages(Integer pages) {
        this.pages = pages;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public static BookDetails create(SqlRowSet rs){
        BookDetails b = new BookDetails();
        b.setBookId(rs.getString("book_id"));
        b.setDescription(rs.getString("description"));
        b.setImage(rs.getString("image_url"));
        b.setRating(rs.getDouble("rating"));
        b.setTitle(rs.getString("title"));
        b.setPages(rs.getInt("pages"));
        b.setAuthor(rs.getString("authors"));
        return b;
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
        .add("bookId", bookId)
        .add("title", title)
        .add("rating", rating)
        .add("pages", pages)
        .add("authors", author)
        .add("image", image)
        .add("description", description)
        .build();
    }

}
