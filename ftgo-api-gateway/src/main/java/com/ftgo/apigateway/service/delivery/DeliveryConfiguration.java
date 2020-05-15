package com.ftgo.apigateway.service.delivery;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The configuration class to instantiate the routing rules for the kitchen service.
 * 
 * @author  Wuyi Chen
 * @date    05/15/2020
 * @version 1.0
 * @since   1.0
 */
@Configuration
@EnableConfigurationProperties(DeliveryDestinations.class)
public class DeliveryConfiguration {
	@Bean
	public RouteLocator deliveryProxyRouting(RouteLocatorBuilder builder, DeliveryDestinations deliveryDestinations) {
		return builder.routes()
				.route(r -> r.path("/deliveries/**").and().method("GET").uri(deliveryDestinations.getDeliveryServiceUrl()))
				.route(r -> r.path("/couriers/**").and().method("POST").uri(deliveryDestinations.getDeliveryServiceUrl()))
				.build();
	}
}
