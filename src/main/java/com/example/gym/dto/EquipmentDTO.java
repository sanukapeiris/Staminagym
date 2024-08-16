package com.example.gym.dto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class EquipmentDTO {
    private String Equipmentid ;
    private String Equipmentname;
    private String EquipmentQTY;
    private String PurchaseDate ;
}
