package lesson4.home.dao;

import lesson4.home.connection.ConnectionDB;
import lesson4.home.entity.NewsTag;
import lesson4.home.entity.ReviewTag;
import lesson4.home.util.Statements;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultPortalMethodsDAO implements PortalMethodsDAO {

    private final String GET_RUBRICS = "SELECT rubricName, subrubricName FROM rubrics";
    private final String GET_NEWS_RUBRICS = "SELECT newsRubric FROM news";

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

            while(newsResultSet.next()) {
                String rubricName = newsResultSet.getString(1);
                if(map.containsKey(rubricName)) {
                    map.put(rubricName, map.get(rubricName) + 1);
                } else {
                    map.put(rubricName, 1);
                }
            }

            while(subrubricsResultSet.next()) {
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
        return 0;
    }

    @Override
    public List<String> newsWithMoreThenTwoLinks() {
        return null;
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
