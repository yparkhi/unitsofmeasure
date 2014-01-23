/**
 *  The UCUM codes, UCUM table (regardless of format) and UCUM Specification
 *  are copyright © 1999-2013 Regenstrief Institute, Inc. 
 *  and The UCUM Organization, Indianapolis, IN. All rights reserved.
 */
package org.unitsofmeasurement.impl.system;

import org.unitsofmeasurement.impl.AbstractUnit;
import org.unitsofmeasurement.impl.function.PiMultiplierConverter;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.*;

import static org.unitsofmeasurement.impl.system.SIPrefix.*;

/**
 * <p> This class contains {@link SI} and Non-SI units as defined
 *     in the <a href="http://unitsofmeasure.org/"> Uniform Code for Units
 *     of Measure</a>.</p>
 *
 * <p> Compatibility with {@link SI} units has been given
 *     priority over strict adherence to the standard. We have attempted to note
 *     every place where the definitions in this class deviate from the
 *     UCUM standard, but such notes are likely to be incomplete.</p>
 *
 * @author  <a href="mailto:eric-r@northwestern.edu">Eric Russell</a>
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a href="http://www.unitsofmeasure.org">UCUM</a>
 * @version 2.3, $Date$
 */
public final class UCUM extends AbstractSystemOfUnits {

    /**
     * The singleton instance.
     */
    private static final UCUM INSTANCE = new UCUM();

    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private UCUM() {
    }

    /**
     * Returns the singleton instance of this class.
     *
     * @return the UCUM system instance.
     */
    public static UCUM getInstance() {
        return INSTANCE;
    }

    //////////////////////////////
    // BASE UNITS: UCUM 4.2 §25 //
    //////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> METER = addUnit(SI.METRE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> SECOND = addUnit(SI.SECOND);
    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In UCUM, the gram is the base unit of mass,
     * rather than the kilogram. This doesn't have much effect on the units
     * themselves, but it does make formatting the units a challenge.
     */
    public static final AbstractUnit<Mass> GRAM = addUnit(SI.GRAM);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Angle> RADIAN = addUnit(SI.RADIAN);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Temperature> KELVIN = addUnit(SI.KELVIN);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<ElectricCharge> COULOMB = addUnit(SI.COULOMB);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<LuminousIntensity> CANDELA = addUnit(SI.CANDELA);
    ///////////////////////////////////////////////
    // DIMENSIONLESS DERIVED UNITS: UCUM 4.3 §26 //
    ///////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> TRIILLIONS = addUnit(SI.ONE.multiply(1000000000000L));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> BILLIONS = addUnit(SI.ONE.multiply(1000000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> MILLIONS = addUnit(SI.ONE.multiply(1000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> THOUSANDS = addUnit(SI.ONE.multiply(1000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> HUNDREDS = addUnit(SI.ONE.multiply(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> PI = addUnit(SI.ONE.transform(new PiMultiplierConverter()));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> PERCENT = addUnit(SI.ONE.divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> PER_THOUSAND = addUnit(SI.ONE.divide(1000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> PER_MILLION = addUnit(SI.ONE.divide(1000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> PER_BILLION = addUnit(SI.ONE.divide(1000000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> PER_TRILLION = addUnit(SI.ONE.divide(1000000000000L));
    ////////////////////////////
    // SI UNITS: UCUM 4.3 §27 //
    ////////////////////////////
    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In UCUM, the mole is no longer a base unit,
     * but is defined as <code>Unit.ONE.multiply(6.0221367E23)</code>.
     */
    public static final AbstractUnit<AmountOfSubstance> MOLE = addUnit(SI.MOLE);
    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In UCUM, the steradian is defined as
     * <code>RADIAN.pow(2)</code>.
     */
    public static final AbstractUnit<SolidAngle> STERADIAN = addUnit(SI.STERADIAN);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Frequency> HERTZ = addUnit(SI.HERTZ);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Force> NEWTON = addUnit(SI.NEWTON);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Pressure> PASCAL = addUnit(SI.PASCAL);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Energy> JOULE = addUnit(SI.JOULE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Power> WATT = addUnit(SI.WATT);
    /**
     * We deviate slightly from the standard here, to maintain compatability
     * with the existing SI units. In UCUM, the ampere is defined as
     * <code>COULOMB.divide(SECOND)</code>.
     */
    public static final AbstractUnit<ElectricCurrent> AMPERE = addUnit(SI.AMPERE);
    public static final AbstractUnit<MagnetomotiveForce> AMPERE_TURN = addUnit(SI.AMPERE_TURN);
    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In UCUM, the volt is defined as
     * <code>JOULE.divide(COULOMB)</code>.
     */
    public static final AbstractUnit<ElectricPotential> VOLT = addUnit(SI.VOLT);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<ElectricCapacitance> FARAD = addUnit(SI.FARAD);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<ElectricResistance> OHM = addUnit(SI.OHM);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<ElectricConductance> SIEMENS = addUnit(SI.SIEMENS);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<MagneticFlux> WEBER = addUnit(SI.WEBER);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Temperature> CELSIUS = addUnit(SI.CELSIUS);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<MagneticFluxDensity> TESLA = addUnit(SI.TESLA);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<ElectricInductance> HENRY = addUnit(SI.HENRY);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<LuminousFlux> LUMEN = addUnit(SI.LUMEN);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Illuminance> LUX = addUnit(SI.LUX);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Radioactivity> BECQUEREL = addUnit(SI.BECQUEREL);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<RadiationDoseAbsorbed> GRAY = addUnit(SI.GRAY);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<RadiationDoseEffective> SIEVERT = addUnit(SI.SIEVERT);
    ///////////////////////////////////////////////////////////////////////
    // OTHER UNITS FROM ISO 1000, ISO 2955, AND ANSI X3.50: UCUM 4.3 §28 //
    ///////////////////////////////////////////////////////////////////////
    // The order of GON and DEGREE has been inverted because GON is defined in terms of DEGREE
    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing NonSI units. In UCUM, the degree is defined as
     * <code>PI.multiply(RADIAN.divide(180))</code>.
     */
    public static final AbstractUnit<Angle> DEGREE = addUnit(SI.DEGREE_ANGLE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Angle> GRADE = addUnit(SI.DEGREE_ANGLE.multiply(0.9));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Angle> GON = GRADE;
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Angle> MINUTE_ANGLE = addUnit(SI.MINUTE_ANGLE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Angle> SECOND_ANGLE = addUnit(SI.SECOND_ANGLE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> LITER = addUnit(SI.LITRE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> ARE = addUnit(SI.SQUARE_METRE.multiply(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> MINUTE = addUnit(SI.MINUTE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> HOUR = addUnit(SI.HOUR);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> DAY = addUnit(SI.DAY);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> YEAR_TROPICAL = addUnit(SI.DAY.multiply(365.24219));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> YEAR_JULIAN = addUnit(SI.DAY.multiply(365.25));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> YEAR_GREGORIAN = addUnit(SI.DAY.multiply(365.2425));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> YEAR = addUnit(SI.DAY.multiply(365.25));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> MONTH_SYNODAL = addUnit(SI.DAY.multiply(29.53059));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> MONTH_JULIAN = addUnit(YEAR_JULIAN.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> MONTH_GREGORIAN = addUnit(YEAR_GREGORIAN.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Time> MONTH = addUnit(YEAR_JULIAN.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> TONNE = addUnit(SI.KILOGRAM.multiply(1000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Pressure> BAR = addUnit(SI.PASCAL.multiply(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> ATOMIC_MASS_UNIT = addUnit(SI.UNIFIED_ATOMIC_MASS);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Energy> ELECTRON_VOLT = addUnit(SI.ELECTRON_VOLT);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> ASTRONOMIC_UNIT = addUnit(SI.ASTRONOMICAL_UNIT);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> PARSEC = addUnit(SI.METRE.multiply(3.085678E16));
    /////////////////////////////////
    // NATURAL UNITS: UCUM 4.3 §29 //
    /////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Speed> C = addUnit(SI.METRES_PER_SECOND.multiply(299792458));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Action> PLANCK = addUnit(SI.JOULE_SECOND.multiply(6.6260755E-24));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<?> BOLTZMAN = addUnit(JOULE.divide(KELVIN).multiply(1.380658E-23));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<ElectricPermittivity> PERMITTIVITY_OF_VACUUM = addUnit(SI.FARADS_PER_METRE.multiply(8.854187817E-12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<MagneticPermeability> PERMEABILITY_OF_VACUUM 
            = addUnit(SI.NEWTONS_PER_SQUARE_AMPERE.multiply(PI).multiply(4).divide(1E7).asType(MagneticPermeability.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<ElectricCharge> ELEMENTARY_CHARGE = addUnit(SI.COULOMB.transform(SI.ELECTRON_VOLT.getConverterToSI()));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> ELECTRON_MASS = addUnit(GRAM.multiply(9.1093897E-28));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> PROTON_MASS = addUnit(GRAM.multiply(1.6726231E-24));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<?> NEWTON_CONSTANT_OF_GRAVITY = addUnit(METER.pow(3).multiply(SI.KILOGRAM.pow(-1)).multiply(SECOND.pow(-2)).multiply(6.67259E-11));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Acceleration> ACCELLERATION_OF_FREEFALL = addUnit(SI.METRES_PER_SQUARE_SECOND.multiply(9.80665));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Pressure> ATMOSPHERE = addUnit(SI.PASCAL.multiply(101325));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> LIGHT_YEAR = addUnit(C.multiply(YEAR_JULIAN).asType(Length.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Force> GRAM_FORCE = addUnit(GRAM.multiply(ACCELLERATION_OF_FREEFALL).asType(Force.class));
    // POUND_FORCE contains a forward reference to avoirdupois pound weight, so it has been moved after section §36 below
    /////////////////////////////
    // CGS UNITS: UCUM 4.3 §30 //
    /////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<WaveNumber> KAYSER = addUnit(SI.RECIPROCAL_METRE.divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Acceleration> GAL = addUnit(CENTI(METER).divide(SECOND.pow(2)).asType(Acceleration.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Force> DYNE = addUnit(SI.GRAM.multiply(CENTI(SI.METRE)).divide(SI.SECOND.pow(2)).asType(Force.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Energy> ERG = addUnit(DYNE.multiply(CENTI(SI.METRE)).asType(Energy.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<DynamicViscosity> POISE = addUnit(DYNE.multiply(SECOND).divide(CENTI(SI.METRE).pow(2)).asType(DynamicViscosity.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<ElectricCurrent> BIOT = addUnit(AMPERE.multiply(10));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<KinematicViscosity> STOKES = addUnit(CENTI(SI.METRE).pow(2).divide(SI.SECOND).asType(KinematicViscosity.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<MagneticFlux> MAXWELL = addUnit(SI.WEBER.divide(1E8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<MagneticFluxDensity> GAUSS = addUnit(SI.TESLA.divide(1E4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<MagneticFieldStrength> OERSTED = addUnit(SI.AMPERES_PER_METRE.multiply(250).divide(PI).asType(MagneticFieldStrength.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<MagnetomotiveForce> GILBERT = addUnit(OERSTED.multiply(CENTI(SI.METRE)).asType(MagnetomotiveForce.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Luminance> STILB = addUnit(CANDELA.divide(CENTI(METER).pow(2)).asType(Luminance.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Luminance> LAMBERT = addUnit(STILB.divide(PI).asType(Luminance.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Illuminance> PHOT = addUnit(LUX.divide(1E4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Radioactivity> CURIE = addUnit(SI.BECQUEREL.multiply(3.7E10));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<IonizingRadiation> ROENTGEN = addUnit(SI.COULOMBS_PER_KILOGRAM.multiply(2.58E-4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<RadiationDoseAbsorbed> RAD = addUnit(ERG.divide(SI.GRAM).multiply(100).asType(RadiationDoseAbsorbed.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<RadiationDoseEffective> REM = addUnit(RAD.asType(RadiationDoseEffective.class));
    /////////////////////////////////////////////////
    // INTERNATIONAL CUSTOMARY UNITS: UCUM 4.4 §31 //
    /////////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> INCH_INTERNATIONAL = addUnit(CENTI(METER).multiply(254).divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> FOOT_INTERNATIONAL = addUnit(INCH_INTERNATIONAL.multiply(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> YARD_INTERNATIONAL = addUnit(FOOT_INTERNATIONAL.multiply(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> MILE_INTERNATIONAL = addUnit(FOOT_INTERNATIONAL.multiply(5280));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> FATHOM_INTERNATIONAL = addUnit(FOOT_INTERNATIONAL.multiply(6));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> NAUTICAL_MILE_INTERNATIONAL = addUnit(METER.multiply(1852));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Speed> KNOT_INTERNATIONAL = addUnit(NAUTICAL_MILE_INTERNATIONAL.divide(HOUR).asType(Speed.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> SQUARE_INCH_INTERNATIONAL = addUnit(INCH_INTERNATIONAL.pow(2).asType(Area.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> SQUARE_FOOT_INTERNATIONAL = addUnit(FOOT_INTERNATIONAL.pow(2).asType(Area.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> SQUARE_YARD_INTERNATIONAL = addUnit(YARD_INTERNATIONAL.pow(2).asType(Area.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> CUBIC_INCH_INTERNATIONAL = addUnit(INCH_INTERNATIONAL.pow(3).asType(Volume.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> CUBIC_FOOT_INTERNATIONAL = addUnit(FOOT_INTERNATIONAL.pow(3).asType(Volume.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> CUBIC_YARD_INTERNATIONAL = addUnit(YARD_INTERNATIONAL.pow(3).asType(Volume.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> BOARD_FOOT_INTERNATIONAL = addUnit(CUBIC_INCH_INTERNATIONAL.multiply(144));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> CORD_INTERNATIONAL = addUnit(CUBIC_FOOT_INTERNATIONAL.multiply(128));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> MIL_INTERNATIONAL = addUnit(INCH_INTERNATIONAL.divide(1000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> CIRCULAR_MIL_INTERNATIONAL = addUnit(MIL_INTERNATIONAL.pow(2).multiply(PI).divide(4).asType(Area.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> HAND_INTERNATIONAL = addUnit(INCH_INTERNATIONAL.multiply(4));
    //////////////////////////////////////////
    // US SURVEY LENGTH UNITS: UCUM 4.4 §32 //
    //////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> FOOT_US_SURVEY = addUnit(METER.multiply(1200).divide(3937));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> YARD_US_SURVEY = addUnit(FOOT_US_SURVEY.multiply(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> INCH_US_SURVEY = addUnit(FOOT_US_SURVEY.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> ROD_US_SURVEY = addUnit(FOOT_US_SURVEY.multiply(33).divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> CHAIN_US_SURVEY = addUnit(ROD_US_SURVEY.multiply(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> LINK_US_SURVEY = addUnit(CHAIN_US_SURVEY.divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> RAMDEN_CHAIN_US_SURVEY = addUnit(FOOT_US_SURVEY.multiply(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> RAMDEN_LINK_US_SURVEY = addUnit(CHAIN_US_SURVEY.divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> FATHOM_US_SURVEY = addUnit(FOOT_US_SURVEY.multiply(6));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> FURLONG_US_SURVEY = addUnit(ROD_US_SURVEY.multiply(40));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> MILE_US_SURVEY = addUnit(FURLONG_US_SURVEY.multiply(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> ACRE_US_SURVEY = addUnit(ROD_US_SURVEY.pow(2).multiply(160).asType(Area.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> SQUARE_ROD_US_SURVEY = addUnit(ROD_US_SURVEY.pow(2).asType(Area.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> SQUARE_MILE_US_SURVEY = addUnit(MILE_US_SURVEY.pow(2).asType(Area.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> SECTION_US_SURVEY = addUnit(MILE_US_SURVEY.pow(2).asType(Area.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> TOWNSHP_US_SURVEY = addUnit(SECTION_US_SURVEY.multiply(36));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> MIL_US_SURVEY = addUnit(INCH_US_SURVEY.divide(1000));
    /////////////////////////////////////////////////
    // BRITISH IMPERIAL LENGTH UNITS: UCUM 4.4 §33 //
    /////////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> INCH_BRITISH = addUnit(CENTI(METER).multiply(2539998).divide(1000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> FOOT_BRITISH = addUnit(INCH_BRITISH.multiply(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> ROD_BRITISH = addUnit(FOOT_BRITISH.multiply(33).divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> CHAIN_BRITISH = addUnit(ROD_BRITISH.multiply(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> LINK_BRITISH = addUnit(CHAIN_BRITISH.divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> FATHOM_BRITISH = addUnit(FOOT_BRITISH.multiply(6));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> PACE_BRITISH = addUnit(FOOT_BRITISH.multiply(5).divide(20));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> YARD_BRITISH = addUnit(FOOT_BRITISH.multiply(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> MILE_BRITISH = addUnit(FOOT_BRITISH.multiply(5280));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> NAUTICAL_MILE_BRITISH = addUnit(FOOT_BRITISH.multiply(6080));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Speed> KNOT_BRITISH = addUnit(NAUTICAL_MILE_BRITISH.divide(HOUR).asType(Speed.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> ACRE_BRITISH = addUnit(YARD_BRITISH.pow(2).multiply(4840).asType(Area.class));
    ///////////////////////////////////
    // US VOLUME UNITS: UCUM 4.4 §34 //
    ///////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> GALLON_US = addUnit(CUBIC_INCH_INTERNATIONAL.multiply(231));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> BARREL_US = addUnit(GALLON_US.multiply(42));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> QUART_US = addUnit(GALLON_US.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> PINT_US = addUnit(QUART_US.divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> GILL_US = addUnit(PINT_US.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> FLUID_OUNCE_US = addUnit(GILL_US.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> FLUID_DRAM_US = addUnit(FLUID_OUNCE_US.divide(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> MINIM_US = addUnit(FLUID_DRAM_US.divide(60));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> CORD_US = addUnit(CUBIC_FOOT_INTERNATIONAL.multiply(128));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> BUSHEL_US = addUnit(CUBIC_INCH_INTERNATIONAL.multiply(215042).divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> GALLON_WINCHESTER = addUnit(BUSHEL_US.divide(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> PECK_US = addUnit(BUSHEL_US.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> DRY_QUART_US = addUnit(PECK_US.divide(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> DRY_PINT_US = addUnit(DRY_QUART_US.divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> TABLESPOON_US = addUnit(FLUID_OUNCE_US.divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> TEASPOON_US = addUnit(TABLESPOON_US.divide(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> CUP_US = addUnit(TABLESPOON_US.multiply(16));
    /////////////////////////////////////////////////
    // BRITISH IMPERIAL VOLUME UNITS: UCUM 4.4 §35 //
    /////////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> GALLON_BRITISH = addUnit(LITER.multiply(454609).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> PECK_BRITISH = addUnit(GALLON_BRITISH.multiply(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> BUSHEL_BRITISH = addUnit(PECK_BRITISH.multiply(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> QUART_BRITISH = addUnit(GALLON_BRITISH.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> PINT_BRITISH = addUnit(QUART_BRITISH.divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> GILL_BRITISH = addUnit(PINT_BRITISH.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> FLUID_OUNCE_BRITISH = addUnit(GILL_BRITISH.divide(5));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> FLUID_DRAM_BRITISH = addUnit(FLUID_OUNCE_BRITISH.divide(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> MINIM_BRITISH = addUnit(FLUID_DRAM_BRITISH.divide(60));
    ////////////////////////////////////////////
    // AVOIRDUPOIS WIEGHT UNITS: UCUM 4.4 §36 //
    ////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> GRAIN = addUnit(MILLI(GRAM).multiply(6479891).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> POUND = addUnit(GRAIN.multiply(7000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> OUNCE = addUnit(POUND.divide(16));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> DRAM = addUnit(OUNCE.divide(16));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> SHORT_HUNDREDWEIGHT = addUnit(POUND.multiply(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> LONG_HUNDREDWEIGHT = addUnit(POUND.multiply(112));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> SHORT_TON = addUnit(SHORT_HUNDREDWEIGHT.multiply(20));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> LONG_TON = addUnit(LONG_HUNDREDWEIGHT.multiply(20));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> STONE = addUnit(POUND.multiply(14));
    // CONTINUED FROM SECTION §29
    // contains a forward reference to POUND, so we had to move it here, below section §36
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Force> POUND_FORCE = addUnit(POUND.multiply(ACCELLERATION_OF_FREEFALL).asType(Force.class));
    /////////////////////////////////////
    // TROY WIEGHT UNITS: UCUM 4.4 §37 //
    /////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> PENNYWEIGHT_TROY = addUnit(GRAIN.multiply(24));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> OUNCE_TROY = addUnit(PENNYWEIGHT_TROY.multiply(24));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> POUND_TROY = addUnit(OUNCE_TROY.multiply(12));
    /////////////////////////////////////////////
    // APOTECARIES' WEIGHT UNITS: UCUM 4.4 §38 //
    /////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> SCRUPLE_APOTHECARY = addUnit(GRAIN.multiply(20));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> DRAM_APOTHECARY = addUnit(SCRUPLE_APOTHECARY.multiply(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> OUNCE_APOTHECARY = addUnit(DRAM_APOTHECARY.multiply(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> POUND_APOTHECARY = addUnit(OUNCE_APOTHECARY.multiply(12));
    /////////////////////////////////////////////
    // TYPESETTER'S LENGTH UNITS: UCUM 4.4 §39 //
    /////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> LINE = addUnit(INCH_INTERNATIONAL.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> POINT = addUnit(LINE.divide(6));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> PICA = addUnit(POINT.multiply(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> POINT_PRINTER = addUnit(INCH_INTERNATIONAL.multiply(13837).divide(1000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> PICA_PRINTER = addUnit(POINT_PRINTER.multiply(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> PIED = addUnit(CENTI(METER).multiply(3248).divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> POUCE = addUnit(PIED.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> LINGE = addUnit(POUCE.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> DIDOT = addUnit(LINGE.divide(6));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> CICERO = addUnit(DIDOT.multiply(12));
    //////////////////////////////////////
    // OTHER LEGACY UNITS: UCUM 4.5 §40 //
    //////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Temperature> FAHRENHEIT = addUnit(KELVIN.multiply(5).divide(9).shift(459.67));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Energy> CALORIE_AT_15C = addUnit(JOULE.multiply(41858).divide(10000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Energy> CALORIE_AT_20C = addUnit(JOULE.multiply(41819).divide(10000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Energy> CALORIE_MEAN = addUnit(JOULE.multiply(419002).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Energy> CALORIE_INTERNATIONAL_TABLE = addUnit(JOULE.multiply(41868).divide(10000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Energy> CALORIE_THERMOCHEMICAL = addUnit(JOULE.multiply(4184).divide(1000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Energy> CALORIE = addUnit(CALORIE_THERMOCHEMICAL);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> CALORIE_FOOD = addUnit(KILO(CALORIE_THERMOCHEMICAL));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_AT_39F = addUnit(KILO(JOULE).multiply(105967).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_AT_59F = addUnit(KILO(JOULE).multiply(105480).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_AT_60F = addUnit(KILO(JOULE).multiply(105468).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_MEAN = addUnit(KILO(JOULE).multiply(105587).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_INTERNATIONAL_TABLE = addUnit(KILO(JOULE).multiply(105505585262L).divide(100000000000L));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_THERMOCHEMICAL = addUnit(KILO(JOULE).multiply(105735).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU = addUnit(BTU_THERMOCHEMICAL);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Power> HORSEPOWER = addUnit(FOOT_INTERNATIONAL.multiply(POUND_FORCE).divide(SECOND).asType(Power.class));
    /////////////////////////////////////////////////////////
    // SECTIONS §41-§43 skipped; implement later if needed //
    /////////////////////////////////////////////////////////
    ///////////////////////////////////////
    // MISCELLANEOUS UNITS: UCUM 4.5 §44 //
    ///////////////////////////////////////
    /** temporary helper for MHO */
    private static final Unit<? extends Quantity<?>> TMP_MHO = SIEMENS.alternate("mho");

    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Volume> STERE = addUnit(METER.pow(3).asType(Volume.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Length> ANGSTROM = addUnit(NANO(METER).divide(10));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Area> BARN = addUnit(FEMTO(METER).pow(2).multiply(100).asType(Area.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Pressure> ATMOSPHERE_TECHNICAL = addUnit(KILO(GRAM_FORCE).divide(CENTI(METER).pow(2)).asType(Pressure.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<ElectricConductance> MHO = addUnit(TMP_MHO.asType(ElectricConductance.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Pressure> POUND_PER_SQUARE_INCH =  addUnit(POUND_FORCE.divide(INCH_INTERNATIONAL.pow(2)).asType(Pressure.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Angle> CIRCLE = addUnit(PI.multiply(RADIAN).multiply(2).asType(Angle.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<SolidAngle> SPHERE = addUnit(PI.multiply(STERADIAN).multiply(4).asType(SolidAngle.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Mass> CARAT_METRIC = addUnit(GRAM.divide(5));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Dimensionless> CARAT_GOLD = addUnit(SI.ONE.divide(24));
    ////////////////////////////////////////////////
    // INFORMATION TECHNOLOGY UNITS: UCUM 4.6 §45 //
    ////////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Information> BIT = addUnit(SI.BIT);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Information> BYTE = addUnit(SI.BIT.multiply(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<InformationRate> BAUD = addUnit(SI.BITS_PER_SECOND);

    ///////////////////////
    // MISSING FROM UCUM //
    ///////////////////////

    /** To be added to the <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AbstractUnit<Frequency> FRAMES_PER_SECOND = addUnit(SI.ONE.divide(SECOND)).asType(Frequency.class);


    /////////////////////
    // Collection View //
    /////////////////////

    @Override
    public String getName() {
        return "UCUM";
    }

    /**
     * Returns the unit corresponding to the specified quantity type.
     * The UCUM system uses the same mapping as the {@link SI} system.
     *
     * @param quantityType
     * @return <code>SI.getInstance().getUnit(quantityType)</code>
     */
    @Override
    public <Q extends Quantity<Q>> AbstractUnit<Q> getUnit(Class<Q> quantityType) {
        return SI.getInstance().getUnit(quantityType);
    }


    /**
     * Adds a new unit not mapped to any specified quantity type.
     *
     * @param  unit the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends AbstractUnit<?>>  U addUnit(U unit) {
        INSTANCE.units.add(unit);
        return unit;
    }
    
    /**
     * Adds a new unit not mapped to any specified quantity type.
     *
     * @param  unit the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>>  U addUnit(U unit) {
        INSTANCE.units.add(unit);
        return unit;
    }
}
