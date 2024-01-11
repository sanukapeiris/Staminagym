package com.example.gym.view.tdm;

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
