/**
 * 
 */
package org.jscience.demo.quantity;

import static org.jscience.physics.unit.system.SI.KILOGRAM;
import static org.jscience.physics.unit.system.SI.SECOND;
import static org.jscience.physics.unit.system.SIPrefix.MILLI;

import org.jscience.physics.quantity.QuantityFactory;
import org.unitsofmeasurement.quantity.Mass;
import org.unitsofmeasurement.quantity.Time;

/**
 * @author Werner Keil
 *
 */
public class FactoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Mass m = QuantityFactory.getInstance(Mass.class).create(23.0, KILOGRAM); // 23.0 kg
		 Time t = QuantityFactory.getInstance(Time.class).create(124, MILLI(SECOND)); // 124 ms
		 
		 System.out.println(m);
		 System.out.println(t);
	}
}
