/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.function;

/**
 * Provides String description to implementations
 *
 * <p>There is no requirement that a distinct result be returned each
 * time the supplier is invoked, unless implementing classes enforce it.
 * 
 * <p>This is a <a href="http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html">functional interface</a>
 * whose functional method is {@link #getDescription()}.
 * 
 * @author Werner Keil
 */
//equivalent to @FunctionalInterface
public interface DescriptionSupplier {
	
    /**
     * @return a description
     */
    String getDescription();
}
