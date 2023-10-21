package com.pollServiceProject.repository;

import com.pollServiceProject.model.UserAnswer;

import java.util.List;
import java.util.Map;

public interface UserAnswerRepository {
    void createUserAnswer(UserAnswer userAnswer);
    void updateUserAnswer(UserAnswer userAnswer);
    void deleteUserAnswerById(Long id);
    void deleteAllUserAnswerById(Long userId);
    UserAnswer getUserAnswerById(Long id);

    List<UserAnswer> getAllUserAnswersByUserId(Long userId);

    Long getTotalAnsweredQuestionsByUser(Long userId);
    Long getTotalQuestionAnswersByUser(Long questionId);

    List<Map<String, Object>> getUsersPerOptionCountByQuestionId(Long questionId);

    List<Map<String, Object>> getAllQuestionAndTheOptionsCount();

}
