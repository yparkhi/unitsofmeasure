/**
 * The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 * and UCUM Specification are copyright © 1999-2010,
 * Regenstrief Institute, Inc. and the Unified Codes for Units of Measures
 * (UCUM) Organization. All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure;

import java.util.Map;

import org.unitsofmeasure.quantity.Dimensionless;
import org.unitsofmeasure.quantity.Mass;

/**
 * @author paul.morrison
 * 
 */
public abstract class AbstractUnit<Q extends Quantity<Q>> implements Unit<Q> {

    static final Unit<Dimensionless> ONE = null;

    // public static final Unit<Mass> METRIC_MASS = QuantityFactory.getInstance(
    // Mass.class).getMetricUnit();
    String symbol; // e.g. "A"
    String name; // e.g. "Angstrom"
    double multFactor; // e.g. 1E-10
    double addFactor = 0.0; // used for temperatures

    protected AbstractUnit() {

    }

    public AbstractUnit(String name, double factor) {
	this.name = name;
	this.multFactor = factor;
    }

    protected AbstractUnit(String name) {
	this(name, 0);
    }

    @Override
    public Unit<Q> add(double offset) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<?> alternate(String symbol) {
	// TODO Auto-generated method stub
	return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Quantity<T>> Unit<T> asType(Class<T> type)
	    throws ClassCastException {
	// Unit<T> metricUnit =
	// QuantityFactory.getInstance(type).getMetricUnit();
	// if ((metricUnit == null) || metricUnit.isCompatible(this))
	// return (Unit<T>) this;
	//	throw new ClassCastException("The unit: " + this //$NON-NLS-1$
	//		+ " is not of parameterized type " + type); //$NON-NLS-1$
	// // TODO use MsgFormat
	return null;
    }

    @Override
    public Unit<Q> divide(double divisor) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<?> divide(Unit<?> that) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public UnitConverter getConverterTo(Unit<Q> that)
	    throws UnconvertibleException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public UnitConverter getConverterToAny(Unit<?> that)
	    throws IncommensurableException, UnconvertibleException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Dimension getDimension() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public Map<Unit<?>, Integer> getProductUnits() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getSymbol() {
	return symbol;
    }

    @Override
    public Unit<?> inverse() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean isCompatible(Unit<?> that) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public Unit<Q> multiply(double factor) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<?> multiply(Unit<?> that) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<?> pow(int n) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Unit<?> root(int n) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public abstract Unit<Q> toMetric();

    @Override
    public Unit<Q> transform(UnitConverter operation) {
	// TODO Auto-generated method stub
	return null;
    }

    public double getMultFactor() {
	return multFactor;
    }
}
