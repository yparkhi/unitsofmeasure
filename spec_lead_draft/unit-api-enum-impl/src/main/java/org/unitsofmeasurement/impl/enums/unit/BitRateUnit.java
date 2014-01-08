/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.enums.unit;

import static org.unitsofmeasurement.impl.enums.unit.Constants.*;

import org.unitsofmeasurement.impl.enums.DescriptiveEnum;
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
import javax.measure.quantity.InformationRate;

/**
 * Implements the speed of data-transmission. The system unit for this quantity is "bit/s" (bit per second).
 * @author Werner Keil
 * @version 1.8 ($Revision$), $Date$
 */
public enum BitRateUnit implements Unit<InformationRate>, Multiplier, DescriptiveEnum<BitRateUnit> {
	bps("bps", BPS_NAME, 1.0), Kbps("Kbps", KBPS_NAME, 1.0e3), Mbps("Mbps", MBPS_NAME, 1.0e6),
    Gbps("Gbps", GBPS_NAME, 1.0e9), Tbps("Tbps", TBPS_NAME, 1.0e12), Pbps("Pbps", PBPS_NAME, 1.0e15), Ebps("Ebps", EBPS_NAME, 1.0e18),
    K("K", KBPS_NAME, 1.0e3), M("M", MBPS_NAME, 1.0e6), G("G", GBPS_NAME, 1.0e9), T("T", TBPS_NAME, 1.0e12), P("P", PBPS_NAME, 1.0e15),
    E("E", EBPS_NAME, 1.0e18), // aliases
    NOUNIT("", "", 0);

	private final String symbol;
    private final String description;
    private final double multFactor;

    private BitRateUnit(final String symbol, final String name, double multF) {
        this.symbol = symbol;
    	this.description = name;
        this.multFactor = multF;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    public double getMultFactor() {
        return multFactor;
    }

    @Override
	public Unit<InformationRate> getSystemUnit() {
		return bps;
    }

	@Override
	public String getName() {
		return name();
	}
	
    public static BitRateUnit getBySymbol(String symbol) {
        for (BitRateUnit b : values()) {
            if (b.getSymbol().equalsIgnoreCase(symbol)) return b;
        }
        return bps;
    }

    @Override
    public Map<Unit<?>, Integer> getProductUnits() {
        Map<Unit<?>, Integer> prodUnits = new HashMap<Unit<?>, Integer>();
        prodUnits.put(Kbps, Integer.valueOf(3));
        prodUnits.put(Mbps, Integer.valueOf(6));
        prodUnits.put(Gbps, Integer.valueOf(9));
        prodUnits.put(Tbps, Integer.valueOf(12));
        prodUnits.put(Pbps, Integer.valueOf(15));
        prodUnits.put(Ebps, Integer.valueOf(18));
        return prodUnits;
    }

    @Override
    public Unit<InformationRate> add(double offset) {
        return this;
    }

    @Override
    public Unit<InformationRate> alternate(String symbol) {
        if (Kbps.name().equals(symbol))
            return K;
        if (Mbps.name().equals(symbol))
            return M;
        if (Gbps.name().equals(symbol))
            return G;
        if (Tbps.name().equals(symbol))
            return T;
        if (Pbps.name().equals(symbol))
            return P;
        if (Ebps.name().equals(symbol))
            return E;

        // and reverse
        if (K.name().equals(symbol))
            return Kbps;
        if (M.name().equals(symbol))
            return Mbps;
        if (G.name().equals(symbol))
            return Gbps;
        if (T.name().equals(symbol))
            return Tbps;
        if (P.name().equals(symbol))
            return Pbps;
        if (E.name().equals(symbol))
            return Ebps;

        return this;
    }

    @SuppressWarnings("unchecked")
	@Override
    public <T extends Quantity<T>> Unit<T> asType(Class<T> type)
            throws ClassCastException {
        Unit<T> metricUnit = QuantityFactory.getInstance(type).getMetricUnit();
        if ((metricUnit == null) || metricUnit.isCompatible(this))
         return (Unit<T>) this;
          throw new ClassCastException("The unit: " + this //$NON-NLS-1$
              + " is not of parameterized type " + type); //$NON-NLS-1$
    }

    @Override
    public Unit<InformationRate> divide(double divisor) {
        return this;
    }

    public Unit<?> divide(Unit<?> that) {
        return this;
    }

    public UnitConverter getConverterTo(Unit<InformationRate> that)
            throws UnconvertibleException {
        // currently unused
        return null;
    }

    public UnitConverter getConverterToAny(Unit<?> that)
            throws IncommensurableException, UnconvertibleException {
        // currently unused
        return null;
    }

    public Dimension getDimension() {
        return SimpleDimension.INSTANCE;
    }

     public Unit<?> inverse() {
        return this;
    }

    public boolean isCompatible(Unit<?> that) {
        if (that instanceof BitRateUnit) return true;
        return false;
    }

    public Unit<InformationRate> multiply(double factor) {
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

    public Unit<InformationRate> transform(UnitConverter operation) {
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DescriptiveEnum<BitRateUnit>[] iValues() {
		return BitRateUnit.values();
	}
}
