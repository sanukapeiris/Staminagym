package com.example.gym.view.tdm;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class FeedbackTM {
    private LocalDate FeedbackDate;
    private String FeedbackText ;
}
