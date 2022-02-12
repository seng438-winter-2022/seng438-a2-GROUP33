package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;

public class ShiftTest extends Range {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShiftTest() {
		// TODO Auto-generated constructor stub
		super(1.00, 1.00);
	}

	private Range testRange, resultRange;
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void setUp() throws Exception {
		testRange = new Range(5.00, 10.50);
		System.out.println("Start " + testName.getMethodName());
	}
	
	//Test Case 1: delta > 0
	@Test
	public void ShiftPositive() {
		resultRange = new Range(9.56, 15.06);
		assertNotEquals(resultRange, Range.shift(testRange, 4.56));
	}
	
	//Test Case 2: delta < 0
	@Test
	public void ShiftNegative() {
		resultRange = new Range(-2.35, 3.15);
		assertNotEquals(resultRange, Range.shift(testRange, -7.35));
	}
	
	//Test Case 3: delta = 0
	@Test
	public void ShiftZero() {
		resultRange = new Range(5.00, 10.50);
		assertEquals(resultRange, Range.shift(testRange, 0));
	}

	@After
	public void tearDown() throws Exception {
		resultRange = null;
		assertNull(resultRange);
		System.out.println("End " + testName.getMethodName());
	}

}
