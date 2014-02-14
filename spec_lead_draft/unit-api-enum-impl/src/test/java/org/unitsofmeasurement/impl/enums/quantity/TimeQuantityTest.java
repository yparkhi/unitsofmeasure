package org.unitsofmeasurement.impl.enums.quantity;

import static org.junit.Assert.*;
import static org.unitsofmeasurement.impl.enums.unit.TimeUnit.*;

import javax.measure.Quantity;
import javax.measure.quantity.Time;

import org.junit.Test;

public class TimeQuantityTest {
	
	@Test
	public void testInstanciate() {
		Time t =  new TimeQuantity(23d, HOUR); // 23.0 h
		assertEquals(Double.valueOf(23.0d), t.getValue());
		assertEquals(HOUR, t.getUnit());
		//assertEquals("km", l.getUnit().getSymbol());
	}
	
	@Test
	public void testToString() {
		Time t =  new TimeQuantity(23.0d, MINUTE); // 23.0 min
		assertEquals("23.0m", t.toString());
	}
	
	@Test
	public void testTemperatureQuantityDoubleTemperatureUnit() {
		Time t = new TimeQuantity(Double.valueOf(20d), HOUR);
		assertEquals(Double.valueOf(20d), t.getValue());
	}

	@Test
	public void testTo() {
		TimeQuantity t = new TimeQuantity(Double.valueOf(30d), MINUTE);
		Quantity<Time> t2 = t.to(SECOND);
		assertEquals(Double.valueOf(1800), t2.getValue());
	}
}
