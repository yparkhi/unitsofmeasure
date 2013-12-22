/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2013, Unit-API contributors and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

/**
 * A Range is a pair of <code>T</code> values that represent a range of values.<p>
 * Range limits MUST be presented in the same scale and have the same unit as measured data values. The MeasurementRange MUST be immutable.
 * 
 * @param <T>
 *            The value of the measurement range.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.2
 */
public class MeasurementRange<T> {
    private final T min;
    private final T max;
    private T res;

    /**
     * Construct an instance of Range with a min and max value.
     *
     * @param min The minimum value for the measurement range.
     * @param max The maximum value for the measurement range.
     * @param res The  resolution of the measurement range.
     */
    private MeasurementRange(T min, T max, T res) {
    	this.min = min;
        this.max = max;
        this.res = res;
    }
    
    /**
     * Construct an instance of Range with a min and max value.
     *
     * @param min The minimum value for the measurement range.
     * @param max The maximum value for the measurement range.
     */
    private MeasurementRange(T min, T max) {
    	this.min = min;
        this.max = max;
    }
    
    
    /**
     * Returns an {@code MeasurementRange} with the specified values.
     *
     * @param <T> the class of the value
     * @param minimum The minimum value for the measurement range.
     * @param maximum The maximum value for the measurement range.
     * @param resolution The resolution of the measurement range.
     * @return an {@code MeasurementRange} with the given values
     */
    public static <T> MeasurementRange<T> of(T minimum, T maximum, T resolution) {
        return new MeasurementRange<>(minimum, maximum, resolution);
    }
    
    /**
     * Returns an {@code MeasurementRange} with the specified values.
     *
     * @param <T> the class of the value
     * @param minimum The minimum value for the measurement range.
     * @param maximum The maximum value for the measurement range.
     * @return an {@code MeasurementRange} with the given values
     */
    public static <T> MeasurementRange<T> of(T minimum, T maximum) {
        return new MeasurementRange<>(minimum, maximum);
    }

    /**
     * Returns the smallest value of the range. The value is the same as that given as the constructor parameter for the smallest value.
     * @return the minimum value
     */
    public T getMinimum() {
        return min;
    }

    /**
     * Returns the largest value of the measurement range. The value is the same as that given as the constructor parameter for the largest value.
     * 
     * @return the maximum value
     */
    public T getMaximum() {
        return max;
    }
    
    /**
     * Returns the resolution of the measurement range. The value is the same as that given as the constructor parameter for the largest value.
     * 
     * @return resolution of the range, the value is the same as that given as the constructor parameter for the resolution
     */
    public T getResolution() {
        return res;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof MeasurementRange<?>)  {
            @SuppressWarnings("unchecked")
            final MeasurementRange<T> that = (MeasurementRange<T>) object;
            return this == that || (
                    that.getMinimum() == getMinimum() &&
                    that.getMaximum() == getMaximum() &&
                    that.getResolution() == getResolution());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return min.hashCode() + max.hashCode() + (res!=null ? res.hashCode() : 0);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
            .append("min= ").append(getMinimum())
            .append(", max= ").append(getMaximum());
        if (res != null) {
        	sb.append(", res= ").append(getResolution());
        }
        return sb.toString();
    }
}
