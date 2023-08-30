package com.jts.observ;

import io.micrometer.observation.Observation;
import io.micrometer.observation.Observation.Context;
import io.micrometer.observation.Observation.Event;
import io.micrometer.observation.ObservationHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MeasureApiPerformace implements ObservationHandler<Observation.Context> {

	@Override
	public void onStart(Context context) {
		log.info("Method execution started.");
		context.put("execution-time", System.currentTimeMillis());
	}

	@Override
	public void onStop(Context context) {
		long timeTaken = System.currentTimeMillis() - context.getOrDefault("execution-time", 0L);
		log.info("Method execution completd {} for name {}", timeTaken, context.getName());
	}

	@Override
	public void onError(Context context) {
		log.info("Error cuured while executing method.");
	}

	@Override
	public void onEvent(Event event, Context context) {
		ObservationHandler.super.onEvent(event, context);
	}

	@Override
	public void onScopeOpened(Context context) {
		ObservationHandler.super.onScopeOpened(context);
	}

	@Override
	public void onScopeClosed(Context context) {
		ObservationHandler.super.onScopeClosed(context);
	}

	@Override
	public boolean supportsContext(Context context) {
		return true;
	}

}
