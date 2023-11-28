package com.example.gym.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class InventoryDTO {
    private String ProductName;
    private String ProductQTY;
    private String ProductPrice;
}