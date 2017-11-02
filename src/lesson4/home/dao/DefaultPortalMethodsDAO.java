package lesson4.home.dao;

import lesson4.home.connection.ConnectionDB;
import lesson4.home.entity.NewsTag;
import lesson4.home.entity.ReviewTag;
import lesson4.home.exception.NotSubRubricException;
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
    private final String GET_SUBRUBRICS = "SELECT subrubricName FROM rubrics WHERE subrubricName = ?";
    private final String RENAME_NEWS_RUBRIC = "UPDATE news SET newsRubric = ? WHERE newsRubric = ?";
    private final String GET_NEWS_TAGS = "SELECT tag FROM news_tags WHERE newsId = ?";
    private final String GET_REVIEW_TAGS = "SELECT tag FROM reviews_tags";
    private final String GET_MOST_FAMOUS_REVIEW_TAG =
            "SELECT tag, count(*) c FROM reviews_tags GROUP BY tag ORDER BY c DESC LIMIT 1";

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
    public void replaceNews(String originalRubric, String targetRubric) throws NotSubRubricException {
        if(!checkForSubrubric(originalRubric)) {
            throw new NotSubRubricException("Some rubric is not subrubric");
        }
        if(!checkForSubrubric(targetRubric)) {
            throw new NotSubRubricException("Some rubric is not subrubric");
        }

        try (
                Connection connection = connectionDB.getConnection();
                PreparedStatement preparedStatement = Statements.createRenameRubricStatement(connection,
                        RENAME_NEWS_RUBRIC, originalRubric, targetRubric)
        ){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean checkForSubrubric(String name) {
        boolean check = false;
        try (
                Connection connection = connectionDB.getConnection();
                PreparedStatement preparedStatement = Statements.createSubrubricStatement(connection,
                        GET_SUBRUBRICS, name);
                ResultSet resultSet = preparedStatement.executeQuery()
        ){
            if(resultSet.next()) {
                check = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public List<NewsTag> getTagsOfNews(long newsId) {
        List<NewsTag> tags = new ArrayList<>();
        try (
                Connection connection = connectionDB.getConnection();
                PreparedStatement preparedStatement = Statements.createNewsTagsStatement(connection,
                        GET_NEWS_TAGS, newsId);
                ResultSet resultSet = preparedStatement.executeQuery()
        ){
            while (resultSet.next()) {
                NewsTag newsTag = new NewsTag(resultSet.getString(1));
                tags.add(newsTag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tags;
    }

    @Override
    public ReviewTag getMostFamousTag() {
        ReviewTag tag = null;
        try (
                Connection connection = connectionDB.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(GET_MOST_FAMOUS_REVIEW_TAG)
        ){
            if(resultSet.next()) {
                tag = new ReviewTag(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tag;
    }

    private static class Holder {
        private final static PortalMethodsDAO INSTANCE = new DefaultPortalMethodsDAO();
    }

    public static PortalMethodsDAO getInstance() {
        return Holder.INSTANCE;
    }

}
