package com.jts.observ;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@Configuration
public class ObservationRegister {

	@Bean
	public ObservedAspect observedAOP(ObservationRegistry observationRegistry) {
		observationRegistry.observationConfig().observationHandler(new MeasureApiPerformace());
		return new ObservedAspect(observationRegistry);
	}
}
