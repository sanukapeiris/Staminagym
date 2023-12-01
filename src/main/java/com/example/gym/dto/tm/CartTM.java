package com.example.gym.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class CartTM {
    private String Productname;
    private int ProductQTY;
    private double ProductPrice;
    private double total;
}
