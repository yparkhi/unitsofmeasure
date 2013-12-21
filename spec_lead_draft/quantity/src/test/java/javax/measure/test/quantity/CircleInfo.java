/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.quantity;

import static javax.measure.test.unit.DistanceUnit.cm;

public class CircleInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DistanceQuantity radius = new DistanceQuantity(30, cm);
		System.out.println("Radius = " + radius);
		double mult = 2 * Math.PI;
		DistanceQuantity circumference = radius.multiply(mult);
		System.out.println("Circumference = " + circumference);
		AreaQuantity area = (radius.multiply(radius)).multiply(Math.PI);
		System.out.println("Area = " + area);
		// area.add(radius);
	}

}
