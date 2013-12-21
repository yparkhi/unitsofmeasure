package org.jscience.demo.unit;

import static org.jscience.physics.unit.system.UCUM.FOOT_INTERNATIONAL;

import org.jscience.physics.quantity.Measurement;
import org.jscience.physics.quantity.AbstractMeasurement;
import org.jscience.physics.unit.system.SI;
import org.jscience.physics.unit.system.UCUM;
import org.unitsofmeasurement.quantity.Length;
import org.unitsofmeasurement.quantity.Mass;
import org.unitsofmeasurement.unit.Unit;



/**
 * @author Werner Keil
 * This is a back-port of UOMo HelloUnits to prove similar behavior, 
 * especially for Bugzilla item 338334  
 */
public class HelloUnits {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		AbstractMeasurement length = AbstractMeasurement.valueOf(10, SI.METRE);
//		LengthAmount length = new LengthAmount(10, SI.KILOGRAM); // this won't work ;-)
		
		System.out.println(length);
		Unit<Length> lenUnit =  length.getUnit();
		System.out.println(lenUnit);
		
		System.out.println(length.doubleValue(FOOT_INTERNATIONAL)); 
//		System.out.println(length.doubleValue(USCustomary.POUND)); // this won't work either.
//		UnitConverter footConverter = lenUnit.getConverterTo(NonSI.INCH);
		System.out.print(((Measurement<Length>)length).doubleValue(UCUM.INCH_INTERNATIONAL));
		System.out.println(" " + UCUM.INCH_INTERNATIONAL);
		
		Measurement<Mass> mass = AbstractMeasurement.valueOf(1000, SI.GRAM);
		AbstractMeasurement mass2 = AbstractMeasurement.valueOf(1, SI.KILOGRAM);
		System.out.println(mass.equals(mass2));
	}
}
