package com.example.cars.service;


import com.example.cars.model.dto.CarDTO;

import java.util.List;

public interface CarService {
    CarDTO create(CarDTO dto);
    CarDTO getById(Long id);
    List<CarDTO> getAll();
    CarDTO update(Long id, CarDTO dto);
    void delete(Long id);

}