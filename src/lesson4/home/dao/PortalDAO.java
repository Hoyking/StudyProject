package lesson4.home.dao;

import lesson4.home.entity.Author;
import lesson4.home.entity.News;
import lesson4.home.entity.Review;
import lesson4.home.entity.Rubric;

import java.util.List;

public interface PortalDAO {

    List<News> getNewsList();

    void addNews(News news);

    void removeNews(News news);

    void addReview(Review review);

    void removeReview(Review review);

    void addRubric(Rubric rubric);

    void refreshRubric(Rubric rubric);

    void addAuthor(Author author);
}
