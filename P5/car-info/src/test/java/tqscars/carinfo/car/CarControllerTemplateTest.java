package tqscars.carinfo.car;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class CarControllerTemplateTest {
    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository carRepository;

    @AfterEach
    public void resetDB(){carRepository.deleteAll();}

    @Test
    public void whenValidInput_thenCreateCar() throws IOException, Exception{
        Car tesla = new Car("ModelS","Tesla");
        ResponseEntity<Car> entity = restTemplate.postForEntity("/api/cars", tesla, Car.class);

        Car found = carRepository.findByName(tesla.getName());
        assertThat(found.getName()).isEqualTo(tesla.getName());
    }

    @Test
    public void givenCar_whenGetCar_thenStatusOK() throws Exception{
        Car tesla = new Car("ModelS","Tesla");
        carRepository.saveAndFlush(tesla);


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:"+randomServerPort+"/api/car")
                .queryParam("name", "ModelS");

        ResponseEntity<Car> response = restTemplate
                .exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<Car>() {});

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo(tesla.getName());
    }
}