package com.acme.mytrader.price;

import static org.mockito.Mockito.times;

import com.acme.mytrader.execution.ExecutionService;

import org.junit.Test;
import org.mockito.Mockito;

public class PriceListenerImplTest {

    @Test
    public void testBuyIsExecuted(){

        ExecutionService executionService = Mockito.mock(ExecutionService.class);
        PriceListener priceListener = new PriceListenerImpl("IBM", 20, 55, executionService);
        priceListener.priceUpdate("IBM", 50);
        Mockito.verify(executionService, times(1))
        .buy(Mockito.anyString(), Mockito.anyDouble(), Mockito.anyInt());
    }

    @Test
    public void testBuyIsNotExecutedWhenPriceIsHigh(){

        ExecutionService executionService = Mockito.mock(ExecutionService.class);
        PriceListener priceListener = new PriceListenerImpl("IBM", 20, 55, executionService);
        priceListener.priceUpdate("IBM", 100);
        Mockito.verify(executionService, times(0))
        .buy(Mockito.anyString(), Mockito.anyDouble(), Mockito.anyInt());
    }

    @Test
    public void testBuyIsNotExecutedWhenSecurityIsDiff(){

        ExecutionService executionService = Mockito.mock(ExecutionService.class);
        PriceListener priceListener = new PriceListenerImpl("IBM", 20, 55, executionService);
        priceListener.priceUpdate("Something else", 50);
        Mockito.verify(executionService, times(0))
        .buy(Mockito.anyString(), Mockito.anyDouble(), Mockito.anyInt());
    }
    
}
