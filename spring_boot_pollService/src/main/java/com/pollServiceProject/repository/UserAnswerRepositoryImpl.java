package com.pollServiceProject.repository;

import com.pollServiceProject.model.UserAnswer;
import com.pollServiceProject.repository.mapper.UserAnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserAnswerRepositoryImpl implements UserAnswerRepository {

    private static final String USER_ANSWER_TABLE = "user_answer_table";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createUserAnswer(UserAnswer userAnswer) {

        String sql = "INSERT INTO " + USER_ANSWER_TABLE + " (user_id, question_id, question_title, answer) values (?,?,?,?)";
        jdbcTemplate.update(
                sql,
                userAnswer.getUserId(),
                userAnswer.getQuestionId(),
                userAnswer.getQuestionTitle(),
                userAnswer.getAnswer()
        );

    }

    @Override
    public void updateUserAnswer(UserAnswer userAnswer) {

    }

    @Override
    public void deleteUserAnswerById(Long id) {

    }

    @Override
    public void deleteAllUserAnswerById(Long userId) {
        String sql = "DELETE FROM " + USER_ANSWER_TABLE + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public UserAnswer getUserAnswerById(Long id) {
        String sql = "SELECT * FROM " + USER_ANSWER_TABLE + " WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserAnswerMapper());
    }

    @Override
    public List<UserAnswer> getAllUserAnswersByUserId(Long userId) {
        String sql = "SELECT * FROM " + USER_ANSWER_TABLE + " WHERE user_id=?";
        System.out.println("SQL Query: " + sql);
        return jdbcTemplate.query(sql, new Object[]{userId},new UserAnswerMapper());
    }

    @Override
    public Long getTotalAnsweredQuestionsByUser(Long userId) {
        String sql = "SELECT COUNT(*) FROM " + USER_ANSWER_TABLE + " WHERE user_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, Long.class);
    }

    @Override
    public Long getTotalQuestionAnswersByUser(Long questionId) {
        String sql = "SELECT COUNT(DISTINCT user_id) FROM " + USER_ANSWER_TABLE + " WHERE question_id=?";
        return jdbcTemplate.queryForObject(sql, Long.class, questionId);
    }

    @Override
    public List<Map<String, Object>> getUsersPerOptionCountByQuestionId(Long questionId) {
        String sql = "SELECT answer, COUNT(*) as count FROM user_answer_table WHERE question_id=? GROUP BY answer";
        return jdbcTemplate.query(sql, new Object[]{questionId}, (rs, rowNum) -> {
            Map<String, Object> result = new HashMap<>();
            result.put("option", rs.getString("answer"));
            result.put("count", rs.getLong("count"));
            return result;
        });
    }

    @Override
    public List<Map<String, Object>> getAllQuestionAndTheOptionsCount() {
        String sql = "SELECT question_id, question_title, answer, COUNT(*) as user_count FROM user_answer_table GROUP BY question_id, question_title, answer";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Long questionId = rs.getLong("question_id");
            String questionTitle = rs.getString("question_title");
            String option = rs.getString("answer");
            Long count = rs.getLong("user_count");

            Map<String, Object> result = new HashMap<>();
            result.put("questionId", questionId);
            result.put("questionTitle", questionTitle);
            result.put("option", option);
            result.put("userCount", count);

            return result;
        });
    }
}
