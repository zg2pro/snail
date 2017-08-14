package com.systar.animals;

import org.junit.Test;

/**
 * Unit test for simple Snail.
 */
public class SnailTest {

    /**
     * test with a high number to control performance
     */
    @Test
    public void testApp() {
        String res = new Snail(1000).printPlainText();
        System.out.println(res);
    }
}
