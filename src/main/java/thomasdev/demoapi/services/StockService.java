package thomasdev.demoapi.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StockService {

    private static final String[] COMPANIES = {"TechCorp", "FinBank", "HealthPlus", "GreenEnergy"};
    private final Random random = new Random();

    // Méthode pour générer une valeur boursière aléatoire
    public StockData getStockData() {
        String company = COMPANIES[random.nextInt(COMPANIES.length)];
        return new StockData(company, getRandomPrice());
    }

    public List<StockData> getAllStocks() {
        List<StockData> stocks = new ArrayList<>();
        for (String company : COMPANIES) {
            stocks.add(new StockData(company, getRandomPrice()));
        }
        return stocks;
    }

    private double getRandomPrice() {
        return Math.round((100 + random.nextDouble() * 1000) * 100.0) / 100.0;
    }
}

