package org.unitsofmeasure.util;

import java.util.LinkedList;

import org.unitsofmeasure.DistanceUnit;
import org.unitsofmeasure.quantity.DistanceQuantity;

//import org.eclipse.uomo.units.SI;
//import org.eclipse.uomo.units.SI.*;
//import org.eclipse.uomo.units.quantity.*;
//import main.java.org.unitsofmeasure.Unit;
//import main.java.org.unitsofmeasure.quantity.Length;

/**
 * @author paul.morrison
 * 
 *         To change this generated comment edit the template variable
 *         "typecomment": Window>Preferences>Java>Templates. To enable and
 *         disable the creation of type comments go to
 *         Window>Preferences>Java>Code Generation.
 */

public class CalcTripLength {

	public static void main(String[] argv) {

		final DistanceUnit klik = new DistanceUnit("kilometre", DistanceUnit.km,
				1.0);

		LinkedList<TripLeg> trip = new LinkedList<TripLeg>();

		trip.add(new TripLeg("YKK", "NYC", new DistanceQuantity(1200.0, klik)));

		trip.add(new TripLeg("NYC", "LAX", new DistanceQuantity(5000.0, DistanceUnit.km)));

		DistanceQuantity totDist = new DistanceQuantity(0, klik);

		for (TripLeg t : trip) {

			totDist = totDist.add(t.getDist());
		}

		System.out.println(totDist.showInUnits(klik, 2));

	}

}
