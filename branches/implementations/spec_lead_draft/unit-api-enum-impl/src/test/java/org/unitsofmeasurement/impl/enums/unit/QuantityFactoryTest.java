/**
 * 
 */
package org.unitsofmeasurement.impl.enums.unit;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.enums.unit.DistanceUnit.KILOMETRE;

import javax.measure.quantity.Length;

import org.junit.Test;
import org.unitsofmeasurement.impl.enums.unit.QuantityFactory;


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
