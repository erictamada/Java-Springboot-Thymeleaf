package com.example.cp3Digital.service;

import com.example.cp3Digital.model.Car;
import com.example.cp3Digital.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public List<Car> findAll() {
        return carRepository.findAll();
    }
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
