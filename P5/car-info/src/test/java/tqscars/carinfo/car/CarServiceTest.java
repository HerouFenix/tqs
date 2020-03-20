package tqscars.carinfo.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {
    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    public void setUp(){
        Car tesla = new Car("ModelS", "Tesla");
        Car porsche = new Car("911", "Porsche");
        Car lambo = new Car("Aventador", "Lamborghinni");


        Mockito.when(carRepository.findByName(tesla.getName())).thenReturn(tesla);
        Mockito.when(carRepository.findByName(porsche.getName())).thenReturn(porsche);
        Mockito.when(carRepository.findByName(lambo.getName())).thenReturn(lambo);
        Mockito.when(carRepository.findByName("wrong_car_name")).thenReturn(null);
    }

    @Test
    public void whenValidName_thenCarShouldBeFound() {
        String[] existingCars = {"Aventador","ModelS","Aventador"};
        for (String car_name : existingCars){
            Car found = carService.getCarDetails(car_name);
            assertThat(found.getName()).isEqualTo(car_name);
        }
    }

    @Test
    public void whenInvalidName_thenCarShouldNotBeFound() {
        String car_name = "wrong_car_name";
        Car found = carService.getCarDetails(car_name);
        assertThat(found).isNull();

        Mockito.verify(carRepository, VerificationModeFactory.times(1)).findByName(car_name);
        Mockito.reset(carRepository);
    }

}