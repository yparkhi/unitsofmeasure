/**
 * 
 */
package javax.measure.test;

import javax.measure.Measurement;
import javax.measure.Quantity;
import javax.measure.Unit;


/**
 * @author Werner Keil
 * @version 1.1
 */
@SuppressWarnings("hiding")
public final class TestMeasurement<Q extends Quantity<Q>, Number> implements
		Measurement<Q, Double> {

	private final Double val;
	private final Unit<Q> unit;
	
	public TestMeasurement(Double value, Unit<Q> unit) {
		this.val = value;
		this.unit = unit;
	}
	
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// public static final TestMeasurement of(Double value, Unit<Q> unit) {
	// return new TestMeasurement(value, unit);
	// }
	
	@Override
	public Unit<Q> getUnit() {
		return unit;
	}

	@Override
	public Double getValue() {
		return val;
	}

	@Override
	public Measurement<Q, Double> add(Measurement<Q, Double> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, Double> substract(Measurement<Q, Double> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Double> multiply(Measurement<?, Double> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Double> multiply(Double that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Double> divide(Measurement<?, Double> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, Double> to(Unit<Q> unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, Double> inverse() {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public double doubleValue(Unit<Q> unit) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public long longValue(Unit<Q> unit) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
