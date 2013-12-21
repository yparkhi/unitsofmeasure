/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2013 - JScience (http://jscience.org/)
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.jscience.physics.unit;

import java.util.HashSet;
import java.util.Set;

import javolution.util.FastSet;

import org.unitsofmeasurement.unit.Dimension;
import org.unitsofmeasurement.unit.SystemOfUnits;
import org.unitsofmeasurement.unit.Unit;

/**
 * <p> An abstract base class for unit systems.</p>
 *
 * @author <a href="mailto:uomo@catmedia.us">Werner Keil</a>
 * @version 2.0, $Date: 2013-11-17 $
 */
public abstract class AbstractSystemOfUnits implements SystemOfUnits {
    /**
     * Holds the units.
     */
    protected final FastSet<Unit<?>> units = new FastSet<Unit<?>>();


	// ///////////////////
	// Collection View //
	// ///////////////////
    @Override
    public Set<? extends Unit<?>> getUnits() {
        return units.unmodifiable();
    }

    @Override
    public Set<? extends Unit<?>> getUnits(Dimension dimension) {
        final Set<Unit<?>> set = new FastSet<Unit<?>>();
        for (Unit<?> unit : this.getUnits()) {
            if (dimension.equals(unit.getDimension())) {
                set.add(unit);
            }
        }
        return set;
    }
	
	static class Helper {
		static Set<Unit<?>> getUnitsOfDimension(final Set<Unit<?>> units, 
				Dimension dimension) {
			if (dimension != null) {
				Set<Unit<?>>dimSet = new HashSet<Unit<?>>();
				for (Unit<?> u : units) {
					if (dimension.equals(u.getDimension())) {
						dimSet.add(u);
					}
				}
				return dimSet;
			}
			return null;
		}
	}
}
