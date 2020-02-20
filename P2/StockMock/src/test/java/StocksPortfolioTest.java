//Junit
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

//Hamcrest
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

//Mockito
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {
    @Mock IStockMarket mockMarket;
    @InjectMocks StocksPortfolio portfolio;

    @BeforeEach
    void setUp() {
        portfolio.setName("Jonas Pistolas");
    }


    @Test
    void getTotalValueTest() {
        portfolio.addStock(new Stock("MicroHard", 10));
        portfolio.addStock(new Stock("Appel", 2));

        Mockito.when(mockMarket.getPrice("MicroHard")).thenReturn(5.0);
        Mockito.when(mockMarket.getPrice("Appel")).thenReturn(4.20);

        double correctTotal = 10*5 + 4.20*2;

        //assertEquals(portfolio.getTotalValue(),correctTotal);
        assertThat(portfolio.getTotalValue(),is(correctTotal));

        Mockito.verify(mockMarket, Mockito.times(2)).getPrice(Mockito.anyString()); //Verify the Mock's function was called twice
    }
}