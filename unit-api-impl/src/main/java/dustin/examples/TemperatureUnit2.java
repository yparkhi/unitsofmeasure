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
public enum TemperatureUnit2
{
   /** Celsius, used by most of the world's population. */
   CELSIUS(new BigDecimal("0"), new BigDecimal("100"), '\u00B0' + "C", "Anders Celsius")
   {
      /**
       * {@inheritDoc}
       *
       * <p>The source temperature scale in this case is Celsius.</p>
       */
      @Override
      public BigDecimal convertTo(
         final TemperatureUnit2 targetTemperatureScale, final BigDecimal sourceTemperature)
      {
         BigDecimal target = null;
         switch (targetTemperatureScale)
         {
            case CELSIUS :
               target = sourceTemperature;
               break;
            case FAHRENHEIT :
               target = sourceTemperature.multiply(NINE).divide(FIVE).add(THIRTY_TWO);
               break;
            case KELVIN :
               target = sourceTemperature.add(KELVIN.freezingPoint);
               break;
            case RANKINE :
               target = sourceTemperature.add(NINE.divide(FIVE)).add(THIRTY_TWO).add(RANKINE_FAHRENHEIT_DELTA);               
               break;
         }
         return target;
      }
   },
   /** Fahrenheit, commonly used in the United States. */
   FAHRENHEIT(new BigDecimal("32"), new BigDecimal("212"), '\u00B0' + "F", "Daniel Gabriel Fahrenheit")
   {
      /**
       * {@inheritDoc}
       *
       * <p>The source temperature scale in this case is Fahrenheit.</p>
       */
      @Override
      public BigDecimal convertTo(
         final TemperatureUnit2 targetTemperatureScale, final BigDecimal sourceTemperature)
      {
         BigDecimal target = null;
         switch (targetTemperatureScale)
         {
            case CELSIUS :
               target = sourceTemperature.subtract(THIRTY_TWO).divide(NINE.divide(FIVE));
               break;
            case FAHRENHEIT :
               target = sourceTemperature;
               break;
            case KELVIN :
               target = sourceTemperature.add(RANKINE_FAHRENHEIT_DELTA).divide(NINE.divide(FIVE));
               break;
            case RANKINE :
               target = sourceTemperature.add(RANKINE_FAHRENHEIT_DELTA);
               break;
         }
         return target;
      }
   },
   /** Kelvin, commonly used in scientific endeavors. */
   KELVIN(new BigDecimal("273.15"), new BigDecimal("373.15"), "K", "William Thomson, 1st Baron Kelvin")
   {
      /**
       * {@inheritDoc}
       *
       * <p>The source temperature scale in this case is Kelvin.</p>
       */
      @Override
      public BigDecimal convertTo(
         final TemperatureUnit2 targetTemperatureScale, final BigDecimal sourceTemperature)
      {
         BigDecimal target = null;
         switch (targetTemperatureScale)
         {
            case CELSIUS :
               target = sourceTemperature.subtract(KELVIN.freezingPoint);
               break;
            case FAHRENHEIT :
               target = (sourceTemperature.subtract(KELVIN.freezingPoint)).multiply(NINE).divide(FIVE).add(THIRTY_TWO);
               break;
            case KELVIN :
               target = sourceTemperature;
               break;
            case RANKINE :
               target = sourceTemperature.multiply(NINE.divide(FIVE));
               break;
         }
         return target;
      }
   },
   /** Rankine temperature scale. */
   RANKINE(new BigDecimal("491.67"), new BigDecimal("671.641"), '\u00B0' + "R", "William John Macquorn Rankine")
   {
      /**
       * {@inheritDoc}
       *
       * <p>The source temperature scale in this case is Rankine.</p>
       */
      @Override
      public BigDecimal convertTo(
         final TemperatureUnit2 targetTemperatureScale, final BigDecimal sourceTemperature)
      {
         BigDecimal target = null;
         switch (targetTemperatureScale)
         {
            case CELSIUS :
               target = (sourceTemperature.subtract(THIRTY_TWO).subtract(RANKINE_FAHRENHEIT_DELTA)).divide(NINE.divide(FIVE), 2, RoundingMode.HALF_UP);
               break;
            case FAHRENHEIT :
               target = sourceTemperature.subtract(RANKINE_FAHRENHEIT_DELTA);
               break;
            case KELVIN :
               target = sourceTemperature.divide(NINE.divide(FIVE), 2, RoundingMode.HALF_UP);
               break;
            case RANKINE :
               target = sourceTemperature;
               break;
         }
         return target;
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
   TemperatureUnit2(
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
    * Conversion method to be implemented by each type of temperature scale.
    *
    * @param targetTemperatureScale Temperature scale to convert to.
    * @param sourceTemperature Temperature value to be converted.
    * @return Value of temperature in target temperature scale that corresponds
    *     to provided value for source temperature scale; may be null if no
    *     match can be calculated.
    */
   public abstract BigDecimal convertTo(
      final TemperatureUnit2 targetTemperatureScale, final BigDecimal sourceTemperature);

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
