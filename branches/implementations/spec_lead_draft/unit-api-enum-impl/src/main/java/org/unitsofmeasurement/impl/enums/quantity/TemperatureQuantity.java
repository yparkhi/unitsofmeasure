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

import org.unitsofmeasurement.impl.enums.format.SimpleFormat;
import org.unitsofmeasurement.impl.enums.unit.TemperatureUnit;

import javax.measure.Measurement;
import javax.measure.Quantity;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.function.UnitConverter;
import javax.measure.quantity.Temperature;

/**
 * @author Werner Keil
 * @version 1.5, $Date: 2014-01-23 15:03:08 +0100 (Do, 23 Jän 2014) $
 */
public final class TemperatureQuantity extends AbstractQuantity<Temperature> 
  implements Temperature {
    private final Double scalar; // value in reference unit

    private final Double value; // value in unit (Unit unit)

    private final TemperatureUnit unit;

    public TemperatureQuantity(Double val, TemperatureUnit un) {
        value = val;
        unit = un;
        if (val!= null && un != null) {
        	scalar = val.doubleValue() * un.getFactor();
        } 
        else scalar = null;        
    }
    
    public TemperatureQuantity(Double val, Unit<Temperature> u) {
    	this(val, (TemperatureUnit)u);
    }

    @Override
    public boolean isZero() {
        return (value != null) && 0d==(value.doubleValue());
    }

    public TemperatureQuantity add(TemperatureQuantity d1) {
        final TemperatureQuantity dn = new TemperatureQuantity(Double.valueOf(
                this.value.doubleValue() + d1.value.doubleValue()),
        		this.unit);
        return dn;
    }

    public TemperatureQuantity subtract(TemperatureQuantity d1) {
    	final TemperatureQuantity dn = new TemperatureQuantity(
                this.value.doubleValue() - d1.value.doubleValue(), this.unit);
        return dn;
    }

    protected boolean eq(TemperatureQuantity dq) {
         return dq!=null && dq.getValue().equals(getValue()) && 
                 dq.getUnit().equals(getUnit()) &&
                 dq.getScalar().equals(getScalar());
    }

    boolean ne(TemperatureQuantity d1) {
        return ne((TemperatureQuantity) d1);
    }

    boolean gt(TemperatureQuantity d1) {
        return gt((TemperatureQuantity) d1);
    }

    public boolean lt(TemperatureQuantity d1) {
        return lt((TemperatureQuantity) d1);
    }

    public boolean ge(TemperatureQuantity d1) {
        return ge((TemperatureQuantity)d1);
    }

    public boolean le(TemperatureQuantity d1) {
        return le((TemperatureQuantity) d1);
    }

    public TemperatureQuantity divide(Double v) {
        return new TemperatureQuantity(value.doubleValue() / v.doubleValue(), 
                unit);
    }

    protected TemperatureQuantity convert(TemperatureUnit newUnit) {
        return new TemperatureQuantity(value.doubleValue() /  
                newUnit.getFactor(), newUnit);
    }

    @Override
    public Double getScalar() {
        return scalar;
    }

    @Override
    public String toString(boolean withUnit, boolean withSpace, int precision) {
        final StringBuilder sb = new StringBuilder();
    	sb.append(getValue());
    	if(withUnit) {
        	if(withSpace) sb.append(" ");
    		sb.append(getUnit().getSymbol());
    	}
    	return sb.toString();
    }

    @Override
    public String showInUnit(Unit<?> u, int precision, 
            SimpleFormat.Show showWith) {
        return showInUnit(u, value, precision, showWith);
    }

	@Override
	public Number getValue() {
		 return value;
	}

	@Override
	public Unit<Temperature> getUnit() {
		 return unit;
	}

	@Override
	public Measurement<Temperature, Number> add(
                Measurement<Temperature, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Temperature, Number> substract(
                Measurement<Temperature, Number> that) {
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
		return new TemperatureQuantity(value.doubleValue() * 
                        that.doubleValue(), unit);
	}

	@Override
	public Measurement<?, Number> divide(Measurement<?, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Temperature, Number> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Measurement#doubleValue(javax.measure.Unit)
	 */
	protected double doubleValue(Unit<Temperature> unit) {
		Unit<Temperature> myUnit = getUnit();
		try {
			UnitConverter converter = unit.getConverterTo(myUnit);
			return converter.convert(getValue().doubleValue());
		} catch (UnconvertibleException e) {
			throw e;
		} // catch (IncommensurableException e) {
		// throw new IllegalArgumentException(e.getMessage());
		// }
	}
	
	@Override
	public Quantity<Temperature> to(Unit<Temperature> unit) {
        if (this.unit.equals(unit)) {
            return this;
        }
        if (unit instanceof TemperatureUnit) {
//        	final TemperatureUnit asTU = (TemperatureUnit)unit;
//        	for (TemperatureUnit tu : TemperatureUnit.values()) {
//        		if (asTU.equals(tu)) {
//        			return new TemperatureQuantity( asTU)
//        		}
//        	}
        	return convert((TemperatureUnit)unit);
        } else {
        	throw new ArithmeticException("Cannot convert " + this.unit + " to " + unit);
        }
	}

	@Override
	public boolean eq(AbstractQuantity<Temperature> dq) {
		 return eq((TemperatureQuantity) dq);
	}

	@Override
	public Measurement<?, Number> divide(Number that) {
		return divide((Double)that);
	}
}
