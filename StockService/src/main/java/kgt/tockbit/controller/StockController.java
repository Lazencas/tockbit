package kgt.tockbit.controller;

import kgt.tockbit.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    private final StockService stockService;
    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

//
//   @GetMapping("/stock")
//   public String getStockData(Model model){
//       System.out.println("주식api호출");
//        String stockData = stockService.getStockData();
//        model.addAttribute("stockData", stockData);
//        return "stock";
//   }

    //모든 주식데이터 가져와서 db에 저장
    @PostMapping("/stock/fetch/{market}")
    public void fetchAndSaveStockData(@PathVariable("market") String market){
        this.stockService.fetchAllStocks(market);
    }


//    @GetMapping("/stock/{symbol}")
//    public Flux<Stock> updateStock(@PathVariable("symbol") String symbol){
//        return this.stockService.updateStockData(symbol);
//    }


    @GetMapping("/stock/check")
    public String check(){
        System.out.println("호출되는지만 체크");
        return "bravo!!";
    }

    //5년치의 일봉데이터 가져와서 db에 저장
    @GetMapping("/stock/fetch")
    public void fetch(){
        stockService.fetchAndStoreFiveYearsData();
    }


}
