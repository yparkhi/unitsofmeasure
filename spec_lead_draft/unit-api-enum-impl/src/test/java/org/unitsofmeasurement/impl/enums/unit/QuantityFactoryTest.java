/**
 * 
 */
package org.unitsofmeasurement.impl.enums.unit;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.enums.unit.DistanceUnit.KILOMETRE;
import static org.unitsofmeasurement.impl.enums.unit.TimeUnit.MINUTE;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Time;

import org.junit.Test;
import org.unitsofmeasurement.impl.enums.quantity.QuantityFactory;


/**
 * @author Werner Keil
 *
 */
public class QuantityFactoryTest {

	@Test
	public void testLength() {
		Length l =  QuantityFactory.getInstance(Length.class).apply(23.5, KILOMETRE); // 23.0 km
		assertEquals(Double.valueOf(23.5d), l.getValue());
		assertEquals(KILOMETRE, l.getUnit());
		assertEquals("km", l.getUnit().getSymbol());
	}

	
	@Test
	public void testTime() {
		Quantity<Time> t = QuantityFactory.getInstance(Time.class).apply(40, MINUTE); // 40 min
		assertEquals(Integer.valueOf(40), t.getValue());
		assertEquals(MINUTE, t.getUnit());
		assertEquals("m", t.getUnit().getSymbol());
		assertEquals("40 MINUTE", t.toString());
	}

}
