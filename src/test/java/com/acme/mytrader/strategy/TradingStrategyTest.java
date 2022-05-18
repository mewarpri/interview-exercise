package com.acme.mytrader.strategy;

import static org.mockito.Mockito.times;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;

import org.junit.Test;
import org.mockito.Mockito;

public class TradingStrategyTest {
   
    @Test
    public void testPriceListenerSetup() {

        PriceSource priceSource = Mockito.mock(PriceSource.class);
        TradingStrategy tradingStrategy = new TradingStrategy();
        tradingStrategy.tradeStock("IBM", 20, 55, priceSource);
        Mockito.verify(priceSource, times(1))
        .addPriceListener(Mockito.any(PriceListener.class));
    }
}
