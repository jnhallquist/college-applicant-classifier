package com.jennifernguyen.app;

import junit.framework.TestCase;

public class ApplicationTest extends TestCase {
    public void testValidGetGPAPercentile() {
        Application validGPAPercentile = new Application("Jane", "Smith", 0, "California", 3.6, 4.0, 1920, 27, 0);

        assertEquals ( validGPAPercentile.getGPAPercentile(), 0.9 );
    }

    public void testIsValidState() {
        Application validState1 = new Application("Jane", "Smith", 17, "California", 3.6, 4.0, 1920, 27, 0);
        Application validState2 = new Application("Jane", "Smith", 83, "Wyoming", 3.6, 4.0, 1920, 27, 0);

        assertTrue ( validState1.isValidInState() );
        assertTrue ( validState2.isValidInState() );
    }

    public void testIsInvalidState() {
        Application invalidState1 = new Application("Jane", "Smith", 17, "Wyoming", 3.6, 4.0, 1920, 27, 0);
        Application invalidState2 = new Application("Jane", "Smith", 54, "California", 3.6, 4.0, 1920, 27, 0);

        assertFalse ( invalidState1.isValidInState() );
        assertFalse ( invalidState2.isValidInState() );
    }
}
