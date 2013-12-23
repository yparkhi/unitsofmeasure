/**
 *
 */
package org.unitsofmeasurement.impl.enums.quantity;

import org.unitsofmeasurement.impl.enums.unit.SimpleFormat;
import org.unitsofmeasurement.impl.util.Multiplier;
import org.unitsofmeasurement.impl.util.Nameable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * @author Werner Keil
 * @version 1.8 ($Revision$), $Date$
 */
public abstract class DimensionQuantity<Q extends Quantity<Q>> implements Quantity<Q>,Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 859680039827023765L;

	public abstract Number getScalar();

//    public abstract Number getValue();
//
//    public abstract Unit<Q> getUnit();

    public abstract boolean eq(DimensionQuantity<Q> dq);

    public abstract boolean isZero();

    @SuppressWarnings("unchecked")
	@Override
    public boolean equals(Object o) {
        if (o instanceof DimensionQuantity) {
            return eq((DimensionQuantity<Q>) o);
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

        String str = getStr(BigDecimal.valueOf(result), precision);

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

    protected String getStr(BigDecimal val, int precision) {
        BigDecimal bd2 = val.setScale(precision, RoundingMode.HALF_UP);
        String str = bd2.toString();
        return str;
    }
}
