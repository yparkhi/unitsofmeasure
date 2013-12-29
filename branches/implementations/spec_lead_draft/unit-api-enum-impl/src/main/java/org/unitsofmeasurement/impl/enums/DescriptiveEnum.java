/**
 * Copyright (c) 2013 Werner Keil and others.
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.impl.enums;

import org.unitsofmeasurement.impl.function.DescriptionSupplier;

/**
 * This interface is used to provide a <code>getDescription()</code> method to enums.
 * @author Werner Keil
 * @version 0.2
 */
public interface DescriptiveEnum<I extends DescriptiveEnum<I>> extends DescriptionSupplier {
	String name(); // this is just a compatibility measure with the original enum
	String getDescription();
	DescriptiveEnum<I>[] iValues();
}
