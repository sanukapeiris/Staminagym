package com.example.gym.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class FeedbackDTO {
    private LocalDate Date;
    private String Feedback ;
}
