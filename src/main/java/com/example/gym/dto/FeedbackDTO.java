package com.example.gym.dto;

import com.example.gym.entity.Feedback;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class FeedbackDTO extends Feedback {
    private LocalDate FeedbackDate;
    private String Feedback ;
}
