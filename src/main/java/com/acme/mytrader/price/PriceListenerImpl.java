package com.acme.mytrader.price;

import com.acme.mytrader.execution.ExecutionService;

public class PriceListenerImpl implements PriceListener {

    private String stock;
    private int numberOfStocks;
    private double triggerPrice;
    private ExecutionService executionService;
   
    public PriceListenerImpl(String stock, int numberOfStocks, double triggerPrice, ExecutionService executionService) {
        this.stock = stock;
        this.numberOfStocks = numberOfStocks;
        this.triggerPrice = triggerPrice;
        this.executionService = executionService;
    }

    //This method is called from price source
    @Override
    public void priceUpdate(String security, double price) {
        
        if(security.equals(stock) && price < triggerPrice){
            executionService.buy(security, price, numberOfStocks);
            System.out.println("Buy executed for: "+security);
        }
        
    }
    
}
