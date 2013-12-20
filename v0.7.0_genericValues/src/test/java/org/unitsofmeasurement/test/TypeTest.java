/**
 * 
 */
package org.unitsofmeasurement.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.unitsofmeasurement.Measurement;
import org.unitsofmeasurement.quantity.Length;
import org.unitsofmeasurement.test.unit.DistanceUnit;

/**
 * @author Werner Keil
 * @version 1.0, $Date$
 * 
 */
public class TypeTest {

	@Test
	public void testStringMeasurement() {
		Measurement<Length, String> length = new StringMeasurement<Length, String>(
				"Ten", DistanceUnit.m);
		assertEquals("Ten", length.value());
	}

}
