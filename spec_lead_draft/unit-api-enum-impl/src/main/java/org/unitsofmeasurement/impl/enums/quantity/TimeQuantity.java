/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2014, Jean-Marie Dautelle, Werner Keil, V2COM and individual
 *  contributors by the @author tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.unitsofmeasurement.impl.enums.quantity;

import org.unitsofmeasurement.impl.enums.unit.TimeUnit;
import org.unitsofmeasurement.impl.format.SimpleFormat;

import javax.measure.Measurement;
import javax.measure.Unit;
import javax.measure.quantity.Time;

/**
 * @author Werner Keil
 * @version 1.4, $Date$
 */
public class TimeQuantity extends AbstractQuantity<Time> {
    /**
	 * 
	 */
	private static final long serialVersionUID = -421330065304945228L;

	private final Double scalar; // value in reference unit

    private final Double value; // value in unit (Unit unit)

    private final TimeUnit unit;

//    TimeQuantity(){
//    }

    public TimeQuantity(Double val, TimeUnit un) {
        value = val;
        unit = un;
        if (val!= null && un != null) {
        	scalar = val.doubleValue() * un.getMultFactor();
        } 
        else scalar = null;        
    }

    @Override
    public boolean isZero() {
        return (value != null) && 0d==(value.doubleValue());
    }

    public TimeQuantity add(TimeQuantity d1) {
        final TimeQuantity dn = new TimeQuantity(Double.valueOf(this.value.doubleValue() + d1.value.doubleValue()),
        		this.unit);
        return dn;
    }

    public TimeQuantity subtract(TimeQuantity d1) {
    	final TimeQuantity dn = new TimeQuantity(this.value.doubleValue() - d1.value.doubleValue(), this.unit);
        return dn;
    }

    public boolean eq(TimeQuantity dq) {
         return dq!=null && dq.getValue().equals(getValue()) && dq.getUnit().equals(getUnit()) &&
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

    public TimeQuantity divide(Double v) {
        return new TimeQuantity(value.doubleValue() / v.doubleValue(), unit);
    }

    public TimeQuantity convert(TimeUnit newUnit) {
        return new TimeQuantity(value.doubleValue() /  newUnit.getMultFactor(), newUnit);
    }

    @Override
    public Number getScalar() {
        return scalar;
    }

    @Override
    public String toString(boolean withUnit, boolean withSpace, int precision) {
        final StringBuilder sb = new StringBuilder();
    	if(withUnit) sb.append(getUnit());
    	if(withSpace) sb.append(" ");
    	sb.append(getValue());
    	return sb.toString();
    }

    @Override
    public String showInUnit(Unit<?> u, int precision, SimpleFormat.Show showWith) {
        return showInUnit(u, value, precision, showWith);
    }

	@Override
	public Number getValue() {
		 return value;
	}

	@Override
	public Unit<Time> getUnit() {
		 return unit;
	}

	@Override
	public Measurement<Time, Number> add(Measurement<Time, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Time, Number> substract(Measurement<Time, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Number> multiply(Measurement<?, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Number> multiply(Number that) {
		return new TimeQuantity(value.doubleValue() * that.doubleValue(), unit);
	}

	@Override
	public Measurement<?, Number> divide(Measurement<?, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Time, Number> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Time, Number> to(Unit<Time> unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eq(AbstractQuantity<Time> dq) {
		 return eq((TimeQuantity) dq);
	}

	@Override
	public Measurement<?, Number> divide(Number that) {
		// TODO Auto-generated method stub
		return null;
	}
}
