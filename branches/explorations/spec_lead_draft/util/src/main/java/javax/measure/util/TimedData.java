/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.util;

import java.util.function.Supplier;

import javax.measure.function.Nameable;

/**
 * TimedData is a container for a data value that keeps track of its age. This class keeps track of the birth time of a bit of data, i.e. time the object is instantiated.<br/>The TimedData MUST be immutable.
 * 
 * @param <T>
 *            The data value.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.2 ($Revision$)
 * @see <a href="http://en.wikipedia.org/wiki/Time_series"> Wikipedia:
 *      Time Series</a>
 */
public class TimedData<T> implements Nameable, Supplier<T> {
	// TODO do we keep null for min and max to represent infinity? 
	// Java 8 Optional was evaluated, but caused conflict with the type-safe Quantity feature of this API
    private final T data;
    private long timestamp;
    private String name;
    
    /**
     * Construct an instance of Range with a min, max and res value.
     *
     * @param data The value for the measurement range.
     * @param time The time value for the measurement range.
     */
    protected TimedData(T data, long time) {
    	this.data = data;
        this.timestamp = time;
    }    
    
    /**
     * Returns an {@code MeasurementRange} with the specified values.
     *
     * @param <T> the class of the value
     * @param val The minimum value for the measurement range.
     * @param time The maximum value for the measurement range.
     * @return an {@code MeasurementRange} with the given values
     */
    public static <T> TimedData<T> of(T val, long time) {
        return new TimedData<>(val, time);
    }
    
    /**
     * Returns the time with which this TimedData was created.
     * 
     * @return the time of creation
     */
    public long getTimestamp() {
        return timestamp;
    }
    
	@Override
	public String getName() {
		return name;
	}

	@Override
	public T get() {
		return data;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals()
	 */
    @Override
    public boolean equals(Object object) {
        if(object instanceof TimedData<?>)  {
            @SuppressWarnings("unchecked")
            final TimedData<T> that = (TimedData<T>) object;
            return this == that || (
                    that.get() == get() &&
                    that.getTimestamp() == getTimestamp() &&
                    that.getName() == getName());
        }
        return false;
    }

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode() {
        return data.hashCode() + (name!=null ? name.hashCode() : 0);
    }

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
            .append("data= ").append(get())
            .append(", timestamp= ").append(getTimestamp());
        if (name != null && name.length()>0) {
        	sb.append(", name= ").append(getName());
        }
        return sb.toString();
    }

}
