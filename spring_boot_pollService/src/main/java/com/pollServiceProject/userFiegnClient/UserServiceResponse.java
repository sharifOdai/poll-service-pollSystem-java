package com.pollServiceProject.userFiegnClient;

import java.time.LocalDate;

public class UserServiceResponse {

    private Long id;
    private Boolean status;


    public UserServiceResponse() {
    }

    public UserServiceResponse(Long id, Boolean status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

