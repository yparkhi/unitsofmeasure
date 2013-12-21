/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2013, Unit-API contributors and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.exception;

/**
 * Signals that an error has been reached unexpectedly while parsing.
 * 
 * @author Werner Keil
 */
public class UnitParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3179553925611520368L;

	/**
	 * The zero-based character offset into the string being parsed at which the
	 * error was found during parsing.
	 * 
	 * @serial
	 */
	private int errorIndex;

	/** The original input data. */
	private CharSequence data;

	/**
	 * Constructs a MonetaryParseException with the specified detail message,
	 * parsed text and index. A detail message is a String that describes this
	 * particular exception.
	 * 
	 * @param message
	 *            the detail message
	 * @param parsedData
	 *            the parsed text, should not be null
	 * @param errorIndex
	 *            the position where the error is found while parsing.
	 */
	public UnitParseException(String message, CharSequence parsedData,
			int errorIndex) {
		super(message);
		this.data = parsedData;
		this.errorIndex = errorIndex;
	}

	/**
	 * Constructs a MonetaryParseException with the parsed text and offset. A
	 * detail message is a String that describes this particular exception.
	 * 
	 * @param parsedData
	 *            the parsed text, should not be null
	 * @param errorIndex
	 *            the position where the error is found while parsing.
	 */
	public UnitParseException(CharSequence parsedData,
			int errorIndex) {
		super("Parse Error");
		this.data = parsedData;
		this.errorIndex = errorIndex;
	}

	/**
	 * Returns the index where the error was found.
	 * 
	 * @return the index where the error was found
	 */
	public int getErrorIndex() {
		return errorIndex;
	}

	/**
	 * Returns the string that was being parsed.
	 * 
	 * @return the parsed string, or {@code null}, if {@code null} was passed as
	 *         input.
	 */
	public String getParsedString() {
		if (data == null)
			return null;
		return data.toString();
	}

}
