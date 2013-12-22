/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.util;

/**
 * Represents a supplier of <b>name</b> string.
 * 
 * <p>There is no requirement that a distinct result be returned each
 * time the supplier is invoked.
 * 
 * <p>This is a <a href="http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html">functional interface</a>
 * whose functional method is {@link #getName()}.
 * 
 * @author Werner Keil
 * @version 1.1 ($Revision: 283 $), 2013-12-22
 */
public interface Nameable {
    String getName();
}
