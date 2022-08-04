package Sprint2.Objects;

public class News {
    Long  id;
    String title;
    String short_content;
    String content;
    String date;
    String picture_url;
    Languages languages;
    Publications publications;

    public News (){}

    public News(Long id, String title, String short_content, String content, String date, String picture_url, Languages languages, Publications publications) {
        this.id = id;
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.date = date;
        this.picture_url = picture_url;
        this.languages = languages;
        this.publications = publications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_content() {
        return short_content;
    }

    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public Languages getLanguages() {
        return languages;
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }

    public Publications getPublications() {
        return publications;
    }

    public void setPublications(Publications publications) {
        this.publications = publications;
    }
}