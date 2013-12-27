/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2010 - JScience (http://jscience.org/) All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is freely
 * granted, provided that this notice is preserved.
 */
package org.unitsofmeasurement.impl.function;

import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.function.UnitConverter;

import org.unitsofmeasurement.impl.AbstractUnit;
import org.unitsofmeasurement.impl.system.SIPrefix;

/**
 * <p> This class provides a set of mappings between
 *     {@link AbstractUnit physical units} and symbols (both ways), between {@link SIPrefix prefixes}
 * and symbols (both ways), and from {@link AbstractConverter
 *     physical unit converters} to {@link SIPrefix prefixes} (one way). No attempt
 * is made to verify the uniqueness of the mappings.</p>
 *
 * <p> Mappings are read from a
 * <code>ResourceBundle</code>, the keys of which should consist of a
 * fully-qualified class name, followed by a dot ('.'), and then the name of a
 * static field belonging to that class, followed optionally by another dot and a
 * number. If the trailing dot and number are not present, the value associated
 * with the key is treated as a
 *     {@link SymbolMap#label(AbstractUnit, String) label}, otherwise if the trailing
 * dot and number are present, the value is treated as an {@link SymbolMap#alias(AbstractUnit,String) alias}.
 * Aliases map from String to Unit only, whereas labels map in both directions. A
 * given unit may have any number of aliases, but may have only one label.</p>
 *
 * @author <a href="mailto:eric-r@northwestern.edu">Eric Russell</a>
 * @author Werner Keil
 * @version 5.1, December 23, 2013
 */
public class SymbolMap {
	private static final Logger logger = Logger.getLogger("org.unitsofmeasurement.impl.unit.format.SymbolMap");
	
    private final Map<String, AbstractUnit<?>> _symbolToUnit;
    private final Map<AbstractUnit<?>, String> _unitToSymbol;
    private final Map<String, Object> _symbolToPrefix;
    private final Map<Object, String> _prefixToSymbol;
    private final Map<UnitConverter, SIPrefix> _converterToPrefix;

    /**
     * Creates an empty mapping.
     */
    public SymbolMap() {
        _symbolToUnit = new HashMap<String, AbstractUnit<?>>();
        _unitToSymbol = new HashMap<AbstractUnit<?>, String>();
        _symbolToPrefix = new HashMap<String, Object>();
        _prefixToSymbol = new HashMap<Object, String>();
        _converterToPrefix = new HashMap<UnitConverter, SIPrefix>();
    }

    /** 
     * Creates a symbol map from the specified resource bundle,
     *
     * @param rb the resource bundle.
     */
    public SymbolMap(ResourceBundle rb) {
        this();
        for (Enumeration<String> i = rb.getKeys(); i.hasMoreElements();) {
            String fqn = i.nextElement();
            String symbol = rb.getString(fqn);
            boolean isAlias = false;
            int lastDot = fqn.lastIndexOf('.');
            String className = fqn.substring(0, lastDot);
            String fieldName = fqn.substring(lastDot + 1, fqn.length());
            if (Character.isDigit(fieldName.charAt(0))) {
                isAlias = true;
                fqn = className;
                lastDot = fqn.lastIndexOf('.');
                className = fqn.substring(0, lastDot);
                fieldName = fqn.substring(lastDot + 1, fqn.length());
            }
            try {
                Class<?> c = Class.forName(className);
                Field field = c.getField(fieldName);
                Object value = field.get(null);
                if (value instanceof AbstractUnit<?>) {
                    if (isAlias) {
                        alias((AbstractUnit<?>) value, symbol);
                    } else {
                        label((AbstractUnit<?>) value, symbol);
                    }
                } else if (value instanceof SIPrefix) {
                    label((SIPrefix) value, symbol);
                } else {
                    throw new ClassCastException("unable to cast " + value + " to Unit or Prefix");
                }
            } catch (Exception error) {
                logger.log(Level.SEVERE, "Error", error);
            }
        }
    }

    /**
     * Attaches a label to the specified unit. For example:[code]
     *    symbolMap.label(DAY.multiply(365), "year");
     *    symbolMap.label(NonSI.FOOT, "ft");
     * [/code]
     *
     * @param unit the unit to label.
     * @param symbol the new symbol for the unit.
     */
    public void label(AbstractUnit<?> unit, String symbol) {
        _symbolToUnit.put(symbol, unit);
        _unitToSymbol.put(unit, symbol);
    }

    /**
     * Attaches an alias to the specified unit. Multiple aliases may be
     * attached to the same unit. Aliases are used during parsing to
     * recognize different variants of the same unit.[code]
     *     symbolMap.alias(NonSI.FOOT, "foot");
     *     symbolMap.alias(NonSI.FOOT, "feet");
     *     symbolMap.alias(SI.METER, "meter");
     *     symbolMap.alias(SI.METER, "metre");
     * [/code]
     *
     * @param unit the unit to label.
     * @param symbol the new symbol for the unit.
     */
    public void alias(AbstractUnit<?> unit, String symbol) {
        _symbolToUnit.put(symbol, unit);
    }

    /**
     * Attaches a label to the specified prefix. For example:[code]
     *    symbolMap.label(SIPrefix.GIGA, "G");
     *    symbolMap.label(SIPrefix.MICRO, "µ");
     * [/code]
     */
    public void label(SIPrefix prefix, String symbol) {
        _symbolToPrefix.put(symbol, prefix);
        _prefixToSymbol.put(prefix, symbol);
        _converterToPrefix.put(prefix.getConverter(), prefix);
    }

    /**
     * Returns the unit for the specified symbol.
     * 
     * @param symbol the symbol.
     * @return the corresponding unit or <code>null</code> if none.
     */
    public AbstractUnit<?> getUnit(String symbol) {
        return _symbolToUnit.get(symbol);
    }

    /**
     * Returns the symbol (label) for the specified unit.
     *
     * @param unit the corresponding symbol.
     * @return the corresponding symbol or <code>null</code> if none.
     */
    public String getSymbol(AbstractUnit<?> unit) {
        return _unitToSymbol.get(unit);
    }

    /**
     * Returns the prefix (if any) for the specified symbol.
     *
     * @param symbol the unit symbol.
     * @return the corresponding prefix or <code>null</code> if none.
     */
    public SIPrefix getPrefix(String symbol) {
        for (Iterator<String> i = _symbolToPrefix.keySet().iterator(); i.hasNext();) {
            String pfSymbol = i.next();
            if (symbol.startsWith(pfSymbol)) {
                return (SIPrefix) _symbolToPrefix.get(pfSymbol);
            }
        }
        return null;
    }

    /**
     * Returns the prefix for the specified converter.
     *
     * @param converter the unit converter.
     * @return the corresponding prefix or <code>null</code> if none.
     */
    public SIPrefix getPrefix(UnitConverter converter) {
        return (SIPrefix) _converterToPrefix.get(converter);
    }

    /**
     * Returns the symbol for the specified prefix.
     *
     * @param prefix the prefix.
     * @return the corresponding symbol or <code>null</code> if none.
     */
    public String getSymbol(SIPrefix prefix) {
        return _prefixToSymbol.get(prefix);
    }
}
