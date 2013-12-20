/**
 * 
 */
package org.unitsofmeasurement.test;

import java.math.BigDecimal;

import org.unitsofmeasurement.Measurement;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.unit.Unit;

/**
 * @author Werner Keil
 * @version 1.1
 */
@SuppressWarnings("hiding")
public final class TestMeasurement<Q extends Quantity<Q>, Number> implements
		Measurement<Q, BigDecimal> {

	private final BigDecimal val;
	private final Unit<Q> unit;
	
	public TestMeasurement(BigDecimal value, Unit<Q> unit) {
		this.val = value;
		this.unit = unit;
	}
	
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// public static final TestMeasurement of(BigDecimal value, Unit<Q> unit) {
	// return new TestMeasurement(value, unit);
	// }
	
	@Override
	public Unit<Q> unit() {
		return unit;
	}

	@Override
	public BigDecimal value() {
		return val;
	}

	@Override
	public Measurement<Q, BigDecimal> add(Measurement<Q, BigDecimal> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, BigDecimal> substract(Measurement<Q, BigDecimal> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, BigDecimal> multiply(Measurement<?, BigDecimal> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, BigDecimal> multiply(BigDecimal that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, BigDecimal> divide(Measurement<?, BigDecimal> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, BigDecimal> to(Unit<Q> unit) {
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
	public Measurement<? extends Measurement<Q, BigDecimal>, BigDecimal> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

}
