package com.blackwaterpragmatic.converter;

import com.blackwaterpragmatic.constant.MeasurementScale;

public class MeasurementConverter {
	private double measurement = 0;
	private MeasurementScale from = MeasurementScale.CELSIUS;
	private MeasurementScale to = MeasurementScale.CELSIUS;

	public MeasurementConverter convert(final double measurement) {
		this.measurement = measurement;
		return this;
	}

	public MeasurementConverter from(final MeasurementScale from) {
		if (null != from) {
			this.from = from;
		}
		return this;
	}

	public MeasurementConverter to(final MeasurementScale to) {
		if (null != to) {
			this.to = to;
		}
		return this;
	}

	public double execute() {
		if (from.getMeasurementType() == to.getMeasurementType()) {
			final double result;
			switch (to) {
				case CELSIUS:
					result = convertToCelsius();
					break;
				case FAHRENHEIT:
					result = convertToFahrenheit();
					break;
				case KELVIN:
					result = convertToKelvin();
					break;
				default:
					throw new UnsupportedOperationException(String.format("%s conversion is currently unsupported", to));
			}
			return (double) Math.round(result * 100) / 100;
		} else {
			throw new UnsupportedOperationException(String.format("Cannot convert %s to %s", from.getMeasurementType(), to.getMeasurementType()));
		}
	}

	private double convertToKelvin() {
		switch (from) {
			case CELSIUS:
			case FAHRENHEIT:
				return convertToCelsius() + 273.15;
			default:
				return measurement;
		}
	}

	private double convertToFahrenheit() {
		switch (from) {
			case CELSIUS:
				return ((measurement * 9) / 5) + 32;
			case KELVIN:
				return (((measurement - 273.15) * 9) / 5) + 32;
			default:
				return measurement;
		}
	}

	private double convertToCelsius() {
		switch (from) {
			case FAHRENHEIT:
				return ((measurement - 32) * 5) / 9;
			case KELVIN:
				return measurement - 273.15;
			default:
				return measurement;
		}
	}
}
