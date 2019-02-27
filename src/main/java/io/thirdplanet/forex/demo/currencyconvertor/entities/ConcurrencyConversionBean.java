package io.thirdplanet.forex.demo.currencyconvertor.entities;

import java.math.BigDecimal;

public class ConcurrencyConversionBean {
    private Long id ;
    private String from ;
    private String to ;
    private  BigDecimal conversionMultiple ;
    private BigDecimal quantity ;
    private BigDecimal totalCalculatedAmount  ;
    private int port ;



    public ConcurrencyConversionBean(){
        //pass
    }



    public ConcurrencyConversionBean(
            Long id ,
            String from ,
            String to ,
            BigDecimal conversionMultiple ,
            BigDecimal quantity ,
            BigDecimal totalCalculatedAmount  ,
            int port){
        this.id = id  ;
        this.to = to ;
        this.from = from ;
        this.conversionMultiple = conversionMultiple ;
        this.quantity = quantity ;
        this.totalCalculatedAmount = totalCalculatedAmount  ;
        this.port = port ;
    }

    public Long getId (){return id;}
    public void setId(){this.id = id ;}

    public String getFrom (){return from;}
    public void setFrom(){this.from = from ;}


    public String getTo(){return to;}
    public void setTo(){this.to = to ;}

    public BigDecimal getConversionMultiple(){return  conversionMultiple;}
    public void setConversionMultiple(BigDecimal converstionMultiple){this.conversionMultiple = converstionMultiple;}

    public BigDecimal getQuantity(){ return quantity; }
    public void setQuantity(BigDecimal quantity){this.quantity = quantity;}

    public BigDecimal getTotalCalculatedAmount(){return totalCalculatedAmount;}
    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount){this.totalCalculatedAmount = totalCalculatedAmount;}

    public int getPort(){return port;}
    public void setPort(int port){this.port = port;}


    @Override
    public String toString(){

        return  "id: " + id.toString() + " " + "from:" + from + " " + "to:" + to   + " " +"conversion multiple: " + conversionMultiple + " " +"quantity: " + quantity ;
    }
}
