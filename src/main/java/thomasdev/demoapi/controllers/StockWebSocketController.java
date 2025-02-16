package thomasdev.demoapi.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import thomasdev.demoapi.services.StockData;
import thomasdev.demoapi.services.StockService;

import java.util.List;

@Controller
public class StockWebSocketController {

    private final StockService stockService;

    public StockWebSocketController(StockService stockService) {
        this.stockService = stockService;
    }

    @MessageMapping("/stocks")
    @SendTo("/topic/stocks")
    public List<StockData> sendStockData() {
        return stockService.getAllStocks();
    }

    // update every 5 sec
    @Scheduled(fixedRate = 5000)
    public void broadcastStockUpdates() {
        List<StockData> updatedStocks = stockService.getAllStocks();
        WebSocketBroadcaster.broadcast("/topic/stocks", updatedStocks);
    }
}
