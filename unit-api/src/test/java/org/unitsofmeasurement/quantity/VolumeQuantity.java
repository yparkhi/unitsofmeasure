/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

import static org.unitsofmeasurement.VolumeUnit.REF_UNIT;

import org.unitsofmeasurement.AreaUnit;
import org.unitsofmeasurement.DistanceUnit;
import org.unitsofmeasurement.VolumeUnit;

/**
 * @author paul.morrison
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class VolumeQuantity extends DimensionQuantity {
	
	public VolumeQuantity(double val, VolumeUnit un) {
	    	      
		units = val;
		unit = un;
		scalar = val * unit.getMultFactor();
	}
	/*
	Volume(double val) {
	    
		units = val;
		unit = cumetre;   // reference Unit
		scalar = val;
		
	}
	*/
	public VolumeQuantity add(VolumeQuantity v1) {
		return new VolumeQuantity(scalar + 
		v1.scalar, REF_UNIT);
	} 

	
	public VolumeQuantity subtract(VolumeQuantity v1) {
		return new VolumeQuantity(scalar - 
		v1.scalar, REF_UNIT);
	} 
	
	public boolean eq(VolumeQuantity v1) {
		return (scalar == 
		  v1.scalar);
	} 
	public boolean ne(VolumeQuantity v1) {
		return (scalar != 
		  v1.scalar);
	} 
	public boolean gt(VolumeQuantity v1) {
		return (scalar >
		  v1.scalar);
	} 
	public boolean lt(VolumeQuantity v1) {
		return (scalar < 
		  v1.scalar);
	} 
	public boolean ge(VolumeQuantity v1) {
		return (scalar >= 
		  v1.scalar);
	} 
	public boolean le(VolumeQuantity v1) {
		return (scalar <= 
		  v1.scalar);
	} 
	
	public VolumeQuantity multiply(double v) {
		return new VolumeQuantity(scalar * v, REF_UNIT );
	}
	
	public VolumeQuantity divide(double v) {
		return new VolumeQuantity(scalar / v, REF_UNIT);
	}
	public AreaQuantity convert(AreaUnit newUnit){
		return new AreaQuantity(scalar / newUnit.getMultFactor(), newUnit);
	}
	// mixed type operations
	
	public AreaQuantity divide(DistanceQuantity d1) {
		return new AreaQuantity(scalar / 
		  d1.scalar, AreaUnit.REF_UNIT);
	}
	public DistanceQuantity divide(AreaQuantity a1) {
		return new DistanceQuantity(scalar /
		  a1.scalar, DistanceUnit.REF_UNIT);
	} 
	
	

}
