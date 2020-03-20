package tqscars.carinfo.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService service;

    @BeforeEach
    public void setUp() throws Exception{

    }

    @Test
    public void whenPostCar_thenCreateCar() throws Exception {
        Car tesla = new Car("ModelS", "Tesla");
        given(service.save(Mockito.any())).willReturn(tesla);

        mvc.perform(post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(tesla)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("ModelS")))
                .andExpect(jsonPath("$.maker", is("Tesla")));   //Note: For this to work you have to define the getters and setters!
        verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
        reset(service);
    }

    @Test
    public void givenCar_whenGetCar_thenReturnJson() throws Exception{
        Car tesla = new Car("ModelS", "Tesla");
        given(service.getCarDetails("ModelS")).willReturn(tesla);

        mvc.perform(get("/api/car").contentType(MediaType.APPLICATION_JSON).param("name","ModelS"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("ModelS")))
                .andExpect(jsonPath("$.maker", is("Tesla")));   //Note: For this to work you have to define the getters and setters!
        verify(service, VerificationModeFactory.times(1)).getCarDetails("ModelS");
        reset(service);
    }
}