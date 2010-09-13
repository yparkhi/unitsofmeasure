/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

import java.math.*;

import org.unitsofmeasurement.unit.AbstractUnit;



/**
 * @author paul.morrison
 */
class DimensionQuantity  {
	protected double scalar; // value in reference units
	protected double units; // value in units (Unit unit)
	protected AbstractUnit unit;

	

	public Object add(DimensionQuantity dn, DimensionQuantity d1, DimensionQuantity d2, AbstractUnit<?> au) {
		if (d1.unit == d2.unit){
			dn.unit = d1.unit;
			dn.scalar = d1.scalar + d2.scalar;
			dn.units = d1.units + d2.units;			
		}
		else {
			dn.unit = au;
			dn.scalar = d1.scalar + d2.scalar;
			dn.units = dn.scalar;			
		}
		return dn;			
	}
	public Object subtract(DimensionQuantity dn, DimensionQuantity d1, DimensionQuantity d2, AbstractUnit<?> au) {
		if (d1.unit == d2.unit){
			dn.unit = d1.unit;
			dn.scalar = d1.scalar - d2.scalar;
			dn.units = d1.units - d2.units;			
		}
		else {
			dn.unit = au;
			dn.scalar = d1.scalar - d2.scalar;
			dn.units = dn.scalar;			
		}
		return dn;
			
	}
	
	
	public boolean eq(DimensionQuantity d1) {
		return (scalar == d1.scalar);
	}
	public boolean ne(DimensionQuantity d1) {
		return (scalar != d1.scalar);
	}
	public boolean gt(DimensionQuantity d1) {
		return (scalar > d1.scalar);
	}
	public boolean lt(DimensionQuantity d1) {
		return (scalar < d1.scalar);
	}
	public boolean ge(DimensionQuantity d1) {
		return (scalar >= d1.scalar);
	}
	public boolean le(DimensionQuantity d1) {
		return (scalar <= d1.scalar);
	}

	public String toString() {

		return (new Double(units)).toString() + ' ' + unit.getName();
	}

	String showInUnits(AbstractUnit<?> u, int precision) {
		double result = scalar / u.getMultFactor();
		
		String str = (new Double(result)).toString();
		char cs[] = str.toCharArray();
		int i = 0;
		while (i < cs.length && (cs[i] >= '0' && cs[i] <= '9' || cs[i] == '.'))
			i++;
		BigDecimal bd = new BigDecimal(new String(cs, 0, i));
		BigDecimal bd2 = bd.setScale(precision, RoundingMode.HALF_UP);
		str = bd2.toString();

		String exp = "";
		if (i < cs.length)
			exp = new String(cs, i, cs.length - i);

		return str + exp  + ' ' + u.getName();

	}
	

	

}
