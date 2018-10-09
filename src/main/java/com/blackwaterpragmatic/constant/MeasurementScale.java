package com.blackwaterpragmatic.constant;

import static com.blackwaterpragmatic.constant.MeasurementType.DISTANCE;
import static com.blackwaterpragmatic.constant.MeasurementType.TEMPERATURE;

public enum MeasurementScale {
	CENTIMETER(DISTANCE),
	INCH(DISTANCE),

	CELSIUS(TEMPERATURE),
	FAHRENHEIT(TEMPERATURE),
	KELVIN(TEMPERATURE);

	private MeasurementType measurementType;

	private MeasurementScale(final MeasurementType measurementType) {
		this.measurementType = measurementType;
	}

	public MeasurementType getMeasurementType() {
		return measurementType;
	}


}
