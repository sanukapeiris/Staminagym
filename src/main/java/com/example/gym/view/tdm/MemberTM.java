package com.example.gym.view.tdm;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class MemberTM {
    private String MemberID;
    private String FistName;
    private String LastName;
    private int Age;
    private String Gender;
    private LocalDate Birth ;
    private String Email;
    private String ContactNo;
}
