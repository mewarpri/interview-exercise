package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionServiceImpl;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceListenerImpl;
import com.acme.mytrader.price.PriceSource;
import com.acme.mytrader.price.PriceSourceImpl;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {

    public static void main(String[] args) {
        
        //Getting specified information from program arguments
        String stockToMonitor = args[0];
        int numberOfStocks = Integer.parseInt(args[1]);
        double triggerPrice = Double.parseDouble(args[2]);
        TradingStrategy tradingStrategy = new TradingStrategy();
        PriceSource priceSource = new PriceSourceImpl();
        tradingStrategy.tradeStock(stockToMonitor, numberOfStocks, triggerPrice, priceSource);
    }

    public void tradeStock(String stockToMonitor, int numberOfStocks, double triggerPrice, PriceSource priceSource){

      PriceListener priceListener = new PriceListenerImpl(stockToMonitor, numberOfStocks, triggerPrice, new ExecutionServiceImpl());
      priceSource.addPriceListener(priceListener);
      //price source will invoke priceUpdate() of priceListener when price changes -> provided by third party
    }
}
