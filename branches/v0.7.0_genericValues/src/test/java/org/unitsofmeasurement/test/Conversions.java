/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test;

import org.unitsofmeasurement.test.quantity.DistanceQuantity;
import org.unitsofmeasurement.test.unit.DistanceUnit;

public class Conversions {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DistanceQuantity length = new DistanceQuantity(30, DistanceUnit.cm);
        System.out.println("Length = " + length);
        DistanceQuantity l1 = length.convert(DistanceUnit.m);
        System.out.println(l1);
        DistanceQuantity l2 = length.convert(DistanceUnit.km);
        System.out.println(l2);
        System.out.println(l2.showInUnits(DistanceUnit.cm, 2));
    }

}
