package com.pollServiceProject.service;


import com.pollServiceProject.model.PollQuestion;
import com.pollServiceProject.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService{
    @Autowired
    private PollRepository pollRepository;

    @Override
    public Long createPoll(PollQuestion pollQuestion) {

        return pollRepository.createPoll(pollQuestion);
    }

    @Override
    public void updatePoll(PollQuestion pollQuestion)
    {
        pollRepository.updatePoll(pollQuestion);
    }

    @Override
    public void deletePollById(Long id)
    {
        pollRepository.deletePollById(id);
    }

    @Override
    public PollQuestion getPollById(Long id)
    {
        return pollRepository.getPollById(id);
    }

    @Override
    public String getQuestionTitleById(Long id) {
        return pollRepository.getQuestionTitleById(id);
    }


}
