/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.enums.quantity;

import org.unitsofmeasurement.impl.function.Multiplier;
import org.unitsofmeasurement.impl.function.SimpleFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.function.Nameable;

/**
 * @author Werner Keil
 * @version 1.10 ($Revision$), $Date$
 */
public abstract class AbstractQuantity<Q extends Quantity<Q>> implements Quantity<Q>,Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 859680039827023765L;

	public abstract Number getScalar();

//    public abstract Number getValue();
//
//    public abstract Unit<Q> getUnit();

    public abstract boolean eq(AbstractQuantity<Q> dq);

    public abstract boolean isZero();

    @SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object o) {
        if (o instanceof AbstractQuantity) {
            return eq((AbstractQuantity<Q>) o);
        }
        return false;
    }

    public abstract String toString(boolean withUnit, boolean withSpace, int precision);

    public String toString(boolean withUnit, boolean withSpace) {
        return toString(withUnit, withSpace, 0);
    }

    public String toString(boolean withSpace) {
        return toString(true, withSpace);
    }

    public String toString(int precision) {
        return toString(true, false, precision);
    }

    @Override
    public String toString() {
        return toString(false);
    }

    public abstract String showInUnit(Unit<?> u, int precision, SimpleFormat.Show show);

    protected String showInUnit(Unit<?> u, Number s, int precision, SimpleFormat.Show show, boolean withSpace) {
        if (u == null) {
            throw new IllegalArgumentException("Null unit not allowed!");  //$NON-NLS-1$
        }
        double result;
        if (u instanceof Multiplier) {
            result = s.doubleValue() / ((Multiplier)u).getMultFactor();
        } else {
            result = s.doubleValue();
        }

        String str = getStr(Double.valueOf(result), precision);

        switch (show) {
            case NAME:
                if (u instanceof Nameable) {
                    StringBuilder sb = new StringBuilder(str);
                    if (withSpace) sb.append(' ');
                    return sb.append(((Nameable)u).getName()).toString();
                }
                return str;
            default:
                StringBuilder sb = new StringBuilder(str);
                if (withSpace) sb.append(' ');
                return sb.append(u.getSymbol()).toString();
        }
    }
    
    protected String showInUnit(Unit<?> u, Double s, int precision, SimpleFormat.Show showItem) {
        return showInUnit(u, s, precision, showItem, true);
    }

    protected String showInUnit(Unit<?> u, BigDecimal s, int precision, SimpleFormat.Show showItem) {
        return showInUnit(u, s, precision, showItem, true);
    }

    /**
     *
     * @param u
     * @param precision number of decimal places
     * @return
     */
    public String showInUnit(Unit<?> u, int precision) {
        return showInUnit(u, precision, SimpleFormat.Show.SYMBOL);
    }

    protected String getStr(Number val, int precision) {
    	if (val instanceof BigDecimal) { //TODO for #JavaME disable that part
    		BigDecimal num = ((BigDecimal)val).setScale(precision, RoundingMode.HALF_UP);
    		String str = num.toString();
    		return str;
    	} return String.valueOf(val);
    }
}
