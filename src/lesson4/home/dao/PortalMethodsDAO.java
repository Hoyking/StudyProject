package lesson4.home.dao;

import lesson4.home.entity.NewsTag;
import lesson4.home.entity.ReviewTag;
import lesson4.home.exception.NotSubRubricException;

import java.util.List;
import java.util.Map;

public interface PortalMethodsDAO {

    Map<String, Integer> newsRubricsCapacity();

    int unlinkedReviewsNum();

    List<String> newsWithMoreThenTwoLinks();

    void removeRubric(String rubricName);

    void replaceNews(String originalRubric, String targetRubric) throws NotSubRubricException;

    List<NewsTag> getTagsOfNews(long newsId);

    ReviewTag getMostFamousTag();

}
