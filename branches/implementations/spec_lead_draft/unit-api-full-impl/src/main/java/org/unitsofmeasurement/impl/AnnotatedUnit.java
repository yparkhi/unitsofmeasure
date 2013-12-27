/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2010 - JScience (http://jscience.org/)
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.unitsofmeasurement.impl;

import java.util.Map;

import javax.measure.Quantity;
import javax.measure.function.UnitConverter;

import org.unitsofmeasurement.impl.model.QuantityDimension;

/**
 * <p> This class represents an annotated unit.</p>
 * 
 * <p> Instances of this class are created through the
 *     {@link AbstractUnit#annotate(String)} method.</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 5.0, October 12, 2010
 */
public final class AnnotatedUnit<Q extends Quantity<Q>> extends AbstractUnit<Q> {

    /**
     * Holds the actual unit.
     */
    private final AbstractUnit<Q> actualUnit;

    /**
     * Holds the annotation.
     */
    private final String annotation;

    /**
     * Creates an annotated unit equivalent to the specified unit.
     *
     * @param actualUnit the unit to be annotated.
     * @param annotation the annotation.
     * @return the annotated unit.
     */
    public AnnotatedUnit(AbstractUnit<Q> actualUnit, String annotation) {
        this.actualUnit = (actualUnit instanceof AnnotatedUnit) ?
            ((AnnotatedUnit<Q>)actualUnit).actualUnit : actualUnit;
        this.annotation = annotation;
    }

    /**
     * Returns the actual unit of this annotated unit (never an annotated unit
     * itself).
     *
     * @return the actual unit.
     */
    public AbstractUnit<Q> getActualUnit() {
        return actualUnit;
    }

    /**
     * Returns the annotqtion of this annotated unit.
     *
     * @return the annotation.
     */
     public String getAnnotation() {
        return annotation;
    }

    @Override
    public String getSymbol() {
        return actualUnit.getSymbol();
    }

    @Override
    public Map<? extends AbstractUnit<?>, Integer> getProductUnits() {
        return actualUnit.getProductUnits();
    }

    @Override
    public AbstractUnit<Q> toSI() {
        return actualUnit.getSystemUnit();
    }

    @Override
    public QuantityDimension getDimension() {
        return actualUnit.getDimension();
    }

    @Override
    public UnitConverter getConverterToSI() {
        return actualUnit.getConverterToSI();
    }

    @Override
    public int hashCode() {
        return actualUnit.hashCode() + annotation.hashCode();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof AnnotatedUnit<?>))
            return false;
        AnnotatedUnit<?> thatUnit = (AnnotatedUnit<?>) that;
        return this.actualUnit.equals(thatUnit.actualUnit) &&
                this.annotation.equals(thatUnit.annotation);
    }
}
