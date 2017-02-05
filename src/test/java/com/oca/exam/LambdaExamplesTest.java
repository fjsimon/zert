package com.oca.exam;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit getFirstResult for simple LambdaExamples.
 */
public class LambdaExamplesTest extends TestCase {
    /**
     * Create the getFirstResult case
     *
     * @param testName name of the getFirstResult case
     */
    public LambdaExamplesTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( LambdaExamplesTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
