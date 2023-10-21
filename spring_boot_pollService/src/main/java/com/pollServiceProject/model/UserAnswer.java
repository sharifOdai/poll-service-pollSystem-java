package com.pollServiceProject.model;

import java.util.List;

public class UserAnswer {

    private Long id;
    private Long userId;
    private Long questionId;
    private String questionTitle;
    private String answer;

    public UserAnswer(){}

    public UserAnswer(Long id, Long userId, Long questionId, String questionTitle, String answer) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.answer = answer;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public UserAnswerResponse toUserAnswerResponse(Long userId, List<UserAnswer> userAnswerList){
        return new UserAnswerResponse(userId, userAnswerList);
    }
}
