package lesson4.home.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Review {

    private String name;
    private String text;
    private Rubric rubric;
    private List<ReviewTag> reviewTags;
    private List<News> links;
    private int score;
    private Author author;

    public Review() {
        reviewTags = new ArrayList<>();
        links = new ArrayList<>();
    }

    public Review(String name, String text, Rubric rubric, int score, Author author) {
        this.name = name;
        this.text = text;
        this.rubric = rubric;
        this.score = score;
        this.author = author;
        reviewTags = new ArrayList<>();
        links = new ArrayList<>();
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

    public List<ReviewTag> getReviewTags() {
        return reviewTags;
    }

    public void addNewsTag(ReviewTag reviewTag) {
        reviewTags.add(reviewTag);
    }

    public void removeNewsTag(ReviewTag reviewTag) {
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
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
        return score == review.score &&
                Objects.equals(name, review.name) &&
                Objects.equals(text, review.text) &&
                Objects.equals(rubric, review.rubric) &&
                Objects.equals(author, review.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, text, rubric, score, author);
    }

}
