package io.thirdplanet.forex.demo.currencyconvertor.controllers;
//http://www.springboottutorial.com/creating-microservices-with-spring-boot-part-3-currency-conversion-microservice

import io.thirdplanet.forex.demo.currencyconvertor.entities.ConcurrencyConversionBean;
import io.thirdplanet.forex.demo.currencyconvertor.proxies.ICurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ICurrencyExchangeServiceProxy proxy ;

    @GetMapping("/foo")
    public String foo(){
        return "foo";
    }

    @GetMapping("/bar")
    public String bar(){
        return "bar";
    }

    @GetMapping("/foobar")
    public String foobar(){
        return "foobar";
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public  ConcurrencyConversionBean convertCurrency (@PathVariable String from ,
                                      @PathVariable String to,
                                      @PathVariable BigDecimal quantity){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);


        System.out.println("==========================");
        System.out.println(uriVariables.toString());
        System.out.println(quantity.toString());
        System.out.println("==========================");


        ResponseEntity<ConcurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                ConcurrencyConversionBean.class,
                uriVariables);

        ConcurrencyConversionBean response = responseEntity.getBody() ;
        response.setQuantity(quantity);
        response.setConversionMultiple(new BigDecimal(String.valueOf(response.getQuantity())));


        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(response.toString());
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<");


        return new ConcurrencyConversionBean(
                response.getId(),
                response.getFrom(),
                response.getTo(),
                response.getConversionMultiple(),
                response.getQuantity(),
                response.getQuantity().multiply(response.getConversionMultiple()),
                        response.getPort());

        //return  response ;

    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public ConcurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        ConcurrencyConversionBean response = proxy.retrieveExchangeValue(from,to) ;
        logger.info("{}", response);
        return new ConcurrencyConversionBean(
                response.getId(),
                response.getFrom(),
                response.getTo(),
                response.getConversionMultiple(),
                //response.getQuantity(),
                quantity,
                quantity.multiply(response.getConversionMultiple()),
                response.getPort());
    }




}
