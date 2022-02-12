package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

public class CalculateColumnTotalTest extends DataUtilities {
	private static final double DELTA = .000000001d;
	private DefaultKeyedValues2D values;

	private void valuesGenerate(int row, int col) {
		double counter = 1.0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				values.addValue(counter++, "r" + Integer.toString(i), "c" + Integer.toString(j));
			}
		}
	}

	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() throws Exception {
		values = new DefaultKeyedValues2D();
		System.out.println("Start " + testName.getMethodName());
	}
	
	@Test
	public void calculateColumnTotalForEmptyTable() {
		assertEquals(0.0, DataUtilities.calculateColumnTotal(values, 0), DELTA);
	}

	@Test
	public void calculateColumnTotalForSingleColumn() {
		valuesGenerate(2, 1);
		assertEquals(3.0, DataUtilities.calculateColumnTotal(values, 0), DELTA);
	}

	@Test
	public void calculateColumnTotalForMultipleColumn() {
		valuesGenerate(3, 8);
		assertEquals(27.0, DataUtilities.calculateColumnTotal(values, 0), DELTA);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void calculateColumnTotalForInvalidColumn() throws IndexOutOfBoundsException {
		valuesGenerate(1, 1);
		assertEquals(3.0, DataUtilities.calculateColumnTotal(values, 4), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateColumnTotalForNullTable() throws IllegalArgumentException {
		DataUtilities.calculateColumnTotal(null, 0);
	}

	@After
	public void tearDown() throws Exception {
		values = null;
		assertNull(values);
		System.out.println("End " + testName.getMethodName());
	}
}
