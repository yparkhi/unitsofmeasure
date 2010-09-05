/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.quantity;

import java.math.*;

import org.unitsofmeasurement.AbstractUnit;
import org.unitsofmeasurement.Unit;
import org.unitsofmeasurement.quantity.Quantity;

/**
 * @author paul.morrison
 */
class DimensionQuantity implements Quantity<DimensionQuantity> {
    protected double scalar; // value in reference units
    protected double units; // value in units (Unit unit)
    protected AbstractUnit<?> unit;

    public String toString() {

	return (new Double(units)).toString() + ' ' + unit.getName();
    }

    public String showInUnits(AbstractUnit<?> u, int precision) {
	double result = scalar / u.getMultFactor();

	String s = result == 1 ? "" : "s";
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

	return (str + exp + ' ' + u.getName() + s);

    }

    public Unit<?> getUnit() {
        return unit;
    }

}
