package org.unitsofmeasurement.impl.enums.unit;

import org.unitsofmeasurement.impl.enums.quantity.QuantityFactory;
import org.unitsofmeasurement.impl.function.Multiplier;

import java.util.HashMap;
import java.util.Map;

import javax.measure.Dimension;
import javax.measure.IncommensurableException;
import javax.measure.Quantity;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.function.UnitConverter;
import javax.measure.quantity.Time;

/**
 * @author Werner Keil
 * @version 1.2 ($Revision$), $Date$
 */
public enum TimeUnit implements Unit<Time>, Multiplier {

    SECOND("s", 1.0), // reference Unit
	MINUTE("m", 60),
    HOUR("h", 60 * 60);

    private final String symbol;
    private final double multFactor;

    private TimeUnit(String s, double multF) {
        this.symbol = s;
        this.multFactor = multF;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

	@Override
	public String getName() {
		return name();
	}
    
    public double getMultFactor() {
        return multFactor;
    }

    @Override
	public Unit<Time> getSystemUnit() {
		return SECOND;
    }

    @Override
    public Map<? extends Unit<?>, Integer> getProductUnits() {
        Map<Unit<Time>, Integer> prodUnits = new HashMap<Unit<Time>, Integer>();
        prodUnits.put(HOUR, Integer.valueOf(2));
        return prodUnits;
    }

    public static TimeUnit getBySymbol(String symbol) {
        if (HOUR.name().equals(symbol)) {
            return HOUR;
        }
        if (MINUTE.name().equals(symbol)) {
            return MINUTE;
        }
        return SECOND;
    }

    public UnitConverter getConverterTo(Unit<Time> that)
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
    public Unit<Time> alternate(String s) {
        return this;
    }

    public Dimension getDimension() {
        return SimpleDimension.INSTANCE;
    }

     public Unit<?> inverse() {
        return this;
    }

    @Override
    public Unit<Time> divide(double v) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

    @Override
    public Unit<?> divide(Unit<?> unit) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

    public boolean isCompatible(Unit<?> that) {
        if (that instanceof TimeUnit) return true;
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

    public Unit<Time> multiply(double factor) {
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

    public Unit<Time> transform(UnitConverter operation) {
        return this;
    }

    @Override
    public Unit<Time> shift(double v) {
        return this;
    }
}