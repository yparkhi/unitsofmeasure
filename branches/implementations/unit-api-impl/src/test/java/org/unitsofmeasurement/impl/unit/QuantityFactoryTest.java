/**
 * 
 */
package org.unitsofmeasurement.impl.unit;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.unit.DistanceUnit.KILOMETRE;

import org.junit.Test;
import org.unitsofmeasurement.quantity.Length;

/**
 * @author Werner Keil
 *
 */
public class QuantityFactoryTest {

	@Test
	public void testLength() {
		Length l =  QuantityFactory.getInstance(Length.class).create(23.5, KILOMETRE); // 23.0 km
		assertEquals(Double.valueOf(23.5d), l.value());
		assertEquals(KILOMETRE, l.unit());
	}

}
