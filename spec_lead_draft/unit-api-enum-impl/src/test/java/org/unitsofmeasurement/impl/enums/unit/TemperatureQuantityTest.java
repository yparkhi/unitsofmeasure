/**
 * Copyright (c) 2014 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.enums.unit;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.enums.unit.TemperatureUnit.CELSIUS;
import javax.measure.quantity.Temperature;
import org.junit.Test;
import org.unitsofmeasurement.impl.enums.quantity.TemperatureQuantity;


/**
 * @author Werner Keil
 *
 */
public class TemperatureQuantityTest {

	@Test
	public void testInstanciate() {
		Temperature t =  new TemperatureQuantity(23.0, CELSIUS); // 23.0 °C
		assertEquals(Double.valueOf(23.0d), t.getValue());
		assertEquals(CELSIUS, t.getUnit());
		//assertEquals("km", l.getUnit().getSymbol());
	}
	
	@Test
	public void testToString() {
		Temperature t =  new TemperatureQuantity(23.0d, CELSIUS); // 23.0 °C
		assertEquals("23.0°C", t.toString());
	}
}
