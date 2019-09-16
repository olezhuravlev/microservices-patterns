package net.chrisrichardson.ftgo.restaurantservice.domain;

import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;

import com.ftgo.common.domain.CommonConfiguration;

@Configuration
@EntityScan
@Import({ TramEventsPublisherConfiguration.class, CommonConfiguration.class })
public class RestaurantServiceDomainConfiguration {
	@Bean
	public RestaurantService restaurantService(JpaRepositoryFactoryBean restaurantRepository) {
		return new RestaurantService((RestaurantRepository) restaurantRepository.getObject());
	}

	@Bean
	public JpaRepositoryFactoryBean<RestaurantRepository, Restaurant, Long> restaurantRepository() {
		return new JpaRepositoryFactoryBean<>(RestaurantRepository.class);
	}
}
