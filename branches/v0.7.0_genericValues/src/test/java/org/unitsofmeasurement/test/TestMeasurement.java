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
 * 
 */
public class TestMeasurement<Q extends Quantity<Q>> implements
		Measurement<Q, BigDecimal> {


	public Measurement<Q, BigDecimal> add(Measurement<Q, BigDecimal> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<Q, BigDecimal> substract(Measurement<Q, BigDecimal> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<?, BigDecimal> multiply(Measurement<?, BigDecimal> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<?, BigDecimal> multiply(BigDecimal that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<?, BigDecimal> divide(Measurement<?, BigDecimal> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<? extends Measurement<Q, BigDecimal>, BigDecimal> inverse() {
		// TODO Auto-generated method stub
		return null;
	}


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
	public Unit<Q> unit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal value() {
		// TODO Auto-generated method stub
		return null;
	}

}
