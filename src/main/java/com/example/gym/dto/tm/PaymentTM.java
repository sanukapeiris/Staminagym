package com.example.gym.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class PaymentTM {
    private String MemberID;
    private String PaymentType;
    private String AccountNo;
}
