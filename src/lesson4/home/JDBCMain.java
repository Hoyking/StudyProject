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
        /*Rubric rubric1 = new Rubric("Rubric 1");
        Rubric rubric1_1 = new Rubric("Rubric 1.1");
        rubric1.addSubrubric(rubric1_1);

        *//*News news1 = new News(1, "News 1", "These are news 1", rubric1);
        portalDAO.addNews(news1);*//*

        Author steve = new Author(1, "Steve", "Stevenson");
        *//*Author peter = new Author(2, "Peter", "Peterson");
        Author john = new Author(3, "John", "Johnson");

        portalDAO.addAuthor(steve);
        portalDAO.addAuthor(peter);
        portalDAO.addAuthor(john);*//*

        Review review = new Review(1, "Review 1", "This is review 1", rubric1, 5, steve);
        //portalDAO.addReview(review);

        News news2 = new News(2, "News 2", "These are news 2 about something", rubric1_1);
        news2.addLink(review);
        news2.addNewsTag(new NewsTag("Two"));
        news2.addNewsTag(new NewsTag("Smth"));
        portalDAO.addNews(news2);*/

        /*News news3 = new News(3, "News 3", "These are special news", new Rubric("Rubric 1.2"));
        news3.addNewsTag(new NewsTag("special"));
        portalDAO.addNews(news3);*/


        printMap(portalMethodsDAO.newsRubricsCapacity());
    }

    private void printMap(Map<String, Integer> map) {
        map.forEach((key, value) -> System.out.println("Rubric: " + key + ", news number: " + value));
    }

}
