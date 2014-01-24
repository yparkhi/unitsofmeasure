/**
 * 
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
		Temperature t =  new TemperatureQuantity(23.5, CELSIUS); // 23.0 °C
		assertEquals(Double.valueOf(23.5d), t.getValue());
		assertEquals(CELSIUS, t.getUnit());
		//assertEquals("km", l.getUnit().getSymbol());
	}
	
	@Test
	public void testToString() {
		Temperature t =  new TemperatureQuantity(23.5, CELSIUS); // 23.0 °C
		assertEquals("23.5°C", t.toString());
	}
}
