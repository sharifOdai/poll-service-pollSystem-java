package com.pollServiceProject.service;

import com.pollServiceProject.model.PollQuestion;

public interface PollService {

    Long createPoll (PollQuestion pollQuestion);
    void updatePoll (PollQuestion pollQuestion);
    void deletePollById (Long id);
    PollQuestion getPollById (Long id);

    String getQuestionTitleById (Long id);


}
