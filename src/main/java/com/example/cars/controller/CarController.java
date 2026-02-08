package com.example.cars.controller;

import com.example.cars.model.dto.CarDTO;
import com.example.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<CarDTO> create(@RequestBody CarDTO dto) {
        return ResponseEntity.ok(carService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> update(@PathVariable Long id, @RequestBody CarDTO dto) {
        return ResponseEntity.ok(carService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }
}