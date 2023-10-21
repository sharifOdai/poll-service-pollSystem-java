package com.pollServiceProject.repository.mapper;

import com.pollServiceProject.model.PollQuestion;
import org.apache.tomcat.jni.Poll;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component

public class PollMapper implements RowMapper<PollQuestion> {
    @Override
    public PollQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long questionId = rs.getLong("question_id");
        String title = rs.getString("title");
        String firstAnswer = rs.getString("first_answer");
        String secondAnswer = rs.getString("second_answer");
        String thirdAnswer = rs.getString("third_answer");
        String fourthAnswer = rs.getString("fourth_answer");

        PollQuestion pollQuestion = new PollQuestion(questionId, title, firstAnswer,
                secondAnswer, thirdAnswer, fourthAnswer);

        return pollQuestion;
    }
}
