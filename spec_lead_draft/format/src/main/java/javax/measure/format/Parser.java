/**
 * Copyright (c) 2013-2014 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.format;


/**
 * Represents a function that parses an input value and produces an output.
 * 
 * <p>
 * This is a <a href=
 * "http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html"
 * >functional interface</a> whose functional method is {@link #parse()}.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.2, $Date$
 * @param <I>
 *            the input
 * @param <O>
 *            the output
 * @see ParserException
 */
// equivalent to @FunctionalInterface
public interface Parser<I, O> {
	/**
	 * Parses the specified {@code I} to produce a {@code O}.
	 */
	public O parse(I input) throws ParserException;
}
