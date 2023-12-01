package com.example.gym.dto;

import com.example.gym.dto.tm.CartTM;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PlaceSuplimentsDTO {
    private String ProductName;
    private String ProductQTY;
    private List <CartTM> cartTmList = new ArrayList<>();



}
