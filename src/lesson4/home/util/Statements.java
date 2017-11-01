package lesson4.home.util;

import lesson4.home.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Statements {

    public static PreparedStatement createNewsStatement(Connection connection, String sql, News news) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, news.getId());
            preparedStatement.setString(2, news.getName());
            preparedStatement.setString(3, news.getContent());
            preparedStatement.setString(4, news.getRubric().getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement createRubricStatement(Connection connection, String sql, Rubric rubric) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rubric.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement createRubricStatement(Connection connection, String sql, Rubric rubric, int subrubricId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rubric.getName());
            preparedStatement.setString(2, rubric.getSubrubrics().get(subrubricId).getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement createNullSubrubricStatement(Connection connection, String sql, Rubric rubric) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rubric.getName());
            preparedStatement.setString(2, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement createDelRubricStatement(Connection connection, String sql, Rubric rubric) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rubric.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement createReviewStatement(Connection connection, String sql, Review review) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, review.getId());
            preparedStatement.setString(2, review.getName());
            preparedStatement.setString(3, review.getContent());
            preparedStatement.setDouble(4, review.getScore());
            preparedStatement.setDouble(5, review.getAuthor().getId());
            preparedStatement.setString(6, review.getRubric().getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement createAuthorStatement(Connection connection, String sql, Author author) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, author.getId());
            preparedStatement.setString(2, author.getName());
            preparedStatement.setString(3, author.getSurname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement createTagStatement(Connection connection, String sql, long id, String tagName) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, tagName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement createLinkStatement(Connection connection, String sql, long id1, long id2) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id1);
            preparedStatement.setLong(2, id2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement createReviewLinksStatement(Connection connection, String sql, long reviewId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, reviewId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }



}
