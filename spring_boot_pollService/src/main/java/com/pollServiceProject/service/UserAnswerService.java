package com.pollServiceProject.service;

import com.pollServiceProject.model.UserAnswer;
import com.pollServiceProject.model.UserAnswerRequest;
import com.pollServiceProject.model.UserAnswerResponse;

import java.util.List;
import java.util.Map;

public interface UserAnswerService {
    UserAnswerResponse createUserAnswer(UserAnswerRequest userAnswerRequest) throws IllegalAccessException;
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
