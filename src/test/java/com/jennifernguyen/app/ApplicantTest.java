package com.jennifernguyen.app;

import junit.framework.TestCase;

public class ApplicantTest extends TestCase {

    public ApplicantTest( String testName ) {
        super( testName );
    }

    public void testHasValidName() {
        Applicant validApplicantName = new Applicant("Jane", "Smith", 0, null);

        assertTrue( validApplicantName.hasValidName() );
    }

    public void testHasInvalidName() {
        Applicant invalidApplicantName1 = new Applicant("jane", "Smith", 0, null);
        Applicant invalidApplicantName2 = new Applicant("jane", "smith", 0, null);
        Applicant invalidApplicantName3 = new Applicant("Jane", "smith", 0, null);

        assertFalse( invalidApplicantName1.hasValidName() );
        assertFalse( invalidApplicantName2.hasValidName() );
        assertFalse( invalidApplicantName3.hasValidName() );
    }

    public void testHasValidAge() {
        Applicant validApplicantAge1 = new Applicant("Jane", "Smith", 18, null);
        Applicant validApplicantAge2 = new Applicant("Jane", "Smith", 0, null);

        assertTrue ( validApplicantAge1.hasValidAge() );
        assertTrue ( validApplicantAge2.hasValidAge() );
    }

    public void testHasInvalidAge() {
        Applicant invalidApplicantAge = new Applicant("Jane", "Smith", -18, null);

        assertFalse ( invalidApplicantAge.hasValidAge() );
    }
}
