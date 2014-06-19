package org.jscience.demo.unit;

import static org.jscience.physics.unit.system.SI.*;
import static org.jscience.physics.unit.system.UCUM.*;

import org.jscience.physics.quantity.Measurement;
import org.jscience.physics.quantity.PhysicsMeasurement;
import org.jscience.physics.quantity.QuantityFactory;
import org.jscience.physics.unit.PhysicsUnit;
import org.unitsofmeasurement.quantity.Mass;
import org.unitsofmeasurement.unit.Unit;

public class UCUMDemo {

	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit =  ATOMIC_MASS_UNIT;
		System.out.println(atomicMassUnit);
		
		Mass mass = QuantityFactory.getInstance(Mass.class).create(10, atomicMassUnit);
		System.out.println(mass);
		
//		Measurement<Mass> massInKg = mass.to(KILOGRAM);
//		System.out.println(massInKg);
	}

}
