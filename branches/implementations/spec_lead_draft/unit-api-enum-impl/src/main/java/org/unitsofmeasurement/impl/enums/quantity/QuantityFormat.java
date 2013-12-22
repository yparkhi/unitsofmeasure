package org.unitsofmeasurement.impl.enums.quantity;


import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

import javax.measure.Quantity;
import javax.measure.function.UnitFormat;

/**
 * <p>
 * This abstract base class provides a simple interface for formatting and parsing
 * {@linkplain Quantity quantities}.
 * </p>
 *
 * @author <a href="mailto:werner.keil@gmail.com">Werner Keil</a>
 * @version 1.1
 */
public abstract class QuantityFormat extends Format implements UnitFormat {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8064128758619895542L;
	public static final String SPLIT_VALUE_DELIMITER = "/";

    @SuppressWarnings({ "rawtypes" })
	@Override
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        if (obj instanceof Quantity)
            return format( (Quantity)obj, toAppendTo, pos );
        else
            throw new IllegalArgumentException("Cannot format given Object as a Quantity");
    }

    /**
     * Formats a Quantity into a quantity string.
     * @param quantity a Quantity to be formatted into a quantity string.
     * @param toAppendTo the string buffer for the returning quantity string.
     * @param fieldPosition keeps track of the position of the field
     * within the returned string.
     * @return the string buffer passed in as toAppendTo, with formatted text appended.
     */
    public abstract StringBuffer format(@SuppressWarnings("rawtypes") Quantity quantity, StringBuffer toAppendTo,
                                        FieldPosition fieldPosition);

    /**
     * Parse a quantity string according to the given parse position.  For
     * example, a time text "10Kbps" will be parsed into a BitRateQuantity
     * equivalent of 10 Kbps.
     *
     * @param source  The quantity string to be parsed
     *
     * @param pos   On input, the position at which to start parsing; on
     *              output, the position at which parsing terminated, or the
     *              start position if the parse failed.
     *
     * @return      Quantity, or null if the input could not be parsed
     */
    @SuppressWarnings("rawtypes")
	public abstract Quantity parse(String source, ParsePosition pos);

    @Override
    public Object parseObject(String source, ParsePosition pos) {
        return parse(source, pos);
    }
}
