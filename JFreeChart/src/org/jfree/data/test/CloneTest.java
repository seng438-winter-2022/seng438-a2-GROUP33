package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

public class CloneTest extends DataUtilities {
	
	//Establishing DELTA, and declaring all of the arrays
    private static final double DELTA = .000000001d;
    private DefaultKeyedValues2D table;
    
    private double [][] testingSource;
    private double [][] emptySource;
    private double [][] empty2DArray;
    private double [][] shallowCopyArray;
  
   
    
    @Rule
    public TestName testName = new TestName();

   //Creating a 2D array and populating each value with an incrementing index

    @Before
    public void setUp() throws Exception {
    	double counter = 0.0;
    	empty2DArray = new double[1][1];
        testingSource = new double[2][3];
        emptySource = new double[1][1];
        for(int i =0; i < testingSource.length; i++) {
        	for(int j= 0; j < testingSource[i].length; j++) {
        		testingSource[i][j] = counter;
        		counter += 1.0;
        	}       	
        }
        System.out.println("Start " + testName.getMethodName());
    }

  
	//A simple test to see if the clone method can clone a testing source that is populated in @Before
	@Test
    public void check2DClone(){ 
       //assertArrayEquals(testingSource, DataUtilities.clone(testingSource));
       assertTrue(Arrays.deepEquals(testingSource, DataUtilities.clone(testingSource)));
       
    }
	
	
	//This test will purposely fail as the testing source and empty source are two different arrays and thus not
	//equal so the assertFail will return True and thus the test case will pass
	@Test
    public void purposeFail(){ 
       //assertArrayEquals(testingSource, DataUtilities.clone(testingSource));
       assertFalse(Arrays.deepEquals(testingSource, emptySource));
       
    }
	
	//This test aims to see if the clone method will work on an empty array
	@Test
    public void emptyClone(){ 
       //assertArrayEquals(testingSource, DataUtilities.clone(testingSource));
		assertTrue(Arrays.deepEquals(empty2DArray, DataUtilities.clone(empty2DArray)));
       
    }
	//This test aims to see if the clone method will work with a shallow copy
	@Test
    public void modifyValues(){ 
       shallowCopyArray = DataUtilities.clone(testingSource);
	   assertTrue(Arrays.deepEquals(testingSource, shallowCopyArray));
       
    }

	//Setting testingSource to null
    @After
    public void tearDown() throws Exception {
        testingSource = null;
        assertNull(testingSource);
        System.out.println("End " + testName.getMethodName());
    }

}