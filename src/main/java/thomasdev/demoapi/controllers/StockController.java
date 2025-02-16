package thomasdev.demoapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thomasdev.demoapi.services.StockData;
import thomasdev.demoapi.services.StockService;
/**
 * REST version
 */
@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public StockData getStockData() {
        return stockService.getStockData();
    }
    @GetMapping("/all")
    public List<StockData> getAllStockData() {
        return stockService.getAllStocks();
    }
}

