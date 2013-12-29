/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.function;

/**
 * Represents a supplier of {@code double}-valued multiplication factors. This is a
 * {@code double}-producing specialization of {@code Supplier}.
 *
 * <p>There is no requirement that a distinct result be returned each
 * time the supplier is invoked.
 *
 * <p>This is a <a href="http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html">functional interface</a>
 * whose functional method is {@link #getMultFactor()}.
 *
 * @see <a href="http://download.java.net/jdk8/docs/api/java/util/function/Supplier.html">Supplier</a>
 * @author Werner Keil
 * @version 0.2, $Date$
 */
//equivalent to @FunctionalInterface
public interface Multiplier {
    double getMultFactor();
}
