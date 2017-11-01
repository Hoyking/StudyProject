package lesson4.home;

import lesson4.home.dao.DefaultPortalDAO;
import lesson4.home.dao.PortalDAO;
import lesson4.home.entity.Author;
import lesson4.home.entity.News;
import lesson4.home.entity.Review;
import lesson4.home.entity.Rubric;

public class JDBCMain {

    private PortalDAO portalDAO = DefaultPortalDAO.getInstance();

    public void main() {
        Rubric rubric1 = new Rubric("Rubric 1");
        Rubric rubric1_1 = new Rubric("Rubric 1.1");
        rubric1.addSubrubric(rubric1_1);

        News news = new News(1, "News 1", "These are news 1", rubric1);
        portalDAO.addNews(news);

        Author steve = new Author(1, "Steve", "Stevenson");
        Author peter = new Author(2, "Peter", "Peterson");
        Author john = new Author(3, "John", "Johnson");

        portalDAO.addAuthor(steve);
        portalDAO.addAuthor(peter);
        portalDAO.addAuthor(john);

        Review review = new Review(1, "Review 1", "This is review 1", rubric1, 5, steve);
        portalDAO.addReview(review);
    }

}
