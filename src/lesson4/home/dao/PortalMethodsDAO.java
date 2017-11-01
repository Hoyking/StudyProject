package lesson4.home.dao;

import lesson4.home.entity.NewsTag;
import lesson4.home.entity.ReviewTag;

import java.util.List;
import java.util.Map;

public interface PortalMethodsDAO {

    Map<String, Integer> newsRubricsCapacity();

    int unlinkedReviewsNum();

    List<String> newsWithMoreThenTwoLinks();

    void removeRubric(String rubricName);

    void replaceReviews(String subrubricName1, String subrubricName2);

    List<NewsTag> getTagsOfNews(long newsId);

    ReviewTag getMostFamousTag();

}
