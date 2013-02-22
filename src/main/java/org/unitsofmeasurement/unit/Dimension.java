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
 * Dependence of a unit on the base units of a system of units. The dependency is expresses as a
 * {@linkplain #getProductDimensions() product of powers} of dimensions corresponding to the base
 * units, omitting any numerical factor.
 *
 * <p>Concrete dimensions are obtained through the {@link Unit#getDimension()} method.
 * Two units {@code u1} and {@code u2} are {@linkplain Unit#isCompatible(Unit) compatible} if
 * and only if <code>u1.getDimension().{@linkplain #equals equals}(u2.getDimension())</code>.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1
 *
 * @see <a href="http://en.wikipedia.org/wiki/Dimensional_analysis">Wikipedia: Dimensional Analysis</a>
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
     * Returns the base dimensions and their exponent whose product is this dimension.
     * Bases dimensions are dimensions corresponding to base units in the
     * {@linkplain SystemOfUnits system of units} in use.
     * The exponent of any dimension not included in the map is assumed to be zero.
     *
     * <p>Special cases, ignoring all dimensions associated to power 0 (if any):</p>
     * <ul>
     *   <li>If this {@code Dimension} instance corresponds to the
     *       {@linkplain org.unitsofmeasurement.quantity.Dimensionless dimensionless quantity},
     *       then this method returns an empty map.</li>
     *   <li>If this {@code Dimension} is itself a base dimension, then this method returns
     *       a singleton map containing this dimension associated to power 1.</li>
     * </ul>
     *
     * @return the mapping between the base dimensions and their exponent (never {@code null}).
     *
     * @see Unit#getProductUnits()
     */
    Map<? extends Dimension, Integer> getProductDimensions();

    /**
     * Returns {@code true} if the given object is also a dimension, and both dimensions
     * have equal {@linkplain #getProductDimensions() product of powers} of base dimensions.
     *
     * <p>Implementations shall take special care against infinite recursivity if this
     * {@code Dimension} instance is itself contained in the set of keys.</p>
     *
     * @param  object the other object to compare with this dimension, or {@code null}.
     * @return {@code true} if the other object is also a dimension, and both dimensions
     *         have equal product of powers.
     */
    @Override
    boolean equals(Object object);
}
