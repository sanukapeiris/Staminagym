package com.example.gym.entity;


import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class Member {
    private String MemberID;
    private String FirstName;
    private String LastName;
    private int Age;
    private String Gender;
    private LocalDate BirthDate;
    private String Email;
    private String ContactNo;

}
