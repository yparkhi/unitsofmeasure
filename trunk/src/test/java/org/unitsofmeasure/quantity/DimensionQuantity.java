/**
 * The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 * and UCUM Specification are copyright © 1999-2010,
 * Regenstrief Institute, Inc. and the Unified Codes for Units of Measures
 * (UCUM) Organization. All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure.quantity;

import java.math.*;

import org.unitsofmeasure.AbstractUnit;
import org.unitsofmeasure.Quantity;
import org.unitsofmeasure.Unit;

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
