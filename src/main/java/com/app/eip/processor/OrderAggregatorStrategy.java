package com.app.eip.processor;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;


@Component
public class OrderAggregatorStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null){
            return newExchange;
        }

        String oldBody = oldExchange.getIn().getBody(String.class);
        String newBody = newExchange.getIn().getBody(String.class);

        oldExchange.getIn().setBody(oldBody + "" + newBody);
        System.out.println("Aggregated values: " + oldExchange.getIn().getBody(String.class));
        return oldExchange;
    }
}