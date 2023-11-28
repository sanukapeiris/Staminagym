package com.example.gym.dto;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class PaymentDTO {
    private String MemberID;
    private String Paymenttype;
    private String Accountno;
}
