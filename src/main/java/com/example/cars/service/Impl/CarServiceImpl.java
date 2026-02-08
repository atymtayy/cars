package com.example.cars.service.impl;

import com.example.cars.model.dto.CarDTO;
import com.example.cars.model.entity.Car;
import com.example.cars.repository.CarRepository;
import com.example.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDTO create(CarDTO dto) {
        Car car = Car.builder()
                .brand(dto.getBrand())
                .model(dto.getModel())
                .year(dto.getYear())
                .price(dto.getPrice())
                .build();

        car = carRepository.save(car);
        return mapToDTO(car);
    }

    @Override
    public CarDTO getById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        return mapToDTO(car);
    }

    @Override
    public List<CarDTO> getAll() {
        return carRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO update(Long id, CarDTO dto) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setPrice(dto.getPrice());

        Car savedCar = carRepository.save(car);
        return mapToDTO(savedCar);
    }

    @Override
    public void delete(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found");
        }
        carRepository.deleteById(id);
    }

    private CarDTO mapToDTO(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .price(car.getPrice())
                .build();
    }
}