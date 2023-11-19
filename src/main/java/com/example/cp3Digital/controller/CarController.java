package com.example.cp3Digital.controller;

import ch.qos.logback.core.model.Model;
import com.example.cp3Digital.model.Car;
import com.example.cp3Digital.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String listCar(org.springframework.ui.Model model) {
        model.addAttribute("cars", carService.findAll());
        return "car/list";
    }

    @GetMapping("/add")
    public String showAddForm(org.springframework.ui.Model model) {
        model.addAttribute("car", new Car());
        return "car/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, org.springframework.ui.Model model) {
        Car product = carService.findById(id).orElseThrow(() -> new IllegalArgumentException("Carro não encotrado Id: " + id));
        model.addAttribute("car", product);
        return "car/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return "redirect:/cars";
    }
}
