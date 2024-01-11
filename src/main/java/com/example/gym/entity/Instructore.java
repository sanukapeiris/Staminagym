package com.example.gym.entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class Instructore {
    private String InstructorID;
    private String FistName;
    private String LastName;
    private int Age;
    private String Gender;
    private LocalDate Birth ;
    private String Email;
    private String Contactno;
}
