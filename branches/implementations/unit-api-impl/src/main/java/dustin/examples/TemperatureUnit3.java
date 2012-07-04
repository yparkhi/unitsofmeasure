package dustin.examples;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>Enum representing different temperature scales
 * (<span style="font-weight: bold; color: red;">NOT</span> ready for production
 * -see <a href="#warning">warning</a>).</p>
 *
 * <p><span style="font-weight: bold; color: red;">WARNING:</span>
 * <a name="warning">This class has</a>
 * <span style="font-weight: bold; color: red;">NOT</span> been adequately
 * tested and some conversions are likely to not be properly coded. This
 * example is intended for demonstrative purposes only.</p>
 */
@Deprecated
public enum TemperatureUnit3
{
   /** Celsius, used by most of the world's population. */
   CELSIUS(new BigDecimal("0"), new BigDecimal("100"), '\u00B0' + "C", "Anders Celsius")
   {
      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToCelsius(final BigDecimal sourceTemperature)
      {
         return sourceTemperature;
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToFahrenheit(final BigDecimal sourceTemperature)
      {
         return sourceTemperature.multiply(NINE).divide(FIVE).add(THIRTY_TWO);
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToKelvin(final BigDecimal sourceTemperature)
      {
         return sourceTemperature.add(KELVIN.freezingPoint);
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToRankine(final BigDecimal sourceTemperature)
      {
         return sourceTemperature.add(NINE.divide(FIVE)).add(THIRTY_TWO).add(RANKINE_FAHRENHEIT_DELTA);
      }
   },
   /** Fahrenheit, commonly used in the United States. */
   FAHRENHEIT(new BigDecimal("32"), new BigDecimal("212"), '\u00B0' + "F", "Daniel Gabriel Fahrenheit")
   {
      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToCelsius(final BigDecimal sourceTemperature)
      {
         return sourceTemperature.subtract(THIRTY_TWO).divide(NINE.divide(FIVE));
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToFahrenheit(final BigDecimal sourceTemperature)
      {
         return sourceTemperature;
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToKelvin(final BigDecimal sourceTemperature)
      {
         return sourceTemperature.add(RANKINE_FAHRENHEIT_DELTA).divide(NINE.divide(FIVE));
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToRankine(final BigDecimal sourceTemperature)
      {
         return sourceTemperature.add(RANKINE_FAHRENHEIT_DELTA);
      }
   },
   /** Kelvin, commonly used in scientific endeavors. */
   KELVIN(new BigDecimal("273.15"), new BigDecimal("373.15"), "K", "William Thomson, 1st Baron Kelvin")
   {
      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToCelsius(final BigDecimal sourceTemperature)
      {
         return sourceTemperature.subtract(KELVIN.freezingPoint);
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToFahrenheit(final BigDecimal sourceTemperature)
      {
         return (sourceTemperature.subtract(KELVIN.freezingPoint)).multiply(NINE).divide(FIVE).add(THIRTY_TWO);
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToKelvin(final BigDecimal sourceTemperature)
      {
         return sourceTemperature;
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToRankine(final BigDecimal sourceTemperature)
      {
         return sourceTemperature.multiply(NINE.divide(FIVE));
      }
   },
   /** Rankine temperature scale. */
   RANKINE(new BigDecimal("491.67"), new BigDecimal("671.641"), '\u00B0' + "R", "William John Macquorn Rankine")
   {
      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToCelsius(final BigDecimal sourceTemperature)
      {
         return (sourceTemperature.subtract(THIRTY_TWO).subtract(RANKINE_FAHRENHEIT_DELTA)).divide(NINE.divide(FIVE), 2, RoundingMode.HALF_UP);
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToFahrenheit(final BigDecimal sourceTemperature)
      {
         return sourceTemperature.subtract(RANKINE_FAHRENHEIT_DELTA);
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToKelvin(final BigDecimal sourceTemperature)
      {
         return sourceTemperature.divide(NINE.divide(FIVE), 2, RoundingMode.HALF_UP);
      }

      /** {@inheritDoc} */
      @Override
      public BigDecimal convertToRankine(final BigDecimal sourceTemperature)
      {
         return sourceTemperature;
      }
   };

   /** Freezing point of water for each temperature scale. */
   private BigDecimal freezingPoint;

   /** Boiling point of water for each temperature scale. */
   private BigDecimal boilingPoint;

   /** Units by which this temperature scale is expressed. */
   private String units;

   /** Name of person that this temperature scale is named for. */
   private String namedFor;

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
    * @param newUnits Units of measurement for this temperature scale.
    * @param newNamedFor Name of person after which temperature scale was named.
    */
   TemperatureUnit3(
      final BigDecimal newFreezingPoint,
      final BigDecimal newBoilingPoint,
      final String newUnits,
      final String newNamedFor)
   {
      this.freezingPoint = newFreezingPoint;
      this.boilingPoint = newBoilingPoint;
      this.units = newUnits;
      this.namedFor = newNamedFor;
   }

   /**
    * Conversion method to be implemented by each type of temperature scale for
    * converting from that temperature scale to the Celsius temperature scale.
    *
    * @param sourceTemperature Temperature value to be converted.
    * @return Value of temperature in Celsius temperature scale that corresponds
    *     to provided value for source temperature scale; may be null if no
    *     match can be calculated.
    */
   public abstract BigDecimal convertToCelsius(final BigDecimal sourceTemperature);

   /**
    * Conversion method to be implemented by each type of temperature scale for
    * converting from that temperature scale to the Fahrenheit temperature scale.
    *
    * @param sourceTemperature Temperature value to be converted.
    * @return Value of temperature in Fahrenheit temperature scale that corresponds
    *     to provided value for source temperature scale; may be null if no
    *     match can be calculated.
    */
   public abstract BigDecimal convertToFahrenheit(final BigDecimal sourceTemperature);

   /**
    * Conversion method to be implemented by each type of temperature scale for
    * converting from that temperature scale to the Kelvin temperature scale.
    *
    * @param sourceTemperature Temperature value to be converted.
    * @return Value of temperature in Kelvin temperature scale that corresponds
    *     to provided value for source temperature scale; may be null if no
    *     match can be calculated.
    */
   public abstract BigDecimal convertToKelvin(final BigDecimal sourceTemperature);

   /**
    * Conversion method to be implemented by each type of temperature scale for
    * converting from that temperature scale to the Rankine temperature scale.
    *
    * @param sourceTemperature Temperature value to be converted.
    * @return Value of temperature in Rankine temperature scale that corresponds
    *     to provided value for source temperature scale; may be null if no
    *     match can be calculated.
    */
   public abstract BigDecimal convertToRankine(final BigDecimal sourceTemperature);

   /**
    * Provide the freezing point of water for this temperature scale.
    *
    * @return Freezing point of this temperature scale.
    */
   public BigDecimal getFreezingPoint()
   {
      return this.freezingPoint;
   }

   /**
    * Provide the boiling point of water for this temperature scale.
    *
    * @return Boiling point of this temperature scale.
    */
   public BigDecimal getBoilingPoint()
   {
      return this.boilingPoint;
   }

   /**
    * Unit of measurement for this temperature scale.
    *
    * @return Unit of measurement for this temperature scale.
    */
   public String getUnits()
   {
      return this.units;
   }

   /**
    * Provide the name of the person for which this temperature scale was named.
    *
    * @return Name of person for which this temperature scale was named.
    */
   public String getNamedFor()
   {
      return this.namedFor;
   }
}
