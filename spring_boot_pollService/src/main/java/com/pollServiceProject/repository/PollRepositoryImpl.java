package com.pollServiceProject.repository;

import com.pollServiceProject.model.PollQuestion;
import com.pollServiceProject.repository.mapper.PollMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PollRepositoryImpl implements PollRepository {

    private static final String POLL_TABLE_NAME = "poll_question_table";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Long createPoll(PollQuestion pollQuestion) {
        String sql = "INSERT INTO " + POLL_TABLE_NAME + " (title, first_answer, second_answer, third_answer, fourth_answer ) values (?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                pollQuestion.getTitle(),
                pollQuestion.getFirstAnswer(),
                pollQuestion.getSecondAnswer(),
                pollQuestion.getThirdAnswer(),
                pollQuestion.getFourthAnswer()

        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updatePoll(PollQuestion pollQuestion) {
        String sql = "UPDATE " + POLL_TABLE_NAME + " SET title=?, first_answer=?, second_answer=?, third_answer=?, fourth_answer=? WHERE question_id=?";
        jdbcTemplate.update(
                sql,
                pollQuestion.getTitle(),
                pollQuestion.getFirstAnswer(),
                pollQuestion.getSecondAnswer(),
                pollQuestion.getThirdAnswer(),
                pollQuestion.getFourthAnswer(),
                pollQuestion.getQuestionId()
        );
    }

    @Override
    public void deletePollById(Long id) {
        String sql = "DELETE " + POLL_TABLE_NAME + " WHERE question_id=?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public PollQuestion getPollById(Long id) {
        String sql = "SELECT * FROM " + POLL_TABLE_NAME + " WHERE question_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PollMapper());
    }

    @Override
    public String getQuestionTitleById(Long id) {
        String sql = "SELECT title FROM " + POLL_TABLE_NAME + " WHERE question_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
    }


}
