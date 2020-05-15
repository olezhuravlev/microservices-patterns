package com.ftgo.apigateway.service.accounting;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The configuration class to instantiate the routing rules for the accounting service.
 * 
 * @author  Wuyi Chen
 * @date    05/15/2020
 * @version 1.0
 * @since   1.0
 */
@Configuration
@EnableConfigurationProperties(AccountingDestinations.class)
public class AccountingConfiguration {
	@Bean
	public RouteLocator accountingProxyRouting(RouteLocatorBuilder builder, AccountingDestinations accoutingDestinations) {
		return builder.routes()
				.route(r -> r.path("/accounts/**").and().method("GET").uri(accoutingDestinations.getAccountingServiceUrl()))
				.build();
	}
}
