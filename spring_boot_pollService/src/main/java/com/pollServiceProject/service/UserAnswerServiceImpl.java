package com.pollServiceProject.service;

import com.pollServiceProject.model.UserAnswer;
import com.pollServiceProject.model.UserAnswerRequest;
import com.pollServiceProject.model.UserAnswerResponse;
import com.pollServiceProject.repository.PollRepository;
import com.pollServiceProject.repository.UserAnswerRepository;
import com.pollServiceProject.userFiegnClient.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    @Autowired
    UserService userService;
    @Autowired
    UserAnswerRepository userAnswerRepository;
    @Autowired
    PollRepository pollRepository;







    @Override
    public UserAnswerResponse createUserAnswer(UserAnswerRequest userAnswerRequest) throws IllegalAccessException {


        Long userId = userAnswerRequest.getUserId();


        if (!userService.isUserRegistered(userId)){
            throw new IllegalAccessException("the user is not registered");
        }

        Long questionId = userAnswerRequest.getUserAnswer().getQuestionId();
        String questionTitle = pollRepository.getQuestionTitleById(questionId);
        String userAnswer = userAnswerRequest.getUserAnswer().getAnswer();

        userAnswerRequest.setUserId(userId);

        UserAnswer userAnswerToCreate = userAnswerRequest.toUserResponse();
        userAnswerToCreate.setQuestionId(questionId);
        userAnswerToCreate.setQuestionTitle(questionTitle);
        userAnswerToCreate.setAnswer(userAnswer);

        userAnswerRepository.createUserAnswer(userAnswerToCreate);
        List<UserAnswer> userAnswerList = userAnswerRepository.getAllUserAnswersByUserId(userId);

        return new UserAnswerResponse(userId, userAnswerList);






    }

    @Override
    public void updateUserAnswer(UserAnswer userAnswer) {

    }

    @Override
    public void deleteUserAnswerById(Long id) {
        userAnswerRepository.deleteUserAnswerById(id);

    }

    @Override
    public void deleteAllUserAnswerById(Long userId) {
        userAnswerRepository.deleteAllUserAnswerById(userId);
    }

    @Override
    public UserAnswer getUserAnswerById(Long id) {
        return userAnswerRepository.getUserAnswerById(id);
    }

    @Override
    public List<UserAnswer> getAllUserAnswersByUserId(Long userId) {
        return userAnswerRepository.getAllUserAnswersByUserId(userId);
    }

    @Override
    public Long getTotalAnsweredQuestionsByUser(Long userId) {
        return userAnswerRepository.getTotalAnsweredQuestionsByUser(userId);
    }

    @Override
    public Long getTotalQuestionAnswersByUser(Long questionId) {
        return userAnswerRepository.getTotalQuestionAnswersByUser(questionId);
    }

    @Override
    public List<Map<String, Object>> getUsersPerOptionCountByQuestionId(Long questionId) {
        return userAnswerRepository.getUsersPerOptionCountByQuestionId(questionId);
    }

    @Override
    public List<Map<String, Object>> getAllQuestionAndTheOptionsCount() {
        return userAnswerRepository.getAllQuestionAndTheOptionsCount();
    }
}
