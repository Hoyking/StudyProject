package lesson4.home.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class News {

    private String name;
    private String text;
    private Rubric rubric;
    private List<NewsTag> newsTags;
    private List<Review> links;

    public News() {
        newsTags = new ArrayList<>();
        links = new ArrayList<>();
    }

    public News(String name, String text, Rubric rubric) {
        this.name = name;
        this.text = text;
        this.rubric = rubric;
        newsTags = new ArrayList<NewsTag>();
        links = new ArrayList<Review>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Rubric getRubric() {
        return rubric;
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }

    public List<NewsTag> getNewsTags() {
        return newsTags;
    }

    public void addNewsTag(NewsTag newsTag) {
        newsTags.add(newsTag);
    }

    public void removeNewsTag(NewsTag newsTag) {
        newsTags.remove(newsTag);
    }

    public List<Review> getLinks() {
        return links;
    }

    public void addLink(Review review) {
        links.add(review);
    }

    public void removeLink(Review review) {
        newsTags.remove(review);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(name, news.name) &&
                Objects.equals(text, news.text) &&
                Objects.equals(rubric, news.rubric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, text, rubric);
    }

}
