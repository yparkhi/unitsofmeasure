package org.unitsofmeasurement.demo.types;

import static org.unitsofmeasurement.impl.AbstractMeasurement.NONE;
import static org.unitsofmeasurement.demo.types.SaffirSimpsonHurricaneWindScale.Category.*;

import javax.measure.Measurement;
import javax.measure.MeasurementRange;
import javax.measure.function.Nameable;
import javax.measure.quantity.Velocity;

import org.unitsofmeasurement.impl.AbstractMeasurement;

/**
 * @author Werner Keil
 * @version 0.2
 * @see <a href="http://en.wikipedia.org/wiki/Saffir%E2%80%93Simpson_hurricane_wind_scale"> Wikipedia:
 *      Saffir–Simpson hurricane wind scale</a>
 */
public class SaffirSimpsonHurricaneWindScale extends MeasurementRange<Measurement<Velocity, Number>>
	implements Nameable {

	public static enum Category {
		UNKNOWN, TROPICAL_DEPRESSION, TROPICAL_STORM, ONE, TWO, THREE, FOUR, FIVE
	}
	
	private final Category category;

	public Category getCategory() {
		return category;
	}
	
	protected SaffirSimpsonHurricaneWindScale(Measurement<Velocity, Number> min,
			Measurement<Velocity, Number> max, Category level) {
		super(min, max);
		this.category = level;
	}
	
	protected SaffirSimpsonHurricaneWindScale(Measurement<Velocity, Number> min,
			Measurement<Velocity, Number> max) {
		this(min, max, UNKNOWN);
	}
	
	public static final SaffirSimpsonHurricaneWindScale of(AbstractMeasurement<Velocity> min, 
			AbstractMeasurement<Velocity> max) {
		return new SaffirSimpsonHurricaneWindScale(min, max);
	}
	
	public static final SaffirSimpsonHurricaneWindScale of(AbstractMeasurement<Velocity> min, 
			AbstractMeasurement<Velocity> max, Category level) {
		return new SaffirSimpsonHurricaneWindScale(min, max, level);
	}
	
	public boolean hasMinimum() {
		return getMinimum() != null && !NONE.equals(getMinimum()) && 
				!(getMinimum().getUnit() == null || getMinimum().getValue() == null);
	}

	public boolean hasMaximum() {
		return getMaximum() != null && !NONE.equals(getMaximum()) &&
				!(getMaximum().getUnit() == null || getMaximum().getValue() == null) ;
	}
	
	@Override
	public String toString() {
		return getName() + " [category=" + category + ", minimum=" + getMinimum()
				+ ", maximum=" + getMaximum() + "]";
	}

	@Override
	public String getName() {
		return "Saffir–Simpson hurricane wind scale";
	}
}
