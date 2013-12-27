/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.system;

import static org.unitsofmeasurement.impl.system.SI.METRES_PER_SECOND;

import javax.measure.SystemOfUnits;
import javax.measure.Unit;
import javax.measure.quantity.Velocity;

import org.unitsofmeasurement.impl.AbstractUnit;


public class CommonUnits extends AbstractSystemOfUnits {

	private CommonUnits() {
		
	}
	
	private static final CommonUnits INSTANCE = new CommonUnits();
	
	public String getName() {
		return "Common Units";
	}

	/**
	 * A unit of velocity expressing the number of international {@link #KILOMETRE
	 * kilometres} per {@link #HOUR hour} (abbreviation <code>kph</code>).
	 */
	public static final Unit<Velocity> KILOMETRES_PER_HOUR = addUnit(
			METRES_PER_SECOND.multiply(0.277778d)).asType(Velocity.class);
	
	/**
	 * Returns the unique instance of this class.
	 * 
	 * @return the Imperial instance.
	 */
	public static SystemOfUnits getInstance() {
		return INSTANCE;
	}
	
    /**
     * Adds a new unit not mapped to any specified quantity type.
     *
     * @param  unit the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends AbstractUnit<?>>  U addUnit(U unit) {
        INSTANCE.units.add(unit);
        return unit;
    }
    
	/**
	 * Adds a new named unit to the collection.
	 * 
	 * @param unit the unit being added.
	 * @param name the name of the unit.
	 * @return <code>unit</code>.
	 */
	@SuppressWarnings("unchecked")
	private static <U extends Unit<?>> U addUnit(U unit, String name) {
		if (name != null && unit instanceof AbstractUnit) {
			AbstractUnit<?> aUnit = (AbstractUnit<?>)unit;
			//aUnit.setName(name);
			INSTANCE.units.add(aUnit);
			return (U) aUnit;
		}
		INSTANCE.units.add(unit);
		return unit;
	}

}
