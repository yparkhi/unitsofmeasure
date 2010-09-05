/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

import static org.unitsofmeasurement.AreaUnit.sqmetre;
import static org.unitsofmeasurement.DistanceUnit.m;

import org.unitsofmeasurement.AreaUnit;
import org.unitsofmeasurement.VolumeUnit;

/**
 * @author paul.morrison
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class AreaQuantity extends DimensionQuantity {
		
	public AreaQuantity(double val, AreaUnit un) {
	    	      
		units = val;
		unit = un;
		scalar = val * unit.getMultFactor();
	}
	/*
	Area(double val) {
	    
		units = val;
		unit = sqmetre;   // reference Unit
		scalar = val;
		
	}
	*/
	
	public AreaQuantity add(AreaQuantity a1) {
		return new AreaQuantity(scalar + a1.scalar, sqmetre);
			} 

	
	public AreaQuantity subtract(AreaQuantity a1) {
		return new AreaQuantity(scalar - a1.scalar, sqmetre);
	} 	
	
	public boolean equals(AreaQuantity a1) {
		return (scalar ==  a1.scalar);
	}
	public boolean equals(Object a1) {
	    if (a1 instanceof AreaQuantity) {
		return equals((AreaQuantity) a1);
	    }
	    return false;
	}

	public boolean gt(AreaQuantity a1) {
		return (scalar >  a1.scalar);
	} 
	public boolean lt(AreaQuantity a1) {
		return (scalar <  a1.scalar);
	} 
	public boolean ge(AreaQuantity a1) {
		return (scalar >=  a1.scalar);
	} 
	public boolean le(AreaQuantity a1) {
		return (scalar <=  a1.scalar);
	} 
	
	public AreaQuantity multiply(double v) {
		return new AreaQuantity(scalar * v,  sqmetre);
	}
	
	public AreaQuantity divide(double v) {
		return new AreaQuantity(scalar / v, sqmetre);
	}
	
	// mixed type operations
	
	public DistanceQuantity divide(DistanceQuantity d1) {
		return new DistanceQuantity(scalar / 
		  d1.scalar, m);
	} 
	public VolumeQuantity multiply(DistanceQuantity d1) {
		return new VolumeQuantity(scalar * 
 d1.scalar, VolumeUnit.cumetre);
	} 
	public AreaQuantity convert(AreaUnit newUnit){
		return new AreaQuantity(scalar / newUnit.getMultFactor(), newUnit);
	}
}
