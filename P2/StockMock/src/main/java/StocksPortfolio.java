import java.lang.reflect.Array;
import java.util.ArrayList;

public class StocksPortfolio {
    private String name;
    private IStockMarket marketService;
    private ArrayList<Stock> stocks = new ArrayList<>();

    public IStockMarket getMarketService(){
        return this.marketService;
    }

    public void setMarketService(IStockMarket newMarket){
        this.marketService = newMarket;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public double getTotalValue(){
        double total = 0;

        for(Stock s : this.stocks){
            total += (marketService.getPrice(s.getName()) * s.getQuantity());
        }

        return total;
    }

    public void addStock(Stock newStock){
        this.stocks.add(newStock);
    }


}
