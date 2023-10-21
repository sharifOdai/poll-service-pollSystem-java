package com.pollServiceProject.repository.mapper;

import com.pollServiceProject.model.UserAnswer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserAnswerMapper implements RowMapper<UserAnswer> {


    @Override
    public UserAnswer mapRow(ResultSet rs, int rowNum) throws SQLException {

        UserAnswer userAnswer = new UserAnswer(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("question_id"),
                rs.getString("question_title"),
                rs.getString("answer")
        );

        return userAnswer;
    }
}
