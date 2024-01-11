package com.example.gym.entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class HealthReport {
    private String MemberID;
    private String HealthReportID;
    private String Weight;
    private String Height;
    private String MedicalCondition;
    private String BodyFatpercentage;
}
