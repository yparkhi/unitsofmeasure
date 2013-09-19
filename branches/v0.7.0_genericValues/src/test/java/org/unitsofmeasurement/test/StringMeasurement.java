/**
 * 
 */
package org.unitsofmeasurement.test;

import org.unitsofmeasurement.Measurement;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.unit.Unit;

/**
 * @author Werner Keil
 * @version 1.1
 */
@SuppressWarnings("hiding")
public final class StringMeasurement<Q extends Quantity<Q>, String> implements
		Measurement<Q, String> {
	private String v;
	private Unit<Q> u;

	public StringMeasurement(String value, Unit<Q> unit) {
		this.v = value;
		this.u = unit;
	}

	public Measurement<Q, String> add(Measurement<Q, String> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<Q, String> substract(Measurement<Q, String> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<?, String> multiply(Measurement<?, String> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<?, String> multiply(String that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<?, String> divide(Measurement<?, String> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<? extends Measurement<Q, String>, String> inverse() {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<Q, String> to(Unit<Q> unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double doubleValue(Unit<Q> unit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue(Unit<Q> unit) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Unit<Q> unit() {
		return u;
	}

	@Override
	public String value() {
		return v;
	}

}
