/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2011, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.test.unit;

import org.unitsofmeasurement.quantity.Dimensionless;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.unit.Unit;

/**
 * @author paul.morrison
 * @param <V>
 * 
 */
public abstract class TestUnit<Q extends Quantity<Q, V>, V> implements
		Unit<Q, V> {

	public static final Unit<Dimensionless, Number> ONE = (Unit<Dimensionless, Number>) new BaseUnit<Dimensionless>(
			"one");

	// public static final Unit<Mass> METRIC_MASS = QuantityFactory.getInstance(
	// Mass.class).getMetricUnit();

	protected String symbol; // e.g. "A"
	protected String name; // e.g. "Angstrom"

	public String getName() {
		return name;
	}

	double multFactor; // e.g. 1E-10
	double addFactor = 0.0; // used for temperatures

	protected TestUnit() {

	}

	public TestUnit(String name, double factor) {
		this.name = name;
		this.multFactor = factor;
	}

	protected TestUnit(String name) {
		this(name, 0);
	}

	public double getMultFactor() {
		return multFactor;
	}

	@Override
	public String toString() {
		return getName();
	}
}
