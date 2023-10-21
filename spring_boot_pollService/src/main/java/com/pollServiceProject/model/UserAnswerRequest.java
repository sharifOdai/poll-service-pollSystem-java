package com.pollServiceProject.model;


public class UserAnswerRequest {

    private Long userId;
    private UserAnswer userAnswer;

    public UserAnswerRequest(Long userId, UserAnswer userAnswer) {
        this.userId = userId;
        this.userAnswer = userAnswer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserAnswer getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(UserAnswer userAnswer) {
        this.userAnswer = userAnswer;
    }

    public UserAnswer toUserResponse(){
        return new UserAnswer(
                this.userAnswer.getId(),
                this.userId,
                this.userAnswer.getQuestionId(),
                this.userAnswer.getQuestionTitle(),
                this.userAnswer.getAnswer()
        );
    }
}
