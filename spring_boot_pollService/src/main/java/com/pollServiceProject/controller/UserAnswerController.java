package com.pollServiceProject.controller;

import com.pollServiceProject.model.UserAnswer;
import com.pollServiceProject.model.UserAnswerRequest;
import com.pollServiceProject.model.UserAnswerResponse;
import com.pollServiceProject.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user-answer")
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;

    @PostMapping("/create")
    public ResponseEntity<?>  createUserAnswer(@RequestBody UserAnswerRequest userAnswerRequest) throws IllegalAccessException {
         userAnswerService.createUserAnswer(userAnswerRequest);
         return ResponseEntity.ok(" user answer created successfully ");

    }

    @DeleteMapping("/delete-all-user-answers/{userId}")
    public ResponseEntity<?> deleteAllUserAnswersByUserId(@PathVariable Long userId){
        userAnswerService.deleteAllUserAnswerById(userId);
        return ResponseEntity.ok(" all user answers were deleted successfully!");
    }

    @GetMapping("/answer/{id}")
    public UserAnswer getAnswerById(@PathVariable Long id){
        return userAnswerService.getUserAnswerById(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserAnswersByUserId(@PathVariable Long userId) {
        List<UserAnswer> userAnswers = userAnswerService.getAllUserAnswersByUserId(userId);

        if (userAnswers.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("userAnswers", userAnswers);

            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/total-questions-user-answered/{userId}")
    public ResponseEntity<?> getTotalAnsweredQuestionsByUser(@PathVariable Long userId){
        Long totalAnswers = userAnswerService.getTotalAnsweredQuestionsByUser(userId);
        return ResponseEntity.ok("total questions were answered by this user is: " + totalAnswers);
    }

    @GetMapping("/total-users-answered-question/{questionId}")
    public ResponseEntity<?> getTotalQuestionAnswersByUser(@PathVariable Long questionId){
        Long totalUsers = userAnswerService.getTotalQuestionAnswersByUser(questionId);
        return ResponseEntity.ok("total users answered this question: " + totalUsers);
    }

    @GetMapping("/question-option-count/{questionId}")
    public ResponseEntity<String> getUsersPerOptionCountByQuestionId(@PathVariable Long questionId) {
        List<Map<String, Object>> optionCountList = userAnswerService.getUsersPerOptionCountByQuestionId(questionId);

        if (optionCountList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            StringBuilder responseMessage = new StringBuilder();

            for (Map<String, Object> optionCount : optionCountList) {
                String option = (String) optionCount.get("option");
                Long count = (Long) optionCount.get("count");

                responseMessage.append(count).append(" users chose the option '").append(option).append("', ");
            }

            String finalMessage = responseMessage.substring(0, responseMessage.length() - 2);

            return ResponseEntity.ok(finalMessage);
        }
    }

    @GetMapping("/all-questions-and-their-counts")
    public ResponseEntity<List<Map<String, Object>>> getAllQuestionAndTheOptionsCount() {
        List<Map<String, Object>> optionCounts = userAnswerService.getAllQuestionAndTheOptionsCount();
        return ResponseEntity.ok(optionCounts);
    }
}
