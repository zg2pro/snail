package com.systar.animals;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Snail.
 */
public class SnailTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SnailTest(String testName) {
	super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
	return new TestSuite(SnailTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws Exception {
	String res = new Snail(1000).easyPrint();
	System.out.println(res);
    }
}
