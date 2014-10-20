package org.jscience.demo.unit;

import org.jscience.physics.unit.system.*;
import org.unitsofmeasurement.quantity.Velocity;
import org.unitsofmeasurement.unit.Unit;


public class UnitDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unit<Velocity> kmh = SIPrefix.KILO(SI.METRE).divide(UCUM.HOUR).asType(Velocity.class);
//		Unit<Velocity> kmh2 = SIPrefix.KILO(SI.METRE).multiply(UCUM.HOUR).asType(Velocity.class);
		Unit<?> kmh3 = SIPrefix.KILO(SI.METRE).multiply(UCUM.HOUR);
		
		System.out.println(kmh);
//		System.out.println(kmh2);
		System.out.println(kmh3);
	}

}
