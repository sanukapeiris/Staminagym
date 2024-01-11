package com.example.gym.entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class Report {
    private String FromDate;
    private String ToDate;
    private String Income;
}
