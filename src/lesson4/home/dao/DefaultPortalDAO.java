package lesson4.home.dao;

import lesson4.home.connection.ConnectionDB;
import lesson4.home.entity.*;
import lesson4.home.util.Statements;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultPortalDAO implements PortalDAO {

    private final String GET_NEWS = "SELECT * FROM news";
    private final String ADD_NEWS = "INSERT INTO news (id, name, content, newsRubric) VALUES (?, ?, ?, ?)";
    private final String ADD_REVIEW = "INSERT INTO reviews (id, name, content, score, authorId, reviewRubric)" +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private final String GET_RUBRIC = "SELECT rubricName, subrubricName FROM rubrics WHERE rubricName = ?";
    private final String INSERT_RUBRIC = "INSERT INTO rubrics (rubricName, subrubricName) VALUES (?, ?)";
    private final String DELETE_RUBRIC = "DELETE FROM rubrics WHERE rubricName = ?";
    private final String ADD_AUTHOR = "INSERT INTO authors (id, name, surname) VALUES (?, ?, ?)";
    private final String ADD_NEWS_TAG = "INSERT INTO news_tags (newsId, tag) VALUES (?, ?)";
    private final String ADD_NEWS_LINK = "INSERT INTO news_links (newsId, reviewId) VALUES (?, ?)";
    private final String ADD_REVIEW_TAG = "INSERT INTO review_tags (reviewId, tag) VALUES (?, ?)";
    private final String ADD_REVIEW_LINK = "INSERT INTO review_links (reviewId, newsId) VALUES (?, ?)";

    private ConnectionDB connectionDB = ConnectionDB.getInstance();

    private DefaultPortalDAO() {}

    @Override
    public List<News> getNewsList() {
        List<News> courseList = new ArrayList<>();
        try (
                Connection connection = connectionDB.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(GET_NEWS)
        ){
            while (resultSet.next()) {
                courseList.add(new News());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public void addNews(News news) {
        try (
                Connection connection = connectionDB.getConnection();
                PreparedStatement preparedStatement = Statements.createNewsStatement(connection, ADD_NEWS, news);
                PreparedStatement categoryPreparedStatement = Statements.createRubricStatement(connection,
                        GET_RUBRIC, news.getRubric());
                ResultSet rubricsResultSet = categoryPreparedStatement.executeQuery()
        ){
            preparedStatement.executeUpdate();
            addNewsTags(news);
            addNewsLinks(news);
            if(!rubricsResultSet.next()) {
                addRubric(news.getRubric());
            } else {
                refreshRubric(news.getRubric());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addNewsTags(News news) {
        for(NewsTag tag : news.getNewsTags()) {
            try (
                    Connection connection = connectionDB.getConnection();
                    PreparedStatement preparedStatement = Statements.createTagStatement(connection,
                            ADD_NEWS_TAG, news.getId(), tag.getName())
            ){
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addNewsLinks(News news) {
        for(Review link : news.getLinks()) {
            try (
                    Connection connection = connectionDB.getConnection();
                    PreparedStatement preparedStatement = Statements.createLinkStatement(connection,
                            ADD_NEWS_LINK, news.getId(), link.getId())
            ){
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removeNews(News news) {

    }

    @Override
    public void addReview(Review review) {
        try (
                Connection connection = connectionDB.getConnection();
                PreparedStatement preparedStatement = Statements.createReviewStatement(connection, ADD_REVIEW, review);
                PreparedStatement categoryPreparedStatement = Statements.createRubricStatement(connection,
                        GET_RUBRIC, review.getRubric());
                ResultSet rubricsResultSet = categoryPreparedStatement.executeQuery()
        ){
            preparedStatement.executeUpdate();
            if(!rubricsResultSet.next()) {
                addRubric(review.getRubric());
            } else {
                refreshRubric(review.getRubric());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addReviewTags(Review review) {
        for(ReviewTag tag : review.getReviewTags()) {
            try (
                    Connection connection = connectionDB.getConnection();
                    PreparedStatement preparedStatement = Statements.createTagStatement(connection,
                            ADD_REVIEW_TAG, review.getId(), tag.getName())
            ){
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addReviewLinks(Review review) {
        for(News link : review.getLinks()) {
            try (
                    Connection connection = connectionDB.getConnection();
                    PreparedStatement preparedStatement = Statements.createLinkStatement(connection,
                            ADD_REVIEW_LINK, review.getId(), link.getId())
            ){
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removeReview(Review review) {

    }

    @Override
    public void addRubric(Rubric rubric) {
        if(rubric.getSubrubrics().size() == 0) {
            try (
                    Connection connection = connectionDB.getConnection();
                    PreparedStatement preparedStatement = Statements.createNullSubrubricStatement(connection,
                            INSERT_RUBRIC, rubric)
            ){
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            for(int index = 0; index < rubric.getSubrubrics().size(); index++) {
                try (
                        Connection connection = connectionDB.getConnection();
                        PreparedStatement preparedStatement = Statements.createRubricStatement(connection,
                                INSERT_RUBRIC, rubric, index)
                ){
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void refreshRubric(Rubric rubric) {
        try (
                Connection connection = connectionDB.getConnection();
                PreparedStatement preparedStatement = Statements.createDelRubricStatement(connection,
                        DELETE_RUBRIC, rubric)
        ){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        addRubric(rubric);
    }

    @Override
    public void addAuthor(Author author) {
        try (
                Connection connection = connectionDB.getConnection();
                PreparedStatement preparedStatement = Statements.createAuthorStatement(connection,
                        ADD_AUTHOR, author)
        ){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class Holder {
        private final static PortalDAO INSTANCE = new DefaultPortalDAO();
    }

    public static PortalDAO getInstance() {
        return Holder.INSTANCE;
    }

}
