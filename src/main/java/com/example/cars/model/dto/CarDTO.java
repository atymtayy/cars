package com.example.cars.model.dto;



import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private double price;
}
