package com.example.gym.entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class Payment {
    private String MemberID;
    private String Paymenttype;
    private String Accountno;
}
