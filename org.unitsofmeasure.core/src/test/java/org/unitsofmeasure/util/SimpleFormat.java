/**
 * The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 * and UCUM Specification are copyright © 1999-2010,
 * Regenstrief Institute, Inc. and the Unified Codes for Units of Measures
 * (UCUM) Organization. All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure.util;

import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Map;

import org.unitsofmeasure.AbstractUnit;
import org.unitsofmeasure.Unit;
import org.unitsofmeasure.UnitConverter;

/**
 * <p>
 * This class provides the interface for formatting and parsing
 * {@link javax.measure.unit.Unit units} according to the <a
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
 * @author <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
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
		CharSequence annotation = null;
		// if (unit instanceof AnnotatedUnit<?>) {
		// AnnotatedUnit<?> annotatedUnit = (AnnotatedUnit<?>) unit;
		// unit = annotatedUnit.getActualUnit();
		// annotation = annotatedUnit.getAnnotation();
		// }
		String mapSymbol = symbolMap.get(unit);
		if (mapSymbol != null) {
			symbol = mapSymbol;
			// } else if (unit instanceof ProductUnit<?>) {
			// ProductUnit<?> productUnit = (ProductUnit<?>) unit;
			// StringBuffer app = new StringBuffer();
			// for (int i = 0; i < productUnit.getUnitCount(); i++) {
			// if (productUnit.getUnitRoot(i) != 1) {
			// throw new IllegalArgumentException(
			//			    "Unable to format units in UCUM (fractional powers not supported)"); //$NON-NLS-1$
			// }
			// StringBuffer temp = new StringBuffer();
			// temp = (StringBuffer) format(productUnit.getUnit(i), temp);
			//		if ((temp.indexOf(".") >= 0) || (temp.indexOf("/") >= 0)) { //$NON-NLS-1$ //$NON-NLS-2$
			// temp.insert(0, '(');
			// temp.append(')');
			// }
			// int pow = productUnit.getUnitPow(i);
			// if (i > 0) {
			// if (pow >= 0) {
			// app.append('.');
			// } else if (i < (productUnit.getUnitCount() - 1)) {
			// app.append('.');
			// } else {
			// app.append('/');
			// pow = -pow;
			// }
			// } else if (pow < 0) {
			// app.append('/');
			// pow = -pow;
			// }
			// app.append(temp);
			// if (pow != 1) {
			// app.append(Integer.toString(pow));
			// }
			// }
			// symbol = app;
			// } else if ((unit instanceof TransformedUnit<?>)
			// || unit.equals(MetricSystem.KILOGRAM)) {
			// StringBuffer temp = new StringBuffer();
			// UnitConverter converter;
			// boolean printSeparator;
			// if (unit.equals(MetricSystem.KILOGRAM)) {
			// // A special case because KILOGRAM is a BaseUnit instead of
			// // a transformed unit, for compatability with existing SI
			// // unit system.
			// temp = format(UCUM.GRAM, temp, new FieldPosition(0));
			// converter = Prefix.KILO.getConverter();
			// printSeparator = true;
			// } else {
			// TransformedUnit<?> transformedUnit = (TransformedUnit<?>) unit;
			// Unit<?> parentUnits = transformedUnit.getParentUnit();
			// converter = transformedUnit.toParentUnit();
			// if (parentUnits.equals(MetricSystem.KILOGRAM)) {
			// // More special-case hackery to work around gram/kilogram
			// // incosistency
			// parentUnits = GRAM;
			// converter = converter.concatenate(Prefix.KILO
			// .getConverter());
			// }
			// temp = format(parentUnits, temp, new FieldPosition(0));
			// printSeparator = !parentUnits.equals(Unit.ONE);
			// }
			// formatConverter(converter, printSeparator, temp);
			// symbol = temp;
			// } else if (unit instanceof BaseUnit<?>) {
			// symbol = ((BaseUnit<?>) unit).getSymbol();
			// } else if (unit instanceof AlternateUnit<?>) {
			// symbol = ((AlternateUnit<?>) unit).getSymbol();
		} else {
			throw new IllegalArgumentException(
					"Symbol mapping for unit of type " + //$NON-NLS-1$
							unit.getClass().getName() + " has not been set " + //$NON-NLS-1$
							"(see UnitFormat.SymbolMap)"); //$NON-NLS-1$
		}

		appendable.append(symbol);
		if (annotation != null && annotation.length() > 0) {
			appendAnnotation(unit, symbol, annotation, appendable);
		}

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
			// } else if (converter == UnitConverter.IDENTITY) {
			// // do nothing
			// } else if (converter instanceof MultiplyConverter) {
			// if (unitIsExpression) {
			// buffer.insert(0, '(');
			// buffer.append(')');
			// }
			// MultiplyConverter multiplyConverter = (MultiplyConverter)
			// converter;
			// double factor = multiplyConverter.getFactor();
			// long lFactor = (long) factor;
			// if ((lFactor != factor) || (lFactor < -9007199254740992L)
			// || (lFactor > 9007199254740992L)) {
			// throw new IllegalArgumentException(
			//			"Only integer factors are supported in UCUM"); //$NON-NLS-1$
			// }
			// if (continued) {
			// buffer.append('.');
			// }
			// buffer.append(lFactor);
			// } else if (converter instanceof RationalConverter) {
			// if (unitIsExpression) {
			// buffer.insert(0, '(');
			// buffer.append(')');
			// }
			// RationalConverter rationalConverter = (RationalConverter)
			// converter;
			// if (!rationalConverter.getDividend().equals(BigInteger.ONE)) {
			// if (continued) {
			// buffer.append('.');
			// }
			// buffer.append(rationalConverter.getDividend());
			// }
			// if (!rationalConverter.getDivisor().equals(BigInteger.ONE)) {
			// buffer.append('/');
			// buffer.append(rationalConverter.getDivisor());
			// }
			// } else if (converter instanceof UnitConverter.Compound) {
			// UnitConverter.Compound compound = (UnitConverter.Compound)
			// converter;
			// formatConverter(compound.getLeft(), true, buffer);
			// // formatConverter(compound.getRight(), true, buffer);
		} else {
			throw new IllegalArgumentException(
					"Unable to format units (unsupported UnitConverter " //$NON-NLS-1$
							+ converter + ")"); //$NON-NLS-1$
		}
	}

	@Override
	public Unit<?> parse(CharSequence csq, ParsePosition cursor)
			throws IllegalArgumentException {
	return AbstractUnit.METRIC_MASS;
	}

	/**
	 * The Parsing format outputs formats and parses units according to the
	 * "c/s" or "c/i" column in the UCUM standard, depending on which SymbolMap
	 * is passed to its constructor.
	 */
	// private static class Parsing extends SimpleFormat {
	//
	// /**
	// *
	// */
	// private static final long serialVersionUID = -922531801940132715L;
	//
	// private static final SymbolMapImpl CASE_SENSITIVE_SYMBOLS = new
	// SymbolMapImpl(
	//		ResourceBundle.getBundle(BUNDLE_BASE + "_CS")); //$NON-NLS-1$
	// private static final SymbolMapImpl CASE_INSENSITIVE_SYMBOLS = new
	// SymbolMapImpl(
	//		ResourceBundle.getBundle(BUNDLE_BASE + "_CI")); //$NON-NLS-1$
	// private static final Parsing DEFAULT_CS = new Parsing(
	// CASE_SENSITIVE_SYMBOLS, true);
	// private static final Parsing DEFAULT_CI = new Parsing(
	// CASE_INSENSITIVE_SYMBOLS, false);
	// private final boolean _caseSensitive;
	//
	// public Parsing(SymbolMapImpl symbols, boolean caseSensitive) {
	// super(symbols);
	// _caseSensitive = caseSensitive;
	// }
	//
	// @SuppressWarnings("unchecked")
	// @Override
	// public Unit<? extends Quantity> parse(CharSequence csq,
	// ParsePosition cursor) throws IllegalArgumentException {
	// // Parsing reads the whole character sequence from the parse
	// // position.
	// int start = cursor.getIndex();
	// int end = csq.length();
	// if (end <= start)
	// return Unit.ONE;
	// String source = csq.subSequence(start, end).toString().trim();
	// if (source.length() == 0)
	// return Unit.ONE;
	// if (!_caseSensitive) {
	// source = source.toUpperCase();
	// }
	// UCUMParser parser = new UCUMParser(symbolMap,
	// new ByteArrayInputStream(source.getBytes()));
	// try {
	// Unit<?> result = parser.parseUnit();
	// cursor.setIndex(end);
	// return result;
	// } catch (org.unitsofmeasure.ucum.ParseException e) {
	// if (e.currentToken != null) {
	// cursor.setErrorIndex(start + e.currentToken.endColumn);
	// } else {
	// cursor.setErrorIndex(start);
	// }
	// throw new IllegalArgumentException(e.getMessage());
	// } catch (TokenMgrError e) {
	// cursor.setErrorIndex(start);
	// throw new IllegalArgumentException(e.getMessage());
	// }
	// }
	// }
}
