/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test;

import org.unitsofmeasurement.test.quantity.DistanceQuantity;


/**
 * @author paul.morrison
 */
public class TripLeg {

    String fromAirport;
    String toAirport;
    DistanceQuantity distance;

    public TripLeg(String fA, String tA, DistanceQuantity dist) {
        fromAirport = fA;
        toAirport = tA;
        distance = dist;
    }

    public DistanceQuantity getDist() {
        return distance;
    }
}
