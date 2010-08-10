package org.unitsofmeasure.util;
import org.unitsofmeasure.quantity.DistanceQuantity;


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
