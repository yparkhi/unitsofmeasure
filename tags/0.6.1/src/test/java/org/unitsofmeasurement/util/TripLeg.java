/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.util;
import org.unitsofmeasurement.quantity.DistanceQuantity;


//import org.eclipse.uomo.units.quantity.*;

/**
 * @author paul.morrison
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
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
