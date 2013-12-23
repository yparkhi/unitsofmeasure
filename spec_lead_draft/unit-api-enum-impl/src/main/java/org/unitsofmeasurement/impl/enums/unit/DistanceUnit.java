/**
 *
 */
package org.unitsofmeasurement.impl.enums.unit;

import org.unitsofmeasurement.impl.enums.LongNameEnum;
import org.unitsofmeasurement.impl.enums.quantity.QuantityFactory;
import org.unitsofmeasurement.impl.util.Multiplier;

import java.util.HashMap;
import java.util.Map;

import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.exception.IncommensurableException;
import javax.measure.exception.UnconvertibleException;
import javax.measure.function.UnitConverter;
import javax.measure.quantity.Length;

/**
 * @author Werner Keil
 * @version 1.3 ($Revision: 17458 $), $Date: 2011-07-16 17:07:12 +0530 (Sat, 16 Jul 2011) $
 */
public enum DistanceUnit implements Unit<Length>, Multiplier, LongNameEnum<DistanceUnit> {
    METRE("m", "m", 1.0), // reference Unit
	KILOMETRE("km", "km", 1.0e3);

    private final String symbol;
    private final String description;
    private final double multFactor;

    private DistanceUnit(final String symbol, final String name, double multF) {
        this.symbol = symbol;
    	this.description = name;
        this.multFactor = multF;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getMultFactor() {
        return multFactor;
    }

    @Override
	public Unit<Length> getSystemUnit() {
		return METRE;
    }

    @Override
    public Map<? extends Unit<Length>, Integer> getProductUnits() {
        Map<Unit<Length>, Integer> prodUnits = new HashMap<Unit<Length>, Integer>();
        prodUnits.put(KILOMETRE, Integer.valueOf(3));
        return prodUnits;
    }

    public static DistanceUnit getBySymbol(String symbol) {
        if (KILOMETRE.getSymbol().equals(symbol)) {
            return KILOMETRE;
        }
        return METRE;
    }

    public UnitConverter getConverterTo(Unit<Length> that)
            throws UnconvertibleException {
        // currently unused
        return null;
    }

    public UnitConverter getConverterToAny(Unit<?> that)
            throws IncommensurableException, UnconvertibleException {
        // currently unused
        return null;
    }

    @Override
    public Unit<Length> alternate(String s) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

    public Dimension getDimension() {
        return SimpleDimension.INSTANCE;
    }

     public Unit<?> inverse() {
        return this;
    }

    @Override
    public Unit<Length> divide(double v) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

    @Override
    public Unit<?> divide(Unit<?> unit) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

    public boolean isCompatible(Unit<?> that) {
        if (that instanceof DistanceUnit) return true;
        return false;
    }

    @SuppressWarnings("unchecked")
	@Override
    public <T extends Quantity<T>> Unit<T> asType(Class<T> tClass) {
        Unit<T> metricUnit = QuantityFactory.getInstance(tClass).getMetricUnit();
         if ((metricUnit == null) || metricUnit.isCompatible(this))
          return (Unit<T>) this;
           throw new ClassCastException("The unit: " + this //$NON-NLS-1$
               + " is not of parameterized type " + tClass); //$NON-NLS-1$
    }

    public Unit<Length> multiply(double factor) {
        return this;
    }

    public Unit<?> multiply(Unit<?> that) {
        return this;
    }

    public Unit<?> pow(int n) {
        return this;
    }

    public Unit<?> root(int n) {
        return this;
    }

    public Unit<Length> transform(UnitConverter operation) {
        return this;
    }

    @Override
    public Unit<Length> add(double v) {
        return this;
    }

	@Override
	public String longName() {
		return description;
	}

	@Override
	public LongNameEnum<DistanceUnit>[] iValues() {
		return DistanceUnit.values();
	}
}
