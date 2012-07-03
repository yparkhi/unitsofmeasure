package org.unitsofmeasurement.impl.quantity;

import org.unitsofmeasurement.impl.unit.SimpleFormat;
import org.unitsofmeasurement.impl.unit.TimeUnit;
import org.unitsofmeasurement.quantity.Time;
import org.unitsofmeasurement.unit.Unit;

import java.math.BigDecimal;

/**
 * @author Werner Keil
 * @version 1.1
 */
public class TimeQuantity extends DimensionQuantity<Time> {
    /**
	 * 
	 */
	private static final long serialVersionUID = -421330065304945228L;

	private final BigDecimal scalar; // value in reference unit

    private final BigDecimal value; // value in unit (Unit unit)

    private final TimeUnit unit;

//    TimeQuantity(){
//    }

    public TimeQuantity(BigDecimal val, TimeUnit un) {
        value = val;
        unit = un;
        if (val!= null && un != null) {
        	scalar = val.multiply(BigDecimal.valueOf(un.getMultFactor()));
        } 
        else scalar = null;        
    }

    @Override
    public boolean isZero() {
        return (value != null) && BigDecimal.ZERO.doubleValue()==(value.doubleValue());
    }

    public TimeQuantity add(TimeQuantity d1) {
        final TimeQuantity dn = new TimeQuantity(this.value.add(d1.value), this.unit);
        return dn;
    }

    public TimeQuantity subtract(TimeQuantity d1) {
    	final TimeQuantity dn = new TimeQuantity(this.value.subtract(d1.value), this.unit);
        return dn;
    }

    public boolean eq(TimeQuantity dq) {
         return dq!=null && dq.value().equals(value()) && dq.unit().equals(unit()) &&
                 dq.getScalar().equals(getScalar());
    }

    public boolean ne(TimeQuantity d1) {
        return ne((TimeQuantity) d1);
    }

    public boolean gt(TimeQuantity d1) {
        return gt((TimeQuantity) d1);
    }

    public boolean lt(TimeQuantity d1) {
        return lt((TimeQuantity) d1);
    }

    public boolean ge(TimeQuantity d1) {
        return ge((TimeQuantity)d1);
    }

    public boolean le(TimeQuantity d1) {
        return le((TimeQuantity) d1);
    }

    public TimeQuantity multiply(BigDecimal v) {
        return new TimeQuantity(value.multiply(v), unit);
    }

    public TimeQuantity divide(BigDecimal v) {
        return new TimeQuantity(value.divide(v), unit);
    }

    public TimeQuantity convert(TimeUnit newUnit) {
        return new TimeQuantity(value.divide(BigDecimal.valueOf(newUnit.getMultFactor())), newUnit);
    }

    @Override
    public Number getScalar() {
        return scalar;
    }

    @Override
    public boolean eq(@SuppressWarnings("rawtypes") DimensionQuantity dq) {
        return eq((TimeQuantity) dq);
    }

    @Override
    public String toString(boolean withUnit, boolean withSpace, int precision) {
        return null;
    }

    @Override
    public String showInUnit(Unit<?> u, int precision, SimpleFormat.Show showWith) {
        return showInUnit(u, value, precision, showWith);
    }

	@Override
	public Number value() {
		 return value;
	}

	@Override
	public Unit<Time> unit() {
		 return unit;
	}
}
