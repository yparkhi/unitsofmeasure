package javax.measure.test;

import static javax.measure.test.TestUnit.TEST;
import static org.junit.Assert.*;

import javax.measure.Measurement;
import javax.measure.MeasurementRange;

import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	private Measurement<?, Double> min;
	private Measurement<?, Double> max;
	private Measurement<?, Double> res;
	@SuppressWarnings("rawtypes")
	private MeasurementRange range;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	public void init() {
		min = new TestMeasurement(Double.valueOf(1d), TEST);
		max = new TestMeasurement(Double.valueOf(10d), TEST);
		res = new TestMeasurement(Double.valueOf(2d), TEST);
		
		range = MeasurementRange.of(min, max, res);
	}
	
	@Test
	public void testGetMinimum() {
		assertEquals(min, range.getMinimum());
	}

	@Test
	public void testGetMaximum() {
		assertEquals(max, range.getMaximum());
	}

	@Test
	public void testGetResolution() {
		assertEquals(res, range.getResolution());
	}

	@Test
	public void testToString() {
		assertEquals("", range.toString());
	}

}
