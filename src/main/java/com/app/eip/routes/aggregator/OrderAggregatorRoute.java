package com.app.eip.routes.aggregator;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.eip.processor.OrderAggregatorStrategy;


@Component
public class OrderAggregatorRoute extends RouteBuilder {

    @Autowired
    private OrderAggregatorStrategy orderAggregatorStrategy;


    @Override
    public void configure() throws Exception {

        from("direct:incomingOrders")
        .log("received order: ${body}")
        .aggregate(constant(true), orderAggregatorStrategy)
            .completionInterval(3000)
            .log("aggregated order: ${body}");

        // .completionSize(3); complete after 3 messages
        // .completionTimeout(5000); complete after 5 seconds of inactivity
        // .completionPredicate(header(Exchange.SLIP_ENDPOINT).isEqualTo("true")) //
        // .log("aggregated order: ${body}")


    }
}