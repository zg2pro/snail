package com.systar.animals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for simple Snail.
 */
public class SnailTest {

    @Test(expected = IllegalArgumentException.class)
    public void negativeLength() {
        new Snail(-1).printPlainText();
    }
    
    public void zero() {
        new Snail(0).printPlainText();
    }

    @Test
    public void largeMatrix() {
        int testLength = 1000;
        long timeBefore = System.currentTimeMillis();
        String res = new Snail(testLength).printPlainText();
        long timeAfter = System.currentTimeMillis();
        assertTrue("performance not acceptable", timeAfter - timeBefore < 2000L);
        String[] lines = res.split("\n");
        assertEquals(1000, lines.length);
        String[] line2 = lines[1].split(" ");
        assertEquals("3999", line2[0]);
        assertEquals("1002", line2[line2.length -1]);
        assertEquals("4998", line2[line2.length -2]);
        String[] penUltimate = lines[998].split(" ");
        assertEquals("5996", penUltimate[penUltimate.length -2]);
        System.out.println(res);
    }
}
