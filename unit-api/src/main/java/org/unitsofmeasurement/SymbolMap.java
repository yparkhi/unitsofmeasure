package org.unitsofmeasurement;

/**
 * <p> This interface provides a set of mappings between
 *     {@link Unit Units} and symbols (both ways),
 *     and from {@link UnitConverter
 *     UnitConverter}s to prefixes symbols (also both ways).</p>
 *     
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author Eric Russell
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.3 ($Revision$), $Date: 2010-09-11 20:32:22 +0200 (Sa, 11 Sep 2010) $
 */
public interface SymbolMap {

    /**
     * Attaches a label to the specified unit. For example:[code]
     *    symbolMap.label(DAY.multiply(365), "year");
     *    symbolMap.label(USCustomary.FOOT, "ft");
     * [/code]
     *
     * @param unit the unit to label.
     * @param symbol the new symbol for the unit.
     * @throws UnsupportedOperationException if setting a unit label
     *         is not allowed.
     */
    void label(Unit<?> unit, String symbol);

    /**
     * Attaches an alias to the specified unit. Multiple aliases may be
     * attached to the same unit. Aliases are used during parsing to
     * recognize different variants of the same unit.[code]
     *     symbolMap.alias(USCustomary.FOOT, "foot");
     *     symbolMap.alias(USCustomary.FOOT, "feet");
     *     symbolMap.alias(SI.METER, "meter");
     *     symbolMap.alias(SI.METER, "metre");
     * [/code]
     *
     * @param unit the unit to label.
     * @param symbol the new symbol for the unit.
     * @throws UnsupportedOperationException if setting a unit alias
     *         is not allowed.
     */
    void alias(Unit<?> unit, String symbol);

    /**
     * Attaches a label to the specified prefix. For example:[code]
     *    symbolMap.prefix(new RationalConverter(1000000000, 1), "G"); // GIGA
     *    symbolMap.prefix(new RationalConverter(1, 1000000), "µ"); // MICRO
     * [/code]
     *
     * @param cvtr the unit converter.
     * @param prefix the prefix for the converter.
     * @throws UnsupportedOperationException if setting a prefix
     *         is not allowed.
     */
    void prefix(UnitConverter cvtr, String prefix);

    /**
     * Returns the unit for the specified symbol.
     *
     * @param symbol the symbol.
     * @return the corresponding unit or <code>null</code> if none.
     */
    Unit<?> getUnit(String symbol);

    /**
     * Returns the symbol (label) for the specified unit.
     *
     * @param unit the corresponding symbol.
     * @return the corresponding symbol or <code>null</code> if none.
     */
    String getSymbol(Unit<?> unit);

    /**
     * Returns the unit converter for the specified prefix.
     *
     * @param prefix the prefix symbol.
     * @return the corresponding converter or <code>null</code> if none.
     */
    UnitConverter getConverter(String prefix);

    /**
     * Returns the prefix for the specified converter.
     *
     * @param converter the unit converter.
     * @return the corresponding prefix or <code>null</code> if none.
     */
    String getPrefix(UnitConverter converter);
}
