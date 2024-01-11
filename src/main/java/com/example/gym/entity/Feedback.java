package com.example.gym.entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class Feedback {
    private LocalDate FeedbackDate;
    private String FeedbackText ;
}
