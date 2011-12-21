/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test;

import java.util.LinkedList;

import org.unitsofmeasurement.test.quantity.DistanceQuantity;
import org.unitsofmeasurement.test.unit.DistanceUnit;


/**
 * @author paul.morrison
 *
 *         To change this generated comment edit the template variable
 *         "typecomment": Window>Preferences>Java>Templates. To enable and
 *         disable the creation of type comments go to
 *         Window>Preferences>Java>Code Generation.
 */

public class CalcTripLength {

    public static void main(String[] argv)  {

        final DistanceUnit klik = new DistanceUnit("kilometre", DistanceUnit.km,
                1.0);

        LinkedList<TripLeg> trip = new LinkedList<TripLeg>();

        trip.add(new TripLeg("YKK", "NYC", new DistanceQuantity(1200.0, klik)));

        trip.add(new TripLeg("NYC", "LAX", new DistanceQuantity(5000.0, DistanceUnit.km)));

        DistanceQuantity totDist = new DistanceQuantity(0, klik);

        for (TripLeg t : trip) {

            totDist = totDist.add(t.getDist());
        }

        boolean b = totDist.eq(new DistanceQuantity(6200,klik));

        System.out.println(totDist.showInUnits(klik, 2));
        System.out.println(b ? "true" : "false");

    }

}
