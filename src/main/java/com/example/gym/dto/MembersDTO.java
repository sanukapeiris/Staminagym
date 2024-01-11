package com.example.gym.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class MembersDTO {
    private String MemberID;
    private String FistName;
    private String LastName;
    private int Age;
    private String Gender;
    private LocalDate Birth ;
    private String Email;
    private String ContactNo;
}
