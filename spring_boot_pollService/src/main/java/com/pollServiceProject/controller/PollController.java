package com.pollServiceProject.controller;

import com.pollServiceProject.model.PollQuestion;
import com.pollServiceProject.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poll")
public class PollController {
@Autowired
private PollService pollService;

@PostMapping("/create")
    public ResponseEntity<?> createPollQuestion(@RequestBody PollQuestion pollQuestion){
    pollService.createPoll(pollQuestion);
    return ResponseEntity.ok("poll question created successfully");
}

@PutMapping("/update")
    public ResponseEntity<?> updatePollQuestion(@RequestBody PollQuestion pollQuestion){
    pollService.updatePoll(pollQuestion);
    return ResponseEntity.ok("poll question updated successfully");
}

@DeleteMapping("/delete/{questionId}")
    public ResponseEntity<?> deletePollQuestionById(@PathVariable Long questionId){
    pollService.deletePollById(questionId);
    return ResponseEntity.ok("poll question deleted successfully");
}

@GetMapping("/{questionId}")
    public PollQuestion getPollQuestionById(@PathVariable Long questionId){
    return pollService.getPollById(questionId);

}


}
