package com.blackwaterpragmatic.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.blackwaterpragmatic.constant.MeasurementScale;

import org.junit.Test;

public class MeasurementConverterTest {

	@Test
	public void shouldConvertCelsiusToFahrenheit() {
		final double convertedTemp = new MeasurementConverter()
				.convert(100)
				.from(MeasurementScale.CELSIUS)
				.to(MeasurementScale.FAHRENHEIT)
				.execute();
		assertEquals(212, convertedTemp, 0.01);
	}

	@Test
	public void shouldConvertKelvinToFahrenheit() {
		final double convertedTemp = new MeasurementConverter()
				.convert(273.15)
				.from(MeasurementScale.KELVIN)
				.to(MeasurementScale.FAHRENHEIT)
				.execute();
		assertEquals(32, convertedTemp, 0.01);
	}

	@Test
	public void shouldConvertFahrenheitToFahrenheit() {
		final double convertedTemp = new MeasurementConverter()
				.convert(100)
				.from(MeasurementScale.FAHRENHEIT)
				.to(MeasurementScale.FAHRENHEIT)
				.execute();
		assertEquals(100, convertedTemp, 0.01);
	}

	@Test
	public void shouldConvertFahrenheitToCelsius() {
		final double convertedTemp = new MeasurementConverter()
				.convert(32)
				.from(MeasurementScale.FAHRENHEIT)
				.to(MeasurementScale.CELSIUS)
				.execute();
		assertEquals(0, convertedTemp, 0.01);
	}

	@Test
	public void shouldConvertKelvinToCelsius() {
		final double convertedTemp = new MeasurementConverter()
				.convert(273.15)
				.from(MeasurementScale.KELVIN)
				.to(MeasurementScale.CELSIUS)
				.execute();
		assertEquals(0, convertedTemp, 0.01);
	}

	@Test
	public void shouldConvertCelsiusToCelsius() {
		final double convertedTemp = new MeasurementConverter()
				.convert(0)
				.from(MeasurementScale.CELSIUS)
				.to(MeasurementScale.CELSIUS)
				.execute();
		assertEquals(0, convertedTemp, 0.01);
	}

	@Test
	public void shouldConvertFahrenheitToKelvin() {
		final double convertedTemp = new MeasurementConverter()
				.convert(32)
				.from(MeasurementScale.FAHRENHEIT)
				.to(MeasurementScale.KELVIN)
				.execute();
		assertEquals(273.15, convertedTemp, 0.01);
	}

	@Test
	public void shouldConvertKelvinToKelvin() {
		final double convertedTemp = new MeasurementConverter()
				.convert(0)
				.from(MeasurementScale.KELVIN)
				.to(MeasurementScale.KELVIN)
				.execute();
		assertEquals(0, convertedTemp, 0.01);
	}

	@Test
	public void shouldConvertCelsiusToKelvin() {
		final double convertedTemp = new MeasurementConverter()
				.convert(0.005)
				.from(MeasurementScale.CELSIUS)
				.to(MeasurementScale.KELVIN)
				.execute();
		assertEquals(273.15, convertedTemp, 0.01);
	}

	@Test
	public void shouldNotChangeFromToNull() {
		final double convertedTemp = new MeasurementConverter()
				.from(null)
				.execute();
		assertEquals(0, convertedTemp, 0.01);
	}

	@Test
	public void shouldNotChangeToToNull() {
		final double convertedTemp = new MeasurementConverter()
				.to(null)
				.execute();
		assertEquals(0, convertedTemp, 0.01);
	}

	@Test
	public void shouldConvertCentimeterToInch() {
		try {
			new MeasurementConverter()
					.convert(0)
					.from(MeasurementScale.CENTIMETER)
					.to(MeasurementScale.INCH)
					.execute();
			fail();
		} catch (final UnsupportedOperationException e) {
			assertEquals("INCH conversion is currently unsupported", e.getMessage());
		}
	}

	@Test
	public void shouldConvertInchToCentimeter() {
		try {
			new MeasurementConverter()
					.convert(0.005)
					.from(MeasurementScale.INCH)
					.to(MeasurementScale.CENTIMETER)
					.execute();
			fail();
		} catch (final UnsupportedOperationException e) {
			assertEquals("CENTIMETER conversion is currently unsupported", e.getMessage());
		}
	}

	@Test
	public void shouldNotConvertDisparateMeasurementTypes() {
		try {
			new MeasurementConverter()
					.convert(0.005)
					.from(MeasurementScale.INCH)
					.to(MeasurementScale.CELSIUS)
					.execute();
			fail();
		} catch (final UnsupportedOperationException e) {
			assertEquals("Cannot convert DISTANCE to TEMPERATURE", e.getMessage());
		}
	}
}
