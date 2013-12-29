package org.unitsofmeasurement.impl.function;


import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.measure.Unit;
import javax.measure.function.UnitFormat;

/**
 * <p>
 * This class provides a simple interface for formatting and parsing
 * {@linkplain org.unitsofmeasurement.unit.Unit units}.
 * </p>
 *
 * @author <a href="mailto:werner.keil@gmail.com">Werner Keil</a>
 * @version 1.7 ($Revision$), $Date$
 */
public class SimpleFormat extends AbstractFormat {
    /**
     *
     */
    private static final long serialVersionUID = -7753687108842507677L;

    private final Map<String, String> symbolMap = new HashMap<String, String>();

    private static final UnitFormat DEFAULT = new SimpleFormat();

    public static enum Show {
        SYMBOL, NAME;
    }

    // /////////////////
    // Class methods //
    // /////////////////
    /** Returns the default instance for formatting */
    public static UnitFormat getInstance() {
        return DEFAULT;
    }

    /** Returns the instance for formatting using "print" symbols */
    public static UnitFormat getPrintInstance() {
        return getInstance();
    }

    /**
     * Returns the instance for formatting and parsing using case insensitive
     * symbols
     */
    public static UnitFormat getStandardInstance() {
        return getInstance();
    }

    // ////////////////
    // Constructors //
    // ////////////////
    /**
     * Base constructor.
     */
    SimpleFormat() {
    }

    // //////////////
    // Formatting //
    // //////////////
    public Appendable format(Unit<?> unit, Appendable appendable)
            throws IOException {
        CharSequence symbol;

        String mapSymbol = symbolMap.get(unit);
        if (mapSymbol != null) {
            symbol = mapSymbol;
        } else {
            throw new IllegalArgumentException(
                    "Symbol mapping for unit of type " + //$NON-NLS-1$
                            unit.getClass().getName() + " has not been set " + //$NON-NLS-1$
                            "(see UnitFormat.SymbolMap)"); //$NON-NLS-1$
        }

        appendable.append(symbol);

        return appendable;
    }
    
    public Locale getLocale() {
        return Locale.getDefault();
    }
}
