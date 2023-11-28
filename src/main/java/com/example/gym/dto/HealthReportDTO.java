package com.example.gym.dto;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class HealthReportDTO {
    private String HealthReportID;
    private String MemberID;
    private String Weight;
    private String Height;
    private String MedicalCondition;
    private String BodyFatpercentage;



}
