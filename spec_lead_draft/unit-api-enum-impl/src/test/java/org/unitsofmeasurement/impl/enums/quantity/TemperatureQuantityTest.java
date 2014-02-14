package org.unitsofmeasurement.impl.enums.quantity;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.enums.unit.TemperatureUnit.*;

import javax.measure.Quantity;
import javax.measure.quantity.Temperature;

import org.junit.Ignore;
import org.junit.Test;

public class TemperatureQuantityTest {

	@Test
	public void testTemperatureQuantityDoubleTemperatureUnit() {
		Temperature t = new TemperatureQuantity(Double.valueOf(20d), CELSIUS);
		assertEquals(Double.valueOf(20d), t.getValue());
	}

	@Test
	@Ignore
	public void testTo() {
		TemperatureQuantity t = new TemperatureQuantity(Double.valueOf(30d), CELSIUS);
		Quantity<Temperature> t2 = t.to(FAHRENHEIT);
		assertEquals(Double.valueOf(20d), t2.getValue());
	}

}
