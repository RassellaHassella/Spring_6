package web.Service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("red", "488 GTB", 5000000));
        cars.add(new Car("blue", "Granta", 450000));
        cars.add(new Car("green", "Soul", 1200000));
        cars.add(new Car("black", "XC90", 3000000));
        cars.add(new Car("grey", "ferari", 2500000));
    }

    public List<Car> carsPage(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
