package io.thirdplanet.forex.demo.currencyconvertor.proxies;

import io.thirdplanet.forex.demo.currencyconvertor.entities.ConcurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="forex-service", url="localhost:8000")
@RibbonClient(name="forex-service")
public interface ICurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ConcurrencyConversionBean retrieveExchangeValue(
            @PathVariable("from") String from,
            @PathVariable("to") String to
    );
}
