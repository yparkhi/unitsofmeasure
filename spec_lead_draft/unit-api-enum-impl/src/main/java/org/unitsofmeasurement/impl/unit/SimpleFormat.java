package org.unitsofmeasurement.impl.unit;


import java.io.IOException;
import java.text.ParsePosition;
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
 * @version 1.6 ($Revision: 18019 $), $Date: 2011-07-23 18:25:49 +0530 (Sat, 23 Jul 2011) $
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

    static final String BIT_NAME = "bit"; //$NON-NLS-1$
    static final String BYTE_NAME = "Byte"; //$NON-NLS-1$
	static final String KB_NAME = "kb"; //$NON-NLS-1$
    static final String MB_NAME = "Mb"; //$NON-NLS-1$
    static final String GB_NAME = "Gb"; //$NON-NLS-1$
    static final String TB_NAME = "Tb"; //$NON-NLS-1$
    static final String PB_NAME = "Pb"; //$NON-NLS-1$
    static final String EB_NAME = "Eb"; //$NON-NLS-1$
    static final String KBYTE_NAME = "kByte"; //$NON-NLS-1$
    static final String MBYTE_NAME = "MByte"; //$NON-NLS-1$
    static final String GBYTE_NAME = "GByte"; //$NON-NLS-1$
    static final String TBYTE_NAME = "TByte"; //$NON-NLS-1$
    static final String PBYTE_NAME = "PByte"; //$NON-NLS-1$
    static final String EBYTE_NAME = "EByte"; //$NON-NLS-1$

    static final String BPS_NAME = "Bit per Second"; //$NON-NLS-1$
    static final String KBPS_NAME = "Kilobit per Second"; //$NON-NLS-1$
    static final String MBPS_NAME = "Megabit per Second"; //$NON-NLS-1$
    static final String GBPS_NAME = "Gigabit per Second"; //$NON-NLS-1$
    static final String TBPS_NAME = "Terabit per Second"; //$NON-NLS-1$
    static final String PBPS_NAME = "Petabit per Second"; //$NON-NLS-1$
    static final String EBPS_NAME = "Exabit per Second"; //$NON-NLS-1$

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

    public Unit<?> parse(CharSequence csq, ParsePosition cursor)
            throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Locale getLocale() {
        return Locale.getDefault();
    }
}
