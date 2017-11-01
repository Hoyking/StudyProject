package lesson4.home.dao;

import lesson4.home.connection.ConnectionDB;
import lesson4.home.entity.NewsTag;
import lesson4.home.entity.ReviewTag;
import lesson4.home.util.Statements;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultPortalMethodsDAO implements PortalMethodsDAO {

    private final String GET_RUBRICS = "SELECT rubricName, subrubricName FROM rubrics";
    private final String GET_NEWS_RUBRICS = "SELECT newsRubric FROM news";
    private final String GET_REVIEWS_ID = "SELECT id FROM reviews";
    private final String GET_REVIEW_LINKS = "SELECT newsId FROM review_links WHERE reviewId = ?";
    private final String GET_NEWS_LINKS = "SELECT reviewId FROM news_links WHERE newsId = ?";
    private final String GET_NEWS = "SELECT * FROM news";

    private ConnectionDB connectionDB = ConnectionDB.getInstance();

    @Override
    public Map<String, Integer> newsRubricsCapacity() {
        Map<String, Integer> map = null;
        try (
                Connection connection = connectionDB.getConnection();
                Statement newsStatement = connection.createStatement();
                ResultSet newsResultSet = newsStatement.executeQuery(GET_NEWS_RUBRICS);
                Statement subrubricsStatement = connection.createStatement();
                ResultSet subrubricsResultSet = subrubricsStatement.executeQuery(GET_RUBRICS)
        ){
            map = new HashMap<>();

            while (newsResultSet.next()) {
                String rubricName = newsResultSet.getString(1);
                if(map.containsKey(rubricName)) {
                    map.put(rubricName, map.get(rubricName) + 1);
                } else {
                    map.put(rubricName, 1);
                }
            }

            while (subrubricsResultSet.next()) {
                String rubric = subrubricsResultSet.getString(1);
                String subrubric = subrubricsResultSet.getString(2);
                if(subrubric != null) {
                    map.put(rubric, map.get(rubric) + map.get(subrubric));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public int unlinkedReviewsNum() {
        int unlinkedReviewsNum = 0;
        try (
                Connection connection = connectionDB.getConnection();
                Statement reviewsStatement = connection.createStatement();
                ResultSet reviewsResultSet = reviewsStatement.executeQuery(GET_REVIEWS_ID)
        ){
            while (reviewsResultSet.next()) {
                if(getLinksNumOfReview(reviewsResultSet.getLong(1)) == 0) {
                    unlinkedReviewsNum++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unlinkedReviewsNum;
    }

    private int getLinksNumOfReview(long id) {
        int num = 0;
        try (
                Connection connection = connectionDB.getConnection();
                PreparedStatement reviewsStatement = Statements.createLinksStatement(connection,
                        GET_REVIEW_LINKS, id);
                ResultSet reviewResultSet = reviewsStatement.executeQuery()
        ){
            while(reviewResultSet.next()) {
                num++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public List<String> newsWithMoreThenTwoLinks() {
        List<String> headers = new ArrayList<>();
        try (
                Connection connection = connectionDB.getConnection();
                Statement newsStatement = connection.createStatement();
                ResultSet newsResultSet = newsStatement.executeQuery(GET_NEWS)
        ){
            while (newsResultSet.next()) {
                if(getLinksNumOfNews(newsResultSet.getLong(1)) >= 2) {
                    headers.add(newsResultSet.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return headers;
    }

    private int getLinksNumOfNews(long id) {
        int num = 0;
        try (
                Connection connection = connectionDB.getConnection();
                PreparedStatement reviewsStatement = Statements.createLinksStatement(connection,
                        GET_NEWS_LINKS, id);
                ResultSet reviewResultSet = reviewsStatement.executeQuery()
        ){
            while(reviewResultSet.next()) {
                num++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public void removeRubric(String rubricName) {

    }

    @Override
    public void replaceReviews(String subrubricName1, String subrubricName2) {

    }

    @Override
    public List<NewsTag> getTagsOfNews(long newsId) {
        return null;
    }

    @Override
    public ReviewTag getMostFamousTag() {
        return null;
    }

    private static class Holder {
        private final static PortalMethodsDAO INSTANCE = new DefaultPortalMethodsDAO();
    }

    public static PortalMethodsDAO getInstance() {
        return Holder.INSTANCE;
    }

}
