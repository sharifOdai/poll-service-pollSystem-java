package com.pollServiceProject.model;

import java.util.List;

public class UserAnswerResponse {

    private Long userId;
    private List<UserAnswer> userAnswerList;

    public UserAnswerResponse(){};

    public UserAnswerResponse(Long userId, List<UserAnswer> userAnswerList) {
        this.userId = userId;
        this.userAnswerList = userAnswerList;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    public List<UserAnswer> getUserAnswerList() {
        return userAnswerList;
    }

    public void setUserAnswerList(List<UserAnswer> userAnswerList) {
        this.userAnswerList = userAnswerList;
    }
}
