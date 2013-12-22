/**
 * 
 */
package org.unitsofmeasurement.impl.unit;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.unit.DistanceUnit.KILOMETRE;

import javax.measure.quantity.Length;

import org.junit.Test;


/**
 * @author Werner Keil
 *
 */
public class QuantityFactoryTest {

	@Test
	public void testLength() {
		Length l =  QuantityFactory.getInstance(Length.class).create(23.5, KILOMETRE); // 23.0 km
		assertEquals(Double.valueOf(23.5d), l.getValue());
		assertEquals(KILOMETRE, l.getUnit());
	}

}
