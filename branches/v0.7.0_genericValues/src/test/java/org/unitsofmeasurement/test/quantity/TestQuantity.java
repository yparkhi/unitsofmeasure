package org.unitsofmeasurement.test.quantity;

import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.test.unit.TestUnit;
import org.unitsofmeasurement.unit.Unit;

public abstract class TestQuantity<V> implements Quantity<TestQuantity<V>, V> {
	protected TestUnit<TestQuantity<V>, V> unit;

	@Override
	public V value() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit<TestQuantity<V>, V> unit() {
		// TODO Auto-generated method stub
		return unit;
	}

}
