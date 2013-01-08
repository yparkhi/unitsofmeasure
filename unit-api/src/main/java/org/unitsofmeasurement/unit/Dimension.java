/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;

import java.util.Map;


/**
 * Represents the dimension of a unit.
 *
 * <p>Concrete dimensions are obtained through the {@link Unit#getDimension()} method.</p>
 *
 * <p>Two units {@code u1} and {@code u2} are {@linkplain Unit#isCompatible(Unit) compatible}
 * if and only if {@code u1.getDimension().equals(u2.getDimension())}.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1
 *
 * @see <a href="http://en.wikipedia.org/wiki/Dimensional_analysis">Dimensional Analysis on Wikipedia</a>
 * @since 0.6.0
 */
public interface Dimension {
    /**
     * Returns the product of this dimension with the one specified.
     *
     * @param  that the dimension multiplicand.
     * @return {@code this * that}
     */
    Dimension multiply(Dimension that);

    /**
     * Returns the quotient of this dimension with the one specified.
     *
     * @param  that the dimension divisor.
     * @return {@code this / that}
     */
    Dimension divide(Dimension that);

    /**
     * Returns this dimension raised to an exponent.
     *
     * @param  n the exponent.
     * @return the result of raising this dimension to the exponent.
     */
    Dimension pow(int n);

    /**
     * Returns the given root of this dimension.
     *
     * @param  n the root's order.
     * @return the result of taking the given root of this dimension.
     * @throws ArithmeticException if {@code n == 0}.
     */
    Dimension root(int n);

    /**
     * Returns the fundamental dimensions and their exponent whose product is
     * this dimension, or {@code null} if this dimension is a fundamental dimension.
     *
     * @return the mapping between the fundamental dimensions and their exponent.
     */
    Map<? extends Dimension, Integer> getProductDimensions();
}
