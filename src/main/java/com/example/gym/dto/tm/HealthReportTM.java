package com.example.gym.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class HealthReportTM {
    private String MemberID;
    private String HealthReportID;
    private String Weight;
    private String Height;
    private String MedicalCondition;
    private String BodyFatpercentage;

}
