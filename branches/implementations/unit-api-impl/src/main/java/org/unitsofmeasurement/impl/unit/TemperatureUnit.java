package org.unitsofmeasurement.impl.unit;

import org.unitsofmeasurement.impl.Multiplier;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.quantity.Temperature;
import org.unitsofmeasurement.unit.Dimension;
import org.unitsofmeasurement.unit.IncommensurableException;
import org.unitsofmeasurement.unit.UnconvertibleException;
import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.unit.UnitConverter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Werner Keil
 * @version 1.0 ($Revision: 1 $), $Date: 2010-10-29 17:17:07 +0100 (Fr, 29 Okt 2010) $
 */
public enum TemperatureUnit implements Unit<Temperature>, Multiplier {
   /** Celsius, used by most of the world's population. */
   CELSIUS(new BigDecimal("0"), new BigDecimal("100"), '\u00B0' + "C", "Anders Celsius"),

	/** Fahrenheit, commonly used in the United States. */
	FAHRENHEIT(new BigDecimal("32"), new BigDecimal("212"), '\u00B0' + "F", "Daniel Gabriel Fahrenheit"),

	/** Kelvin, commonly used in scientific endeavors. */
	KELVIN(new BigDecimal("273.15"), new BigDecimal("373.15"), "K", "William Thomson, 1st Baron Kelvin"),

	RANKINE(new BigDecimal("491.67"), new BigDecimal("671.641"), '\u00B0' + "R", "William John Macquorn Rankine");
//    s("s", 1.0), // reference Unit
//	m("m", 60),
//    h("h", 60 * 60);

    /** Units by which this temperature scale is expressed. */
    private final String description;
    
    private final double multFactor;
    /** Freezing point of water for each temperature scale. */
    private final BigDecimal freezingPoint;

    /** Boiling point of water for each temperature scale. */
    private final BigDecimal boilingPoint;

    /** Name of person that this temperature scale is named for. */
    private final String namedFor;
    
//    private TemperatureUnit(String d, double multF) {
//        this.description = d;
//        this.multFactor = multF;
//    }

	private static final BigDecimal FIVE = new BigDecimal("5");
    private static final BigDecimal NINE = new BigDecimal("9");
    private static final BigDecimal THIRTY_TWO = new BigDecimal("32");
    private static final BigDecimal KELVIN_CELSIUS_DELTA = new BigDecimal("273");
    private static final BigDecimal RANKINE_FAHRENHEIT_DELTA = new BigDecimal("459.67");
    
    /**
     * Constructor for TemperatureUnit that accepts key characteristics of each
     * temperature scale.
     *
     * @param newFreezingPoint Freezing point for this temperature scale.
     * @param newBoilingPoint Boiling point for this temperature scale.
     * @param newUnits Unit symbol for this temperature scale.
     * @param newNamedFor Name of person after which temperature scale was named.
     */
    private TemperatureUnit(
       final BigDecimal newFreezingPoint,
       final BigDecimal newBoilingPoint,
       final String newSymbol,
       final String newNamedFor)
    {
       this.freezingPoint = newFreezingPoint;
       this.boilingPoint = newBoilingPoint;
       this.description = newSymbol;
       this.namedFor = newNamedFor;
       this.multFactor = 1;
    }

    public String getSymbol() {
        return description;
    }

    public double getMultFactor() {
        return multFactor;
    }
    
    public String getDescriptiveName() {
		return namedFor;
	}

    @Override
	public Unit<Temperature> getSystemUnit() {
		return KELVIN;
    }

    @Override
    public Map<? extends Unit<Temperature>, Integer> getProductUnits() {
        Map<Unit<Temperature>, Integer> prodUnits = new HashMap<Unit<Temperature>, Integer>();
        prodUnits.put(KELVIN, Integer.valueOf(2));
        return prodUnits;
    }

    public static TemperatureUnit getBySymbol(String symbol) {
        if (CELSIUS.name().equals(symbol)) {
            return CELSIUS;
        }
        if (FAHRENHEIT.name().equals(symbol)) {
            return FAHRENHEIT;
        }
        return KELVIN;
    }

    public UnitConverter getConverterTo(Unit<Temperature> that)
            throws UnconvertibleException {
        // currently unused
        return null;
    }

    public UnitConverter getConverterToAny(Unit<?> that)
            throws IncommensurableException, UnconvertibleException {
        // currently unused
        return null;
    }

    @Override
    public Unit<?> alternate(String s) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

    public Dimension getDimension() {
        return SimpleDimension.INSTANCE;
    }

     public Unit<?> inverse() {
        return this;
    }

    @Override
    public Unit<Temperature> divide(double v) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

    @Override
    public Unit<?> divide(Unit<?> unit) {
        return null;  //To change body of implemented methods use File | Settings | File TemplateBuilder.
    }

    public boolean isCompatible(Unit<?> that) {
        if (that instanceof TemperatureUnit) return true;
        return false;
    }

    @SuppressWarnings({ "unchecked" })
	@Override
    public <T extends Quantity<T>> Unit<T> asType(Class<T> tClass) {
        Unit<T> metricUnit = QuantityFactory.getInstance(tClass).getMetricUnit();
         if ((metricUnit == null) || metricUnit.isCompatible(this))
          return (Unit<T>) this;
           throw new ClassCastException("The unit: " + this //$NON-NLS-1$
               + " is not of parameterized type " + tClass); //$NON-NLS-1$
    }

    public Unit<Temperature> multiply(double factor) {
        return this;
    }

    public Unit<?> multiply(Unit<?> that) {
        return this;
    }

    public Unit<?> pow(int n) {
        return this;
    }

    public Unit<?> root(int n) {
        return this;
    }

    public Unit<Temperature> transform(UnitConverter operation) {
        return this;
    }

    @Override
    public Unit<Temperature> add(double v) {
        return this;
    }
}