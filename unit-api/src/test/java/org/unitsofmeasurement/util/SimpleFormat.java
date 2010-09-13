/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.util;

import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.unitsofmeasurement.unit.AbstractUnit;
import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.unit.UnitConverter;

/**
 * <p>
 * This class provides the interface for formatting and parsing
 * {@link org.unitsofmeasurement.Unit units} according to the <a
 * href="http://unitsofmeasure.org/">Uniform Code for Units of Measure</a>
 * (UCUM).
 * </p>
 * 
 * <p>
 * For a technical/historical overview of this format please read <a
 * href="http://www.pubmedcentral.nih.gov/articlerender.fcgi?artid=61354"> Units
 * of Measure in Clinical Information Systems</a>.
 * </p>
 * 
 * <p>
 * As of revision 1.16, the BNF in the UCUM standard contains an <a
 * href="http://unitsofmeasure.org/ticket/4">error</a>. I've attempted to work
 * around the problem by modifying the BNF productions for &lt;Term&gt;. Once
 * the error in the standard is corrected, it may be necessary to modify the
 * productions in the UCUMParser.jj file to conform to the standard.
 * </p>
 * 
 * @author <a href="mailto:eric-r@northwestern.edu">Eric Russell</a>
 * @author <a href="mailto:jcp@catmedia.us">Werner Keil</a>
 * @version 1.2.2 ($Revision: 79 $), $Date: 2010-01-03 17:24:31 +0100 (So, 03
 *          Jän 2010) $
 */
public class SimpleFormat extends BaseFormat {
	/**
     *
     */
	private static final long serialVersionUID = -7753687108842507677L;

	private final Map<String, String> symbolMap = new HashMap<String, String>();

	private static final BaseFormat DEFAULT = new SimpleFormat();

	// /////////////////
	// Class methods //
	// /////////////////
	/** Returns the instance for formatting using "print" symbols */
	public static BaseFormat getPrintInstance() {
		return DEFAULT;
	}

	// /**
	// * Returns the instance for formatting and parsing using case sensitive
	// * symbols
	// */
	// public static SimpleFormat getCaseSensitiveInstance() {
	// return Parsing.DEFAULT_CS;
	// }

	/**
	 * Returns the instance for formatting and parsing using case insensitive
	 * symbols
	 */
	public static BaseFormat getStandardInstance() {
		return DEFAULT;
	}

	// ////////////////
	// Constructors //
	// ////////////////
	/**
	 * Base constructor.
	 */
	SimpleFormat() {
	}

	// //////////////
	// Formatting //
	// //////////////
	public Appendable format(Unit<?> unit, Appendable appendable)
			throws IOException {
		CharSequence symbol;
//		CharSequence annotation = null;
		// if (unit instanceof AnnotatedUnit<?>) {
		// AnnotatedUnit<?> annotatedUnit = (AnnotatedUnit<?>) unit;
		// unit = annotatedUnit.getActualUnit();
		// annotation = annotatedUnit.getAnnotation();
		// }
		String mapSymbol = symbolMap.get(unit);
		if (mapSymbol != null) {
			symbol = mapSymbol;
		} else {
			throw new IllegalArgumentException(
					"Symbol mapping for unit of type " + //$NON-NLS-1$
							unit.getClass().getName() + " has not been set " + //$NON-NLS-1$
							"(see UnitFormat.SymbolMap)"); //$NON-NLS-1$
		}

		appendable.append(symbol);
//		if (annotation != null && annotation.length() > 0) {
//			appendAnnotation(unit, symbol, annotation, appendable);
//		}

		return appendable;
	}

	void appendAnnotation(Unit<?> unit, CharSequence symbol,
			CharSequence annotation, Appendable appendable) throws IOException {
		appendable.append('{');
		appendable.append(annotation);
		appendable.append('}');
	}

	/**
	 * Formats the given converter to the given StringBuffer. This is similar to
	 * what {@link ConverterFormat} does, but there's no need to worry about
	 * operator precedence here, since UCUM only supports multiplication,
	 * division, and exponentiation and expressions are always evaluated left-
	 * to-right.
	 * 
	 * @param converter
	 *            the converter to be formatted
	 * @param continued
	 *            <code>true</code> if the converter expression should begin
	 *            with an operator, otherwise <code>false</code>. This will
	 *            always be true unless the unit being modified is equal to
	 *            Unit.ONE.
	 * @param buffer
	 *            the <code>StringBuffer</code> to append to. Contains the
	 *            already-formatted unit being modified by the given converter.
	 */
	void formatConverter(UnitConverter converter, boolean continued,
			StringBuffer buffer) {
		boolean unitIsExpression = ((buffer.indexOf(".") >= 0) || (buffer //$NON-NLS-1$
				.indexOf("/") >= 0)); //$NON-NLS-1$
		// Prefix prefix = symbolMap.getPrefixObject(converter);
		String prefix = "";
		if ((prefix != null) && (!unitIsExpression)) {
			buffer.insert(0, symbolMap.get(prefix));
		} else {
			throw new IllegalArgumentException(
					"Unable to format units (unsupported UnitConverter " //$NON-NLS-1$
							+ converter + ")"); //$NON-NLS-1$
		}
	}

	public Unit<?> parse(CharSequence csq, ParsePosition cursor)
			throws IllegalArgumentException {
	return AbstractUnit.ONE;
	}

    public Locale getLocale() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
