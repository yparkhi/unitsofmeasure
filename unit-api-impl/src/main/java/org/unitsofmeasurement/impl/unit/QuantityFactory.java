/**
 *
 */
package org.unitsofmeasurement.impl.unit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.unitsofmeasurement.quantity.Dimensionless;
import org.unitsofmeasurement.quantity.Information;
import org.unitsofmeasurement.quantity.InformationRate;
import org.unitsofmeasurement.quantity.Length;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.quantity.Temperature;
import org.unitsofmeasurement.quantity.Time;
import org.unitsofmeasurement.unit.Unit;

/**
 * A factory producing simple quantities instances (tuples {@link Number}/
 * {@link Unit}).
 * 
 * For example:[code] Mass m =
 * QuantityFactory.getInstance(Mass.class).create(23.0, KILOGRAM); // 23.0 kg
 * Time m = QuantityFactory.getInstance(Time.class).create(124, MILLI(SECOND));
 * // 124 ms [/code]
 * 
 * @param <Q>
 *            The type of the quantity.
 * 
 * @author <a href="mailto:werner.keil@gmail.com">Werner Keil</a>
 * @version 1.1.2 ($Revision: 17458 $), $Date: 2011-07-16 17:07:12 +0530 (Sat, 16 Jul 2011) $
 * 
 * TODO probably move this to "quantity" package
 * TODO Introduce Interface (either that was QuantityFactory and this an *Impl or Abstract*, or e.g. QuantityProvider)
 */
public abstract class QuantityFactory<Q extends Quantity<Q>> {
    static final double BYTE_FACTOR = 8.0;

	/**
	 * Holds the current instances.
	 */
	@SuppressWarnings("rawtypes")
	private static final Map<Class, QuantityFactory> INSTANCES = new ConcurrentHashMap<Class, QuantityFactory>();

	private static final Logger logger = Logger.getLogger(QuantityFactory.class
			.getName());

	private static final Level LOG_LEVEL = Level.FINE;

	/**
	 * Returns the default instance for the specified quantity type.
	 * 
	 * @param <Q>
	 *            The type of the quantity
	 * @param type
	 *            the quantity type
	 * @return the quantity factory for the specified type
	 */
	@SuppressWarnings("unchecked")
	public static <Q extends Quantity<Q>> QuantityFactory<Q> getInstance(
			final Class<Q> type) {

		logger.log(LOG_LEVEL, "Type: " + type + ": " + type.isInterface());
		QuantityFactory<Q> factory;
		if (!type.isInterface()) {
			if (type != null && type.getInterfaces() != null
					& type.getInterfaces().length > 0) {
				logger.log(LOG_LEVEL, "Type0: " + type.getInterfaces()[0]);
				Class<?> type2 = type.getInterfaces()[0];

				factory = INSTANCES.get(type2);
				if (factory != null)
					return factory;
				if (!Quantity.class.isAssignableFrom(type2))
					// This exception is not documented because it should never
					// happen if the
					// user don't try to trick the Java generic types system
					// with unsafe cast.
					throw new ClassCastException();
				factory = new Default<Q>((Class<Q>) type2);
				INSTANCES.put(type2, factory);
			} else {
				factory = INSTANCES.get(type);
				if (factory != null)
					return factory;
				if (!Quantity.class.isAssignableFrom(type))
					// This exception is not documented because it should never
					// happen if the
					// user don't try to trick the Java generic types system
					// with unsafe cast.
					throw new ClassCastException();
				factory = new Default<Q>(type);
				INSTANCES.put(type, factory);
			}
		} else {
			factory = INSTANCES.get(type);
			if (factory != null)
				return factory;
			if (!Quantity.class.isAssignableFrom(type))
				// This exception is not documented because it should never
				// happen if the
				// user don't try to trick the Java generic types system with
				// unsafe cast.
				throw new ClassCastException();
			factory = new Default<Q>(type);
			INSTANCES.put(type, factory);
		}
		return factory;
	}

	/**
	 * Overrides the default implementation of the factory for the specified
	 * quantity type.
	 * 
	 * @param <Q>
	 *            The type of the quantity
	 * @param type
	 *            the quantity type
	 * @param factory
	 *            the quantity factory
	 */
	@SuppressWarnings("rawtypes")
	protected static <Q extends Quantity> void setInstance(final Class<Q> type,
			QuantityFactory factory) {
		if (!Quantity.class.isAssignableFrom(type))
			// This exception is not documented because it should never happen
			// if the
			// user don't try to trick the Java generic types system with unsafe
			// cast.
			throw new ClassCastException();
		INSTANCES.put(type, factory);
	}

	/**
	 * Returns the quantity for the specified number stated in the specified
	 * unit.
	 * 
	 * @param value
	 *            the value stated in the specified unit
	 * @param unit
	 *            the unit
	 * @return the corresponding quantity
	 */
	public abstract Q create(Number value, Unit<Q> unit);

	/**
	 * Returns the metric unit for quantities produced by this factory or
	 * <code>null</code> if unknown.
	 * 
	 * @return the metric units for this factory quantities.
	 */
	public abstract Unit<Q> getMetricUnit();

	/**
	 * The default factory implementation. This factory uses reflection for
	 * providing a default implementation for every {@link org.unitsofmeasurement.impl.quantity.DimensionQuantity}
	 * sub-types.
	 * 
	 * @param <Q>
	 *            The type of the quantity
	 */
	private static final class Default<Q extends Quantity<Q>> extends
			QuantityFactory<Q> {

		/**
		 * The type of the quantities created by this factory.
		 */
		private final Class<Q> type;

		/**
		 * The metric unit for quantities created by this factory.
		 */
		private final Unit<Q> metricUnit;

		/**
		 * Creates a new factory for quantities of the given type.
		 * 
		 * @param type
		 *            The type of the quantities created by this factory.
		 */
		@SuppressWarnings("unchecked")
		Default(final Class<Q> type) {
			this.type = type;
			metricUnit = CLASS_TO_METRIC_UNIT.get(type);
		}

		@SuppressWarnings("rawtypes")
		static final Map<Class, Unit> CLASS_TO_METRIC_UNIT = new HashMap<Class, Unit>();
		static {
			CLASS_TO_METRIC_UNIT.put(Dimensionless.class, DimensionlessUnit.ONE);
			CLASS_TO_METRIC_UNIT.put(Length.class, DistanceUnit.METRE);
			CLASS_TO_METRIC_UNIT.put(Time.class, TimeUnit.s);
			CLASS_TO_METRIC_UNIT.put(Information.class, BitUnit.BIT);
            CLASS_TO_METRIC_UNIT.put(InformationRate.class, BitRateUnit.bps);
            CLASS_TO_METRIC_UNIT.put(Temperature.class, TemperatureUnit.KELVIN);
		}

		@Override
		@SuppressWarnings("unchecked")
		public Q create(final Number value, final Unit<Q> unit) {
			return (Q) Proxy
					.newProxyInstance(type.getClassLoader(),
							new Class<?>[] { type }, new GenericHandler<Q>(
									value, unit));
		}

		@Override
		public Unit<Q> getMetricUnit() {
			return metricUnit;
		}
	}

	/**
	 * The method invocation handler for implementation backed by any kind of
	 * {@link Number}. This is a fall back used when no specialized handler is
	 * available for the number type.
	 */
	private static final class GenericHandler<Q extends Quantity<Q>> implements
			InvocationHandler {
		final Unit<Q> unit;
		final Number value;

		GenericHandler(final Number value, final Unit<Q> unit) {
			this.unit = unit;
			this.value = value;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Object invoke(final Object proxy, final Method method,
				final Object[] args) {
			final String name = method.getName();
			if (name.equals("doubleValue")) { // Most frequent.
				final Unit<Q> toUnit = (Unit<Q>) args[0];
				if ((toUnit == unit) || (toUnit.equals(unit)))
					return value.doubleValue(); // Returns value directly.
				return unit.getConverterTo(toUnit).convert(value.doubleValue());
			} else if (name.equals("longValue")) {
				final Unit<Q> toUnit = (Unit<Q>) args[0];
				if ((toUnit == unit) || (toUnit.equals(unit)))
					return value.longValue(); // Returns value directly.
				double doubleValue = unit.getConverterTo(toUnit).convert(
						value.doubleValue());
				if ((doubleValue < Long.MIN_VALUE)
						|| (doubleValue > Long.MAX_VALUE))
					throw new ArithmeticException("Overflow: " + doubleValue
							+ " cannot be represented as a long");
				return (long) doubleValue;
			} else if (name.equals("value")) {
				return value;
			} else if (name.equals("unit")) {
				return unit;
			} else if (name.equals("toString")) {
				final StringBuilder buffer = new StringBuilder();
				return buffer.append(value).append(' ').append(unit).toString();
			} else if (name.equals("hashCode")) {
				return value.hashCode() * 31 + unit.hashCode();
			} else if (name.equals("equals")) {
				final Object obj = args[0];
				if (!(obj instanceof Quantity))
					return false;
				final Quantity that = (Quantity) obj;
				return equals(that);
			} else if (name.equals("compareTo")) {
				final Quantity that = (Quantity) args[0];
				return equals(that);
			} else {
				throw new UnsupportedOperationException(name);
			}
		}
	}
}
