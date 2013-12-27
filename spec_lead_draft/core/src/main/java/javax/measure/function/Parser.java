/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.function;

import javax.measure.exception.ParserException;

/**
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 *
 * @param <I> the input
 * @param <O> the output
 */
//@FunctionalInterface
public interface Parser<I, O> {
	/**
     * Parses the specified {@code I} to produce a {@code O}.
     */
	public O parse(I input) throws ParserException;
}
