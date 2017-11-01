package lesson4.home.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class News {

    private long id;
    private String name;
    private String content;
    private Rubric rubric;
    private List<NewsTag> newsTags;
    private List<Review> links;

    public News() {
        newsTags = new ArrayList<>();
        links = new ArrayList<>();
    }

    public News(long id, String name, String content, Rubric rubric) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.rubric = rubric;
        newsTags = new ArrayList<NewsTag>();
        links = new ArrayList<Review>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return id == news.id &&
                Objects.equals(name, news.name) &&
                Objects.equals(content, news.content) &&
                Objects.equals(rubric, news.rubric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, rubric);
    }

}
