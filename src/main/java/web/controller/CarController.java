package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.DAO.UserDAO;
import web.Service.CarService;
import web.Service.CarServiceImpl;
import web.model.Car;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/")
    public String carsPage( Model model) {
        List<Car> listCar = carService.getAll();
        model.addAttribute("carsList", listCar);
        return "cars";
    }

}
