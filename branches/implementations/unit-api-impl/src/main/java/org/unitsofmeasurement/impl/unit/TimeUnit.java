package org.unitsofmeasurement.impl.unit;

import org.unitsofmeasurement.impl.Multiplier;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.quantity.Time;
import org.unitsofmeasurement.unit.Dimension;
import org.unitsofmeasurement.unit.IncommensurableException;
import org.unitsofmeasurement.unit.UnconvertibleException;
import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.unit.UnitConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Werner Keil
 * @version 1.0 ($Revision: 133 $), $Date: 2010-10-29 17:17:07 +0100 (Fr, 29 Okt 2010) $
 */
public enum TimeUnit implements Unit<Time>, Multiplier {

    s("s", 1.0), // reference Unit
	m("m", 60),
    h("h", 60 * 60);

    private final String description;
    private final double multFactor;

    private TimeUnit(String d, double multF) {
        this.description = d;
        this.multFactor = multF;
    }

    public String getSymbol() {
        return description;
    }

    public double getMultFactor() {
        return multFactor;
    }

    @Override
	public Unit<Time> getSystemUnit() {
		return m;
    }

    @Override
    public Map<? extends Unit, Integer> getProductUnits() {
        Map<Unit<Time>, Integer> prodUnits = new HashMap<Unit<Time>, Integer>();
        prodUnits.put(h, Integer.valueOf(2));
        return prodUnits;
    }

    public static TimeUnit getBySymbol(String symbol) {
        if (h.name().equals(symbol)) {
            return h;
        }
        if (m.name().equals(symbol)) {
            return m;
        }
        return s;
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
    public Unit<?> alternate(String s) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
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

    @SuppressWarnings("rawtypes")
	@Override
    public <T extends Quantity<T>> Unit<T> asType(Class<T> tClass) {
        Unit<T> metricUnit = QuantityFactory.getInstance(tClass).getMetricUnit();
         if ((metricUnit == null) || metricUnit.isCompatible(this))
          return (Unit) this;
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
    public Unit<Time> add(double v) {
        return this;
    }
}