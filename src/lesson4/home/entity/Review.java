package lesson4.home.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Review {

    private long id;
    private String name;
    private String content;
    private Rubric rubric;
    private List<ReviewTag> reviewTags;
    private List<News> links;
    private double score;
    private Author author;

    public Review() {
        reviewTags = new ArrayList<>();
        links = new ArrayList<>();
    }

    public Review(long id, String name, String content, Rubric rubric, double score, Author author) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.rubric = rubric;
        this.score = score;
        this.author = author;
        reviewTags = new ArrayList<>();
        links = new ArrayList<>();
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

    public List<ReviewTag> getReviewTags() {
        return reviewTags;
    }

    public void addReviewTag(ReviewTag reviewTag) {
        reviewTags.add(reviewTag);
    }

    public void removeReviewTag(ReviewTag reviewTag) {
        reviewTags.add(reviewTag);
    }

    public List<News> getLinks() {
        return links;
    }

    public void addLink(News news) {
        links.add(news);
    }

    public void removeLink(News news) {
        links.add(news);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id &&
                score == review.score &&
                Objects.equals(name, review.name) &&
                Objects.equals(content, review.content) &&
                Objects.equals(rubric, review.rubric) &&
                Objects.equals(author, review.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, rubric, score, author);
    }

}
