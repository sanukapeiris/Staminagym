package com.example.gym.entity;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Equipment {
    private String id;
    private String name;
    private String qty;
    private String Date;

}
