package lesson4.home;

import lesson4.home.dao.DefaultPortalDAO;
import lesson4.home.dao.DefaultPortalMethodsDAO;
import lesson4.home.dao.PortalDAO;
import lesson4.home.dao.PortalMethodsDAO;
import lesson4.home.entity.*;

import java.util.Map;

public class JDBCMain {

    private PortalDAO portalDAO = DefaultPortalDAO.getInstance();
    private PortalMethodsDAO portalMethodsDAO = DefaultPortalMethodsDAO.getInstance();

    public void main() {
        News news3 = new News(3, "News 3", "These are special news", new Rubric("Rubric 1.2"));
        news3.addNewsTag(new NewsTag("special"));
        //portalDAO.addNews(news3);

        Rubric rubric1 = new Rubric("Rubric 1");
        Rubric rubric1_1 = new Rubric("Rubric 1.1");
        rubric1.addSubrubric(rubric1_1);

        Author steve = new Author(1, "Steve", "Stevenson");
        Author peter = new Author(2, "Peter", "Peterson");
        Author john = new Author(3, "John", "Johnson");

        Review review = new Review(2, "Review of a video game", "This is a review of a video game",
                rubric1_1, 5, john);
        review.addReviewTag(new ReviewTag("game"));
        review.addReviewTag(new ReviewTag("video game"));
        //portalDAO.addReview(review);

        Review review1 = new Review(3, "Review of a red table", "This is a review of a red table",
                rubric1_1, 5, john);
        review1.addReviewTag(new ReviewTag("red"));
        review1.addReviewTag(new ReviewTag("table"));
        review1.addLink(news3);
        //portalDAO.addReview(review1);

        Review review2 = new Review(4, "Review of smth", "This is a review of a red table",
                rubric1, 6, peter);
        review2.addReviewTag(new ReviewTag("smth"));
        review2.addLink(news3);
        //portalDAO.addReview(review2);

        //printMap(portalMethodsDAO.newsRubricsCapacity());
        System.out.println("Number of unlinked reviews: " + portalMethodsDAO.unlinkedReviewsNum());
    }

    private void printMap(Map<String, Integer> map) {
        map.forEach((key, value) -> System.out.println("Rubric: " + key + ", news number: " + value));
    }

}
