/**
 *  The Units of Measure API, UCUM codes, UCUM table (regardless of format),
 *  and UCUM Specification are copyright © 1999-2010, Regenstrief Institute, Inc.
 *  and the Unified Codes for Units of Measures (UCUM) Organization.
 *  All rights reserved.
 *
 * See TermsOfUse for details.
 */
package org.unitsofmeasure.util;

import java.util.HashSet;
import java.util.Set;

import org.unitsofmeasure.SystemOfUnits;
import org.unitsofmeasure.Unit;
import org.unitsofmeasure.quantity.Acceleration;
import org.unitsofmeasure.quantity.AmountOfSubstance;
import org.unitsofmeasure.quantity.Area;
import org.unitsofmeasure.quantity.CatalyticActivity;
import org.unitsofmeasure.quantity.ElectricCapacitance;
import org.unitsofmeasure.quantity.ElectricCharge;
import org.unitsofmeasure.quantity.ElectricConductance;
import org.unitsofmeasure.quantity.ElectricCurrent;
import org.unitsofmeasure.quantity.ElectricInductance;
import org.unitsofmeasure.quantity.ElectricPotential;
import org.unitsofmeasure.quantity.ElectricResistance;
import org.unitsofmeasure.quantity.Energy;
import org.unitsofmeasure.quantity.Force;
import org.unitsofmeasure.quantity.Length;
import org.unitsofmeasure.quantity.LuminousIntensity;
import org.unitsofmeasure.quantity.MagneticFlux;
import org.unitsofmeasure.quantity.MagneticFluxDensity;
import org.unitsofmeasure.quantity.MagnetomotiveForce;
import org.unitsofmeasure.quantity.Mass;
import org.unitsofmeasure.quantity.Power;
import org.unitsofmeasure.quantity.Pressure;
import org.unitsofmeasure.quantity.RadiationDoseAbsorbed;
import org.unitsofmeasure.quantity.RadiationDoseEffective;
import org.unitsofmeasure.quantity.Temperature;
import org.unitsofmeasure.quantity.Time;
import org.unitsofmeasure.quantity.Velocity;
import org.unitsofmeasure.quantity.Volume;

/**
 * <p>
 * This convenience class holds metric base units and derived units as specified
 * by the "Système International d'Unités" (SI).
 * </p>
 * 
 * <p>
 * All base units defined here are retrieved from their name using the
 * {@link BaseFormat#getStandard() standard format} (UCUM) for units. For
 * example:<code>METRE = UnitFormat.getStandard().parse("m")</code>
 * </p>
 * 
 * <p>
 * This class provides also support for the 20 SI prefixes used in the metric
 * system (decimal multiples and submultiples of SI units). For example:
 * 
 * <pre>
 * <code>
 *     import org.unitsofmeasure.quantity.*;
 *     import static org.unitsofmeasure.Metric.*; // Static import.
 *     ...
 *     Unit<Pressure> HECTOPASCAL = HECTO(PASCAL);
 *     Unit<Length> KILOMETRE = KILO(METRE);
 * </pre>
 * 
 * </code>
 * </p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @see <a
 *      href="http://en.wikipedia.org/wiki/International_System_of_Units">Wikipedia:
 *      International System of Units</a>
 * @version 1.0
 */
public final class Metric extends SystemOfUnits {

	/**
	 * Holds the unit format instance.
	 */
	private static final BaseFormat FORMAT = SimpleFormat.getStandard();

	/**
	 * Private constructor (utility class, cannot be instantiated).
	 */
	private Metric() {
	}

	/**
	 * The singleton instance of {@code Metric}.
	 */
	private static final Metric INSTANCE = new Metric();

	/**
	 * Returns the singleton instance of this class.
	 * 
	 * @return the metric system instance.
	 */
	public static final SystemOfUnits getInstance() {
		return INSTANCE;
	}

	/**
	 * Holds the dimensionless unit <code>ONE</code>.
	 */
	// public static Unit<Dimensionless> ONE =
	// FORMAT.parse("").asType(Dimensionless.class);

	// //////////////
	// BASE UNITS //
	// //////////////
	/**
	 * The base unit for electric current quantities (<code>A</code>). The
	 * Ampere is that constant current which, if maintained in two straight
	 * parallel conductors of infinite length, of negligible circular
	 * cross-section, and placed 1 meter apart in vacuum, would produce between
	 * these conductors a force equal to 2 * 10-7 newton per meter of length. It
	 * is named after the French physicist Andre Ampere (1775-1836).
	 */
	public static final Unit<ElectricCurrent> AMPERE = FORMAT.parse("A")
			.asType(ElectricCurrent.class);

	/**
	 * The base unit for luminous intensity quantities (<code>cd</code>). The
	 * candela is the luminous intensity, in a given direction, of a source that
	 * emits monochromatic radiation of frequency 540 * 1012 hertz and that has
	 * a radiant intensity in that direction of 1/683 watt per steradian
	 * 
	 * @see <a href="http://en.wikipedia.org/wiki/Candela"> Wikipedia:
	 *      Candela</a>
	 */
	public static final Unit<LuminousIntensity> CANDELA = FORMAT.parse("cd")
			.asType(LuminousIntensity.class);

	/**
	 * The base unit for thermodynamic temperature quantities (<code>K</code>).
	 * The kelvin is the 1/273.16th of the thermodynamic temperature of the
	 * triple point of water. It is named after the Scottish mathematician and
	 * physicist William Thomson 1st Lord Kelvin (1824-1907)
	 */
	public static final Unit<Temperature> KELVIN = FORMAT.parse("K").asType(
			Temperature.class);

	/**
	 * The base unit for mass quantities (<code>kg</code>). It is the only SI
	 * unit with a prefix as part of its name and symbol. The kilogram is equal
	 * to the mass of an international prototype in the form of a
	 * platinum-iridium cylinder kept at Sevres in France.
	 * 
	 * @see #GRAM
	 */
	public static final Unit<Mass> KILOGRAM = FORMAT.parse("Kg").asType(
			Mass.class);

	/**
	 * The base unit for length quantities (<code>m</code>). One metre was
	 * redefined in 1983 as the distance traveled by light in a vacuum in
	 * 1/299,792,458 of a second.
	 */
	public static final Unit<Length> METRE = FORMAT.parse("m").asType(
			Length.class);

	/**
	 * Equivalent to {@link #METRE}.
	 */
	public static final Unit<Length> METER = METRE;

	/**
	 * The base unit for amount of substance quantities (<code>mol</code>). The
	 * mole is the amount of substance of a system which contains as many
	 * elementary entities as there are atoms in 0.012 kilogram of carbon 12.
	 */
	public static final Unit<AmountOfSubstance> MOLE = FORMAT.parse("mol")
			.asType(AmountOfSubstance.class);

	/**
	 * The base unit for duration quantities (<code>s</code>). It is defined as
	 * the duration of 9,192,631,770 cycles of radiation corresponding to the
	 * transition between two hyperfine levels of the ground state of cesium
	 * (1967 Standard).
	 */
	public static final Unit<Time> SECOND = FORMAT.parse("s")
			.asType(Time.class);

	// //////////////////////////////
	// SI DERIVED ALTERNATE UNITS //
	// //////////////////////////////

	/**
	 * The unit for magnetomotive force (<code>At</code>).
	 */
	public static final Unit<MagnetomotiveForce> AMPERE_TURN = AMPERE
			.alternate("At").asType(MagnetomotiveForce.class);

	/**
	 * The derived unit for mass quantities (<code>g</code>). The base unit for
	 * mass quantity is {@link #KILOGRAM}.
	 */
	public static final Unit<Mass> GRAM = KILOGRAM.divide(1000);

	/**
	 * The unit for plane angle quantities (<code>rad</code>). One radian is the
	 * angle between two radii of a circle such that the length of the arc
	 * between them is equal to the radius.
	 */
	// public static final Unit<Angle> RADIAN =
	// ONE.alternate("rad").asType(Angle.class);;

	/**
	 * The unit for solid angle quantities (<code>sr</code>). One steradian is
	 * the solid angle subtended at the center of a sphere by an area on the
	 * surface of the sphere that is equal to the radius squared. The total
	 * solid angle of a sphere is 4*Pi steradians.
	 */
	// public static final Unit<SolidAngle> STERADIAN =
	// ONE.alternate("sr").asType(SolidAngle.class);;

	/**
	 * The unit for binary information (<code>bit</code>).
	 */
	// public static final Unit<Data> BIT =
	// ONE.alternate("bit").asType(Data.class);

	/**
	 * The derived unit for frequency (<code>Hz</code>). A unit of frequency
	 * equal to one cycle per second. After Heinrich Rudolf Hertz (1857-1894),
	 * German physicist who was the first to produce radio waves artificially.
	 */
	// public static final Unit<Frequency> HERTZ =
	// ONE.divide(SECOND).alternate("Hz").asType(Frequency.class);

	/**
	 * The derived unit for force (<code>N</code>). One newton is the force
	 * required to give a mass of 1 kilogram an Force of 1 metre per second per
	 * second. It is named after the English mathematician and physicist Sir
	 * Isaac Newton (1642-1727).
	 */
	public static final Unit<Force> NEWTON = METRE.multiply(KILOGRAM).divide(
			SECOND.pow(2)).alternate("N").asType(Force.class);

	/**
	 * The derived unit for pressure, stress (<code>Pa</code>). One pascal is
	 * equal to one newton per square meter. It is named after the French
	 * philosopher and mathematician Blaise Pascal (1623-1662).
	 */
	public static final Unit<Pressure> PASCAL = NEWTON.divide(METRE.pow(2))
			.alternate("Pa").asType(Pressure.class);

	/**
	 * The derived unit for energy, work, quantity of heat (<code>J</code>). One
	 * joule is the amount of work done when an applied force of 1 newton moves
	 * through a distance of 1 metre in the direction of the force. It is named
	 * after the English physicist James Prescott Joule (1818-1889).
	 */
	public static final Unit<Energy> JOULE = NEWTON.multiply(METRE).alternate(
			"J").asType(Energy.class);

	/**
	 * The derived unit for power, radiant, flux (<code>W</code>). One watt is
	 * equal to one joule per second. It is named after the British scientist
	 * James Watt (1736-1819).
	 */
	public static final Unit<Power> WATT = JOULE.divide(SECOND).alternate("W")
			.asType(Power.class);

	/**
	 * The derived unit for electric charge, quantity of electricity (
	 * <code>C</code>). One Coulomb is equal to the quantity of charge
	 * transferred in one second by a steady current of one ampere. It is named
	 * after the French physicist Charles Augustin de Coulomb (1736-1806).
	 */
	public static final Unit<ElectricCharge> COULOMB = SECOND.multiply(AMPERE)
			.alternate("C").asType(ElectricCharge.class);

	/**
	 * The derived unit for electric potential difference, electromotive force (
	 * <code>V</code>). One Volt is equal to the difference of electric
	 * potential between two points on a conducting wire carrying a constant
	 * current of one ampere when the power dissipated between the points is one
	 * watt. It is named after the Italian physicist Count Alessandro Volta
	 * (1745-1827).
	 */
	public static final Unit<ElectricPotential> VOLT = WATT.divide(AMPERE)
			.alternate("V").asType(ElectricPotential.class);

	/**
	 * The derived unit for capacitance (<code>F</code>). One Farad is equal to
	 * the capacitance of a capacitor having an equal and opposite charge of 1
	 * coulomb on each plate and a potential difference of 1 volt between the
	 * plates. It is named after the British physicist and chemist Michael
	 * Faraday (1791-1867).
	 */
	public static final Unit<ElectricCapacitance> FARAD = COULOMB.divide(VOLT)
			.alternate("F").asType(ElectricCapacitance.class);

	/**
	 * The derived unit for electric resistance (<code>Ohm</code>). One Ohm is
	 * equal to the resistance of a conductor in which a current of one ampere
	 * is produced by a potential of one volt across its terminals. It is named
	 * after the German physicist Georg Simon Ohm (1789-1854).
	 */
	public static final Unit<ElectricResistance> OHM = VOLT.divide(AMPERE)
	    .alternate("Ω").asType(ElectricResistance.class);

	/**
	 * The derived unit for electric conductance (<code>S</code>). One Siemens
	 * is equal to one ampere per volt. It is named after the German engineer
	 * Ernst Werner von Siemens (1816-1892).
	 */
	public static final Unit<ElectricConductance> SIEMENS = AMPERE.divide(VOLT)
			.alternate("S").asType(ElectricConductance.class);

	/**
	 * The derived unit for magnetic flux (<code>Wb</code>). One Weber is equal
	 * to the magnetic flux that in linking a circuit of one turn produces in it
	 * an electromotive force of one volt as it is uniformly reduced to zero
	 * within one second. It is named after the German physicist Wilhelm Eduard
	 * Weber (1804-1891).
	 */
	public static final Unit<MagneticFlux> WEBER = VOLT.multiply(SECOND)
			.alternate("Wb").asType(MagneticFlux.class);

	/**
	 * The derived unit for magnetic flux density (<code>T</code>). One Tesla is
	 * equal equal to one weber per square metre. It is named after the
	 * Serbian-born American electrical engineer and physicist Nikola Tesla
	 * (1856-1943).
	 */
	public static final Unit<MagneticFluxDensity> TESLA = WEBER.divide(
			METRE.pow(2)).alternate("T").asType(MagneticFluxDensity.class);

	/**
	 * The derived unit for inductance (<code>H</code>). One Henry is equal to
	 * the inductance for which an induced electromotive force of one volt is
	 * produced when the current is varied at the rate of one ampere per second.
	 * It is named after the American physicist Joseph Henry (1791-1878).
	 */
	public static final Unit<ElectricInductance> HENRY = WEBER.divide(AMPERE)
			.alternate("H").asType(ElectricInductance.class);

	/**
	 * The derived unit for Celsius temperature (<code>Cel</code>). This is a
	 * unit of temperature such as the freezing point of water (at one
	 * atmosphere of pressure) is 0 Cel, while the boiling point is 100 Cel.
	 */
	public static final Unit<Temperature> CELSIUS = KELVIN.add(273.15);

	/**
	 * The derived unit for luminous flux (<code>lm</code>). One Lumen is equal
	 * to the amount of light given out through a solid angle by a source of one
	 * candela intensity radiating equally in all directions.
	 */
	// public static final Unit<LuminousFlux> LUMEN =
	// CANDELA.multiply(STERADIAN).alternate("lm").asType(LuminousFlux.class);

	/**
	 * The derived unit for illuminance (<code>lx</code>). One Lux is equal to
	 * one lumen per square metre.
	 */
	// public static final Unit<Illuminance> LUX =
	// LUMEN.divide(METRE.pow(2)).alternate("lx").asType(Illuminance.class);

	/**
	 * The derived unit for activity of a radionuclide (<code>Bq</code>). One
	 * becquerel is the radiation caused by one disintegration per second. It is
	 * named after the French physicist, Antoine-Henri Becquerel (1852-1908).
	 */
	// public static final Unit<RadioactiveActivity> BECQUEREL =
	// ONE.divide(SECOND).alternate("Bq").asType(RadioactiveActivity.class);

	/**
	 * The derived unit for absorbed dose, specific energy (imparted), kerma (
	 * <code>Gy</code>). One gray is equal to the dose of one joule of energy
	 * absorbed per one kilogram of matter. It is named after the British
	 * physician L. H. Gray (1905-1965).
	 */
	public static final Unit<RadiationDoseAbsorbed> GRAY = JOULE.divide(
			KILOGRAM).alternate("Gy").asType(RadiationDoseAbsorbed.class);

	/**
	 * The derived unit for dose equivalent (<code>Sv</code>). One Sievert is
	 * equal is equal to the actual dose, in grays, multiplied by a
	 * "quality factor" which is larger for more dangerous forms of radiation.
	 * It is named after the Swedish physicist Rolf Sievert (1898-1966).
	 */
	public static final Unit<RadiationDoseEffective> SIEVERT = JOULE.divide(
			KILOGRAM).alternate("Sv").asType(RadiationDoseEffective.class);

	/**
	 * The derived unit for catalytic activity (<code>kat</code>).
	 */
	public static final Unit<CatalyticActivity> KATAL = MOLE.divide(SECOND)
			.alternate("kat").asType(CatalyticActivity.class);

	// ////////////////////////////
	// SI DERIVED PRODUCT UNITS //
	// ////////////////////////////

	/**
	 * The metric unit for velocity quantities (<code>m/s</code>).
	 * 
	 */
	public static final Unit<Velocity> METRES_PER_SECOND = METRE.divide(SECOND)
			.asType(Velocity.class);

	/**
	 * Equivalent to {@link #METRES_PER_SECOND}.
	 */
	public static final Unit<Velocity> METERS_PER_SECOND = METRES_PER_SECOND;

	/**
	 * The metric unit for acceleration quantities (<code>m/s2</code>).
	 */
	public static final Unit<Acceleration> METRES_PER_SQUARE_SECOND = METRES_PER_SECOND
			.divide(SECOND).asType(Acceleration.class);

	/**
	 * Equivalent to {@link #METRES_PER_SQUARE_SECOND}.
	 */
	public static final Unit<Acceleration> METERS_PER_SQUARE_SECOND = METRES_PER_SQUARE_SECOND;

	/**
	 * The metric unit for area quantities (<code>m2</code>).
	 */
	public static final Unit<Area> SQUARE_METRE = METRE.multiply(METRE).asType(
			Area.class);

	/**
	 * Equivalent to {@link #SQUARE_METRE}.
	 */
	public static final Unit<Area> SQUARE_METER = SQUARE_METRE;

	/**
	 * The metric unit for volume quantities (<code>m3</code>).
	 */
	public static final Unit<Volume> CUBIC_METRE = SQUARE_METRE.multiply(METRE)
			.asType(Volume.class);

	/**
	 * Equivalent to {@link #CUBIC_METRE}.
	 */
	public static final Unit<Volume> CUBIC_METER = CUBIC_METRE;

	/**
	 * Holds collection of units.
	 */
	private static final Set<Unit<?>> UNITS = new HashSet<Unit<?>>();

	/**
	 * Adds a new unit to the collection.
	 * 
	 * @param unit
	 *            the unit being added.
	 * @return <code>unit</code>.
	 */
	private static <U extends Unit<?>> U addUnit(U unit) {
		UNITS.add(unit);
		return unit;
	}

	@Override
	public Set<Unit<?>> getUnits() {
		return UNITS;
	}

	static {
		addUnit(AMPERE);
		addUnit(AMPERE_TURN);
		addUnit(GRAM);
	}

}
