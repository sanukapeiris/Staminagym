package com.example.gym.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class InventoryDTO {
    private String ProductName;
    private String ProductQty;
    private String ProductPrice;

    public String getCode() {
        return ProductName;
    }
}
