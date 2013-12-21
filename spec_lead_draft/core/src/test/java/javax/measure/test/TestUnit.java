/**
 * 
 */
package javax.measure.test;

import java.util.Map;

import javax.measure.Dimension;
import javax.measure.Unit;
import javax.measure.exception.IncommensurableException;
import javax.measure.exception.UnconvertibleException;
import javax.measure.function.UnitConverter;

/**
 * @author Werner
 *
 */
public enum TestUnit implements Unit {
	TEST;

	@Override
	public String getSymbol() {
		return name().substring(0, 1);
	}

	@Override
	public Dimension getDimension() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit getSystemUnit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getProductUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCompatible(Unit that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Unit asType(Class type) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterTo(Unit that)
			throws UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterToAny(Unit that)
			throws IncommensurableException, UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit alternate(String symbol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit transform(UnitConverter operation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit add(double offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit multiply(double factor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit multiply(Unit that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit divide(double divisor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit divide(Unit that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit root(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit pow(int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
