package tqscars.carinfo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carService.save(car);

        return new ResponseEntity<>(saved, status);
    }

    @GetMapping("/car")
    public Car getCarDetails(@RequestParam(name = "name") String name){
        return carService.getCarDetails(name);
    }

}
